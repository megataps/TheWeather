package com.demo.theweather.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.demo.theweather.AppConfigs;
import com.demo.theweather.R;
import com.demo.theweather.TWApplication;
import com.demo.theweather.exception.ExceptionAwareLoader;
import com.demo.theweather.loader.SearchCityLoader;
import com.demo.theweather.model.City;
import com.demo.theweather.service.CityService;
import com.demo.theweather.ui.adapter.CityAdapter;
import com.demo.theweather.util.LogUtils;

import java.util.List;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class ChooseCitiesActivity extends BaseActivity {

    private ListView mCityListView;
    private CityAdapter mCityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_cities);

        initUiView();

        loadData();
    }

    private void initUiView() {
        mCityListView = (ListView) findViewById(R.id.city_list_view);
        mCityAdapter = new CityAdapter();
        mCityListView.setAdapter(mCityAdapter);

        mCityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                City city = (City) mCityAdapter.getItem(i);
                city.setSelected(!city.isSelected());
                mCityAdapter.notifyDataSetChanged();
            }
        });

        TextView txtDone = (TextView)findViewById(R.id.txtDone);

        txtDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    if (getCityService().getSelectedCityList().isEmpty()) {
                        showAlertDialog(getString(R.string.common_error), getString(R.string.choose_cities_empty));
                        return;
                    }

                    getCityService().saveSelectedCities();

                } catch (Exception ex) {
                    LogUtils.printStackTrace(ex);
                    return;
                }

                Intent intent = new Intent(ChooseCitiesActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private CityService getCityService() {
        return TWApplication.getServiceFactory().getCityService();
    }

    private void loadData() {

        getSupportLoaderManager().initLoader(AppConfigs.CITY_LOADER_ID, null, new LoaderManager.LoaderCallbacks<List<City>>() {
            @Override
            public Loader<List<City>> onCreateLoader(final int id, final Bundle args) {
                showProgressDialog(true);
                return new SearchCityLoader(ChooseCitiesActivity.this, "");
            }

            @Override
            public void onLoadFinished(final Loader<List<City>> loader, final List<City> cities) {
                showProgressDialog(false);

                final Exception exception = ((ExceptionAwareLoader) loader).getException();
                if (exception != null) {
                    showAlertDialog(getString(R.string.common_error), exception.getMessage());
                    return;
                }

                mCityAdapter.setCities(cities);
                mCityAdapter.notifyDataSetChanged();

                getSupportLoaderManager().destroyLoader(AppConfigs.CITY_LOADER_ID);
            }

            @Override
            public void onLoaderReset(final Loader<List<City>> loader) {
                // Do nothing
            }
        });
    }
}
