package com.mnt.productinv.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    private String brand;

    private String category;

    private double price;

    private int quantity;

    @Column(name = "manufacture_date")
    private Date manufactureDate;

    @Column(name = "expiry_date")
    private Date expiryDate;




}
