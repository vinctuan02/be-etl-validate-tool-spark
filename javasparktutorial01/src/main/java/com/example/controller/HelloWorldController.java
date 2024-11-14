package com.example.controller;

import com.example.spark.SparkJob;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
   private final SparkJob sparkJob;

    public HelloWorldController(SparkJob sparkJob) {
        this.sparkJob = sparkJob;
    }

    @GetMapping("/hello1")
    public String helloWorld() {
        try {
            sparkJob.runSparkJob();
            return "Hello from Spring Boot and Spark!";
        } catch (Exception e) {
            e.printStackTrace(); // Log the error for debugging
            return "Error occurred while running Spark job: " + e.getMessage();
        }
    }
}
