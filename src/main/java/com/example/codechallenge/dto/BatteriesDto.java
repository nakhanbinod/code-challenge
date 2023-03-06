package com.example.codechallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BatteriesDto {

    private String name;
    private int postCode;
    private int watt;
}
