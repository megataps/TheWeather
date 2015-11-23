package com.demo.theweather.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.demo.common.network.ImageLoader;
import com.demo.theweather.R;
import com.demo.theweather.exception.ExceptionAwareLoader;
import com.demo.theweather.loader.WeatherLoader;
import com.demo.theweather.model.City;
import com.demo.theweather.model.CurrentCondition;
import com.demo.theweather.model.Weather;
import com.demo.theweather.model.WeatherWrapper;
import com.demo.theweather.service.request.WeatherParams;
import com.demo.theweather.ui.activity.BaseActivity;
import com.demo.theweather.ui.adapter.WeatherOfDateAdapter;
import com.demo.theweather.util.NetworkUtils;
import com.demo.theweather.util.TemperatureUtils;

import java.util.List;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class WeatherOfCityFragment extends BaseFragment {

    private static final String TAG = WeatherOfCityFragment.class.getName();
    private static final String ARG_CITY = "ARG_CITY";
    private static final String ARG_LOADER_ID = "ARG_LOADER_ID";

    private ListView mWeahterOfDateListView;
    private WeatherOfDateAdapter mWeatherOfDateAdapter;

    private TextView mTxtCityName;
    private TextView mTxtTemperature;
    private ImageView mImgWeatherIcon;
    private TextView mTxtDescription;
    private TextView mTxtHumidity;
    private TextView mTxtWind;
    private TextView mTxtFeelsLike;

    private View mErrorLayout;

    private int mLoaderId;
    private City mCity;
    private WeatherWrapper mWeatherWrapper;

    public static WeatherOfCityFragment newInstance(City city, int loaderId) {
        WeatherOfCityFragment fragment = new WeatherOfCityFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_CITY, city);
        args.putInt(ARG_LOADER_ID, loaderId);
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
        mLoaderId = getArguments().getInt(ARG_LOADER_ID);

        initUiView(view);

        return view;
    }

    private void initUiView(View view) {
        mViewSwitcher = (ViewSwitcher) view.findViewById(R.id.view_switcher);

        mErrorLayout = view.findViewById(R.id.error_layout);
        mErrorLayout.setVisibility(View.GONE);

        mTxtCityName = (TextView)view.findViewById(R.id.txtCityName);
        mTxtTemperature = (TextView)view.findViewById(R.id.txtTemperature);
        mTxtDescription = (TextView)view.findViewById(R.id.txtDescription);
        mTxtHumidity = (TextView)view.findViewById(R.id.txtHumidity);
        mTxtWind = (TextView)view.findViewById(R.id.txtWind);
        mTxtFeelsLike = (TextView)view.findViewById(R.id.txtFeelsLike);

        mImgWeatherIcon = (ImageView)view.findViewById(R.id.imgWeatherIcon);

        mWeahterOfDateListView = (ListView) view.findViewById(R.id.weather_of_date_list_view);
        mWeatherOfDateAdapter = new WeatherOfDateAdapter();
        mWeahterOfDateListView.setAdapter(mWeatherOfDateAdapter);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loadData();
    }

    public void loadData() {

        if(!NetworkUtils.isNetworkAvailable(getActivity())) {
//            ((BaseActivity) getActivity()).showAlertDialog(getString(R.string.common_error), getString(R.string.common_network_error));

            if(mWeatherWrapper == null) {
                mErrorLayout.setVisibility(View.VISIBLE);
            } else {
                updateUiView(mWeatherWrapper);
            }

            return;
        }

        loadWeatherOfCity(mCity.getName());
    }

    private void updateUiWitCurrentCondition(CurrentCondition currentCondition) {
        mTxtTemperature.setText(TemperatureUtils.format(currentCondition.getTempC()) + "C");
        mTxtDescription.setText(currentCondition.getWeatherDesc());
        mTxtHumidity.setText(currentCondition.getHumidity() + "%");
        mTxtWind.setText(currentCondition.getWindspeedKmph() + " km/h");
        mTxtFeelsLike.setText(currentCondition.getFeelsLikeC() + "°C");

        mImgWeatherIcon.setTag(currentCondition.getWeatherIconUrl());
        ImageLoader.getInstance(getActivity()).displayImage(currentCondition.getWeatherIconUrl(),
                mImgWeatherIcon);
    }

    private void updateWeatherOfDate(List<Weather> weathers) {
        mWeatherOfDateAdapter.setWeathers(weathers);
        mWeatherOfDateAdapter.notifyDataSetChanged();
    }

    private void updateUiView(WeatherWrapper weatherWrapper) {
        mErrorLayout.setVisibility(View.GONE);
        mWeatherWrapper = weatherWrapper;

        mTxtCityName.setText(weatherWrapper.getRequest().getQuery());

        List<CurrentCondition> currentConditions = weatherWrapper.getCurrentConditions();
        if(currentConditions != null && !currentConditions.isEmpty()) {
            updateUiWitCurrentCondition(currentConditions.get(0));
        }

        updateWeatherOfDate(weatherWrapper.getWeathers());
    }

    private void loadWeatherOfCity(final String cityName) {

        final WeatherParams params = new WeatherParams(cityName);

        LoaderManager.enableDebugLogging(true);
        getSupportLoaderManager().initLoader(mLoaderId, null, new LoaderManager.LoaderCallbacks<WeatherWrapper>() {
            @Override
            public Loader<WeatherWrapper> onCreateLoader(final int id, final Bundle args) {
                showProgressbar(true);
                return new WeatherLoader(getActivity(), params);
            }

            @Override
            public void onLoadFinished(final Loader<WeatherWrapper> loader, final WeatherWrapper weatherWrapper) {
                showProgressbar(false);

                final Exception exception = ((ExceptionAwareLoader) loader).getException();
                if (exception != null) {
                    mErrorLayout.setVisibility(View.VISIBLE);
                    ((BaseActivity)getActivity()).showAlertDialog(getString(R.string.common_error),
                            exception.getMessage());
                    return;
                }

                updateUiView(weatherWrapper);

//                getSupportLoaderManager().destroyLoader(loaderId);
            }

            @Override
            public void onLoaderReset(final Loader<WeatherWrapper> loader) {
                // Do nothing
            }
        });
    }
}
