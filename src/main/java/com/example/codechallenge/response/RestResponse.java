package com.example.codechallenge.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

public class RestResponse {

    public static ResponseEntity<ApiResponse> message(String message, HttpStatus statusCode){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(message);
        apiResponse.setStatusCode(statusCode.value());
        return new ResponseEntity<>(apiResponse, statusCode);
    }
    public static ResponseEntity<ApiResponse> response(String message, HttpStatus statusCode, String payloadKey, Object payload) {
        ApiResponse apiResponse = new ApiResponse();
        if (!StringUtils.isEmpty(payloadKey)){
            apiResponse.addPayload(payloadKey, payload);
            apiResponse.setStatusCode(statusCode.value());
        }
        apiResponse.setMessage(message);
        return new ResponseEntity<>(apiResponse, statusCode);
    }

}
