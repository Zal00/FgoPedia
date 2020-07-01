package com.nya.fgopedia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    //lama waktu tampil splash screen
    private int waktu_load = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //fungsi intent untuk menuju ke halaman berikutnya dengan waktu load yang telah dientukan
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent menu2 = new Intent (SplashScreenActivity.this, IntroSliderActivity.class);
                startActivity(menu2);
                finish();
            }
        },waktu_load);
    }
}