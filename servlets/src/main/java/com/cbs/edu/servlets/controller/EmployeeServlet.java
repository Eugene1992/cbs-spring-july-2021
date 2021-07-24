package com.cbs.edu.servlets.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cbs.edu.servlets.model.Employee;

public class EmployeeServlet extends HttpServlet {

    private List<Employee> employees;

    @Override
    public void init() throws ServletException {
        employees = new ArrayList<>();

        Employee anna = new Employee(0, "Anna", 23, 15000);
        Employee tom = new Employee(1, "Tom", 32, 25000);
        Employee sara = new Employee(2, "Sara", 53, 115000);
        Employee jack = new Employee(3, "Jack", 42, 165000);

        employees.add(anna.getId(), anna);
        employees.add(tom.getId(), tom);
        employees.add(sara.getId(), sara);
        employees.add(jack.getId(), jack);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String action = req.getParameter("action");

        if (action != null) {
            final int id = Integer.parseInt(req.getParameter("id"));

            switch (action) {
                case "delete":
                employees.remove(id);
                break;

                case "update":
                    // TODO: 7/24/2021 implement update
                    break;
            }
        }
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer age = Integer.valueOf(req.getParameter("age"));
        Integer salary = Integer.valueOf(req.getParameter("salary"));

        int index = employees.size();
        Employee employee = new Employee(index, name, age, salary);
        employees.add(employee);

        req.setAttribute("employees", employees);
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
