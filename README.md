# LiteratureSpring

## Project description.

***This project demonstrates usage of Java technologies to create web application.***
**The application displays the result of the queries:** 
authors/books in any variation.authors/books in any variation. 
Repository layer retrieves data from MySQL database tables using JpaRepository. 
Converter and DTO layer added to project.
Added `CRUD Concept Application` (Create, Read, Update, Delete), tested on `Mysql`, version 5.1.47.

## Technologies used in the project:
- `Java core`, jdk 1.8
- `POJO`
- `Spring Boot`
- `JpaRepository`
- Database: `Mysql`, version 5.1.47
- Property package with `CRUD Concept Application` (Create, Read, Delete)
- `Lombok`, version 1.18.2
- Tools: git, maven
- Application/Web Server: Apache Tomcat

## Installation instructions:
- Clone repository
- Run mvn **clean install**
- Used database server - **mysql**
- Driver - **com.mysql.jdbc.Driver**
- Url - <jdbc:mysql://localhost:3306/library?useSSL=false&createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf-8&characterSetResults=utf-8&autoReconnect=true>
- Run the script to create a database
