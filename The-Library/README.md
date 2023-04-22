# The Library

[![forthebadge](https://forthebadge.com/images/badges/contains-tasty-spaghetti-code.svg)](https://forthebadge.com)

The Library is a Java application that allows users to manage a library.

The application is built using Java 17, Maven, Docker, MySQL, JUnit, Jacoco, Mockito and Mermaid.

<p align = "left">
<img src="Doc/img/library.png" width=30%>

---

## Design Document

<p align = "left">
<img src="Doc/img/uml.png" width=30%>

[Design Document](Doc/DESIGN.md)

---

## Tests

<p align = "left">
<img src="Doc/img/tests.png" width=30%>

---

## How it looks

<p align = "left">
<img src="Doc/img/menu.png" width=30%> <img src="Doc/img/users.png" width=30%> <img src="Doc/img/tables.png" width=30%>

---

## Getting Started

[![forthebadge](https://forthebadge.com/images/badges/works-on-my-machine.svg)](https://forthebadge.com)

### Prerequisites

- JDK 17
- Maven
- Docker
- MysSQL

### Installing

1. Clone the repository
2. Run `mvn clean install` to build the project
3. Run `docker-compose up` to start the database or `docker-compose f docker-compose.yml up` to start the database in the background. This will start the database on port 3306 and adminer on port 8080.
4. Run `mvn exec:java` to start the application
5. Main method is located in `src/main/java/....../App.java`

---

### Running the tests

Run `mvn test` to run the tests, or `mvn jacoco:prepare-agent test install jacoco:report` to run the tests and generate a coverage report.

---

### MySQL

When running the application for the first time, the database will be created and populated with data from the `schema.sql` file.

### Built With

- [Maven](https://maven.apache.org/) - Dependency Management
- [Docker](https://www.docker.com/) - Containerization
- [MySQL](https://www.mysql.com/) - Database
- [JUnit](https://junit.org/junit5/) - Testing
- [Jacoco](https://www.jacoco.org/jacoco/) - Code Coverage
- [Mockito](https://site.mockito.org/) - Mocking

---

## Project Timeline

```mermaid
gantt
dateFormat  YYYY-MM-DD
title The Library
section Project
    Project Planning: 2023-01-18,5d
    Project Development: 2023-01-23, 4d
    Deadline: 2023-01-27, 1d
```

---

Back to [JAVA Projects](../README.md)
