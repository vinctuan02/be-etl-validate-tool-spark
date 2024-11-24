package com.example.dto.response;


import com.example.entity.JDBCConnection;
import com.example.entity.Report;

public class TablePairCreationResponse {
    private Integer pairId;

    private Report report;

    private String sourceTableName;

    private String sinkTableName;

    private String sourceDatabaseName;

    private String sinkDatabaseName;

    private JDBCConnection sourceJDBCConnection;

    private JDBCConnection sinkJDBCConnection;

    public Integer getPairId() {
        return pairId;
    }

    public void setPairId(Integer pairId) {
        this.pairId = pairId;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public String getSourceTableName() {
        return sourceTableName;
    }

    public void setSourceTableName(String sourceTableName) {
        this.sourceTableName = sourceTableName;
    }

    public String getSinkTableName() {
        return sinkTableName;
    }

    public void setSinkTableName(String sinkTableName) {
        this.sinkTableName = sinkTableName;
    }

    public String getSourceDatabaseName() {
        return sourceDatabaseName;
    }

    public void setSourceDatabaseName(String sourceDatabaseName) {
        this.sourceDatabaseName = sourceDatabaseName;
    }

    public String getSinkDatabaseName() {
        return sinkDatabaseName;
    }

    public void setSinkDatabaseName(String sinkDatabaseName) {
        this.sinkDatabaseName = sinkDatabaseName;
    }

    public JDBCConnection getSourceJDBCConnection() {
        return sourceJDBCConnection;
    }

    public void setSourceJDBCConnection(JDBCConnection sourceJDBCConnection) {
        this.sourceJDBCConnection = sourceJDBCConnection;
    }

    public JDBCConnection getSinkJDBCConnection() {
        return sinkJDBCConnection;
    }

    public void setSinkJDBCConnection(JDBCConnection sinkJDBCConnection) {
        this.sinkJDBCConnection = sinkJDBCConnection;
    }
}
