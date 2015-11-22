package com.demo.theweather.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/22/15.
 */
public class DateUtils {

    public static Date convertDateFromString(String dateInput, String formatInput) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return sdf.parse(dateInput);
    }
}
