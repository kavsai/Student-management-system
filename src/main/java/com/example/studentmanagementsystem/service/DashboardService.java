package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.dto.DashboardDTO;
import com.example.studentmanagementsystem.repository.AttendanceRepository;
import com.example.studentmanagementsystem.repository.CourseRepository;
import com.example.studentmanagementsystem.repository.MarksRepository;
import com.example.studentmanagementsystem.repository.Studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private Studentrepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private MarksRepository marksRepository;

    public DashboardDTO getDashboardData() {

        DashboardDTO dashboard = new DashboardDTO();

        dashboard.setTotalStudents(studentRepository.count());
        dashboard.setTotalCourses(courseRepository.count());
        dashboard.setTotalAttendance(attendanceRepository.count());
        dashboard.setTotalMarks(marksRepository.count());

        return dashboard;
    }
}