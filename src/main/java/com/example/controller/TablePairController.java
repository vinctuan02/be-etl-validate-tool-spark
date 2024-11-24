package com.example.controller;

import com.example.dto.request.TablePairCreationRequest;
import com.example.dto.response.ApiResponse;
import com.example.dto.response.TablePairCreationResponse;
import com.example.entity.TablePair;
import com.example.service.TablePairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/table-pair")
public class TablePairController {
    @Autowired
    private TablePairService tablePairService;

    @PostMapping("/create-table-pair")
    ApiResponse<TablePairCreationResponse> createTablePair(@RequestBody TablePairCreationRequest request){

        ApiResponse<TablePairCreationResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(tablePairService.createTablePair(request));
        apiResponse.setMessage("Created Table Pair Success");
        return apiResponse;
    }

    @GetMapping("/get-table-pair/{id}")
    ApiResponse<TablePair> getTablePair(@PathVariable Integer id){
        ApiResponse<TablePair> apiResponse = new ApiResponse<>();
        apiResponse.setResult(tablePairService.getTablePairById(id));

        apiResponse.setMessage("GET Table Pair Success");
        return apiResponse;
    }

    @GetMapping("/get-table-pairs-by-report_id/{reportId}")
    ApiResponse<List<TablePair>> getTablePairsByReportId(@PathVariable Integer reportId){
        ApiResponse<List<TablePair>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(tablePairService.getTablePairsByReportId(reportId));

        apiResponse.setMessage("GET Table Pair Success");
        return apiResponse;
    }

    @GetMapping("/get-all-table-pair")
    ApiResponse<List<TablePair>> getAllTablePair(){
        ApiResponse<List<TablePair>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(tablePairService.getAllTablePair());
        apiResponse.setMessage("GET All Table Pair Success");
        return apiResponse;
    }

    @PutMapping ("/update-table-pair/{id}")
    ApiResponse<TablePair> updateTablePair(@PathVariable Integer id ,@RequestBody TablePairCreationRequest request){
        ApiResponse<TablePair> apiResponse = new ApiResponse<>();
        apiResponse.setResult(tablePairService.updateTablePair(id, request));
        apiResponse.setMessage("Update Table Pair Success");
        return apiResponse;
    }
}
