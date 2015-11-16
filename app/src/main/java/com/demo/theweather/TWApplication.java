package com.demo.theweather;

import android.app.Application;
import android.content.Context;

import com.demo.theweather.service.ServiceFactory;
import com.demo.theweather.service.impl.DefaultServiceFactory;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/16/15.
 */
public class TWApplication extends Application {

    private static TWApplication sInstance;

    private ServiceFactory mServiceFactory;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;

        // initialize ServiceFactory
        mServiceFactory = new DefaultServiceFactory();
    }

    public static TWApplication getsInstance() {
        return sInstance;
    }

    public static Context getContext() {
        return sInstance.getApplicationContext();
    }

    public static ServiceFactory getServiceFactory() {
        return sInstance.mServiceFactory;
    }

}
