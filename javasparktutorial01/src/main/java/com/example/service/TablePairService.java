package com.example.service;

import com.example.dto.request.TablePairCreationRequest;
import com.example.entity.TablePair;
import com.example.exception.AppException;
import com.example.exception.ErrorCode;
import com.example.repository.TablePairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TablePairService {

    @Autowired
    private TablePairRepository tablePairRepository;

    public TablePair createTablePair(TablePairCreationRequest request){

        if(tablePairRepository.existsById(request.getPairId()))
            throw new AppException(ErrorCode.RECORD_EXISTED);

        TablePair tablePair = new TablePair();
        tablePair.setSourceJDBCId(request.getSourceJDBCId());
        tablePair.setSinkJDBCId(request.getSinkJDBCId());
        tablePair.setSourceTableName(request.getSourceTableName());
        tablePair.setSinkTableNames(request.getSinkTableNames());
        tablePair.setReportId(request.getReportId());

        return tablePairRepository.save(tablePair);
    }

    public TablePair getTablePairById(Integer id){
        return tablePairRepository.findById(id).
                orElseThrow(()-> new AppException(ErrorCode.RECORD_NOT_FOUND));
    }

    public List<TablePair> getAllTablePair(){
        return  tablePairRepository.findAll();
    }

    public TablePair updateTablePair(Integer id, TablePairCreationRequest request){
        if(tablePairRepository.existsById(id)){

            TablePair tablePair = new TablePair();

            tablePair.setReportId(request.getReportId());
            tablePair.setSourceJDBCId(request.getSourceJDBCId());
            tablePair.setSinkJDBCId(request.getSinkJDBCId());
            tablePair.setSourceTableName(request.getSourceTableName());
            tablePair.setSinkTableNames(request.getSinkTableNames());

            return tablePairRepository.save(tablePair);
        }else
            throw new RuntimeException("Table Pair not found");
    }

}
