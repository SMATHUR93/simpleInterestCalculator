package com.example.simpleInterestCalculator.service;

import org.springframework.stereotype.Service;

@Service
public class SimpleInterestService {

    public Double calculateSimpleInterest(Double principal, Double rate, Double time) {
        return (principal * rate * time) / 100;
    }
}
