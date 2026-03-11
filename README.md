🏛 Local Permit Registry System
📌 Project Description

The Local Permit Registry System is a web-based application built using Spring Boot and MySQL that helps manage and maintain records of local permits efficiently.

This system allows users or administrators to store, view, and manage permit information in a centralized database. The application demonstrates how modern backend technologies like Spring Boot, Spring Data JPA, and Hibernate can be used to build a scalable web system.

The project is designed mainly for learning backend development and building real-world Java applications.






🚀 Features

✔ Register new permits
✔ View all permit records
✔ Store permit data in MySQL database
✔ Backend developed with Spring Boot
✔ Uses Spring Data JPA for database operations
✔ Embedded Tomcat server for running the application


🛠 Technologies Used
Technology	Purpose
Java 21	Core programming language
Spring Boot	Application framework
Spring MVC	Web architecture
Spring Data JPA	Database access
Hibernate	ORM framework
MySQL	Database
Maven	Dependency management
Tomcat Embedded	Web server


📂 Project Structure
local-permit-registry
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.localpermit
│   │   │       ├── controller
│   │   │       ├── service
│   │   │       ├── repository
│   │   │       ├── entity
│   │   │       └── LocalPermitRegistryApplication.java
│   │   │
│   │   └── resources
│   │       ├── application.properties
│   │       └── templates / jsp pages
│
├── pom.xml
└── README.md



⚙ Installation & Setup

1️⃣ Clone the Repository
git clone https://github.com/rahulkumarA59/local-permit-registry.git

2️⃣ Navigate to Project
cd local-permit-registry

3️⃣ Configure Database
Edit application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/permit_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

4️⃣ Run the Application

Using Maven:

mvn spring-boot:run

Or run the main class:

LocalPermitRegistryApplication.java

🌐 Application Access

After running the application open:

http://localhost:8081
🗄 Database Example



Example table structure:

permit
------
id
permit_name
applicant_name
issue_date
expiry_date
status

📚 Learning Objectives

This project demonstrates:

Spring Boot application setup

MVC architecture

Database integration with JPA

RESTful backend development

Maven project management