package com.example.service;

import com.example.dto.request.TablePairCreationRequest;
import com.example.dto.response.ReportCreationResponse;
import com.example.dto.response.TablePairCreationResponse;
import com.example.entity.JDBCConnection;
import com.example.entity.Report;
import com.example.entity.TablePair;
import com.example.exception.AppException;
import com.example.exception.ErrorCode;
import com.example.mapper.ReportMapper;
import com.example.mapper.TablePairMapper;
import com.example.repository.JDBCConnectionRepository;
import com.example.repository.ReportRepository;
import com.example.repository.TablePairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TablePairService {
    @Autowired
    private ReportMapper reportMapper;
    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private JDBCConnectionRepository jdbcConnectionRepository;

    @Autowired
    private TablePairRepository tablePairRepository;
    @Autowired
    private TablePairMapper tablePairMapper;

    public TablePairCreationResponse createTablePair(TablePairCreationRequest request)  {
        Report report = reportRepository.findById(request.getReportId())
                .orElseThrow(()-> new AppException(ErrorCode.RECORD_NOT_FOUND));

        JDBCConnection jdbcSourceConnection = jdbcConnectionRepository.findById(request.getSourceJDBCId())
                .orElseThrow(()-> new AppException(ErrorCode.RECORD_NOT_FOUND));
        JDBCConnection jdbcSinkConnection = jdbcConnectionRepository.findById(request.getSinkJDBCId())
                .orElseThrow(()-> new AppException(ErrorCode.RECORD_NOT_FOUND));

        TablePair tablePair = tablePairMapper.toTablePair(request);
        tablePair.setSourceJDBCConnection(jdbcSourceConnection);
        tablePair.setSinkJDBCConnection(jdbcSinkConnection);
        tablePair.setReport(report);

        return tablePairMapper.toTablePairCreationResponse(tablePairRepository.save(tablePair));
    }

    public TablePairCreationResponse getTablePairById(Integer id){

        TablePairCreationResponse tablePairCreationResponse = new TablePairCreationResponse();

        TablePair tablePair = tablePairRepository.findById(id).orElseThrow(()-> new AppException(ErrorCode.RECORD_NOT_FOUND));

        tablePairCreationResponse.setPairId(tablePair.getPairId());
        tablePairCreationResponse.setReport(tablePair.getReport());
        tablePairCreationResponse.setSourceJDBCConnection(tablePair.getSourceJDBCConnection());
        tablePairCreationResponse.setSourceDatabaseName(tablePair.getSourceDatabaseName());
        tablePairCreationResponse.setSourceTableName(tablePair.getSourceTableName());
        tablePairCreationResponse.setSinkDatabaseName(tablePair.getSinkDatabaseName());
        tablePairCreationResponse.setSinkTableName(tablePair.getSinkTableName());
        tablePairCreationResponse.setSinkJDBCConnection(tablePair.getSinkJDBCConnection());

        return tablePairCreationResponse;

    }

    public List<TablePair> getTablePairsByReportId(Integer reportId) {
        List<TablePair> tablePairs = new ArrayList<>();
        tablePairs = tablePairRepository.findByReportReportId(reportId);
        return tablePairs;
    }

    public List<TablePair> getAllTablePair(){
        return  tablePairRepository.findAll();
    }

    public TablePair updateTablePair(Integer id, TablePairCreationRequest request){
        if(tablePairRepository.existsById(id)){

            TablePair tablePair = new TablePair();

            JDBCConnection jdbcSourceConnection = jdbcConnectionRepository.findById(request.getSourceJDBCId()).orElseThrow(() -> new RuntimeException("JDBCConnection not found"));
            JDBCConnection jdbcSinkConnection = jdbcConnectionRepository.findById(request.getSinkJDBCId()).orElseThrow(() -> new RuntimeException("JDBCConnection not found"));

//            tablePair.setReportId(request.getReportId());
            tablePair.setSourceJDBCConnection(jdbcSourceConnection);
            tablePair.setSinkJDBCConnection(jdbcSinkConnection);
            tablePair.setSourceTableName(request.getSourceTableName());
            tablePair.setSinkTableName(request.getSinkTableName());

            return tablePairRepository.save(tablePair);
        }else
            throw new RuntimeException("Table Pair not found");
    }

}
