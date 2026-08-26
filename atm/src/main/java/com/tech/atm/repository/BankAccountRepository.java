package com.tech.atm.repository;

import com.tech.atm.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Integer> {
    BankAccount findByAccountNumber(String accountNumber);
}
