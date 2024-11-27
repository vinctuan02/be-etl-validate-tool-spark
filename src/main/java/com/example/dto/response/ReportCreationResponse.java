package com.example.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.util.List;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ReportCreationResponse {
    private Integer reportId;
    private String reportName;
    private String status;
    private String note;

//    @JsonManagedReference
    private List<TablePairCreationResponse> tablePairCreationResponses;
}
