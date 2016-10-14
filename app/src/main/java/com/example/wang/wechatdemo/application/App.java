package com.example.wang.wechatdemo.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by wang on 16/9/24.
 */

public class App extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        App.context = context;
    }
}
