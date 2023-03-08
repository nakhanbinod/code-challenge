package com.example.codechallenge.service;

import com.example.codechallenge.dto.BatteriesDto;

import java.util.List;


public interface BatteriesService {
    void addBatteries(List<BatteriesDto> batteriesDtos);
    Object getBatteriesByPostCodeRange(int postCodeFrom, int postCodeTo);

}
