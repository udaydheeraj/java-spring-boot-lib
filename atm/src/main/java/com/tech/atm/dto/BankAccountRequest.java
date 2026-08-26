package com.tech.atm.dto;


import com.tech.atm.entity.BankAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountRequest {
    private String accountNumber;
    private String accountHolderName;
    private String pin;
    private BigDecimal initialBalance;
    private BankAccount.AccountStatus status;
}
