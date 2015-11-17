package com.demo.theweather.service.impl;

import com.demo.theweather.data.WeatherRepository;
import com.demo.theweather.service.WeatherService;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class WeatherServiceImpl implements WeatherService {

    private WeatherRepository mWeatherRepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        mWeatherRepository = weatherRepository;
    }
}
