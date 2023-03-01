package com.example.codechallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
public class BatteriesDto {

    @NotEmpty(message = "name must not be empty")
    private String name;
    @NotEmpty(message = "postCode must not be empty")
    private String postCode;
    @NotEmpty(message = "watt must not be empty")
    private String watt;
}
