# Product Inventory Management System

A simple **Spring Boot CRUD application** built using **Spring Data JPA**, **Hibernate**, and **MySQL**. This project demonstrates how to perform CRUD operations on products and categories while learning entity relationships using `@ManyToOne` and `@OneToMany`.

---

## Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Lombok
* Postman

---

## Features

* Add a new category
* View all categories
* Add a new product
* View all products
* View a product by ID
* Update product details
* Delete a product
* Associate a product with a category
* Demonstrate One-to-Many and Many-to-One relationships

---

## Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.mnt.productinv
│   │       ├── controller
│   │       ├── entity
│   │       ├── repository
│   │       ├── service
│   │       ├── serviceimpl
│   │       └── ProductinvApplication.java
│   │
│   └── resources
│       ├── application.properties
│       └── data.sql (optional)
│
└── test
```

---

## Database Schema

### Category

| Column        | Type    |
| ------------- | ------- |
| category_id   | INT     |
| category_name | VARCHAR |
| description   | VARCHAR |

### Product

| Column           | Type              |
| ---------------- | ----------------- |
| product_id       | INT               |
| product_name     | VARCHAR           |
| brand            | VARCHAR           |
| price            | DOUBLE            |
| quantity         | INT               |
| manufacture_date | DATE              |
| category_id      | INT (Foreign Key) |

---

## Entity Relationship

```text
Category
-----------------------
category_id
category_name
description
      ▲
      │
      │ 1
      │
      │ N
Product
-----------------------
product_id
product_name
brand
price
quantity
manufacture_date
category_id (FK)
```

---

## JPA Relationship

### Product

```java
@ManyToOne
@JoinColumn(name = "category_id")
private Category category;
```

### Category

```java
@OneToMany(mappedBy = "category")
private List<Product> products;
```

---

## Repository Layer

* ProductRepository
* CategoryRepository

Both repositories extend:

```java
JpaRepository<Entity, Integer>
```

---

## Service Layer

Contains the business logic for:

* Saving products
* Updating products
* Deleting products
* Fetching products
* Managing categories

---

## Controller Layer

REST endpoints expose CRUD operations for products and categories.

Example endpoints:

| Method | Endpoint       | Description        |
| ------ | -------------- | ------------------ |
| GET    | /products      | Get all products   |
| GET    | /products/{id} | Get product by ID  |
| POST   | /products      | Add product        |
| PUT    | /products/{id} | Update product     |
| DELETE | /products/{id} | Delete product     |
| GET    | /categories    | Get all categories |
| POST   | /categories    | Add category       |

---

## Learning Objectives

This project helps you understand:

* Spring Boot project structure
* Spring Data JPA
* Hibernate ORM
* Entity mapping
* `@Entity`
* `@Table`
* `@Id`
* `@GeneratedValue`
* `@Column`
* `@ManyToOne`
* `@OneToMany`
* `@JoinColumn`
* Repository pattern
* Service layer architecture
* REST Controllers
* CRUD operations
* Foreign key relationships
* MySQL integration

---

## Future Enhancements

* Bean Validation
* Global Exception Handling
* DTO Pattern
* Custom JPQL Queries
* Native SQL Queries
* Pagination and Sorting
* Swagger/OpenAPI Documentation
* Unit and Integration Testing
* Product Search API
* Product Filtering by Category
* Spring Security with JWT Authentication

---

## Author

Developed as a learning project to understand Spring Boot, Spring Data JPA, Hibernate, REST APIs, and relational database mapping.
