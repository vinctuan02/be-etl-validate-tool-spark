package com.example.repository;

import com.example.entity.JDBCConnection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JDBCConnectionRepository extends JpaRepository<JDBCConnection, Integer> {
    boolean existsByJdbcName(String jdbcName);
}
