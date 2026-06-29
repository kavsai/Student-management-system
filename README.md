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

## 💡 Important Code Snippets;
1)Controller Layer:##(Attendance)
package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.entity.Attendance;
import com.example.studentmanagementsystem.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    // Create Attendance
    @PostMapping
    public Attendance createAttendance(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }

    // Get All Attendance
    @GetMapping
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    // Get Attendance By ID
    @GetMapping("/{id}")
    public Attendance getAttendanceById(@PathVariable Long id) {
        return attendanceService.getAttendanceById(id);
    }

    // Update Attendance
    @PutMapping("/{id}")
    public Attendance updateAttendance(@PathVariable Long id,
                                       @RequestBody Attendance attendance) {
        return attendanceService.updateAttendance(id, attendance);
    }

    // Delete Attendance
    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
    }
}


2)Service Layer:
package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.entity.Attendance;
import com.example.studentmanagementsystem.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository repository;

    // Create Attendance
    public Attendance saveAttendance(Attendance attendance) {
        return repository.save(attendance);
    }

    // Get All Attendance
    public List<Attendance> getAllAttendance() {
        return repository.findAll();
    }

    // Get Attendance By ID
    public Attendance getAttendanceById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Update Attendance
    public Attendance updateAttendance(Long id, Attendance attendance) {

        Attendance existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setStudentId(attendance.getStudentId());
            existing.setAttendanceDate(attendance.getAttendanceDate());
            existing.setStatus(attendance.getStatus());

            return repository.save(existing);
        }

        return null;
    }

    // Delete Attendance
    public void deleteAttendance(Long id) {
        repository.deleteById(id);
    }
}

🗄️ 3. Repository Layer:

package com.example.studentmanagementsystem.repository;

import com.example.studentmanagementsystem.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}

🧱 4. Entity Layer:
package com.example.studentmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private java.time.LocalDate attendanceDate;
    private String status;
}

⚙️ 5. Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
spring.datasource.username=root
spring.datasource.password=Kaviselva@4

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
