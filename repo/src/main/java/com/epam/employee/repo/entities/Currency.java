package com.epam.employee.repo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
public class Currency {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String base;
    private Date date;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Rate rate;

}
