package com.example.service;

import com.example.dto.request.ReportCreationRequest;
import com.example.dto.response.ReportCreationResponse;
import com.example.entity.Report;
import com.example.entity.TablePair;
import com.example.exception.AppException;
import com.example.exception.ErrorCode;
import com.example.mapper.ReportMapper;
import com.example.repository.ReportRepository;
import com.example.spark.SparkService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private SparkService sparkService;
    @Autowired
    private ReportMapper reportMapper;

    public ReportCreationResponse createReport(ReportCreationRequest request){

        Set<String> validStatuses = Set.of("NOT_COMPARED", "IN_QUEUE", "IN_PROGRESS", "COMPLETED");

        // Nếu trạng thái không hợp lệ, đặt lại thành "NOT_COMPARED"
        if (!validStatuses.contains(request.getStatus())) {
            request.setStatus("NOT_COMPARED");
        }

        Report report = reportMapper.toReport(request);
        Report savedReport = reportRepository.save(report);
        //        reportCreationResponse.setTablePairs(savedReport.getTablePairs());

        return reportMapper.toReportCreationResponse(savedReport);
    }

    public ReportCreationResponse getReportById (Integer id){
        Report report =  reportRepository.findById(id).
                orElseThrow(() -> new RuntimeException("ErrorCode.RECORD_NOT_FOUND"));

        return reportMapper.toReportCreationResponse(report);
    }

    public List<ReportCreationResponse> getAllReports (){
        List<ReportCreationResponse> reportCreationResponses = new ArrayList<>();
        List<Report> reports = reportRepository.findAll();

        for(Report report: reports){
            ReportCreationResponse reportCreationResponse = reportMapper.toReportCreationResponse(report);
            reportCreationResponses.add(reportCreationResponse);
        }

        return  reportCreationResponses;
    }

    public ReportCreationResponse deleteReportById (Integer id){
        Report report =  reportRepository.findById(id).
                orElseThrow(() -> new RuntimeException("ErrorCode.RECORD_NOT_FOUND"));

        reportRepository.deleteById(id);

        return reportMapper.toReportCreationResponse(report);
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
