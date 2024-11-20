package com.example.controller;

import com.example.dto.response.ApiResponse;
import com.example.dto.request.JDBCConnectionCreationRequest;
import com.example.entity.JDBCConnection;
import com.example.service.JDBCConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jdbc_connection")
public class JDBCConnectionController {
    @Autowired
    private JDBCConnectionService jdbcConnectionService;

    @PostMapping("/create-jdbc_connection")
    ApiResponse<JDBCConnection> createJDBCConnection(@RequestBody JDBCConnectionCreationRequest request){
        ApiResponse<JDBCConnection> apiResponse = new ApiResponse<>();
        apiResponse.setResult(jdbcConnectionService.createJDBCConnection(request));

        return apiResponse;
    }

    @GetMapping("/get-all-jdbc_connections")
    public  ApiResponse<List<JDBCConnection>> getAllJDBCConnections() {
        ApiResponse<List<JDBCConnection>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(jdbcConnectionService.getAllJDBCConnections());
        return apiResponse;
    }

    @GetMapping("/get-jdbc_connection-by-id/{id}")
    public ApiResponse<JDBCConnection> getJDBCConnectionById(@PathVariable Integer id) {
        ApiResponse<JDBCConnection> apiResponse = new ApiResponse<>();
        apiResponse.setResult(jdbcConnectionService.getJDBCConnectionById(id));
        return apiResponse;
    }

}
