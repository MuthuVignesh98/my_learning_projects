package com.example.myapplication;

import android.app.Application;

public class MyApplication extends Application {
    private SharedPreferenceComponent mMyComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mMyComponent  = DaggerSharedPreferenceComponent.builder()
                .appModule(new SharedPreferenceModule(this))
                .build(); ;
    }

    SharedPreferenceComponent getMyComponent() {
        return mMyComponent;
    }



}