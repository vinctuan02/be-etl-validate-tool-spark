package com.example.dto.request;

import javax.validation.constraints.NotBlank;

public class TablePairCreationRequest {

    private Integer pairId;

    @NotBlank(message = "INPUT_INVALID")
    private Integer reportId;

    @NotBlank(message = "INPUT_INVALID")
    private String sourceJDBCId;

    @NotBlank(message = "INPUT_INVALID")
    private String sinkJDBCId;

    @NotBlank(message = "INPUT_INVALID")
    private String sourceTableName;

    @NotBlank(message = "INPUT_INVALID")
    private String sinkTableNames;

    public Integer getPairId() {
        return pairId;
    }

    public void setPairId(Integer pairId) {
        this.pairId = pairId;
    }

    public @NotBlank(message = "INPUT_INVALID") Integer getReportId() {
        return reportId;
    }

    public void setReportId(@NotBlank(message = "INPUT_INVALID") Integer reportId) {
        this.reportId = reportId;
    }

    public @NotBlank(message = "INPUT_INVALID") String getSourceJDBCId() {
        return sourceJDBCId;
    }

    public void setSourceJDBCId(@NotBlank(message = "INPUT_INVALID") String sourceJDBCId) {
        this.sourceJDBCId = sourceJDBCId;
    }

    public @NotBlank(message = "INPUT_INVALID") String getSinkJDBCId() {
        return sinkJDBCId;
    }

    public void setSinkJDBCId(@NotBlank(message = "INPUT_INVALID") String sinkJDBCId) {
        this.sinkJDBCId = sinkJDBCId;
    }

    public @NotBlank(message = "INPUT_INVALID") String getSourceTableName() {
        return sourceTableName;
    }

    public void setSourceTableName(@NotBlank(message = "INPUT_INVALID") String sourceTableName) {
        this.sourceTableName = sourceTableName;
    }

    public @NotBlank(message = "INPUT_INVALID") String getSinkTableNames() {
        return sinkTableNames;
    }

    public void setSinkTableNames(@NotBlank(message = "INPUT_INVALID") String sinkTableNames) {
        this.sinkTableNames = sinkTableNames;
    }
}
