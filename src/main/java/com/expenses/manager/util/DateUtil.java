package com.expenses.manager.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    public static Integer getMonthFromMilliseconds(Long milliseconds) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (milliseconds != 0) {
            LocalDate parseDate = LocalDate.parse(dateFormat.format(new Date(milliseconds)),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return parseDate.getMonth().getValue();
        }
        return 0;
    }

    public static Integer getCurrentMonth() {
        return LocalDate.now().getMonth().getValue();
    }
}
