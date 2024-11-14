package com.example.spark;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Component;

@Component
public class SparkJob {
    public void runSparkJob() {
//        // Tắt tất cả log ở mức INFO và dưới
        LogManager.getLogger("org").setLevel(Level.WARN);
        LogManager.getLogger("akka").setLevel(Level.WARN);
//
//        Logger.getLogger("org.apache.spark").setLevel(Level.ERROR);
//        Logger.getLogger("org.sparkproject.jetty").setLevel(Level.ERROR);
//
//        // Hoặc nếu muốn tắt toàn bộ logger
//        LogManager.getRootLogger().setLevel(Level.WARN);
//        // Tạo SparkSession
        SparkSession spark = SparkSession.builder()
                .appName("Compare Two Datasets from Different Sources")
                .config("spark.master", "local[*]")  // Sử dụng local mode
                .getOrCreate();
//
//        // Thông tin kết nối tới MySQL cho DB Source
        String jdbcUrlSource = "mongodb://localhost:27017/admin";
        String userSource = "vinc02";
        String passwordSource = "12345";

        Dataset<Row> dataFrame = spark.read()
                .format("mongo")
                .option("uri", jdbcUrlSource)  // URI của MongoDB
                .option("database", "admin")  // Tên cơ sở dữ liệu
                .option("collection", "users")  // Tên collection
                .load();

//        // Đếm và in số bản ghi
////        long count = dataFrame.count();
////        System.out.println("Số bản ghi trong bảng 'message': " + count);
//
//        long count = dataFrame.count();
//        System.out.println("Số bản ghi trong DataFrame: " + count);
//        if (count > 0) {
//            dataFrame.show();
//        } else {
//            System.out.println("Không có dữ liệu.");
//        }
//
//        System.out.println("Hello, World!");


    }
}
