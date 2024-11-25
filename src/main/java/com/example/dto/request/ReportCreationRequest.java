package com.example.dto.request;

import lombok.Data;

@Data
public class ReportCreationRequest {
    private String reportName;
    private String status;
    private String note;
}
