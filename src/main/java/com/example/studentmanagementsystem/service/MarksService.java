package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.entity.Marks;
import com.example.studentmanagementsystem.repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarksService {

    @Autowired
    private MarksRepository repository;

    // Save Marks
    public Marks saveMarks(Marks marks) {
        return repository.save(marks);
    }

    // Get All Marks
    public List<Marks> getAllMarks() {
        return repository.findAll();
    }

    // Get Marks By ID
    public Marks getMarksById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Update Marks
    public Marks updateMarks(Long id, Marks marks) {

        Marks existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setStudentId(marks.getStudentId());
            existing.setSubject(marks.getSubject());
            existing.setMarks(marks.getMarks());

            return repository.save(existing);
        }

        return null;
    }

    // Delete Marks
    public void deleteMarks(Long id) {
        repository.deleteById(id);
    }
}