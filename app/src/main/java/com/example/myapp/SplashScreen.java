package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3000;
    Animation topAnimation,bottomAnimation;
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        imageView.setAnimation(topAnimation);
        imageView.setAnimation(bottomAnimation);
        textView.setAnimation(bottomAnimation);

        new Handler().postDelayed((Runnable) () -> {
            Intent intent = new Intent(SplashScreen.this,MainActivity.class);
            startActivity(intent);
            finish();
        },SPLASH_SCREEN);

    }
}