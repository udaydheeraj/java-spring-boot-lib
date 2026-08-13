package com.mnt.multiDB1.repository;

import com.mnt.multiDB1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Integer> {
}
