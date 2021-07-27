package com.cbs.edu.servlets.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cbs.edu.servlets.model.Employee;

@Controller
public class EmployeeController {

    private List<Employee> employees;

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

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ModelAndView processEmployees(@RequestParam(required = false) String action,
                                         @RequestParam(required = false) String id,
                                         ModelAndView modelAndView) {
        if (action != null && id != null && !id.isEmpty()) {
            int employeeId = Integer.parseInt(id);
            switch (action) {
                case "delete":
                    employees.remove(employeeId);
                    break;

                case "update":
                    Employee updatedEmployee = employees.get(employeeId);
                    modelAndView.addObject("updEmployee", updatedEmployee);
                    break;
            }
        }
        modelAndView.setViewName("login");
        modelAndView.addObject("employees", employees);

        return modelAndView;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public void createEmployee(@ModelAttribute Employee employee,
                               ModelAndView modelAndView) {
        int index = employees.size();
        Integer id = employee.getId();
        if (id != null) {
            employee.setId(id);
            employees.set(id, employee);
        } else {
            employee.setId(employees.size());
            employees.add(index, employee);
        }

        modelAndView.setViewName("login");
        modelAndView.addObject("employees", employees);
    }
}
