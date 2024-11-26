package com.example.spark;

import com.example.entity.TablePair;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Service;

@Service
public class SparkService {
    public void compareDataFrame(TablePair tablePair) {

        SparkSession spark = SparkSession.builder()
                .appName("Compare Two Datasets from Different Sources")
                .config("spark.master", "local[*]")  // Sử dụng local mode
                .getOrCreate();

        Dataset<Row> dataFrameSource = createDataFrame(
                spark,
                tablePair.getSourceJDBCConnection().getDatabaseType(),
                tablePair.getSourceJDBCConnection().getJdbcUrl(),
                tablePair.getSourceJDBCConnection().getJdbcUser(),
                tablePair.getSourceJDBCConnection().getJdbcPassword(),
                tablePair.getSourceDatabaseName(),
                tablePair.getSourceTableName()
        );

        Dataset<Row> dataFrameSink = createDataFrame(
                spark,
                tablePair.getSinkJDBCConnection().getDatabaseType(),
                tablePair.getSinkJDBCConnection().getJdbcUrl(),
                tablePair.getSinkJDBCConnection().getJdbcUser(),
                tablePair.getSinkJDBCConnection().getJdbcPassword(),
                tablePair.getSinkDatabaseName(),
                tablePair.getSinkTableName()
        );

        dataFrameSource.printSchema();
        dataFrameSink.printSchema();
    }

    public Dataset<Row> createDataFrame(
            SparkSession spark,
            String databaseType,
            String jdbcUrl,
            String user,
            String password,
            String databaseName,
            String tableName
    ) {
        Dataset<Row> dataFrame;

        // Kiểm tra loại cơ sở dữ liệu và thực hiện các bước đọc dữ liệu tương ứng
        switch (databaseType) {
            case "mysql":
                // Đọc dữ liệu từ MySQL
                dataFrame = spark.read()
                        .format("jdbc")
                        .option("url", jdbcUrl)
                        .option("dbtable", tableName)
                        .option("user", user)
                        .option("password", password)
                        .load();
                return dataFrame;

            case "oracle":
                // Đọc dữ liệu từ Oracle
                dataFrame = spark.read()
                        .format("jdbc")
                        .option("url", jdbcUrl)  // jdbc:oracle:thin:@localhost:1521:ORCLCDB
                        .option("dbtable", tableName) //C##VINC02.USERS
                        .option("user", user) // system
                        .option("password", password)
                        .option("driver", "oracle.jdbc.OracleDriver")  // Có thể sửa tên driver nếu cần
                        .load();
                return dataFrame;

            case "mongodb":
                // Đọc dữ liệu từ MongoDB
                dataFrame = spark.read()
                        .format("mongodb")
                        .option("uri", jdbcUrl)  // URI của MongoDB (mongodb://localhost:27017)
                        .option("database", databaseName)  // Tên cơ sở dữ liệu
                        .option("collection", tableName)  // Tên collection
                        .load();
                return dataFrame;

            default:
                throw new IllegalArgumentException("Unsupported database type: " + databaseType);
        }
    }
}