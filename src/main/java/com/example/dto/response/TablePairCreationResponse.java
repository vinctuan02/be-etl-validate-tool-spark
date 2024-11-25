package com.example.dto.response;


import com.example.entity.JDBCConnection;
import com.example.entity.Report;
import lombok.Data;

@Data
public class TablePairCreationResponse {
    private Integer pairId;

    private Report report;

    private String sourceTableName;

    private String sinkTableName;

    private String sourceDatabaseName;

    private String sinkDatabaseName;

    private JDBCConnection sourceJDBCConnection;

    private JDBCConnection sinkJDBCConnection;
}
