package com.example.myapplication;



import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPreferenceModule {




     MyApplication mApplication;

    SharedPreferenceModule(MyApplication mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    MyApplication provideApplication() {
        return mApplication;
    }
}

