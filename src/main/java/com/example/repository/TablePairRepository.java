package com.example.repository;

import com.example.entity.TablePair;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TablePairRepository extends JpaRepository<TablePair, Integer> {
    List<TablePair> findByReportReportId(Integer reportId);
}
