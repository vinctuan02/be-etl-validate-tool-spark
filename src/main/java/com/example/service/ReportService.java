package com.example.service;

import com.example.dto.request.ReportCreationRequest;
import com.example.dto.response.ReportCreationResponse;
import com.example.entity.Report;
import com.example.entity.TablePair;
import com.example.exception.AppException;
import com.example.exception.ErrorCode;
import com.example.repository.ReportRepository;
import com.example.spark.SparkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private SparkService sparkService;

    public ReportCreationResponse createReport(ReportCreationRequest request){
        ReportCreationResponse reportCreationResponse = new ReportCreationResponse();

        Report report = new Report();
        report.setReportName(request.getReportName());
        if(request.getStatus().equals("NOT_COMPARED")|| request.getStatus().equals("IN_QUEUE") || request.getStatus().equals("IN_PROGRESS") || request.getStatus().equals("COMPLETED")){
            report.setStatus(request.getStatus());
        }else{
            report.setStatus("NOT_COMPARED");
        }
        report.setNote(request.getNote());

        Report savedReport = reportRepository.save(report);

        reportCreationResponse.setReportId(savedReport.getReportId());
        reportCreationResponse.setReportName(savedReport.getReportName());
        reportCreationResponse.setStatus(savedReport.getStatus());
        reportCreationResponse.setNote(savedReport.getNote());
//        reportCreationResponse.setTablePairs(savedReport.getTablePairs());

        return reportCreationResponse;

    }

    public ReportCreationResponse getReportById (Integer id){

        ReportCreationResponse reportCreationResponse = new ReportCreationResponse();

        Report report =  reportRepository.findById(id).
                orElseThrow(() -> new RuntimeException("ErrorCode.RECORD_NOT_FOUND"));

        reportCreationResponse.setReportId(report.getReportId());
        reportCreationResponse.setReportName(report.getReportName());
        reportCreationResponse.setStatus(report.getStatus());
        reportCreationResponse.setNote(report.getNote());
        reportCreationResponse.setTablePairs(report.getTablePairs());

        return reportCreationResponse;
    }

    public List<ReportCreationResponse> getAllReports (){
        List<ReportCreationResponse> reportCreationResponses = new ArrayList<>();
        List<Report> reports = reportRepository.findAll();

        for(Report report: reports){
            ReportCreationResponse reportCreationResponse = new ReportCreationResponse();

            reportCreationResponse.setReportId(report.getReportId());
            reportCreationResponse.setReportName(report.getReportName());
            reportCreationResponse.setStatus(report.getStatus());
            reportCreationResponse.setNote(report.getNote());
            reportCreationResponse.setTablePairs(report.getTablePairs());

            reportCreationResponses.add(reportCreationResponse);
        }

        return  reportCreationResponses;
    }

    public ReportCreationResponse deleteReportById (Integer id){
        ReportCreationResponse reportCreationResponse = new ReportCreationResponse();

        Report report =  reportRepository.findById(id).
                orElseThrow(() -> new RuntimeException("ErrorCode.RECORD_NOT_FOUND"));

        reportCreationResponse.setReportId(report.getReportId());
        reportCreationResponse.setReportName(report.getReportName());
        reportCreationResponse.setStatus(report.getStatus());
        reportCreationResponse.setNote(report.getNote());
        reportCreationResponse.setTablePairs(report.getTablePairs());

        reportRepository.deleteById(id);

        return reportCreationResponse;
    }

    public List<TablePair> compareReport(Integer id){
        Report report = reportRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.RECORD_NOT_FOUND));
        List<TablePair> tablePairs = report.getTablePairs();
        for (TablePair tablePair: tablePairs) {
            sparkService.compareDataFrame(tablePair);
        }
        return tablePairs;
    }
}
