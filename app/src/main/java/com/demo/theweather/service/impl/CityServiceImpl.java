package com.demo.theweather.service.impl;

import com.demo.theweather.data.CityRepository;
import com.demo.theweather.model.City;
import com.demo.theweather.service.CityService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/16/15.
 */
public class CityServiceImpl implements CityService {

    private CityRepository mCityRepository;
    private List<City> mCityListCached;

    public CityServiceImpl(CityRepository cityRepository) {
        mCityRepository = cityRepository;

        mCityListCached = new ArrayList<>();
    }

    @Override
    public List<City> getCityList(String name) throws Exception {
        mCityListCached = mCityRepository.getCityList(name);
        return mCityListCached;
    }
}
