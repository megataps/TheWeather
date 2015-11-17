package com.demo.theweather.data;

import com.demo.theweather.model.City;

import java.util.List;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public interface CityRepository {

    List<City> getCityList(String name) throws Exception;
}
