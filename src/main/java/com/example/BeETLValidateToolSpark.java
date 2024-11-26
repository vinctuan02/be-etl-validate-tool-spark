package com.example;

import com.example.entity.TablePair;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeETLValidateToolSpark {
	public static void main(String[] args) {

		SpringApplication.run(BeETLValidateToolSpark.class, args);
//		SparkJob sparkJob = new SparkJob();
//		sparkJob.runSparkJob();


//		ObjectMapper objectMapper = new ObjectMapper();
//		try {
//			String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
//			System.out.println(jsonString);
//		} catch (JsonProcessingException e) {
//			throw new RuntimeException(e);
//		}
//
	}
}
