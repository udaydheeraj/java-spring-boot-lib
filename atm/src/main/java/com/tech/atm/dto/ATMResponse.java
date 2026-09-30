package com.tech.atm.dto;

import com.tech.atm.entity.ATM;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ATMResponse {
    private  Integer atmId;
    private String atmCode;
    private String location;
    private ATM.ATMStatus status;
    private BigDecimal cashAvailable;
}
