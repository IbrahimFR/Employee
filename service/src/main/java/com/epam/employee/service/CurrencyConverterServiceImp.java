package com.epam.employee.service;

import com.epam.employee.models.CurrencyConverterModel;
import com.epam.employee.models.CurrencyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Set;


@Service
public class CurrencyConverterServiceImp implements CurrencyConverterService {

    @Value("${currencies.api.url}")
    private String currencyApiUrl;

    @Value("${currencies.rate.url}")
    private String currencyRateUrl;

    @Value("${curencies.target-rate.url}")
    private String currencyRateByTargetsUrl;


    RestTemplate restTemplate = new RestTemplate();



    @Override
    public CurrencyConverterModel getCurrencyRate(String base) {
        String url = String.format(
                currencyRateUrl, base);
        return restTemplate
                .getForObject(url, CurrencyConverterModel.class);
    }

    @Override
    public CurrencyConverterModel getCurrencyRateByTargets(String base, Set<String> targets) {
        String target = String.join(",", targets);
        String url = String.format(currencyRateByTargetsUrl, target, base);
        return restTemplate
                .getForObject(url, CurrencyConverterModel.class);
    }
}
