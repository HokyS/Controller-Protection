package com.example.ControllerProtection.services;

import com.example.ControllerProtection.entities.Salary;
import com.example.ControllerProtection.repositories.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    public void save(Salary salary){
        salaryRepository.save(salary);
    }
    public Optional<Salary> findById(Long id) {
        return salaryRepository.findById(id);
    }

    public List<Salary> findAll() {
        return salaryRepository.findAll();
    }
}
