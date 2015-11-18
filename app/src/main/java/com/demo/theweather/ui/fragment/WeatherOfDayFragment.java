package com.demo.theweather.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.theweather.R;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class WeatherOfDayFragment extends BaseFragment {

    public static WeatherOfDayFragment newInstance() {
        WeatherOfDayFragment fragment = new WeatherOfDayFragment();
        return fragment;
    }

    public WeatherOfDayFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_of_day, container, false);

        initUiView(view);

        loadData();

        return view;
    }

    private void initUiView(View view) {

    }

    private void loadData() {

    }
}
