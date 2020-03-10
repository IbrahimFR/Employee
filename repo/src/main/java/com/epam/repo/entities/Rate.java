package com.epam.repo.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Rate {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String CAD;
   private String HKD;
   private String ISK;
   private String PHP;
   private String DKK;
   private String HUF;
   private String CZK;
   private String GBP;
   private String RON;
   private String SEK;
   private String IDR;
   private String INR;
   private String BRL;
   private String RUB;
   private String HRK;
   private String JPY;
   private String THB;
   private String CHF;
   private String EUR;
   private String MYR;
   private String BGN;
   private String TRY;
   private String CNY;
   private String NOK;
   private String NZD;
   private String ZAR;
   private String USD;
   private String MXN;
   private String SGD;
   private String AUD;
   private String ILS;
   private String KRW;
   private String PLN;

   @OneToOne(fetch = FetchType.LAZY, optional = false)
   @JoinColumn(name = "currency_id", nullable = false)
   private Currency currency;


}
