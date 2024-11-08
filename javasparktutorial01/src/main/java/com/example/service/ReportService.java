package com.example.service;

import com.example.dto.request.ReportCreationRequest;
import com.example.entity.Report;
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
        if(request.getStatus()== null){
            report.setStatus("NOT_COMPARED");
        }else{
            report.setStatus(request.getStatus());
        }
        report.setNote(request.getNote());

        return reportRepository.save(report);
    }
}
