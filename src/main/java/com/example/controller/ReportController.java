package com.example.controller;

import com.example.dto.request.ReportCreationRequest;
import com.example.dto.response.ApiResponse;
import com.example.dto.response.ReportCreationResponse;
import com.example.entity.TablePair;
import com.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping("/create-report")
    ApiResponse<ReportCreationResponse> createReport(@RequestBody ReportCreationRequest request) {
        ApiResponse<ReportCreationResponse> apiResponse = new ApiResponse<>();
        ReportCreationResponse result = reportService.createReport(request);

        apiResponse.setMessage("Create Report oke");
        apiResponse.setResult(result);

        return apiResponse;
    }

    @GetMapping("/get-report/{id}")
    ApiResponse<ReportCreationResponse> getReportById(@PathVariable Integer id) {
        ApiResponse<ReportCreationResponse> apiResponse = new ApiResponse<>();

        ReportCreationResponse result = reportService.getReportById(id);

        apiResponse.setMessage("Get Report by id oke");
        apiResponse.setResult(result);

        return apiResponse;
    }

    @GetMapping("/get-all-reports")
    ApiResponse<List<ReportCreationResponse>> getAllReports() {
        ApiResponse<List<ReportCreationResponse>> apiResponse = new ApiResponse<>();

        List<ReportCreationResponse> result = reportService.getAllReports();

        apiResponse.setMessage("Get All Reports Oke");
        apiResponse.setResult(result);

        return apiResponse;
    }

    @DeleteMapping("/delete-report/{id}")
    ApiResponse<ReportCreationResponse> deleteReportById(@PathVariable Integer id) {
        ApiResponse<ReportCreationResponse> apiResponse = new ApiResponse<>();

        ReportCreationResponse result = reportService.deleteReportById(id);

        apiResponse.setMessage("Delete report by id oke");
        apiResponse.setResult(result);

        return apiResponse;
    }

    @GetMapping("/compare-report/{id}")
    ApiResponse<List<TablePair>> compareReport(@PathVariable Integer id) {
        ApiResponse<List<TablePair>> apiResponse = new ApiResponse<>();
//        System.out.println("gdgagdsgs");

        List<TablePair> result = reportService.compareReport(id);

        apiResponse.setMessage("Compare report by id oke");
        apiResponse.setResult(result);

        return apiResponse;
    }
}
