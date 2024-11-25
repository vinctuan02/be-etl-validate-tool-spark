package com.example.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
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
}
