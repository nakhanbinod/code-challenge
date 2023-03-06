package com.example.codechallenge.repository;

import com.example.codechallenge.entity.Batteries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatteriesRepository extends JpaRepository<Batteries, Long> {

    List<Batteries> findByPostCodeBetween(Integer postCodeFrom, Integer postCodeTo);

}
