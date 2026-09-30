package com.tech.atm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "atm")
public class ATM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atm_id")
    private Integer atmId;

    @Column(name = "atm_code", nullable = false, unique = true)
    private String atmCode;

    private String location;

    @Column(name = "cash_available", nullable = false)
    private BigDecimal cashAvailable;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ATMStatus status;

    public enum ATMStatus
    {
        ACTIVE,
        INACTIVE,
        MAINTENANCE

    }
}
