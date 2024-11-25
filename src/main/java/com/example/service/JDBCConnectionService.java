package com.example.service;

import com.example.dto.request.JDBCConnectionCreationRequest;
import com.example.dto.response.JDBCConnectionCreationResponse;
import com.example.entity.JDBCConnection;
import com.example.exception.AppException;
import com.example.exception.ErrorCode;
import com.example.mapper.JDBCConnectionMapper;
import com.example.repository.JDBCConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JDBCConnectionService {
    @Autowired
    private JDBCConnectionRepository jdbcConnectionRepository;
    @Autowired
    private JDBCConnectionMapper jdbcConnectionMapper;

    public JDBCConnectionCreationResponse createJDBCConnection(JDBCConnectionCreationRequest request){

        if(jdbcConnectionRepository.existsByJdbcName(request.getJdbcName()))
            throw new AppException(ErrorCode.RECORD_EXISTED);
        JDBCConnection jdbcConnection = jdbcConnectionMapper.toJDBCConnection(request);

        return jdbcConnectionMapper.toJDBCConnectionCreationResponse(jdbcConnectionRepository.save(jdbcConnection));
    }

    public List<JDBCConnectionCreationResponse> getAllJDBCConnections(){
        List<JDBCConnectionCreationResponse> jdbcConnectionCreationResponses = new ArrayList<>();
        List<JDBCConnection> jdbcConnections = jdbcConnectionRepository.findAll();

        for (JDBCConnection jdbcConnection: jdbcConnections) {
            JDBCConnectionCreationResponse jdbcConnectionCreationResponse = jdbcConnectionMapper.toJDBCConnectionCreationResponse(jdbcConnection);
            jdbcConnectionCreationResponses.add(jdbcConnectionCreationResponse);
        }

        return jdbcConnectionCreationResponses;
    }

    public JDBCConnectionCreationResponse getJDBCConnectionById(Integer id){
        JDBCConnectionCreationResponse jdbcConnectionCreationResponse = new JDBCConnectionCreationResponse();
        JDBCConnection jdbcConnection = jdbcConnectionRepository.findById(id).orElseThrow(() -> new RuntimeException("JDBCConnection not found"));

        return jdbcConnectionMapper.toJDBCConnectionCreationResponse(jdbcConnection);
    }

}
