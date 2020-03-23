package com.epam.employee.employee.models;

import com.epam.employee.employee.constants.Constants;
import lombok.Data;

import java.text.ParseException;
import java.util.Date;

@Data
public class CurrencyModel {

    private String base;
    private String date;
    private RateModel rate;

    public Date getSubmissionDate() throws ParseException {
        return Constants.dateFormat.parse(this.date);
    }

    public void setSubmissionDate(Date date) {
        this.date = Constants.dateFormat.format(date);
    }
}
