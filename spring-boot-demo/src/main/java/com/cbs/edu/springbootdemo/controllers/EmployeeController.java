package com.cbs.edu.springbootdemo.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbs.edu.springbootdemo.model.Employee;
import com.cbs.edu.springbootdemo.service.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeService.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.delete(id);
    }

    @PostMapping
    public void createEmployee(@RequestBody @Valid Employee employee) {
        employeeService.create(employee);
    }

    @PutMapping
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.update(employee);
    }
}
