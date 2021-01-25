package com.example.news.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.news.SplashActivity;

public class CenterUtil {

    public static final String NEWS = "News";

    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sharedPreferences=context.getSharedPreferences(NEWS,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key,false);
    }

    public static void setBoolean(Context context, String key, boolean b) {
        context.getSharedPreferences(NEWS,Context.MODE_PRIVATE).edit().putBoolean(key,b).commit();
    }
}
