package com.demo.theweather.service.impl;

import com.demo.theweather.data.WeatherRepository;
import com.demo.theweather.exception.TWException;
import com.demo.theweather.model.WeatherWrapper;
import com.demo.theweather.service.WeatherService;
import com.demo.theweather.service.request.WeatherParams;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class WeatherServiceImpl implements WeatherService {

    private WeatherRepository mWeatherRepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        mWeatherRepository = weatherRepository;
    }

    @Override
    public WeatherWrapper getWeather(WeatherParams params) throws TWException {
        return mWeatherRepository.getWeather(params);
    }
}
