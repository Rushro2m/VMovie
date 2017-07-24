package com.rushro2m.movie.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.rushro2m.movie.MyApp;

/**
 * Created by Administrator on 2017/7/24.
 */

public class SharedUtils {
    public static boolean getFlags(String key) {
        SharedPreferences sdf = getSdf();
        return sdf.getBoolean(key, false);
    }

    public static void putFlags(String key, boolean value) {
        SharedPreferences sdf = getSdf();
        sdf.edit().putBoolean(key, value).apply();
    }

    public static SharedPreferences getSdf() {
        return MyApp.getContext().getSharedPreferences("isFirst", Context.MODE_PRIVATE);
    }
}
