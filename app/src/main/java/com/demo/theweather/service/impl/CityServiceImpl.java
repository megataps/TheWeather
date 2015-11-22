package com.demo.theweather.service.impl;

import android.text.TextUtils;

import com.demo.theweather.data.CityRepository;
import com.demo.theweather.exception.TWException;
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
    public List<City> getCityList(String keyWord) throws TWException {
        if(mCityListCached.isEmpty()) {
            mCityListCached = mCityRepository.getCityList(keyWord);
        }

        return mCityListCached;
    }

    @Override
    public List<City> getSelectedCityList() throws TWException {

        List<City> selectedCities = new ArrayList<>();

        if(!mCityListCached.isEmpty()) {

            for(City city : mCityListCached) {
                if(city.isSelected()) {
                    selectedCities.add(city);
                }
            }
        }

        return selectedCities;
    }

    @Override
    public void saveSelectedCities() throws TWException {
        List<City> selectedCities = getSelectedCityList();

        List<String> results = new ArrayList<String>();
        for (City city : selectedCities) {
            results.add(String.valueOf(city.getId()));
        }

        mCityRepository.saveSelectedCities(TextUtils.join(",", results));
    }
}
