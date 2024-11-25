package com.example.dto.request;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;


@Data
public class TablePairCreationRequest {

    private Integer pairId;

    @NotBlank(message = "INPUT_INVALID")
    private Integer reportId;

    @NotBlank(message = "INPUT_INVALID")
    private Integer sourceJDBCId;

    @NotBlank(message = "INPUT_INVALID")
    private Integer sinkJDBCId;

    @NotBlank(message = "INPUT_INVALID")
    private String sourceTableName;

    @NotBlank(message = "INPUT_INVALID")
    private String sinkTableName;

    private String sourceDatabaseName;

    private String sinkDatabaseName;
}
