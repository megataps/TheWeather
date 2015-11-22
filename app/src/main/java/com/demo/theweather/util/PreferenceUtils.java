package com.demo.theweather.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/22/15.
 */
public class PreferenceUtils {

    private static final String APPLICATION_PREFERENCES = "the_weather_preferences";
    private static final int PREFERENCES_MODE = Context.MODE_PRIVATE;

    private PreferenceUtils() {
    }

    /**
     * check key exist or not
     * @param context
     * @param key
     * @return
     */
    public static boolean contains(final Context context, String key) {
        SharedPreferences prefs = context.getSharedPreferences(APPLICATION_PREFERENCES, PREFERENCES_MODE);
        return prefs.contains(key);
    }

    public static void remove(final Context context, String key) {
        SharedPreferences prefs = context.getSharedPreferences(APPLICATION_PREFERENCES, PREFERENCES_MODE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * Get boolean value in share preference
     * @param context
     * @param key
     * @param defaultValue
     * @return boolean
     */
    public static boolean getBoolean(final Context context, String key, boolean defaultValue) {
        SharedPreferences prefs = context.getSharedPreferences(APPLICATION_PREFERENCES, PREFERENCES_MODE);
        return prefs.getBoolean(key, defaultValue);
    }

    /**
     * Set boolean value in share preference
     * @param context
     * @param key
     * @param value
     */
    public static void setBoolean(final Context context, String key, boolean value) {
        SharedPreferences prefs = context.getSharedPreferences(APPLICATION_PREFERENCES, PREFERENCES_MODE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * Get string value in share preference
     * @param context
     * @param key
     * @param defaultValue
     * @return boolean
     */
    public static String getString(final Context context, String key, String defaultValue) {
        SharedPreferences prefs = context.getSharedPreferences(APPLICATION_PREFERENCES, PREFERENCES_MODE);
        return prefs.getString(key, defaultValue);
    }

    /**
     * Set string value in share preference
     * @param context
     * @param key
     * @param value
     */
    public static void setString(final Context context, String key, String value) {
        SharedPreferences prefs = context.getSharedPreferences(APPLICATION_PREFERENCES, PREFERENCES_MODE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }
}
