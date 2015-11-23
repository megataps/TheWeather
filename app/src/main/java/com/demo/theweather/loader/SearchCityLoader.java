package com.demo.theweather.loader;

import android.content.Context;

import com.demo.theweather.TWApplication;
import com.demo.theweather.model.City;

import java.util.List;

/**
 *
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class SearchCityLoader extends BaseLoader<List<City>> {

    private String mCityName;

    public SearchCityLoader(Context context, String cityName) {
        super(context);
        mCityName = cityName;
    }

    @Override
    protected List<City> doLoadInBackground() throws Exception {
        return TWApplication.getServiceFactory().getCityService().getCityList(mCityName);
    }
}
