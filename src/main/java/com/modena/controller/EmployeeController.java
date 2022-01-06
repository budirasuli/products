package com.modena.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
@RequestMapping("/api")
public class EmployeeController {
    @GetMapping("/checkapi")
    public String getEmployees() {
        return "API Server Ready Ver.1.0.2";
    }
}