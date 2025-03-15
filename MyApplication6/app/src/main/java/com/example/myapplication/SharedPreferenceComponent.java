package com.example.myapplication;


import javax.inject.Singleton;

import dagger.Component;

@Singleton
    @Component(modules = {SharedPreferenceModule.class})
    public interface SharedPreferenceComponent {
        void inject(MainActivity mainActivity);

        void inject(SharedPreferenceModule sharedPreferenceModule);



        void inject(ViewModel viewModel);


        void inject(MyApplication myApplication);


    }

