package com.epam.employee.service;


import com.epam.employee.models.CurrencyModel;

import java.util.Set;

public interface CurrencyConverterService {
    CurrencyModel getCurrencyRate(String base);
    CurrencyModel getCurrencyRateByTargets(String base, Set<String> targets);
}
