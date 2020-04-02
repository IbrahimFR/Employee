package com.epam.employee.rest.controllers;

import com.epam.employee.models.CurrencyConverterModel;
import com.epam.employee.service.CurrencyConverterServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@RestController
@RequestMapping(value ="/api/v1")
public class CurrencyController {

    @Autowired
    CurrencyConverterServiceImp currencyConverterServiceImp;

    @GetMapping("/currency/rates")
    public ResponseEntity<CurrencyConverterModel> getCurrencyRate(
            @RequestParam(value = "base")
            @NotBlank
            @Size(message = "message = “base size should equal 3 characters",min = 3,max =3) String base) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(currencyConverterServiceImp.getCurrencyRate(base));
    }
    @GetMapping("/currency/ratesbytargets")
    public ResponseEntity<CurrencyConverterModel> getCurrencyRateByTargets(
            @RequestParam(value = "symbols") Set<String> symbols,
            @RequestParam(value = "base")
            @NotBlank
            @Size(message = "message = “base size should equal 3 characters",min = 3,max =3) String base) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(currencyConverterServiceImp.getCurrencyRateByTargets(base,symbols));
    }

}
