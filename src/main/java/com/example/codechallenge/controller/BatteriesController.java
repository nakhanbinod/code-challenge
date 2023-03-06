package com.example.codechallenge.controller;

import com.example.codechallenge.dto.BatteriesDto;
import com.example.codechallenge.response.ApiResponse;
import com.example.codechallenge.response.RestResponse;
import com.example.codechallenge.service.BatteriesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/")
@AllArgsConstructor
public class BatteriesController {
    private final BatteriesService batteriesService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> addBatteries(@RequestBody List<BatteriesDto> batteriesList){
        try {
            batteriesService.addBatteries(batteriesList);
        }catch (Exception ex){
            return RestResponse.message(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return RestResponse.message("Successfully batteries added", HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponse> batteriesListByPostCode(@RequestParam int postCodeFrom, @RequestParam int postCodeTo){
        List<BatteriesDto> batteriesDtoList =  batteriesService.getBatteriesByPostCodeRange(postCodeFrom, postCodeTo);
        return RestResponse.response("Date fetch Success", HttpStatus.FOUND, "batteries", batteriesDtoList);

    }

}
