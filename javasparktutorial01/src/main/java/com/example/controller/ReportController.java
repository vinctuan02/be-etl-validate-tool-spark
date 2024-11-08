package com.example.controller;

import com.example.dto.request.ReportCreationRequest;
import com.example.entity.Report;
import com.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

//    @PostMapping("/create-report")
//    Report createReport(@RequestBody ReportCreateRequest request) {
//        return reportService.createReport(request);
//    }

    @GetMapping("/test")
    String test() {
        System.out.println("Hello");
        return "Test";
    }

    @PostMapping("/create-report")
    Report createReport(@RequestBody ReportCreationRequest request) {
        return reportService.createReport(request);
    }

}
