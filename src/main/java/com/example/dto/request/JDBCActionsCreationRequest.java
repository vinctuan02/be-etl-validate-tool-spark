package com.example.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
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

}
