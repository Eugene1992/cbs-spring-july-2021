package com.cbs.edu.springbootdemo.controllers;

import javax.management.MBeanException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbs.edu.springbootdemo.exception.MyBeatifulException;
import com.cbs.edu.springbootdemo.model.Person;
import com.cbs.edu.springbootdemo.validation.PersonValidator;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {

    @Autowired
    private PersonValidator personValidator;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(personValidator);
    }

    @PostMapping
    public void createPerson(@RequestBody @Valid Person person) {
        System.out.println(person);
    }

    @GetMapping("/error")
    public void catchError() throws MyBeatifulException {
        throw new MyBeatifulException();
    }
}
