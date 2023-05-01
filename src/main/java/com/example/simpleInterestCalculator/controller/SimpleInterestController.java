package com.example.simpleInterestCalculator.controller;

import com.example.simpleInterestCalculator.service.SimpleInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/simple-interest")
public class SimpleInterestController {

    @Autowired
    private RestTemplate restTemplate;

    public SimpleInterestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    private SimpleInterestService simpleInterestService;

    @GetMapping
    public Double calculateSimpleInterest(@RequestParam Double principal, @RequestParam Double rate, @RequestParam Double time) {
        return simpleInterestService.calculateSimpleInterest(principal, rate, time);
    }

    @GetMapping("/compound-interest")
    public ResponseEntity<Double> getCompoundInterest(@RequestParam double principal, @RequestParam double rate, @RequestParam double time) {
        double simpleInterest = simpleInterestService.calculateSimpleInterest(principal, rate, time);
        ResponseEntity<Double> response = restTemplate.getForEntity(
                "http://172.18.0.3:5002/compound-interest?principal={principal}&rate={rate}&time={time}&simpleInterest={simpleInterest}",
                Double.class, principal, rate, time, simpleInterest);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok(response.getBody());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}