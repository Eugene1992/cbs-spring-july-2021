package com.cbs.edu.springbootdemo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue
    protected Integer id;
}
