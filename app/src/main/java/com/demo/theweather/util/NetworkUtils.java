package com.demo.theweather.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/16/15.
 */
public class NetworkUtils {

    private NetworkUtils() {
    }

    /**
     * Checking for all possible internet providers
     */
    public static boolean isNetworkAvailable(final Context context) {

        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        }

        NetworkInfo[] infoes = connectivity.getAllNetworkInfo();
        if (infoes == null) {
            return false;
        }

        for (NetworkInfo info : infoes) {
            if (info.getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
        }

        return false;
    }
}
