package com.tech.atm.dto;

import com.tech.atm.entity.BankAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountResponse {

    private Integer id;
    private String accountNumber;
    private String accountHolderName;
    private BigDecimal balance;
    private BankAccount.AccountStatus status;
}
