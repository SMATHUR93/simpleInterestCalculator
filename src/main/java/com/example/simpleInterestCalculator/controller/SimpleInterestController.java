package com.example.simpleInterestCalculator.controller;

import com.example.simpleInterestCalculator.service.SimpleInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simple-interest")
public class SimpleInterestController {

    @Autowired
    private SimpleInterestService simpleInterestService;

    @PostMapping
    public Double calculateSimpleInterest(@RequestParam Double principal, @RequestParam Double rate, @RequestParam Double time) {
        return simpleInterestService.calculateSimpleInterest(principal, rate, time);
    }
}