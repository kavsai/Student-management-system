# Student-management-system
Student Management System using Spring Boot
📚 Smart Student Management System

A Spring Boot + MySQL REST API project for managing students, courses, attendance, and marks.
This system is designed as a backend foundation for a full-stack academic management platform.

🚀 Project Overview

The Smart Student Management System is a backend application that provides APIs to manage student academic data efficiently. It follows a layered architecture using Controller → Service → Repository → Database.

This project is also extendable with:

JWT Authentication
Role-based Access Control
Google OAuth Login
Frontend Integration
🎯 Features
👨‍🎓 Student Management (Create, Read, Delete)
📚 Course Management (CRUD operations)
📝 Attendance Tracking (Present/Absent)
📊 Marks Management System
🔍 REST API based architecture
🗄️ MySQL database integration
⚡ Spring Boot layered structure
🧪 Tested using Postman
🛠️ Tech Stack
Java 17 / 21
Spring Boot
Spring Data JPA
Spring Web
MySQL Database
Maven
Postman (API Testing)
📁 Project Structure
com.example.studentmanagementsystem
│
├── controller
│   ├── StudentController
│   ├── CourseController
│   ├── AttendanceController
│   └── MarksController
│
├── service
│   ├── StudentService
│   ├── CourseService
│   ├── AttendanceService
│   └── MarksService
│
├── repository
│   ├── StudentRepository
│   ├── CourseRepository
│   ├── AttendanceRepository
│   └── MarksRepository
│
├── entity
│   ├── Student
│   ├── Course
│   ├── Attendance
│   └── Marks
│
└── StudentManagementSystemApplication.java
🗄️ Database Configuration

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/student_management
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
▶️ How to Run the Project
1️⃣ Clone Repository
git clone https://github.com/your-username/student-management-system.git
2️⃣ Create Database
CREATE DATABASE student_management;
3️⃣ Run Project

Run:

StudentManagementSystemApplication.java
4️⃣ Server Runs On
http://localhost:8080
📡 API Endpoints
👨‍🎓 Student APIs
Method	Endpoint	Description
POST	/students	Create student
GET	/students	Get all students
GET	/students/{id}	Get student by ID
DELETE	/students/{id}	Delete student
📚 Course APIs
Method	Endpoint
POST	/courses
GET	/courses
PUT	/courses/{id}
DELETE	/courses/{id}
📝 Attendance APIs
Method	Endpoint
POST	/attendance
GET	/attendance
GET	/attendance/student/{id}
📊 Marks APIs
Method	Endpoint
POST	/marks
GET	/marks
PUT	/marks/{id}
DELETE	/marks/{id}
🧪 Sample API Request (Postman)
➕ Create Student

POST

http://localhost:8080/students
JSON Body:
{
  "name": "Kavya",
  "email": "kavya@gmail.com",
  "phone": "9876543210",
  "department": "CSE",
  "year": 2
}
🔐 Future Enhancements
JWT Authentication System
Role-Based Access (Admin / Student)
Google OAuth Login
Email Notifications
PDF Report Generation
Excel Export (Apache POI)
React Frontend Integration

👨‍💻 Author
Name: Kavya
Project: Smart Student Management System
Tech: Spring Boot + MySQL

⭐ Project Status

✔ Backend Completed
✔ APIs Tested via Postman
Built with passion for learning and real-world backend development. More features coming soon!
