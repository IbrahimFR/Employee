package com.epam.repo.entities;

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
    @OneToOne(mappedBy = "currency", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Rate rate;

}
