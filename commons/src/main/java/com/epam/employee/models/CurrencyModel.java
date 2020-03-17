package com.epam.employee.models;

import com.epam.employee.constants.Constants;
import lombok.Data;

import java.text.ParseException;
import java.util.Date;
import java.util.TimeZone;

@Data
public class Currency {

    private String base;
    private String date;
    private Rate rate;

    public Date getSubmissionDate(String timezone) throws ParseException {
        Constants.dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return Constants.dateFormat.parse(this.date);
    }

    public void setSubmissionDate(Date date, String timezone) {
        Constants.dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        this.date = Constants.dateFormat.format(date);
    }
}
