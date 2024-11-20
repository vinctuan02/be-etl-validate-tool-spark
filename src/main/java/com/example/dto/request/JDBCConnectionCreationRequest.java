package com.example.dto.request;

import javax.validation.constraints.NotBlank;

public class JDBCConnectionCreationRequest {

    @NotBlank(message = "INPUT_INVALID")
    private String jdbcName;

    @NotBlank(message = "INPUT_INVALID")
    private String jdbcUrl;

    @NotBlank(message = "INPUT_INVALID")
    private String jdbcUser;

    @NotBlank(message = "INPUT_INVALID")
    private String jdbcPassword;

    @NotBlank(message = "INPUT_INVALID")
    private String databaseType;

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
}
