# 🐾 Swagger PetStore API Testing  
### Manual Testing (Postman) + Automation (REST Assured)

This project contains a complete API testing workflow for the **Swagger PetStore API**, including **manual testing using Postman** and **automation using REST Assured (Java + TestNG + Maven)**.  
The objective is to validate API functionality, cover both positive and negative scenarios, and build a scalable automation framework.

---

## 🚀 Project Overview

This project includes:

- ✔ Manual API Testing using **Postman**
- ✔ Automated API Testing using **REST Assured**
- ✔ JSON Body Models using **POJO classes**
- ✔ Test execution with **TestNG**
- ✔ Framework ready for scalability and maintainability

---

## 🛠 Tools & Technologies

| Tool | Purpose |
|------|---------|
| **Java 17+** | Automation language |
| **REST Assured** | API automation framework |
| **TestNG** | Test runner & assertions |
| **Maven** | Dependency management |
| **Swagger UI** | API documentation |
| **Postman** | Manual API validation |
| **IntelliJ IDEA** | IDE |

---

## 📂 Project Structure

```
Swagger-PetStore-Testing/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── Pojo/
│   │           ├── pet_valid/
│   │           ├── store_valid/
│   │           ├── store_without_token_Invalid/
│   │           ├── Update_non_existing_pet/
│   │           ├── user_Data_is_incomplete_Invalid/
│   │           ├── user_valid/
│   │           └── user_without_token_Invalid/
│   │
│   └── test/
│       └── java/
│           └── Scenarios/
│               ├── Delete_non_existing_pet/
│               ├── pet_valid/
│               ├── store_valid/
│               ├── store_without_token_Invalid/
│               ├── Update_non_existing_pet/
│               ├── user_valid/
│               ├── user_with_Data_is_incomplete/
│               └── user_without_token_Invalid/
│
├── pom.xml
└── README.md
```

This structure is displayed directly inside the README so contributors can understand the framework layout at a glance.

---

## 📌 POJO Layer (Models)

- Generates JSON request bodies dynamically  
- Avoids hardcoded values  
- Reusable for all scenarios  

---

## 📌 Test Layer (Scenarios)

- Contains complete automated test cases  
- Each folder represents a scenario group  
- Includes both **valid and invalid** cases  

---

## 🧪 Test Scenarios Covered

### ✔ Pet APIs
- Add new pet  
- Update existing pet  
- Get pet by ID  
- Delete pet  
- Invalid Pet ID  
- Update / delete non-existing pet  

### ✔ Store APIs
- Place order  
- Get order  
- Delete order  
- Invalid token (negative case)  

### ✔ User APIs
- Create user  
- Login user  
- Get user  
- User with incomplete data (negative case)  

---

## 📄 Manual Testing (Postman)

Included in the project:

- Postman Collection  
- Valid + Invalid Test Cases  
- Assertions for status code, response body, headers  
- Environment variables for dynamic testing  

**Goal:** Validate API behaviors before automation.

---

## 🤖 Automated Testing (REST Assured)

Includes:

- Base URL configuration  
- Request Specifications  
- POJO models for payloads  
- Response validation  
- Logging for request/response  
- TestNG execution  

---

## 👨‍💻 Author

**Adel Elmy**  
Software Testing Engineer  
📧 adelelmy7@gmail.com  
💼  www.linkedin.com/in/adel-elmy
