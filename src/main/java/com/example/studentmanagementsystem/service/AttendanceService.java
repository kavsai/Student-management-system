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