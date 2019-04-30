package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SpalashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen easySplashScreen=new EasySplashScreen(SpalashScreen.this);
        easySplashScreen.withBackgroundResource(R.color.white)

                .withLogo(R.drawable.logo_smart_driver)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(3000);

        View view = easySplashScreen.create();
        setContentView(view);
    }
}
