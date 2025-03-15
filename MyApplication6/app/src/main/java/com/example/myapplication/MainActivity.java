package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.databinding.ActivityMainBinding;

import javax.inject.Inject;

public class MainActivity extends Activity {
     SharedPreferenceComponent sharedPreferenceComponent;

    // @Inject is used to tell which activity,
    // fragment or service is allowed to request
    // dependencies declared in Module class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ViewModel updates the Model after observing changes in the View
        // Model will also update the View via the ViewModel

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Assigning the ViewModel to the binding
        ViewModel viewModel = new ViewModel();
        activityMainBinding.setViewModel(viewModel);

        // Executes pending bindings immediately
        activityMainBinding.executePendingBindings();

        ((MyApplication) getApplication())
                .getMyComponent()
                .inject(this);
    }

    // BindingAdapter to show the toast message
    @BindingAdapter("toastMessage")
    public void runMe(View view, String message) {
        if (message != null && !message.isEmpty()) {

            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
            this.startActivity(intent);


        }
    }
}

