package com.epam.repo.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Employee implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;


}
