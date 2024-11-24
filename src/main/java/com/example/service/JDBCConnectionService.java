package com.example.service;

import com.example.dto.request.JDBCConnectionCreationRequest;
import com.example.dto.response.JDBCConnectionCreationResponse;
import com.example.entity.JDBCConnection;
import com.example.exception.AppException;
import com.example.exception.ErrorCode;
import com.example.repository.JDBCConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JDBCConnectionService {
    @Autowired
    private JDBCConnectionRepository jdbcConnectionRepository;

    public JDBCConnectionCreationResponse createJDBCConnection(JDBCConnectionCreationRequest request){

        if(jdbcConnectionRepository.existsByJdbcName(request.getJdbcName()))
            throw new AppException(ErrorCode.RECORD_EXISTED);

        JDBCConnection jdbcConnection = new JDBCConnection();
        jdbcConnection.setJdbcName(request.getJdbcName());
        jdbcConnection.setJdbcUrl(request.getJdbcUrl());
        jdbcConnection.setJdbcUser(request.getJdbcUser());
        jdbcConnection.setJdbcPassword(request.getJdbcPassword());
        jdbcConnection.setDatabaseType(request.getDatabaseType());

        JDBCConnectionCreationResponse jdbcConnectionCreationResponse = new JDBCConnectionCreationResponse();
        jdbcConnectionCreationResponse.setJdbcName(request.getJdbcName());
        jdbcConnectionCreationResponse.setJdbcUrl(request.getJdbcUrl());
        jdbcConnectionCreationResponse.setJdbcUser(request.getJdbcUser());
        jdbcConnectionCreationResponse.setJdbcPassword(request.getJdbcPassword());
        jdbcConnectionCreationResponse.setDatabaseType(request.getDatabaseType());

        jdbcConnectionRepository.save(jdbcConnection);

        return jdbcConnectionCreationResponse;
    }

    public List<JDBCConnectionCreationResponse> getAllJDBCConnections(){
        List<JDBCConnectionCreationResponse> jdbcConnectionCreationResponses = new ArrayList<>();

        List<JDBCConnection> jdbcConnections = jdbcConnectionRepository.findAll();

        for (JDBCConnection jdbcConnection: jdbcConnections) {
            JDBCConnectionCreationResponse jdbcConnectionCreationResponse = new JDBCConnectionCreationResponse();

            jdbcConnectionCreationResponse.setJdbcId(jdbcConnection.getJdbcId());
            jdbcConnectionCreationResponse.setJdbcName(jdbcConnection.getJdbcName());
            jdbcConnectionCreationResponse.setJdbcUser(jdbcConnection.getJdbcUser());
            jdbcConnectionCreationResponse.setJdbcPassword(jdbcConnection.getJdbcPassword());
            jdbcConnectionCreationResponse.setDatabaseType(jdbcConnection.getDatabaseType());

            jdbcConnectionCreationResponses.add(jdbcConnectionCreationResponse);
        }

        return jdbcConnectionCreationResponses;
    }

    public JDBCConnectionCreationResponse getJDBCConnectionById(Integer id){
        JDBCConnectionCreationResponse jdbcConnectionCreationResponse = new JDBCConnectionCreationResponse();
        JDBCConnection jdbcConnection = jdbcConnectionRepository.findById(id).orElseThrow(() -> new RuntimeException("JDBCConnection not found"));

        jdbcConnectionCreationResponse.setJdbcId(jdbcConnection.getJdbcId());
        jdbcConnectionCreationResponse.setJdbcName(jdbcConnection.getJdbcName());
        jdbcConnectionCreationResponse.setJdbcUser(jdbcConnection.getJdbcUser());
        jdbcConnectionCreationResponse.setJdbcPassword(jdbcConnection.getJdbcPassword());
        jdbcConnectionCreationResponse.setDatabaseType(jdbcConnection.getDatabaseType());

        return jdbcConnectionCreationResponse;
    }

}
