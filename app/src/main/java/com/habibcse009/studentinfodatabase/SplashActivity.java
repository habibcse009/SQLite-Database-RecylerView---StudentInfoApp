package com.habibcse009.studentinfodatabase;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class SplashActivity extends AppCompatActivity {
    int splashTimeOut = 3000;            //splash window time in mini secound
    GifImageView gifImageView;
    TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        gifImageView = (GifImageView) findViewById(R.id.gf);
        txtTitle = findViewById(R.id.txt_title);
        //Initialize font
        Typeface tf = Typeface.createFromAsset(getAssets(), "Milkshake.ttf");
        txtTitle.setTypeface(tf);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, splashTimeOut);
    }

}
