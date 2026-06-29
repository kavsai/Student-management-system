package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.entity.Marks;
import com.example.studentmanagementsystem.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarksController {

    @Autowired
    private MarksService marksService;

    // Create Marks
    @PostMapping
    public Marks createMarks(@RequestBody Marks marks) {
        return marksService.saveMarks(marks);
    }

    // Get All Marks
    @GetMapping
    public List<Marks> getAllMarks() {
        return marksService.getAllMarks();
    }

    // Get Marks By ID
    @GetMapping("/{id}")
    public Marks getMarksById(@PathVariable Long id) {
        return marksService.getMarksById(id);
    }

    // Update Marks
    @PutMapping("/{id}")
    public Marks updateMarks(@PathVariable Long id,
                             @RequestBody Marks marks) {
        return marksService.updateMarks(id, marks);
    }

    // Delete Marks
    @DeleteMapping("/{id}")
    public void deleteMarks(@PathVariable Long id) {
        marksService.deleteMarks(id);
    }
}