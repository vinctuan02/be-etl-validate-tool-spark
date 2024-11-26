package com.example.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class JDBCConnectionCreationResponse {
    private Integer jdbcId;

    private String jdbcName;

    private String jdbcUrl;

    private String jdbcUser;

    private String jdbcPassword;

    private String databaseType;

    @JsonManagedReference
    private List<TablePairCreationResponse> sourceTablePairCreationResponse;

    @JsonManagedReference
    private List<TablePairCreationResponse> sinkTablePairCreationResponse;
}
