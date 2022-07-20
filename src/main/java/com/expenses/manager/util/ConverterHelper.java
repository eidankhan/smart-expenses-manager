package com.expenses.manager.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.expenses.manager.model.Expense;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverterHelper {

    public static Map<String, Object> convertObjectToMap(Expense expense) {
        System.out.println("AppHelper.convertObjectToMap(employee) --> is called");
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> convertedValue = objectMapper.convertValue(expense, Map.class);
        System.out.println("Converted Value --> " + convertedValue);
        return convertedValue;
    }
    
    public static String convertMillisecondsToDateString(Long milliseconds) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	return dateFormat.format(new Date(milliseconds));
    }
}
