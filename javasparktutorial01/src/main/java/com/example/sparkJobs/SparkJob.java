package com.example.sparkJobs;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Component;

@Component
public class SparkJob {
    public void runSparkJob() {
        // Tắt tất cả log ở mức INFO và dưới
        LogManager.getLogger("org").setLevel(Level.WARN);
        LogManager.getLogger("akka").setLevel(Level.WARN);

        // Hoặc nếu muốn tắt toàn bộ logger
        LogManager.getRootLogger().setLevel(Level.WARN);
        // Tạo SparkSession
        SparkSession spark = SparkSession.builder()
                .appName("Compare Two Datasets from Different Sources")
                .config("spark.master", "local[*]")  // Sử dụng local mode
                .getOrCreate();

        // Thông tin kết nối tới MySQL cho DB Source
        String jdbcUrlSource = "jdbc:mysql://localhost:3306/bccs3_saga";
        String userSource = "vinc02";
        String passwordSource = "12345";

        // Tải dữ liệu từ bảng Source
        Dataset<Row> dataFrameSource = spark.read()
                .format("jdbc")
                .option("url", jdbcUrlSource)
                .option("dbtable", "message")
                .option("user", userSource)
                .option("password", passwordSource)
                .load();

        // Đếm và in số bản ghi
        long count = dataFrameSource.count();
        System.out.println("Số bản ghi trong bảng 'message': " + count);

        // Dừng SparkSession
        spark.stop();
    }
}
