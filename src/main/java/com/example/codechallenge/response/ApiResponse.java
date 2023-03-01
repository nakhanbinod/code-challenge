package com.example.codechallenge.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    private String message;
    private int statusCode;
}
