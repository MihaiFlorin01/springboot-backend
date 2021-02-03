package com.example.springbootbackend.service;

import com.example.springbootbackend.model.Employee;
import com.example.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository empployeeRepository;


    public List<Employee> findAll() {
        return empployeeRepository.findAll();
    }


    public Employee save(Employee employee) {
        return empployeeRepository.save(employee);
    }


    public <T> Optional<Employee> findById(Long id) {
        return empployeeRepository.findById(id);
    }


    public void delete(Employee employee) {
        empployeeRepository.delete(employee);
    }
}
