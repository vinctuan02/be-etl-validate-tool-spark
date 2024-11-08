package com.example.controller;

import com.example.dto.request.JDBCActionsCreationRequest;
import com.example.dto.response.ApiResponse;
import com.example.service.JDBCActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/JDBCActions")
public class JDBCActionsController {
    @Autowired
    private JDBCActionsService JDBCActionsService;

    @GetMapping("/test-connection-by-id/{id}")
    ApiResponse<Boolean> testConnectionById (@PathVariable Integer id) {
        ApiResponse<Boolean> apiResponse = new ApiResponse<>();
        Boolean result = JDBCActionsService.testConnectionById(id);
        apiResponse.setResult(result);

        return apiResponse;
    }

    @PostMapping("/test-connection")
    ApiResponse<Boolean> testConnection (@RequestBody JDBCActionsCreationRequest request) {

        ApiResponse<Boolean> apiResponse = new ApiResponse<>();

        Boolean result = JDBCActionsService.testConnectionByReqBody(request);
        apiResponse.setResult(result);

        return apiResponse;
    }

    @PostMapping("/get-database-names")
    ApiResponse<List<String>> getDatabaseNames (@RequestBody JDBCActionsCreationRequest request) {
        ApiResponse<List<String>> apiResponse = new ApiResponse<>();
        List<String> result = JDBCActionsService.getDatabaseNames(request);
        apiResponse.setResult(result);

        return apiResponse;
    }

    @PostMapping("/get-table-names")
    ApiResponse<List<String>> getTableNames (@RequestBody JDBCActionsCreationRequest request) {
        ApiResponse<List<String>> apiResponse = new ApiResponse<>();
        List<String> result = JDBCActionsService.getTableNames(request);
        apiResponse.setResult(result);

        return apiResponse;
    }
}
