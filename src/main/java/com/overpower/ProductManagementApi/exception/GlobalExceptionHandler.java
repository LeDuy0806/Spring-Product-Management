package com.overpower.ProductManagementApi.exception;

import org.springframework.dao.DuplicateKeyException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ex.getStatusCode(), ex.getErrorCode(), ex.getTimestamp());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(ex.getStatusCode()));
    }
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<String> handleDuplicateKeyException(DuplicateKeyException ex) {
        String errorMessage = ex.getMessage();

        if (errorMessage.contains("userName")) {
            errorMessage = "Username already exists";
        } else if (errorMessage.contains("mail")) {
            errorMessage = "Email already exists";
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class ErrorResponse {
    private String message;
    private int statusCode;
    private String errorCode;
    private String timestamp;


}
