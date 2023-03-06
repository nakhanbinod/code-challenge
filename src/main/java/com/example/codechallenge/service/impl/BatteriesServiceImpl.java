package com.example.codechallenge.service.impl;

import com.example.codechallenge.dto.BatteriesDto;
import com.example.codechallenge.entity.Batteries;
import com.example.codechallenge.exception.ApplicationException;
import com.example.codechallenge.repository.BatteriesRepository;
import com.example.codechallenge.service.BatteriesService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BatteriesServiceImpl implements BatteriesService {

    private final BatteriesRepository batteriesRepository;
    private final ModelMapper mapper;

    @Override
    public void addBatteries(List<BatteriesDto> batteriesList){
        try {
            List<Batteries> batteries  = batteriesList.stream()
                    .map(batteriesDto -> mapper.map(batteriesDto, Batteries.class))
                    .collect(Collectors.toList());
            batteriesRepository.saveAll(batteries);
        } catch (Exception ex){
            throw new ApplicationException(ex.getMessage());
        }

    }

    @Override
    public List<BatteriesDto> getBatteriesByPostCodeRange(int postCodeFrom, int postCodeTo) {
        List<Batteries> batteriesList = batteriesRepository.findByPostCodeBetween(postCodeFrom, postCodeTo);
        List<BatteriesDto> batteriesDtos = batteriesList.stream()
                .filter(batteries -> batteries.getPostCode() >= postCodeFrom && batteries.getPostCode() <= postCodeTo)
                .map(batteries -> new BatteriesDto(batteries.getName(), batteries.getPostCode(), batteries.getWatt()))
                .sorted(Comparator.comparing(BatteriesDto::getName, String.CASE_INSENSITIVE_ORDER))
                .toList();
        return batteriesDtos;
    }


}
