package com.demo.theweather.service.request;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/21/15.
 */
public class WeatherParams {

    private String mCityName;

    public WeatherParams(String cityName) {
        mCityName = cityName;
    }

    public String getCityName() {
        return mCityName;
    }
}
