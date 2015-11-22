package com.demo.theweather;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/16/15.
 */
public class AppConfigs {

    public static final int NUMBER_OF_RESULT = 10;
    public static final String WEATHER_API_KEY = "6d06579b6dc6d1d259adb0091869a";
    public static final String APP_URL = "http://api.worldweatheronline.com/free/v2/";

    public static final String WEATHER_URL = APP_URL + "weather.ashx?q=%s&format=json&num_of_results=%d&key=%s";

    public static final int WEATHER_OF_CITY_LOADER_ID = 1;
    public static final int CITY_LOADER_ID = 2;

    public static final String CACHED_CITY_LIST_KEY = "cached_city_list_key";
}
