package com.example.ControllerProtection.controllers;

import com.example.ControllerProtection.entities.Roles;
import com.example.ControllerProtection.entities.Salary;
import com.example.ControllerProtection.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salary")
@PreAuthorize("hasRole('"+ Roles.ADMIN +"')")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @GetMapping()
    public List<Salary> getSalaries(){
        return salaryService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Salary> getSalary(@PathVariable Long id){
        return salaryService.findById(id);
    }

    @PostMapping("/create")
    public void  createSalary(@RequestBody Salary salary){
        salaryService.save(salary);
    }
}