package com.tech.atm.service;

import com.tech.atm.dto.BankAccountRequest;
import com.tech.atm.dto.BankAccountResponse;
import com.tech.atm.entity.BankAccount;
import com.tech.atm.repository.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository  bankAccountRepository;

    BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    @Transactional
    public BankAccountResponse createBankAccount(BankAccountRequest bankAccountRequest) {
        BankAccount entity = BankAccount.builder()
                .accountNumber(bankAccountRequest.getAccountNumber())
                .accountHolderName(bankAccountRequest.getAccountHolderName())
                .pin(bankAccountRequest.getPin())
                .balance(bankAccountRequest.getInitialBalance())
                .status(BankAccount.AccountStatus.ACTIVE)
                .build();

        BankAccount savedAccount = bankAccountRepository.save(entity);
       return BankAccountResponse.builder()
               .id(savedAccount.getId())
               .accountNumber(savedAccount.getAccountNumber())
               .accountHolderName(savedAccount.getAccountHolderName())
               .balance(savedAccount.getBalance())
               .status(BankAccount.AccountStatus.ACTIVE)
               .build();

    }

    @Override
    public BankAccount getAccountByAccountNumber(String accountNumber) {
        return bankAccountRepository.findByAccountNumber(accountNumber);

    }

    @Override
    public List<BankAccountResponse> getBankAccounts() {
        return bankAccountRepository.findAll().stream()
                .map(bankAccount -> BankAccountResponse.builder()
                        .id(bankAccount.getId())
                        .accountNumber(bankAccount.getAccountNumber())
                        .accountHolderName(bankAccount.getAccountHolderName())
                        .balance(bankAccount.getBalance())
                        .status(bankAccount.getStatus())
                        .build())
                .toList();
    }

    @Override
    @Transactional
    public BankAccountResponse updateBankAccount(String accountNumber, BankAccountRequest bankAccountRequest) {
        BankAccount existingAccount = bankAccountRepository.findByAccountNumber(accountNumber);
        existingAccount.setAccountHolderName(bankAccountRequest.getAccountHolderName());
        existingAccount.setPin(bankAccountRequest.getPin());
        existingAccount.setBalance(bankAccountRequest.getInitialBalance());

       BankAccount savedAccount =  bankAccountRepository.save(existingAccount);
       return BankAccountResponse.builder()
               .id(savedAccount.getId())
               .accountNumber(savedAccount.getAccountNumber())
               .accountHolderName(savedAccount.getAccountHolderName())
               .balance(savedAccount.getBalance())
               .status(savedAccount.getStatus())
               .build();
    }

    @Override
    @Transactional
    public void deleteBankAccount(String accountNumber) {
        BankAccount toDelete = bankAccountRepository.findByAccountNumber(accountNumber);
        bankAccountRepository.delete(toDelete);
    }

    @Override
    public BankAccountResponse getBankAccountByAccountNumber(String accountNumber) {
        BankAccount bankAccount = bankAccountRepository.findByAccountNumber(accountNumber);
        return BankAccountResponse.builder()
                .accountNumber(bankAccount.getAccountNumber())
                .id(bankAccount.getId())
                .accountHolderName(bankAccount.getAccountHolderName())
                .status(bankAccount.getStatus())
                .build();
    }


}
