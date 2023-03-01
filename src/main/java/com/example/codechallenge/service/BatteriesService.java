package com.example.codechallenge.service;

import com.example.codechallenge.dto.BatteriesDto;
import com.example.codechallenge.entity.Batteries;
import com.example.codechallenge.exception.ApplicationException;
import com.example.codechallenge.repository.BatteriesRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BatteriesService {
    private final BatteriesRepository batteriesRepository;
    private final ModelMapper mapper;

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
}
