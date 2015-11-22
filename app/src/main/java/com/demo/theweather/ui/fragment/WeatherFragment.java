package com.demo.theweather.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.theweather.R;
import com.demo.theweather.TWApplication;
import com.demo.theweather.model.City;
import com.demo.theweather.ui.activity.BaseActivity;
import com.demo.theweather.util.LogUtils;

import java.util.List;
import java.util.Random;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/18/15.
 */
public class WeatherFragment extends BaseFragment {

    private ViewPager mWeatherViewPager;

    public static WeatherFragment newInstance() {
        WeatherFragment fragment = new WeatherFragment();
        return fragment;
    }

    public WeatherFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);

        initUiView(view);

        loadData();

        return view;
    }

    private void initUiView(View view) {

        mWeatherViewPager = (ViewPager) view.findViewById(R.id.weather_view_pager);

        mWeatherViewPager.setOffscreenPageLimit(1);
        mWeatherViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void loadData() {
        try {
            final WeatherAdapter adapter =
                    new WeatherAdapter(getActivity().getSupportFragmentManager(),
                            TWApplication.getServiceFactory().getCityService().getSelectedCityList());

            mWeatherViewPager.setAdapter(adapter);
        } catch (Exception ex) {
            LogUtils.printStackTrace(ex);
        }
    }

    private Fragment getCurrentActiveFragment() {
        String fragmentName = "android:switcher:" + mWeatherViewPager.getId() + ":" + mWeatherViewPager.getCurrentItem();
        return getChildFragmentManager().findFragmentByTag(fragmentName);
    }

    public void updateWeatherAtCurrent() {
        Fragment fragment = getCurrentActiveFragment();
        if(fragment != null) {
            ((WeatherOfCityFragment) fragment).loadData();
        } else {
            ((BaseActivity)getActivity()).showAlertDialog(getString(R.string.common_error),
                    getString(R.string.update_error));
        }
    }

    public static class WeatherAdapter extends FragmentPagerAdapter {
        List<City> mSelectedCities;

        public WeatherAdapter(FragmentManager fm, List<City> selectedCities) {
            super(fm);
            this.mSelectedCities = selectedCities;
        }

        @Override
        public Fragment getItem(int position) {
            Random random = new Random();
            final int loaderId = random.nextInt(1000);
            return WeatherOfCityFragment.newInstance(mSelectedCities.get(position), loaderId);
        }

        @Override
        public int getCount() {
            return mSelectedCities == null ? 0 : mSelectedCities.size();
        }
    }
}
