package com.demo.theweather.ui.activity;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;

import com.demo.theweather.R;
import com.demo.theweather.loader.SearchCityLoader;
import com.demo.theweather.model.City;

import java.util.List;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadCityList("HaNoi");
    }

    private void loadCityList(final String cityName) {
        Log.e(TAG, "loadCityList");

        getSupportLoaderManager().initLoader(111, null, new LoaderManager.LoaderCallbacks<List<City>>() {
            @Override
            public Loader<List<City>> onCreateLoader(final int id, final Bundle args) {
//                showProgressbar(true);
                return new SearchCityLoader(MainActivity.this, cityName);
            }

            @Override
            public void onLoadFinished(final Loader<List<City>> loader, final List<City> cityList) {
//                showProgressbar(false);

//                if (cityList != null) {
//
//                }

                getSupportLoaderManager().destroyLoader(111);
            }

            @Override
            public void onLoaderReset(final Loader<List<City>> loader) {
                // Do nothing
            }
        });
    }
}
