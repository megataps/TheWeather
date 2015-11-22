package com.demo.theweather.service;

import com.demo.theweather.exception.TWException;
import com.demo.theweather.model.City;

import java.util.List;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/16/15.
 */
public interface CityService {

    List<City> getCityList(String keyWord) throws TWException;

    List<City> getSelectedCityList() throws TWException;

    void saveSelectedCities() throws TWException;
}
