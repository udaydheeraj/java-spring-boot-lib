# Spring Core Concepts

## Introduction

The Spring Framework is one of the most popular Java frameworks for
building enterprise applications. It simplifies application development
by managing objects (called **beans**), handling dependencies
automatically, and promoting clean, maintainable, and loosely coupled
code.

At the heart of Spring lies the **Spring Core Container**, which
provides features like **Inversion of Control (IoC)** and **Dependency
Injection (DI)**. These concepts make applications easier to develop,
test, and maintain.

This document introduces the essential Spring Core concepts in a
beginner-friendly way.

------------------------------------------------------------------------

# Spring Framework Basics

Spring is an open-source Java framework developed to simplify enterprise
application development. Instead of developers manually creating and
managing objects, Spring takes responsibility for creating, configuring,
and connecting them.

### Why Spring?

Without Spring: - Objects are tightly coupled. - Code becomes difficult
to maintain. - Testing becomes harder. - Replacing implementations
requires code changes.

With Spring: - Objects are loosely coupled. - Dependencies are managed
automatically. - Applications become modular and easier to test. -
Configuration is centralized.

Spring achieves this through two fundamental concepts: - Inversion of
Control (IoC) - Dependency Injection (DI)

------------------------------------------------------------------------

# Inversion of Control (IoC)

**Inversion of Control (IoC)** means transferring the responsibility of
creating and managing objects from the programmer to the Spring
Framework.

Normally:

``` java
Engine engine = new Engine();
Car car = new Car(engine);
```

With Spring:

``` java
Car car = context.getBean(Car.class);
```

Spring creates the required objects, injects dependencies, and returns a
fully configured bean.

------------------------------------------------------------------------

# Dependency Injection (DI)

A dependency is an object another object requires to perform its work.

Three types of DI:

### Constructor Injection

``` java
public Car(Engine engine) {
    this.engine = engine;
}
```

### Setter Injection

``` java
public void setEngine(Engine engine) {
    this.engine = engine;
}
```

### Field Injection

``` java
@Autowired
private Engine engine;
```

Constructor injection is generally recommended.

------------------------------------------------------------------------

# Spring Container

The Spring Container creates beans, injects dependencies, manages bean
lifecycle and configuration.

## BeanFactory

A lightweight container that creates beans lazily.

``` java
BeanFactory factory = ...
Car car = factory.getBean(Car.class);
```

## ApplicationContext

The advanced container used by almost all Spring applications.

``` java
ApplicationContext context =
    new AnnotationConfigApplicationContext(AppConfig.class);
```

------------------------------------------------------------------------

# Spring Beans

A **Bean** is simply an object managed by the Spring Container.

``` java
@Component
public class Engine {
}
```

Beans have a name, type, scope, and lifecycle.

------------------------------------------------------------------------

# Component Scanning

Spring automatically scans packages for annotated classes.

``` java
@ComponentScan("com.example")
```

------------------------------------------------------------------------

# Stereotype Annotations

## @Component

``` java
@Component
public class Engine {}
```

## @Service

``` java
@Service
public class StudentService {}
```

## @Repository

``` java
@Repository
public class StudentRepository {}
```

## @Controller

``` java
@Controller
public class StudentController {}
```

------------------------------------------------------------------------

# @Autowired, @Qualifier, @Primary

## @Autowired

``` java
@Autowired
private Engine engine;
```

## @Qualifier

``` java
@Autowired
@Qualifier("dieselEngine")
private Engine engine;
```

## @Primary

``` java
@Bean
@Primary
public Engine petrolEngine() {
    return new PetrolEngine();
}
```

------------------------------------------------------------------------

# @Configuration and @Bean

## @Configuration

``` java
@Configuration
public class AppConfig {}
```

## @Bean

``` java
@Bean
public Engine engine() {
    return new Engine();
}
```

------------------------------------------------------------------------

# Bean Scopes (@Scope)

Singleton (default):

``` java
@Scope("singleton")
```

Prototype:

``` java
@Scope("prototype")
```

------------------------------------------------------------------------

# Bean Lifecycle

1.  Bean creation
2.  Dependency injection
3.  Initialization
4.  Ready to use
5.  Destruction

## @PostConstruct

``` java
@PostConstruct
public void init() {}
```

## @PreDestroy

``` java
@PreDestroy
public void destroy() {}
```

------------------------------------------------------------------------

# @Lazy

``` java
@Lazy
@Component
public class ReportGenerator {}
```

Creates the bean only when first needed.

------------------------------------------------------------------------

# @Value and External Properties

`application.properties`

``` properties
app.name=Student Management System
```

Inject the value:

``` java
@Value("${app.name}")
private String appName;
```

------------------------------------------------------------------------

# Summary

Spring Core revolves around the IoC Container, Dependency Injection,
bean management, component scanning, Java configuration, bean scopes,
lifecycle callbacks, lazy initialization, and externalized
configuration. Mastering these concepts provides a solid foundation for
Spring Boot, Spring MVC, Spring Data JPA, and Spring Security.
