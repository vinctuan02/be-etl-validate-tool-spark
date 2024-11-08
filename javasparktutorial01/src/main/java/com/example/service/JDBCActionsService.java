package com.example.service;

import com.example.dto.request.JDBCActionsCreationRequest;
import com.example.entity.JDBCConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

@Service
public class JDBCActionsService {

    @Autowired
    private JDBCConnectionService jdbcConnectionService;

    public Boolean testConnectionById (int id) {
        JDBCConnection jdbcConnection = jdbcConnectionService.getJDBCConnectionById(id);

        String jdbcUrl = jdbcConnection.getJdbcUrl();
        String jdbcUser = jdbcConnection.getJdbcUser();
        String jdbcPassword = jdbcConnection.getJdbcPassword();

        return checkConnection(jdbcUrl, jdbcUser, jdbcPassword);

    }

    public Boolean testConnectionByReqBody (JDBCActionsCreationRequest request){
        String jdbcUrl = request.getJdbcUrl();
        String jdbcUser = request.getJdbcUser();
        String jdbcPassword = request.getJdbcPassword();

        return checkConnection(jdbcUrl, jdbcUser, jdbcPassword);
    }

    public Boolean checkConnection (String jdbcUrl, String jdbcUser, String jdbcPassword) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            if(connection != null){
                System.out.println("Connected to database successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Connection to database failed: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Connection to database failed: " + e.getMessage());
                }
            }
        }

        return false;
    }

    public List<String> getDatabaseNames(JDBCActionsCreationRequest request) {
        List<String> tables = new ArrayList<>();

        String jdbcUrl = request.getJdbcUrl();
        String jdbcUser = request.getJdbcUser();
        String jdbcPassword = request.getJdbcPassword();

        String query = "SHOW DATABASES";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                tables.add(resultSet.getString(1)); // Lấy tên bảng từ kết quả
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tables;
    }

    public List<String> getTableNames(JDBCActionsCreationRequest request) {
        List<String> tables = new ArrayList<>();

        String jdbcUrl = request.getJdbcUrl();
        String jdbcUser = request.getJdbcUser();
        String jdbcPassword = request.getJdbcPassword();

        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)) {
            DatabaseMetaData metaData = connection.getMetaData();
            try (ResultSet resultSet = metaData.getTables(null, null, "%", new String[]{"TABLE"})) {
                while (resultSet.next()) {
                    tables.add(resultSet.getString("TABLE_NAME"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi lấy danh sách bảng: " + e.getMessage());
        }
        return tables;

    }

}
