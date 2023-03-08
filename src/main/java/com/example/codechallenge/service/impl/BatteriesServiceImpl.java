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
    public Object getBatteriesByPostCodeRange(int postCodeFrom, int postCodeTo) {
        List<Batteries> batteriesList = batteriesRepository.findByPostCodeBetween(postCodeFrom, postCodeTo);

        List<Batteries> filteredBatteries = batteriesList.stream()
                .filter(batteries -> batteries.getPostCode() >= postCodeFrom && batteries.getPostCode() <= postCodeTo)
                .toList();
        double totalWattCapacity = filteredBatteries.stream()
                .mapToDouble(Batteries::getWatt)
                .sum();

        double averageWattCapacity = filteredBatteries.stream()
                .mapToDouble(Batteries::getWatt)
                .average()
                .orElse(Double.NaN);

        List<BatteriesDto> batteriesDtos = filteredBatteries.stream()
                .map(batteries -> new BatteriesDto(batteries.getName(), batteries.getPostCode(), batteries.getWatt()))
                .sorted(Comparator.comparing(BatteriesDto::getName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());

        List<Object> responseList = new ArrayList<>();
        if (!batteriesDtos.isEmpty()) {
           responseList.addAll(batteriesDtos);
            Map<String, Double> capacityMap = new HashMap<>();
            capacityMap.put("totalWattCapacity", totalWattCapacity);
            capacityMap.put("averageWattCapacity", averageWattCapacity);
            responseList.add(capacityMap);
        }else{
            throw new ApplicationException("No Data Found");
        }

        return responseList;
    }


}
