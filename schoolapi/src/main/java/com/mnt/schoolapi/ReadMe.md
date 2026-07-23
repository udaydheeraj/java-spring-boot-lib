students table --> 
entity (table)--> 
repository(database JPA) -->
service(B.Logic) --> 
Controller(Restapi- endpoint) --->

browser/postman : 127.0.0.1:8080/students
-------------------------------------------------------------

Browser/Postman

GET /students

      │

      ▼

StudentController

      │

calls

      ▼

StudentService

      │

calls

      ▼

StudentRepository

      │

findAll()

      │

Hibernate

      │

SELECT * FROM students;

      │

PostgreSQL

      │

returns rows

      │

Hibernate converts rows → Student objects

      │

Spring Boot converts List<Student>

      │

JSON

      │

Browser/Postman