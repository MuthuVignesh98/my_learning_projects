package com.example.myapplication;

import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class ViewModel extends BaseObservable {

    // Creating an instance of the Model class
    private Model model = new Model("", "");

    // String variables for toast messages
    private final String successMessage = "Login successful";
    private final String errorMessage = "Email or Password is not valid";

    // String variable for toast message
    private String toastMessage;

    @Bindable
    public String getToastMessage() {
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    // Getter and setter methods for email variable
    @Bindable
    public String getUserEmail() {
        return model.getEmail();
    }

    public void setUserEmail(String email) {
        model.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    // Getter and setter methods for password variable
    @Bindable
    public String getUserPassword() {
        return model.getPassword();
    }

    public void setUserPassword(String password) {
        model.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    // Actions to be performed when the user clicks the LOGIN button
    public void onButtonClicked() {
        setToastMessage(isValid() ? successMessage : errorMessage);
    }

    // Method to ensure fields are not empty and email/password validation
    private boolean isValid() {
        return !getUserEmail().isEmpty() && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches()
                && !getUserPassword().isEmpty() && getUserPassword().length() > 8;
    }
}
