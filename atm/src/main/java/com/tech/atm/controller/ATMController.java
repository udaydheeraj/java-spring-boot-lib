package com.tech.atm.controller;

import com.tech.atm.dto.ATMRequest;
import com.tech.atm.dto.ATMResponse;
import com.tech.atm.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atms")
public class ATMController {
    private final ATMService atmService;

    ATMController(ATMService atmService) {
        this.atmService = atmService;
    }

    @PostMapping
    public ATMResponse createATM(@RequestBody ATMRequest atmRequest) {
        return atmService.createATM(atmRequest);
    }

    @GetMapping("/{atmCode}")
    public ATMResponse getATM(@PathVariable String atmCode) {
        return atmService.getATM(atmCode);
    }

    @GetMapping
    public List<ATMResponse> getALLATMs() {
        return atmService.getAllATMs();
    }

    public ATMResponse updateATM(String atmCode, ATMRequest atmRequest) {
        return atmService.updateATM(atmCode,atmRequest);
    }

    public void deleteATM(String atmCode) {
        atmService.deleteATM(atmCode);
    }
}
