package com.example.codechallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BatteriesDto {
    public BatteriesDto(String name, int postCode, int watt) {
        this.name = name;
        this.postCode = postCode;
        this.watt = watt;
    }

    private String name;
    private int postCode;
    private int watt;
    private double totalWattCapacity;
    private double averageWattCapacity;

}
