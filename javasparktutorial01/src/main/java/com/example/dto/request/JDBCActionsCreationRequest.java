package com.example.dto.request;

import javax.validation.constraints.NotBlank;

public class JDBCActionsCreationRequest {
    private String jdbcName;

    @NotBlank(message = "INPUT_INVALID")
    private String jdbcUrl;

    @NotBlank(message = "INPUT_INVALID")
    private String jdbcUser;

    @NotBlank(message = "INPUT_INVALID")
    private String jdbcPassword;

    private String databaseName;

    private String databaseType;


    public String getJdbcName() {
        return jdbcName;
    }

    public void setJdbcName(String jdbcName) {
        this.jdbcName = jdbcName;
    }

    public @NotBlank(message = "INPUT_INVALID") String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(@NotBlank(message = "INPUT_INVALID") String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public @NotBlank(message = "INPUT_INVALID") String getJdbcUser() {
        return jdbcUser;
    }

    public void setJdbcUser(@NotBlank(message = "INPUT_INVALID") String jdbcUser) {
        this.jdbcUser = jdbcUser;
    }

    public @NotBlank(message = "INPUT_INVALID") String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(@NotBlank(message = "INPUT_INVALID") String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }

    public @NotBlank(message = "INPUT_INVALID") String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(@NotBlank(message = "INPUT_INVALID") String databaseName) {
        this.databaseName = databaseName;
    }

    public @NotBlank(message = "INPUT_INVALID") String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(@NotBlank(message = "INPUT_INVALID") String databaseType) {
        this.databaseType = databaseType;
    }
}
