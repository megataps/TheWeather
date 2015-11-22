package com.demo.theweather.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.demo.theweather.AppConfigs;
import com.demo.theweather.R;
import com.demo.theweather.TWApplication;
import com.demo.theweather.exception.ExceptionAwareLoader;
import com.demo.theweather.loader.SearchCityLoader;
import com.demo.theweather.model.City;

import java.util.List;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/22/15.
 */
public class SplashActivity extends BaseActivity {

    private static final long SPLASH_DURATION = 1000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        loadCities();
    }

    private void startMainActivity(final boolean hasCitiesSelected) {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent();
                if (hasCitiesSelected) {
                    intent.setClass(SplashActivity.this, MainActivity.class);
                } else {
                    intent.setClass(SplashActivity.this, ChooseCitiesActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, SPLASH_DURATION);
    }

    private void loadCities() {

        getSupportLoaderManager().initLoader(AppConfigs.CITY_LOADER_ID, null, new LoaderManager.LoaderCallbacks<List<City>>() {
            @Override
            public Loader<List<City>> onCreateLoader(final int id, final Bundle args) {
                return new SearchCityLoader(SplashActivity.this, "");
            }

            @Override
            public void onLoadFinished(final Loader<List<City>> loader, final List<City> cities) {

                final Exception exception = ((ExceptionAwareLoader) loader).getException();
                if (exception != null) {
                    showAlertDialog(getString(R.string.common_error), exception.getMessage());
                    return;
                }

                try {

                    boolean hasCitiesSelected =
                            TWApplication.getServiceFactory().getCityService().getSelectedCityList().isEmpty();
                    startMainActivity(!hasCitiesSelected);
                } catch (Exception ex) {
                    showAlertDialog(getString(R.string.common_error), exception.getMessage());
                }

                getSupportLoaderManager().destroyLoader(AppConfigs.CITY_LOADER_ID);
            }

            @Override
            public void onLoaderReset(final Loader<List<City>> loader) {
                // Do nothing
            }
        });
    }
}
