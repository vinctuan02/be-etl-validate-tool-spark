package com.example.udf;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Console {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Log đối tượng dưới dạng JSON
    public static void log(Object object) {
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            System.out.println(json);
        } catch (Exception e) {
            System.out.println("Unable to convert object to JSON. Fallback to toString:");
            System.out.println(object);
        }
    }

    // Log với thông báo tùy chỉnh
    public static void log(String message, Object object) {
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            System.out.println(message + ": " + json);
        } catch (Exception e) {
            System.out.println(message + ": Unable to convert object to JSON. Fallback to toString:");
            System.out.println(object);
        }
    }

    // Log một chuỗi thông thường
    public static void log(String message) {
        System.out.println(message);
    }
}
