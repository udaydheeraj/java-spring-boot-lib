package com.tech.atm.service;

import com.tech.atm.dto.ATMRequest;
import com.tech.atm.dto.ATMResponse;

import java.util.List;

public interface ATMService {

    ATMResponse createATM(ATMRequest  atmRequest);

    ATMResponse getATM(String atmCode);

    List<ATMResponse> getAllATMs();

    ATMResponse updateATM(String atmCode, ATMRequest atmRequest);

    void deleteATM(String atmCode);






}
