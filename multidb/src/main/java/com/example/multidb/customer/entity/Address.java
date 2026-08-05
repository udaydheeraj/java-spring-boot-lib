package com.example.multidb.customer.entity;

import jakarta.persistence.*;

@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int addressId;

    private String city;

    private String state;

    private String country;

}
