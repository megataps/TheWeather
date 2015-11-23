package com.demo.theweather.util;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/19/15.
 */
public class TemperatureUtils {

    public static String format(double temperature) {
        return String.valueOf(Math.round(temperature)) + "°";
    }

    public static String format(String temperature) {
        return temperature + "°";
    }
}
