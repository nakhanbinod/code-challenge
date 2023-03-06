package com.example.codechallenge.response;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ApiResponse {
    private String message;
    private int statusCode;
    private Map<String, Object> result;

    public void addPayload(String key, Object value) {
       this.result.put(key, value);
    }

    public ApiResponse() {
        this.result = new HashMap<>();
    }
}
