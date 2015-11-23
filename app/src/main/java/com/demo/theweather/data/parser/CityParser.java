package com.demo.theweather.data.parser;

import com.demo.common.parser.AbstractJsonParser;
import com.demo.theweather.data.response.BaseResponse;
import com.demo.theweather.model.Astronomy;
import com.demo.theweather.model.City;
import com.demo.theweather.model.CurrentCondition;
import com.demo.theweather.model.Request;
import com.demo.theweather.model.Weather;
import com.demo.theweather.model.WeatherWrapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/22/15.
 */
public class CityParser extends AbstractJsonParser<BaseResponse<List<City>>> {

    private static final String CITIES_TAG = "cities";

    @Override
    protected BaseResponse<List<City>> parse(JSONObject jsonParser) throws JSONException {

        BaseResponse<List<City>> baseResponse = new BaseResponse<>();

        baseResponse.setData(getCities(getArrayObject(CITIES_TAG, jsonParser)));

        return baseResponse;
    }

    private List<City> getCities(JSONArray citiesJson) throws JSONException{

        List<City> cities = new ArrayList<>();

        City city = null;
        JSONObject cityJson = null;
        int length = citiesJson.length();
        for(int i = 0; i < length; i++) {

            cityJson = citiesJson.getJSONObject(i);

            city = new City();
            city.setId(getInt("id", cityJson));
            city.setName(getString("name", cityJson));
            city.setSelected(getBoolean("isSelected", cityJson));

            cities.add(city);
        }

        return cities;
    }
}
