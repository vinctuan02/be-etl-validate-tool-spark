package com.example.service;

import com.example.dto.request.JDBCConnectionCreationRequest;
import com.example.entity.JDBCConnection;
import com.example.exception.AppException;
import com.example.exception.ErrorCode;
import com.example.repository.JDBCConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JDBCConnectionService {
    @Autowired
    private JDBCConnectionRepository jdbcConnectionRepository;
    public JDBCConnection createJDBCConnection(JDBCConnectionCreationRequest request){

        if(jdbcConnectionRepository.existsByJdbcName(request.getJdbcName()))
            throw new AppException(ErrorCode.RECORD_EXISTED);

        JDBCConnection jdbcConnection = new JDBCConnection();
        jdbcConnection.setJdbcName(request.getJdbcName());
        jdbcConnection.setJdbcUrl(request.getJdbcUrl());
        jdbcConnection.setJdbcUser(request.getJdbcUser());
        jdbcConnection.setJdbcPassword(request.getJdbcPassword());
        jdbcConnection.setDatabaseType(request.getDatabaseType());

        jdbcConnectionRepository.save(jdbcConnection);

        return jdbcConnection;
    }

    public List<JDBCConnection> getAllJDBCConnections(){
        return  jdbcConnectionRepository.findAll();
    }

    public JDBCConnection getJDBCConnectionById(Integer id){
        return  jdbcConnectionRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
