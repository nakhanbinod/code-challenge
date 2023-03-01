package com.example.codechallenge;

import com.example.codechallenge.dto.BatteriesDto;
import com.example.codechallenge.entity.Batteries;
import com.example.codechallenge.repository.BatteriesRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest
@AutoConfigureMockMvc
public class BatteryTest {

    private final Logger logger = LoggerFactory.getLogger(BatteryTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BatteriesRepository batteriesRepository;

    @Test
    public void addBatteries(){

    }


}
