package com.mnt.productinv.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    private String brand;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    private Double price;

    private Integer quantity;

    @Column(name = "manufacture_date")
    private LocalDate manufactureDate;

    public Product(String productName, String brand, Category category, Double price, Integer quantity, LocalDate manufactureDate) {
        this.productName = productName;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.manufactureDate = manufactureDate;
    }
}
