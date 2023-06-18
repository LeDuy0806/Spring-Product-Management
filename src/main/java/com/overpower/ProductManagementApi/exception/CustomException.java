package com.overpower.ProductManagementApi.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomException extends RuntimeException {
    private int statusCode;
    private String errorCode;
    private String timestamp;

    public CustomException(String message, int statusCode, String errorCode, LocalDateTime timestamp) {
        super(message);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.timestamp = timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    };


    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
