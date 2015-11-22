package com.demo.theweather.service;

import com.demo.theweather.exception.TWException;
import com.demo.theweather.model.WeatherWrapper;
import com.demo.theweather.service.request.WeatherParams;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/16/15.
 */
public interface WeatherService {

    WeatherWrapper getWeather(WeatherParams params) throws TWException;

}
