package com.example.codechallenge.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestResponse {

    public static ResponseEntity<ApiResponse> message(String message, HttpStatus statusCode){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(message);
        apiResponse.setStatusCode(statusCode.value());
        return new ResponseEntity<>(apiResponse, statusCode);
    }
}
