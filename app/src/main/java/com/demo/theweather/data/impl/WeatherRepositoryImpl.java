package com.demo.theweather.data.impl;

import com.demo.common.network.DefaultHttpClient;
import com.demo.common.network.HttpResponse;
import com.demo.theweather.AppConfigs;
import com.demo.theweather.data.WeatherRepository;
import com.demo.theweather.data.parser.WeatherWrapperParser;
import com.demo.theweather.data.response.BaseResponse;
import com.demo.theweather.exception.TWException;
import com.demo.theweather.model.WeatherWrapper;
import com.demo.theweather.service.request.WeatherParams;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class WeatherRepositoryImpl implements WeatherRepository {

    private static final String TAG = WeatherRepositoryImpl.class.getName();

    private DefaultHttpClient mDefaultHttpClient;
    private WeatherWrapperParser mWeatherWrapperParser;

    public WeatherRepositoryImpl() {
        mDefaultHttpClient = new DefaultHttpClient();
        mWeatherWrapperParser = new WeatherWrapperParser();
    }

    @Override
    public WeatherWrapper getWeather(WeatherParams params) throws TWException {
        try {

            String baseUrl = String.format(AppConfigs.WEATHER_URL, URLEncoder.encode(params.getCityName(), "UTF-8"),
                    AppConfigs.NUMBER_OF_RESULT, AppConfigs.WEATHER_API_KEY);
            URL url = new URL(baseUrl);

            HttpResponse httpResponse = mDefaultHttpClient.get(url, null);

//            if(httpResponse != null && httpResponse.getStatus() >= 200 && httpResponse.getStatus() < 300) {

                mWeatherWrapperParser.parse(httpResponse.getBody());
                BaseResponse<WeatherWrapper> baseResponse = mWeatherWrapperParser.getResult();

                return baseResponse.getData();
//            } else {
//                throw new TWException(mDefaultHttpClient.getErrorMessage());
//            }
        } catch (MalformedURLException ex) {
            throw new TWException(ex.getMessage());
        } catch (JSONException ex) {
            throw new TWException(ex.getMessage());
        } catch (UnsupportedEncodingException ex) {
            throw new TWException(ex.getMessage());
        }
    }

}
