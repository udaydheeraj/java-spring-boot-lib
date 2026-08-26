package com.tech.atm.controller;

import com.tech.atm.dto.BankAccountRequest;
import com.tech.atm.dto.BankAccountResponse;
import com.tech.atm.entity.BankAccount;
import com.tech.atm.service.BankAccountService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController

@Data
public class BankAccountController {

    private final BankAccountService bankAccountService;
    BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping("/api/accounts")
    public ResponseEntity<BankAccountResponse>
    createBankAccount( @RequestBody BankAccountRequest bankAccountRequest) {
        BankAccountResponse bankAccountResponse = bankAccountService.createBankAccount(bankAccountRequest);
        return new ResponseEntity<>(bankAccountResponse, HttpStatus.CREATED);
    }

    @GetMapping("/api/accounts/{accountNumber}")
    public ResponseEntity<BankAccountResponse>
    getBankAccount(@PathVariable String accountNumber) {
        BankAccountResponse bankAccountResponse = bankAccountService.getBankAccountByAccountNumber(accountNumber);
        return new ResponseEntity<>(bankAccountResponse, HttpStatus.OK);
    }


    @GetMapping("/api/accounts")
    public List<BankAccountResponse> getAllBankAccounts() {
        return bankAccountService.getBankAccounts();
    }

    @PutMapping("/api/accounts/{accountNumber}")
    public ResponseEntity<BankAccountResponse>
    updateBankAccount(@PathVariable String accountNumber,@RequestBody BankAccountRequest bankAccountRequest) {
        BankAccountResponse updatedbankAccountResponse = bankAccountService.updateBankAccount(accountNumber,bankAccountRequest);

        return new ResponseEntity<>(updatedbankAccountResponse, HttpStatus.OK);
    }

    @DeleteMapping("/api/accounts/{accountNumber}")
    public ResponseEntity<Map<String,String>> deleteBankAccount(@PathVariable String accountNumber) {
        bankAccountService.deleteBankAccount(accountNumber);
        // Create a structured confirmation message
        Map<String, String> response = Map.of(
                "message", "Bank account deleted successfully",
                "accountNumber", accountNumber,
                "timestamp", java.time.Instant.now().toString()
        );

        return ResponseEntity.ok(response); // Returns HTTP 200 OK with JSON body

    }





}
