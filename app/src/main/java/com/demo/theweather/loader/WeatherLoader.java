package com.demo.theweather.loader;

import android.content.Context;

import com.demo.theweather.TWApplication;
import com.demo.theweather.model.WeatherWrapper;
import com.demo.theweather.service.request.WeatherParams;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class WeatherLoader extends BaseLoader<WeatherWrapper> {

    private WeatherParams mWeatherParams;

    public WeatherLoader(Context context, WeatherParams weatherParams) {
        super(context);
        mWeatherParams = weatherParams;
    }

    @Override
    protected WeatherWrapper doLoadInBackground() throws Exception {
        return TWApplication.getServiceFactory().getWeatherService().getWeather(mWeatherParams);
    }
}
