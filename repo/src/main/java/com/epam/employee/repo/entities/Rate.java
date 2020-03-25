package com.epam.employee.repo.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Rate {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private double CAD;
   private double HKD;
   private double ISK;
   private double PHP;
   private double DKK;
   private double HUF;
   private double CZK;
   private double GBP;
   private double RON;
   private double SEK;
   private double IDR;
   private double INR;
   private double BRL;
   private double RUB;
   private double HRK;
   private double JPY;
   private double THB;
   private double CHF;
   private double EUR;
   private double MYR;
   private double BGN;
   private double TRY;
   private double CNY;
   private double NOK;
   private double NZD;
   private double ZAR;
   private double USD;
   private double MXN;
   private double SGD;
   private double AUD;
   private double ILS;
   private double KRW;
   private double PLN;

   @OneToOne(mappedBy = "rate")
   private Currency currency;


}
