package com.epam.employee.service;


import com.epam.employee.models.CurrencyConverterModel;

import java.util.Set;

public interface CurrencyConverterService {
    CurrencyConverterModel getCurrencyRate(String base);
    CurrencyConverterModel getCurrencyRateByTargets(String base, Set<String> targets);
}
