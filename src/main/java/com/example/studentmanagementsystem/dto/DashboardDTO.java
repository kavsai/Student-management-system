package com.example.studentmanagementsystem.dto;

import lombok.Data;

@Data
public class DashboardDTO {

    private long totalStudents;
    private long totalCourses;
    private long totalAttendance;
    private long totalMarks;
}