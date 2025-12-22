# 🏥 Patient Management System

A **production-oriented backend system** built with Spring Boot to manage patient data securely and efficiently, keeping in mind the various APIs and services required for the patients to register to when using a centralised system which answers to all their needs.  
This project demonstrates **real-world backend engineering skills** including REST API design, authentication, service isolation, database modeling, and API documentation.

---

## 📌 Key Highlights

- Clean layered architecture (Controller → Service → Repository)
- JWT-based authentication & authorization
- Secure password storage using BCrypt
- API Gateway–friendly design
- Swagger/OpenAPI documentation
- PostgreSQL + JPA ORM
- Docker-ready microservice structure
- AWS(local) Deployment

---

## 🧠 Tech Stack

| Layer | Technology |
|------|------------|
| Language | Java 21 |
| Framework | Spring Boot 3 |
| Security | Spring Security + JWT |
| ORM | Spring Data JPA |
| Database | PostgreSQL (H2 for local development) |
| API Documentation | Springdoc OpenAPI (Swagger UI) |
| Build Tool | Maven |
| Containerization | Docker |
| Messaging | Apache Kafka |
| Inter-Service Communication | REST + gRPC |

---

## 🏗️ Architecture Overview

The system is designed with **backend scalability and separation of concerns** in mind.

```
Client (Postman / Frontend)
        |
        v
   API Gateway
        |
        v
 Auth Service  -----> JWT Validation
        |
        v
 Patient Service ----> PostgreSQL
```

📷 **Architecture Diagram** 

<p align="center">
  <img src="https://raw.githubusercontent.com/Vimu-Sama/Patient-Management-System/master/git-image-resources/application-architecture.jpg" alt="Architecture Diagram" width="800"/>
</p>


---

## 📂 Project Structure

```
Patient-Management-System
├── auth-service
│   ├── controller
│   ├── service
│   ├── repository
│   ├── security
│   ├── dto
│   └── utils
│
├── patient-service
│   ├── controller
│   ├── service
│   ├── repository
│   └── model
│
├── api-gateway
│   └── routes & filters
│
└── docs
    └── architecture.png
```

---

## 🔐 Authentication Flow (JWT)

1. User registers with email & password
2. Password is stored **BCrypt-encoded**
3. User logs in → JWT token generated
4. Token sent in header:
   ```
   Authorization: Bearer <token>
   ```
5. Token validated for protected routes

---

## 📡 API Endpoints (Sample)

### Auth Service
| Method | Endpoint | Description |
|------|---------|------------|
| POST | `/auth/register` | Create user |
| POST | `/auth/login` | Authenticate & get JWT |
| GET | `/auth/validate` | Validate JWT |

### Patient Service
| Method | Endpoint | Description |
|------|---------|------------|
| POST | `/patients` | Create patient |
| GET | `/patients/{id}` | Fetch patient |
| GET | `/patients` | List all patients |

---

## 📖 Swagger API Documentation

Each service exposes Swagger UI.

### Direct Service Access
```
http://localhost:4000/swagger-ui/index.html
```

### Via API Gateway
```
http://localhost:4005/swagger-ui/index.html
```

---

## 🧪 Testing

- API testing via Postman
- Token-based authorization tested via headers
- H2 database used for local testing

---

## 🐳 Docker Support

Each service is container-ready.

Example:
```
docker build -t auth-service .
docker run -p 4006:4006 auth-service
```

---

## 🧩 Backend Engineering Concepts Demonstrated

- Stateless authentication (JWT)
- Secure credential handling
- DTO-based response mapping
- API Gateway routing & filtering
- Error handling & HTTP status discipline
- Microservice-friendly design

---

## 📈 Why This Project Stands Out

✔ Not CRUD-only  
✔ Security-first approach  
✔ Real microservice patterns  
✔ Clean, readable codebase  
✔ Interview-ready architecture  

---

## 👤 Author

**Vimarsh Sharma**  
Backend Developer | Java | Spring Boot | Microservices

GitHub: https://github.com/Vimu-Sama

---

## ⭐ Final Note

This project focuses **purely on backend quality** — scalability, security, and clean architecture — making it suitable for **backend developer roles at product-based companies**.
