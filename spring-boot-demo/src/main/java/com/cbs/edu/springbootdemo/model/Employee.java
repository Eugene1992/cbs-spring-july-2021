package com.cbs.edu.springbootdemo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.cbs.edu.springbootdemo.validation.ContactNumberConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer id;

    private String name;

    @Max(100) @Min(16)
    private int age;

    private int salary;

    @ContactNumberConstraint
    private String mobileNumber;
}
