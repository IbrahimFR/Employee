package com.epam.employee.service;

import com.epam.employee.models.CurrencyModel;
import com.epam.employee.repo.dao.CurrencyDaoImp;
import com.epam.employee.repo.dao.EmployeeDaoImp;
import com.epam.employee.repo.entities.Currency;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CurrencyServiceImp implements CurrencyService{
    @Autowired
    EmployeeDaoImp employeeDaoImp;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    CurrencyDaoImp currencyDaoImp;

    @Override
    public CurrencyModel saveCurrency(CurrencyModel currencyModel) {
        Currency createdCurrency = currencyDaoImp.save(toEntity(currencyModel));
        return toModel(createdCurrency);
    }

    @Override
    public CurrencyModel findAllByBase(String base) {
        return toModel(currencyDaoImp.findAllByBase(base));
    }


    private CurrencyModel toModel(Currency currency) {
        CurrencyModel currencyModel = modelMapper.map(currency, CurrencyModel.class);
        return currencyModel;
    }
    private Currency toEntity(CurrencyModel currencyModel) {
        Currency currency = modelMapper.map(currencyModel, Currency.class);
        return currency;
    }
}
