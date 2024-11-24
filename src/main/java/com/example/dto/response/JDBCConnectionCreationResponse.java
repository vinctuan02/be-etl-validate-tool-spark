package com.example.dto.response;

import com.example.entity.TablePair;

import java.util.List;

public class JDBCConnectionCreationResponse {
    private Integer jdbcId;

    private String jdbcName;

    private String jdbcUrl;

    private String jdbcUser;

    private String jdbcPassword;

    private String databaseType;

    //     Quan hệ với TablePair
    private List<TablePair> sourceTablePairs;

    private List<TablePair> sinkTablePairs;

    public Integer getJdbcId() {
        return jdbcId;
    }

    public void setJdbcId(Integer jdbcId) {
        this.jdbcId = jdbcId;
    }

    public String getJdbcName() {
        return jdbcName;
    }

    public void setJdbcName(String jdbcName) {
        this.jdbcName = jdbcName;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcUser() {
        return jdbcUser;
    }

    public void setJdbcUser(String jdbcUser) {
        this.jdbcUser = jdbcUser;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    public List<TablePair> getSourceTablePairs() {
        return sourceTablePairs;
    }

    public void setSourceTablePairs(List<TablePair> sourceTablePairs) {
        this.sourceTablePairs = sourceTablePairs;
    }

    public List<TablePair> getSinkTablePairs() {
        return sinkTablePairs;
    }

    public void setSinkTablePairs(List<TablePair> sinkTablePairs) {
        this.sinkTablePairs = sinkTablePairs;
    }
}
