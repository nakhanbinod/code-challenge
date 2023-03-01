package com.example.codechallenge.repository;

import com.example.codechallenge.entity.Batteries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatteriesRepository extends JpaRepository<Batteries, Long> {

}
