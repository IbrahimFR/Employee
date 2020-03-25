package com.epam.employee.repo.dao;

import com.epam.employee.repo.entities.Currency;
import com.epam.employee.repo.entities.Rate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CurrencyDaoImpTests {

    @Autowired
    private CurrencyDaoImp currencyDaoImp;

    @Test
    public void testSaveCurrency(){
        Rate rate = new Rate();
        rate.setINR(0.2466767148);
        rate.setEUR(0.0029553447);
        Currency currency = new Currency();
        currency.setBase("HUF");
        currency.setDate(new Date());
        currency.setRate(rate);
        currencyDaoImp.save(currency);
        assertNotNull(currency);
    }

    @Test
    public void testGetCurrency() {
        Rate rate = new Rate();
        rate.setINR(0.2466767148);
        rate.setEUR(0.0029553447);
        Currency currency = new Currency();
        currency.setBase("HUF");
        currency.setDate(new Date());
        currency.setRate(rate);
        currencyDaoImp.save(currency);
        Currency currency2 = currencyDaoImp.findAllByBase("HUF");
        assertNotNull(currency);
        assertEquals(currency2.getBase(), currency.getBase());
        assertEquals(currency2.getId(), currency.getId());
    }

    @Test
    public void testDeleteCurrency() {
        Rate rate = new Rate();
        rate.setINR(0.2466767148);
        rate.setEUR(0.0029553447);
        Currency currency = new Currency();
        currency.setBase("HUF");
        currency.setDate(new Date());
        currency.setRate(rate);
        currencyDaoImp.save(currency);
        currencyDaoImp.delete(currency);
    }

    @Test
    public void findAllCurrencies() {
        Rate rate = new Rate();
        rate.setINR(0.2466767148);
        rate.setEUR(0.0029553447);
        Currency currency = new Currency();
        currency.setBase("HUF");
        currency.setDate(new Date());
        currency.setRate(rate);
        currencyDaoImp.save(currency);
        assertNotNull(currencyDaoImp.findAll());
    }

}
