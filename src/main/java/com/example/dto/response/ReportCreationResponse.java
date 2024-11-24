package com.example.dto.response;

import com.example.entity.TablePair;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReportCreationResponse {
    private Integer reportId;
    private String reportName;
    private String status;
    private String note;

    private List<TablePair> tablePairs;

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<TablePair> getTablePairs() {
        return tablePairs;
    }

    public void setTablePairs(List<TablePair> tablePairs) {
        this.tablePairs = tablePairs;
    }
}
