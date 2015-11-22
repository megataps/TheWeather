package com.demo.theweather.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.demo.theweather.R;
import com.demo.theweather.ui.fragment.WeatherFragment;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getName();


    private Toolbar mToolbar;

    private TextView mTxtCity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUiView();

        if (savedInstanceState == null) {
            Fragment fragment = WeatherFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

    private void initUiView() {
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mTxtCity = (TextView)findViewById(R.id.txtCity);

        setSupportActionBar(mToolbar);

//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });

        mTxtCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChooseCitiesActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
