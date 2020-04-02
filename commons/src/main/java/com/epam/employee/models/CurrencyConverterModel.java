package com.epam.employee.models;

import com.epam.employee.constants.Constants;
import lombok.Data;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class CurrencyConverterModel {

    private String base;
    private String date;
    private Map<String, Double> rates;

    public Date getSubmissionDate() throws ParseException {
        return Constants.dateFormat.parse(this.date);
    }

    public void setSubmissionDate(Date date) {
        this.date = Constants.dateFormat.format(date);
    }
}
