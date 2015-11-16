package com.demo.theweather.util;

import android.util.Log;

import com.demo.theweather.BuildConfig;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/16/15.
 */
public class LogUtils {
    private static boolean isDebuggable = BuildConfig.DEBUG;

    private LogUtils() {

    }

    /**
     * log verbal
     * @param tag
     * @param msg
     */
    public static void v(String tag, String msg) {
        if (msg != null && isDebuggable) {
            Log.v(tag, msg);
        }
    }

    /**
     * log debug
     * @param tag
     * @param msg
     */
    public static void d(String tag, String msg) {
        if (msg != null && isDebuggable) {
            Log.d(tag, msg);
        }
    }

    /**
     * log info
     * @param tag
     * @param msg
     */
    public static void i(String tag, String msg) {
        if (msg != null && isDebuggable) {
            Log.i(tag, msg);
        }
    }

    /**
     * log error
     * @param tag
     * @param msg
     */
    public static void e(String tag, String msg) {
        if (msg != null && isDebuggable) {
            Log.e(tag, msg);
        }
    }

    public static void printStackTrace(Exception e) {
        if (e != null && isDebuggable) {
            e.printStackTrace();
        }
    }

}
