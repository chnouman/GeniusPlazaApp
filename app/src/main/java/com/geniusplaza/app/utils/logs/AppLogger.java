package com.geniusplaza.app.utils.logs;

import android.util.Log;
import com.geniusplaza.app.BuildConfig;

public class AppLogger implements Logs {


    public static void v(String tag, String value) {

        if (BuildConfig.DEBUG) {
            Log.v(tag, value);
        }
    }


    public static void d(String tag, String value) {

        if (BuildConfig.DEBUG) {
            Log.d(tag, value);
        }
    }

    public static void d(String value) {
        if (BuildConfig.DEBUG) {
            Log.d("GPLogs", value);
        }
    }


    public static void e(String tag, String value) {

        if (BuildConfig.DEBUG) {
            Log.e(tag, value);
        }
    }

    public static void e(String value) {

        if (BuildConfig.DEBUG) {
            Log.e("GPLogs", value);
        }
    }


    public static void i(String tag, String value) {

        if (BuildConfig.DEBUG) {
            Log.i(tag, value);
        }
    }
}
