package com.demo.theweather.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.demo.theweather.R;
import com.demo.theweather.model.City;
import com.demo.theweather.ui.adapter.CityAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class CityListFragment extends BaseFragment {

    private ListView mCityListView;
    private CityAdapter mCityAdapter;

    public static CityListFragment newInstance() {
        CityListFragment fragment = new CityListFragment();
        return fragment;
    }

    public CityListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city_list, container, false);

        initUiView(view);

        loadData();

        return view;
    }

    private void initUiView(View view) {
        mCityListView = (ListView) view.findViewById(R.id.city_list_view);
        mCityAdapter = new CityAdapter();
        mCityListView.setAdapter(mCityAdapter);

        mCityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                City city =  (City)mCityAdapter.getItem(i);
                city.setSelected(!city.isSelected());
                mCityAdapter.notifyDataSetChanged();
            }
        });
    }

    private void loadData() {
        List<City> cities = new ArrayList<>();
        City city = null;

        for(int i = 0; i < 10; i++) {
            city = new City("city name : " + i, false);
            cities.add(city);
        }

        mCityAdapter.setLanguages(cities);
        mCityAdapter.notifyDataSetChanged();
    }
}
