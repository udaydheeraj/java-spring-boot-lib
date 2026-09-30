package com.tech.atm.repository;

import com.tech.atm.entity.ATM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ATMRepository extends JpaRepository<ATM, Integer> {
    ATM getATMByAtmCode(String atmCode);
}
