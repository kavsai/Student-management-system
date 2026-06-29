package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.dto.DashboardDTO;
import com.example.studentmanagementsystem.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public DashboardDTO getDashboard() {
        return dashboardService.getDashboardData();
    }
}