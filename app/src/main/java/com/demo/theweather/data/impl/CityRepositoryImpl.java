package com.demo.theweather.data.impl;

import android.content.Context;
import android.text.TextUtils;

import com.demo.theweather.AppConfigs;
import com.demo.theweather.data.CityRepository;
import com.demo.theweather.data.parser.CityParser;
import com.demo.theweather.exception.TWException;
import com.demo.theweather.model.City;
import com.demo.theweather.util.PreferenceUtils;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * This class is responsible for get city from local file and save status of city into preferences
 *
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class CityRepositoryImpl implements CityRepository {

    private Context mContext;
    private CityParser mCityParser;

    public CityRepositoryImpl(Context context) {
        mContext = context;
        mCityParser = new CityParser();
    }

    private  String loadJsonFromAsset(Context ctx) throws TWException{
        String json = null;
        try {
            InputStream is = ctx.getAssets().open(AppConfigs.CITY_FILE_NAME);

            BufferedReader r = new BufferedReader(new InputStreamReader(is));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line);
            }
            is.close();
            json = total.toString();
        } catch (IOException ex) {
            throw new TWException(ex.getMessage());
        }
        return json;
    }

    @Override
    public List<City> getCityList(String keyWord) throws TWException {

        try {
            String jsonData = loadJsonFromAsset(mContext);

            mCityParser.parse(jsonData);

            List<City> cities = mCityParser.getResult().getData();
            initSelectedCities(cities);
            return cities;
        } catch (JSONException ex) {
            throw new TWException(ex.getMessage());
        }
    }

    private void initSelectedCities(List<City> cities) {
        String selectedCities = PreferenceUtils.getString(mContext, AppConfigs.CACHED_CITY_LIST_KEY, "");
        if(!TextUtils.isEmpty(selectedCities)) {
            String [] ids = selectedCities.split(AppConfigs.SEPARATOR_CHARACTER);
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
