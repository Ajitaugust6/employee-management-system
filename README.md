# Employee Management System

A full-stack Spring Boot web application with REST API built as part of B.Tech CSE (IoT) placement training.

## Tech Stack
- Spring Boot 4.x
- Spring Security (BCrypt, form login)
- Spring Data JPA + Hibernate
- MySQL 8
- Thymeleaf + Tailwind CSS
- REST API (tested via Postman)

## Features
- User Signup & Login with Spring Security
- Employee CRUD operations
- REST API endpoints at `/api/employees`
- Auto-created MySQL tables via JPA

## API Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/employees | Get all employees |
| GET | /api/employees/{id} | Get by ID |
| POST | /api/employees | Add employee |
| PUT | /api/employees/{id} | Update employee |
| DELETE | /api/employees/{id} | Delete employee |

## Setup
1. Create MySQL database: `CREATE DATABASE employeedb;`
2. Update `src/main/resources/application.properties` with your MySQL password
3. Run as Spring Boot App
4. Open `http://localhost:8080/signup`

## Author
**Ajit Singh K** 
