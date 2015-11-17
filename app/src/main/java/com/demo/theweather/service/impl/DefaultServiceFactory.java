package com.demo.theweather.service.impl;

import com.demo.theweather.data.impl.CityRepositoryImpl;
import com.demo.theweather.data.impl.WeatherRepositoryImpl;
import com.demo.theweather.service.CityService;
import com.demo.theweather.service.ServiceFactory;
import com.demo.theweather.service.WeatherService;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/16/15.
 */
public class DefaultServiceFactory implements ServiceFactory {

    private CityService mCityService;
    private WeatherService mWeatherService;

    public DefaultServiceFactory() {
        mCityService = new CityServiceImpl(new CityRepositoryImpl());
        mWeatherService = new WeatherServiceImpl(new WeatherRepositoryImpl());
    }

    @Override
    public CityService getCityService() {
        return mCityService;
    }

    @Override
    public WeatherService getWeatherService() {
        return mWeatherService;
    }
}
