package com.tech.atm.service;

import com.tech.atm.dto.BankAccountRequest;
import com.tech.atm.dto.BankAccountResponse;
import com.tech.atm.entity.BankAccount;

import java.util.List;

public interface BankAccountService {

    public BankAccountResponse createBankAccount(BankAccountRequest bankAccountRequest);

    public BankAccount getAccountByAccountNumber(String accountNumber);

    public List<BankAccountResponse> getBankAccounts();

    public BankAccountResponse updateBankAccount(String accountNumber, BankAccountRequest bankAccountRequest);

    public void deleteBankAccount(String accountnumber);

    BankAccountResponse getBankAccountByAccountNumber(String accountNumber);
}
