package com.cbs.edu.springbootdemo.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbs.edu.springbootdemo.dao.EmployeeDao;
import com.cbs.edu.springbootdemo.model.Employee;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    //    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public Collection<Employee> getAllEmployees() {
        return employeeDao.getAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeDao.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeDao.delete(id);
    }

    @PostMapping
    public void createEmployee(@RequestBody Employee employee) {
        employeeDao.create(employee);
    }

    @PutMapping
    public void updateEmployee(@RequestBody Employee employee) {
        employeeDao.update(employee);
    }
}
