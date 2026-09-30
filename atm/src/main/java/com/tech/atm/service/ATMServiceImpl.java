package com.tech.atm.service;

import com.tech.atm.dto.ATMRequest;
import com.tech.atm.dto.ATMResponse;
import com.tech.atm.entity.ATM;
import com.tech.atm.repository.ATMRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ATMServiceImpl implements ATMService {

    private final ATMRepository atmRepository;

    ATMServiceImpl(ATMRepository atmRepository) {
        this.atmRepository = atmRepository;
    }

    @Override
    @Transactional
    public ATMResponse createATM( @RequestBody ATMRequest atmRequest) {
        ATM entity = ATM.builder()
                .atmCode(atmRequest.getAtmCode())
                .location(atmRequest.getLocation())
                .status(atmRequest.getStatus())
                .cashAvailable(atmRequest.getCashAvailable())
                .build();

      ATM saveEntity =  atmRepository.save(entity);


        return ATMResponse.builder()
                .atmId(saveEntity.getAtmId())
                .atmCode(saveEntity.getAtmCode())
                .cashAvailable(saveEntity.getCashAvailable())
                .location(saveEntity.getLocation())
                .status(saveEntity.getStatus())
                .build();
    }

    @Override
    public ATMResponse getATM(String atmCode) {
        ATM entity = atmRepository.getATMByAtmCode(atmCode);
        return ATMResponse.builder()
                .atmId(entity.getAtmId())
                .atmCode(entity.getAtmCode())
                .cashAvailable(entity.getCashAvailable())
                .location(entity.getLocation())
                .status(entity.getStatus())
                .build();
    }

    @Override
    public List<ATMResponse> getAllATMs() {

        return atmRepository.findAll().stream()
                .map(entity -> ATMResponse.builder()
                        .atmId(entity.getAtmId())
                        .atmCode(entity.getAtmCode())
                        .cashAvailable(entity.getCashAvailable())
                        .location(entity.getLocation())
                        .status(entity.getStatus())
                        .build()).toList();
    }

    @Override
    @Transactional
    public ATMResponse updateATM(String atmCode, ATMRequest atmRequest) {

        ATM entity = atmRepository.getATMByAtmCode(atmCode);
        entity.setCashAvailable(atmRequest.getCashAvailable());
        entity.setLocation(atmRequest.getLocation());

        return ATMResponse.builder()
                .atmId(entity.getAtmId())
                .atmCode(entity.getAtmCode())
                .location(entity.getLocation())
                .cashAvailable(entity.getCashAvailable())
                .status(entity.getStatus())
                .build();
    }

    @Override
    @Transactional
    public void deleteATM(String atmCode) {

    }
}
