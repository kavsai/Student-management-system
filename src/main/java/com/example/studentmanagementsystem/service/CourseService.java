package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.entity.Course;
import com.example.studentmanagementsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    // Create Course
    public Course saveCourse(Course course) {
        return repository.save(course);
    }

    // Get All Courses
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    // Get Course By ID
    public Course getCourseById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Update Course
    public Course updateCourse(Long id, Course course) {

        Course existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setCourseName(course.getCourseName());
            existing.setCourseCode(course.getCourseCode());
            existing.setCredits(course.getCredits());

            return repository.save(existing);
        }

        return null;
    }

    // Delete Course
    public void deleteCourse(Long id) {
        repository.deleteById(id);
    }
}