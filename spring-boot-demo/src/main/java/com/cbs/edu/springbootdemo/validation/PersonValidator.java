package com.cbs.edu.springbootdemo.validation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cbs.edu.springbootdemo.dao.EmployeeDao;
import com.cbs.edu.springbootdemo.model.Employee;
import com.cbs.edu.springbootdemo.model.Person;

@Component
public class PersonValidator implements Validator {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        Employee foundEmployee = employeeDao.getEmployeeByEmail(person.getEmail());

        if (foundEmployee != null) {
            errors.rejectValue("email", "XXX", "User with such email already exists");
        }
    }
}
