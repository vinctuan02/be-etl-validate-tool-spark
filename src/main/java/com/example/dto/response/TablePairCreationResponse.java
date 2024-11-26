package com.example.dto.response;


import com.example.entity.Report;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
public class TablePairCreationResponse {
    private Integer pairId;

    @JsonBackReference
    private ReportCreationResponse reportCreationResponse;

    private String sourceTableName;

    private String sinkTableName;

    private String sourceDatabaseName;

    private String sinkDatabaseName;

    @JsonBackReference
    private JDBCConnectionCreationResponse sourceJDBCConnectionCreationResponse;

    @JsonBackReference
    private JDBCConnectionCreationResponse sinkJDBCConnectionCreationResponse;
}
