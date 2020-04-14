package com.byfrunze.motozip;

import android.app.Application;
import android.content.Intent;

import com.byfrunze.motozip.content.NavActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class mApp extends Application {

    private FirebaseAuth mAuth;

    @Override
    public void onCreate() {
        super.onCreate();
        mAuth = FirebaseAuth.getInstance();
        if(Objects.requireNonNull(mAuth.getCurrentUser()).isEmailVerified())
            startActivity(new Intent(this, NavActivity.class));
    }
}
