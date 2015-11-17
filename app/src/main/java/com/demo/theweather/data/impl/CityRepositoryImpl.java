package com.demo.theweather.data.impl;

import com.demo.network.DefaultHttpClient;
import com.demo.network.HttpResponse;
import com.demo.theweather.AppConfigs;
import com.demo.theweather.data.CityRepository;
import com.demo.theweather.model.City;

import java.net.URL;
import java.util.List;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class CityRepositoryImpl implements CityRepository {

    private DefaultHttpClient mDefaultHttpClient;

    public CityRepositoryImpl() {
        mDefaultHttpClient = new DefaultHttpClient();
    }

    @Override
    public List<City> getCityList(String name) throws Exception{
        URL url = new URL(AppConfigs.SEARCH_CITY_URL);
//        Map<String, List<String>> headers = new HashMap<>();
//        headers.put("", );

        HttpResponse httpResponse =  mDefaultHttpClient.get(url, null);


        return null;
    }
}
