package com.example.simpleInterestCalculator.repository;

import com.example.simpleInterestCalculator.entity.SimpleInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleInterestRepository extends JpaRepository<SimpleInterest, Long> {

}