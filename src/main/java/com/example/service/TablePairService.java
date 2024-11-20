package com.example.service;

import com.example.dto.request.TablePairCreationRequest;
import com.example.dto.response.ReportCreationResponse;
import com.example.entity.JDBCConnection;
import com.example.entity.Report;
import com.example.entity.TablePair;
import com.example.exception.AppException;
import com.example.exception.ErrorCode;
import com.example.repository.TablePairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TablePairService {

    @Autowired
    private TablePairRepository tablePairRepository;

    @Autowired
    private ReportService reportService;

    @Autowired
    private JDBCConnectionService jdbcConnectionService;

    public TablePair createTablePair(TablePairCreationRequest request){

//        if(tablePairRepository.existsById(request.getPairId()))
//            throw new AppException(ErrorCode.RECORD_EXISTED);
        ReportCreationResponse reportCreationResponse = reportService.getReportById(request.getReportId());

        Report report = new Report();
        report.setReportId(reportCreationResponse.getReportId());
        report.setReportName(reportCreationResponse.getReportName());
        report.setStatus(reportCreationResponse.getStatus());
        report.setNote(reportCreationResponse.getNote());
//        report.setTablePairs(reportCreationResponse.getTablePairs());

        JDBCConnection jdbcSourceConnection = jdbcConnectionService.getJDBCConnectionById(request.getSourceJDBCId());
        JDBCConnection jdbcSinkConnection = jdbcConnectionService.getJDBCConnectionById(request.getSinkJDBCId());


        TablePair tablePair = new TablePair();
        tablePair.setSourceJDBCConnection(jdbcSourceConnection);
        tablePair.setSinkJDBCConnection(jdbcSinkConnection);
        tablePair.setSourceTableName(request.getSourceTableName());
        tablePair.setSinkTableName(request.getSinkTableNames());
        tablePair.setSourceDatabaseName(request.getSourceDatabaseName());
        tablePair.setSinkDatabaseName(request.getSinkDatabaseName());
        tablePair.setReport(report);

        return tablePairRepository.save(tablePair);
    }

    public TablePair getTablePairById(Integer id){
        return tablePairRepository.findById(id).
                orElseThrow(()-> new AppException(ErrorCode.RECORD_NOT_FOUND));
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

            JDBCConnection jdbcSourceConnection = jdbcConnectionService.getJDBCConnectionById(request.getSourceJDBCId());
            JDBCConnection jdbcSinkConnection = jdbcConnectionService.getJDBCConnectionById(request.getSinkJDBCId());

//            tablePair.setReportId(request.getReportId());
            tablePair.setSourceJDBCConnection(jdbcSourceConnection);
            tablePair.setSinkJDBCConnection(jdbcSinkConnection);
            tablePair.setSourceTableName(request.getSourceTableName());
            tablePair.setSinkTableName(request.getSinkTableNames());

            return tablePairRepository.save(tablePair);
        }else
            throw new RuntimeException("Table Pair not found");
    }

}
