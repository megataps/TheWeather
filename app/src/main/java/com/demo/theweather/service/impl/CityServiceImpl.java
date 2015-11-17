package com.demo.theweather.service.impl;

import com.demo.theweather.data.CityRepository;
import com.demo.theweather.service.CityService;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/16/15.
 */
public class CityServiceImpl implements CityService {

    private CityRepository mCityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        mCityRepository = cityRepository;
    }

}
