package com.demo.theweather.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.theweather.R;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/18/15.
 */
public class WeatherFragment extends BaseFragment {

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
        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.weather_view_pager);

        final WeatherAdapter adapter = new WeatherAdapter(getActivity().getSupportFragmentManager(), 3);

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

    }

    public static class WeatherAdapter extends FragmentStatePagerAdapter {
        int mNumOfFragments;

        public WeatherAdapter(FragmentManager fm, int numOfFragments) {
            super(fm);
            this.mNumOfFragments = numOfFragments;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return WeatherOfCurrentTimeFragment.newInstance();
                case 1:
                    return WeatherOfDayFragment.newInstance();
                case 2:
                    return WeatherOfWeekFragment.newInstance();
                default:
                    return WeatherOfCurrentTimeFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return mNumOfFragments;
        }
    }
}
