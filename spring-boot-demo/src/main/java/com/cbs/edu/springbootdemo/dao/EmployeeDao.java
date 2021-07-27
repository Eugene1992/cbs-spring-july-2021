package com.cbs.edu.springbootdemo.dao;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cbs.edu.springbootdemo.model.Employee;

@Component
public class EmployeeDao implements GenericDAO<Employee, Integer> {

    private List<Employee> employees ;

    {
        employees = new ArrayList<>();

        Employee anna = new Employee(0, "Anna", 23, 15000);
        Employee tom =  new Employee(1, "Tom", 32, 25000);
        Employee sara = new Employee(2, "Sara", 53, 115000);
        Employee jack = new Employee(3, "Jack", 42, 165000);

        employees.add(anna.getId(), anna);
        employees.add(tom.getId(), tom);
        employees.add(sara.getId(), sara);
        employees.add(jack.getId(), jack);
    }

    @Override
    public Employee create(Employee entity) {
        employees.add(entity);
        return entity;
    }

    @Override
    public Employee update(Employee entity) {
        employees.set(entity.getId(), entity);
        return entity;
    }

    @Override
    public void delete(Integer integer) {
        employees.remove(integer.intValue());
    }

    @Override
    public Employee get(Integer integer) {
        return employees.get(integer);
    }

    @Override
    public Collection<Employee> getAll() {
        return employees;
    }
}
