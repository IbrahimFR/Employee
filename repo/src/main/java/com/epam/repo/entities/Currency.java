package com.epam.repo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Currency {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

}
