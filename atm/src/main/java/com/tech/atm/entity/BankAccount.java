package com.tech.atm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "bank_accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "account_number", nullable = false, unique = true)
    private String accountNumber;

    @Column(name = "account_holder_name",nullable = false )
    private String accountHolderName;

    @Column(nullable = false )
    private String pin;

    @Column(nullable = false)
    private BigDecimal balance;

    public enum AccountStatus{
        ACTIVE,
        INACTIVE,
        BLOCKED,
        CLOSED
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus status;




}
