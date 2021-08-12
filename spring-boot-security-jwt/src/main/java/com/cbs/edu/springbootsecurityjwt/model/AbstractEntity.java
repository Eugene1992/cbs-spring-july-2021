package com.cbs.edu.springbootsecurityjwt.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue
    protected Integer id;
}
