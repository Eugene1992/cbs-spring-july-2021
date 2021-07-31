package com.cbs.edu.springbootdemo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    private String username;

    private String password;
}
