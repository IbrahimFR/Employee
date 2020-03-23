package com.epam;

import com.epam.employee.models.CurrencyModel;
import org.springframework.stereotype.Service;

@Service
public interface CurrencyService {
    CurrencyModel saveCurrency(CurrencyModel currencyModel);
    CurrencyModel findAllByBase(String base);

}
