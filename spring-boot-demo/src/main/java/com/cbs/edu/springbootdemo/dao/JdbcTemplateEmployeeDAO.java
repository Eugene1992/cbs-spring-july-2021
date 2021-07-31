package com.cbs.edu.springbootdemo.dao;

import java.util.Collection;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.cbs.edu.springbootdemo.model.Employee;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Primary
public class JdbcTemplateEmployeeDAO implements EmployeeDao {

    public final RowMapper<Employee> employeeRowMapper = (rs, rowNum) -> {
        final Employee employee = new Employee();

        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setAge(rs.getInt("age"));
        employee.setSalary(rs.getInt("salary"));

        return employee;
    };

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Employee create(Employee employee) {
        jdbcTemplate.update("INSERT INTO EMPLOYEES(name, age, salary) VALUES (?, ?, ?)",
                employee.getName(), employee.getAge(), employee.getSalary());

        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        jdbcTemplate.update("UPDATE EMPLOYEES SET name = ?, age = ?, salary = ? WHERE id = ?",
                employee.getName(), employee.getAge(), employee.getSalary(), employee.getId());

        return employee;
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM EMPLOYEES WHERE id = ?", id);
    }

    @Override
    public Employee get(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM EMPLOYEES WHERE id = ?", employeeRowMapper, id);
    }

    @Override
    public Collection<Employee> getAll() {
        return jdbcTemplate.query("SELECT * FROM EMPLOYEES", employeeRowMapper);
    }
}
