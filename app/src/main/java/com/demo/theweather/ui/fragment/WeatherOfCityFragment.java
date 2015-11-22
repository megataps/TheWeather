package com.demo.theweather.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.common.network.ImageLoader;
import com.demo.theweather.R;
import com.demo.theweather.exception.ExceptionAwareLoader;
import com.demo.theweather.loader.WeatherLoader;
import com.demo.theweather.model.City;
import com.demo.theweather.model.CurrentCondition;
import com.demo.theweather.model.WeatherWrapper;
import com.demo.theweather.service.request.WeatherParams;
import com.demo.theweather.ui.activity.BaseActivity;
import com.demo.theweather.util.LogUtils;
import com.demo.theweather.util.NetworkUtils;
import com.demo.theweather.util.TemperatureUtils;

import java.util.List;
import java.util.Random;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class WeatherOfCityFragment extends BaseFragment {

    private static final String TAG = WeatherOfCityFragment.class.getName();
    private static final String ARG_CITY = "ARG_CITY";

    private TextView mTxtCityName;
    private TextView mTxtTemperature;
    private ImageView mImgWeatherIcon;
    private TextView mTxtDescription;
    private TextView mTxtHumidity;
    private TextView mTxtWind;
    private TextView mTxtFeelsLike;


    private City mCity;

    public static WeatherOfCityFragment newInstance(City city) {
        LogUtils.e(TAG, "newInstance");
        WeatherOfCityFragment fragment = new WeatherOfCityFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_CITY, city);
        fragment.setArguments(args);
        return fragment;
    }

    public WeatherOfCityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_of_city, container, false);

        mCity = getArguments().getParcelable(ARG_CITY);

        initUiView(view);

        loadData();

        return view;
    }

    private void initUiView(View view) {
        mTxtCityName = (TextView)view.findViewById(R.id.txtCityName);
        mTxtTemperature = (TextView)view.findViewById(R.id.txtTemperature);
        mTxtDescription = (TextView)view.findViewById(R.id.txtDescription);
        mTxtHumidity = (TextView)view.findViewById(R.id.txtHumidity);
        mTxtWind = (TextView)view.findViewById(R.id.txtWind);
        mTxtFeelsLike = (TextView)view.findViewById(R.id.txtFeelsLike);

        mImgWeatherIcon = (ImageView)view.findViewById(R.id.imgWeatherIcon);
    }

    private void loadData() {

        if(!NetworkUtils.isNetworkAvailable(getActivity())) {
            ((BaseActivity) getActivity()).showAlertDialog(getString(R.string.common_error), getString(R.string.common_network_error));
            return;
        }

        loadWeatherOfCity(mCity.getName());
    }

    private void updateUi(CurrentCondition currentCondition) {
        mTxtTemperature.setText(TemperatureUtils.format(currentCondition.getTempC()) + "C");
        mTxtDescription.setText(currentCondition.getWeatherDesc());
        mTxtHumidity.setText(currentCondition.getHumidity() + "%");
        mTxtWind.setText(currentCondition.getWindspeedKmph() + " km/h");
        mTxtFeelsLike.setText(currentCondition.getFeelsLikeC() + "°C");

        mImgWeatherIcon.setTag(currentCondition.getWeatherIconUrl());
        ImageLoader.getInstance(getActivity()).displayImage(currentCondition.getWeatherIconUrl(),
                mImgWeatherIcon);
    }

    private void loadWeatherOfCity(final String cityName) {
        Log.e(TAG, "loadWeatherOfCity");
        LogUtils.e(TAG, "cityName:" + cityName);

        final WeatherParams params = new WeatherParams(cityName);

        Random random = new Random();
        final int loaderId = random.nextInt(1000);
        LogUtils.e(TAG, "loaderId:" + loaderId);

        LoaderManager.enableDebugLogging(true);
        getSupportLoaderManager().initLoader(loaderId, null, new LoaderManager.LoaderCallbacks<WeatherWrapper>() {
            @Override
            public Loader<WeatherWrapper> onCreateLoader(final int id, final Bundle args) {
//                showProgressDialog(true);
                LogUtils.e(TAG, "aaaaaaa");
                return new WeatherLoader(getActivity(), params);
            }

            @Override
            public void onLoadFinished(final Loader<WeatherWrapper> loader, final WeatherWrapper weatherWrapper) {
//                showProgressDialog(false);

                LogUtils.e(TAG, "return cityName:" + cityName);

                final Exception exception = ((ExceptionAwareLoader) loader).getException();
                if (exception != null) {
                    ((BaseActivity)getActivity()).showAlertDialog(getString(R.string.common_error),
                            exception.getMessage());
                    return;
                }

                mTxtCityName.setText(weatherWrapper.getRequest().getQuery());

                List<CurrentCondition> currentConditions = weatherWrapper.getCurrentConditions();
                if(currentConditions != null && !currentConditions.isEmpty()) {
                    updateUi(currentConditions.get(0));
                }

                getSupportLoaderManager().destroyLoader(loaderId);
            }

            @Override
            public void onLoaderReset(final Loader<WeatherWrapper> loader) {
                // Do nothing
            }
        });
    }
}
