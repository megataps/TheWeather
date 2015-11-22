package com.demo.theweather.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.theweather.R;
import com.demo.theweather.ui.fragment.WeatherFragment;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getName();


    private Toolbar mToolbar;

    private TextView mTxtCity;
    private ImageView mImgUpdate;

    private WeatherFragment mWeatherFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUiView();

        if (savedInstanceState == null) {
            mWeatherFragment = WeatherFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mWeatherFragment).commit();
        }
    }

    private void initUiView() {
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mTxtCity = (TextView)findViewById(R.id.txtCity);
        mImgUpdate = (ImageView)findViewById(R.id.imgUpdate);

        setSupportActionBar(mToolbar);

        mTxtCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChooseCitiesActivity.class);
                startActivity(intent);
                finish();
            }
        });


        mImgUpdate.setVisibility(View.VISIBLE);
        mImgUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWeatherFragment.updateWeatherAtCurrent();
            }
        });
    }
}
