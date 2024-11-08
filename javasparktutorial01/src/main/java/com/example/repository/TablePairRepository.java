package com.example.repository;

import com.example.entity.TablePair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TablePairRepository extends JpaRepository<TablePair, Integer> {
}
