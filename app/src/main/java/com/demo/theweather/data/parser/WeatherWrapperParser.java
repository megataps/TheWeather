package com.demo.theweather.data.parser;

import com.demo.common.parser.AbstractJsonParser;
import com.demo.theweather.data.response.BaseResponse;
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
public class WeatherWrapperParser extends AbstractJsonParser<BaseResponse<WeatherWrapper>> {

    private static final String DATA_TAG = "data";
    private static final String CURRENT_CONDITION_TAG = "current_condition";
    private static final String REQUEST_TAG = "request";
    private static final String WEATHER_TAG = "request";

    @Override
    protected BaseResponse<WeatherWrapper> parse(JSONObject jsonParser) throws JSONException {

        JSONObject dataObj = getObject(DATA_TAG, jsonParser);

        BaseResponse<WeatherWrapper> baseResponse = new BaseResponse<>();
        WeatherWrapper weatherWrapper = new WeatherWrapper();

        weatherWrapper.setCurrentConditions(getCurrentConditions(getArrayObject(CURRENT_CONDITION_TAG, dataObj)));
        weatherWrapper.setRequest(getRequest(getArrayObject(REQUEST_TAG, dataObj)));
        weatherWrapper.setWeathers(getWeathers(getArrayObject(WEATHER_TAG, dataObj)));

        baseResponse.setData(weatherWrapper);

        return baseResponse;
    }

    private List<CurrentCondition> getCurrentConditions(JSONArray currConditionListJson) throws JSONException{

        List<CurrentCondition> conditionList = new ArrayList<>();

        CurrentCondition currentCondition = null;
        int length = currConditionListJson.length();
        for(int i = 0; i < length; i++) {

            JSONObject curConditionJson = currConditionListJson.getJSONObject(i);

            currentCondition = new CurrentCondition();
            currentCondition.setObservationTime(getString("observation_time", curConditionJson));
            currentCondition.setTempC(getDouble("temp_C", curConditionJson));
            currentCondition.setTempF(getDouble("temp_F", curConditionJson));
            currentCondition.setWeatherCode(getString("weatherCode", curConditionJson));

            JSONArray iconUrlJson = getArrayObject("weatherIconUrl", curConditionJson);
            currentCondition.setWeatherIconUrl(getString("value", iconUrlJson.getJSONObject(0)));

            JSONArray weatherDescJson = getArrayObject("weatherDesc", curConditionJson);
            currentCondition.setWeatherDesc(getString("value", weatherDescJson.getJSONObject(0)));

            currentCondition.setWindspeedMiles(getString("windspeedMiles", curConditionJson));
            currentCondition.setWindspeedKmph(getString("windspeedKmph", curConditionJson));
            currentCondition.setWinddirDegree(getString("winddirDegree", curConditionJson));
            currentCondition.setWinddir16Point(getString("winddir16Point", curConditionJson));
            currentCondition.setPrecipMM(getString("precipMM", curConditionJson));
            currentCondition.setHumidity(getString("humidity", curConditionJson));
            currentCondition.setVisibility(getString("visibility", curConditionJson));
            currentCondition.setPressure(getString("pressure", curConditionJson));
            currentCondition.setCloudcover(getString("cloudcover", curConditionJson));

            currentCondition.setFeelsLikeC(getString("FeelsLikeC", curConditionJson));
            currentCondition.setFeelsLikeF(getString("FeelsLikeF", curConditionJson));

            conditionList.add(currentCondition);
        }


        return conditionList;
    }

    private Request getRequest(JSONArray requestListJson) throws JSONException{

        JSONObject requestJson  = requestListJson.getJSONObject(0);

        Request request = new Request();
        request.setQuery(getString("query", requestJson));
        request.setType(getString("type", requestJson));

        return request;
    }

    private List<Weather> getWeathers(JSONArray weatherListJson) throws JSONException{

        List<Weather> weathers = new ArrayList<>();

//        Weather weather = null;
//        int length = weatherListJson.length();
//        for(int i = 0; i < length; i++) {
//            JSONObject weatherJson = weatherListJson.getJSONObject(i);
//
//
//            weathers.add(weather);
//        }

        return weathers;
    }

}
