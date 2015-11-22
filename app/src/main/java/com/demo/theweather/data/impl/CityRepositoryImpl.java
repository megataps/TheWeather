package com.demo.theweather.data.impl;

import android.content.Context;
import android.text.TextUtils;

import com.demo.theweather.AppConfigs;
import com.demo.theweather.data.CityRepository;
import com.demo.theweather.exception.TWException;
import com.demo.theweather.model.City;
import com.demo.theweather.util.PreferenceUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class CityRepositoryImpl implements CityRepository {

    private Context mContext;

    public CityRepositoryImpl(Context context) {
        mContext = context;
    }

    @Override
    public List<City> getCityList(String keyWord) throws TWException {
        List<City> cities = new ArrayList<>();
        City hanoi = new City(1, "Ha Noi", false);
        City newYork = new City(2, "New York", false);
        City london = new City(3, "London", false);
        City paris = new City(4, "Paris", false);
        City tokyo = new City(5, "Tokyo", false);
        City haiphong = new City(6, "Hai Phong", false);
        City hochiminh = new City(7, "Ho Chi Minh", false);

        cities.add(hanoi);
        cities.add(newYork);
        cities.add(london);
        cities.add(paris);
        cities.add(tokyo);
        cities.add(haiphong);
        cities.add(hochiminh);

        initSelectedCities(cities);

        return cities;
    }

    private void initSelectedCities(List<City> cities) {
        String selectedCities = PreferenceUtils.getString(mContext, AppConfigs.CACHED_CITY_LIST_KEY, "");
        if(!TextUtils.isEmpty(selectedCities)) {
            String [] ids = selectedCities.split(",");
            int length = ids.length;
            for(int i = 0; i < length; i++) {
                for(City city : cities) {
                    if(Integer.parseInt(ids[i].trim()) == city.getId()) {
                        city.setSelected(true);
                        break;
                    }
                }
            }
        }
    }


    @Override
    public void saveSelectedCities(String selectedCity) throws TWException {

        PreferenceUtils.setString(mContext, AppConfigs.CACHED_CITY_LIST_KEY, selectedCity);
    }
}
