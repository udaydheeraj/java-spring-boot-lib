package com.example.multidb.customer.repository;

import com.example.multidb.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface customerRepository extends JpaRepository<Customer,Integer> {

}
