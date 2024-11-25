package com.example.mapper;

import com.example.dto.request.JDBCConnectionCreationRequest;
import com.example.dto.response.JDBCConnectionCreationResponse;
import com.example.entity.JDBCConnection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JDBCConnectionMapper {
    JDBCConnection toJDBCConnection(JDBCConnectionCreationRequest jdbcConnectionCreationRequest);
    JDBCConnectionCreationResponse toJDBCConnectionCreationResponse (JDBCConnection jdbcConnection);
}
