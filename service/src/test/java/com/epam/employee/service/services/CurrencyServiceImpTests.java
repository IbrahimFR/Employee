package com.epam.employee.service.services;

import com.epam.employee.models.CurrencyModel;
import com.epam.employee.models.EmployeeModel;
import com.epam.employee.models.RateModel;
import com.epam.employee.repo.entities.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
public class CurrencyServiceImpTests {

    private ModelMapper mapper = new ModelMapper();



    @Test
    public void shouldInstantiateMapper() {
        assertThat(mapper, is(notNullValue()));
    }

    @Test
    public void whenConvertCurrencyEntityToCurrencyModel_thenCorrect() {
        Rate rate = new Rate();
        rate.setINR(0.2466767148);
        rate.setEUR(0.0029553447);
        Currency currency = new Currency();
        currency.setBase("HUF");
        currency.setDate(new Date());
        currency.setRate(rate);
        assertNotNull(currency);
        CurrencyModel currencyModel = mapper.map(currency, CurrencyModel.class);
        assertNotNull(currencyModel);
        assertEquals(currency.getBase(), currencyModel.getBase());
        assertEquals(currency.getRate().getEUR(), currencyModel.getRate().getEUR());
    }
    @Test
    public void whenConvertCurrencyModelToCurrencyEntity_thenCorrect() {
        RateModel rateModel = new RateModel();
        rateModel.setINR(0.2466767148);
        rateModel.setEUR(0.0029553447);
        CurrencyModel currencyModel = new CurrencyModel();
        currencyModel.setBase("HUF");
        currencyModel.setSubmissionDate(new Date());
        currencyModel.setRate(rateModel);
        assertNotNull(currencyModel);

        Currency currency = mapper.map(currencyModel, Currency.class);
        assertNotNull(currency);
        assertEquals(currency.getBase(), currencyModel.getBase());
        assertEquals(currency.getRate().getEUR(), currencyModel.getRate().getEUR());
    }
}
