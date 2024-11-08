package com.example.service;

import com.example.dto.request.ReportCreationRequest;
import com.example.entity.Report;
import com.example.exception.AppException;
import com.example.exception.ErrorCode;
import com.example.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;
    public Report createReport(ReportCreationRequest request){
        Report report = new Report();

        report.setReportName(request.getReportName());
        if(request.getStatus().equals("NOT_COMPARED")|| request.getStatus().equals("IN_QUEUE") || request.getStatus().equals("IN_PROGRESS") || request.getStatus().equals("COMPLETED")){
            report.setStatus(request.getStatus());
        }else{

            report.setStatus("NOT_COMPARED");
        }
        report.setNote(request.getNote());

        return reportRepository.save(report);
    }

    public Report getReportById (Integer id){
        return reportRepository.findById(id).
                orElseThrow(() -> new RuntimeException("ErrorCode.RECORD_NOT_FOUND"));
    }
}
