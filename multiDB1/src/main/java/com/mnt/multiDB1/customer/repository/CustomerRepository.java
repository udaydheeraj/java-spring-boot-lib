package com.mnt.multiDB1.customer.repository;

import com.mnt.multiDB1.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository
        extends JpaRepository<Customer, Integer> {
}
