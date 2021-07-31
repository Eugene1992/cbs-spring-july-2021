package com.cbs.edu.springbootdemo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cbs.edu.springbootdemo.dao.EmployeeDao;
import com.cbs.edu.springbootdemo.model.Employee;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService implements GenericService<Employee, Integer> {

//    @Autowired
//    @Qualifier("jdbcTemplateEmployeeDAO")
    private final EmployeeDao employeeDao;

    @Override
    public Employee create(Employee employee) {
        return employeeDao.create(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeDao.delete(id);
    }

    @Override
    public Employee get(Integer id) {
        return employeeDao.get(id);
    }

    @Override
    public Collection<Employee> getAll() {
        return employeeDao.getAll();
    }
}
