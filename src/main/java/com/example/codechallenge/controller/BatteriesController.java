package com.example.codechallenge.controller;

import com.example.codechallenge.dto.BatteriesDto;
import com.example.codechallenge.response.ApiResponse;
import com.example.codechallenge.response.RestResponse;
import com.example.codechallenge.service.BatteriesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/")
@AllArgsConstructor
@Validated
public class BatteriesController {

    private final BatteriesService batteriesService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addBatteries(@Valid @RequestBody List<BatteriesDto> batteriesList){
        try {
            batteriesService.addBatteries(batteriesList);
        }catch (Exception ex){
            return RestResponse.message(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return RestResponse.message("Successfully batteries added", HttpStatus.OK);
    }


}
