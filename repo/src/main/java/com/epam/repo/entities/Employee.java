package com.epam.repo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String fistName;
    private String lastName;
    private String email;
    private String password;


}
