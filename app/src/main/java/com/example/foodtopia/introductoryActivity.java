package com.example.foodtopia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class introductoryActivity extends AppCompatActivity {

    //splash底
    ImageView background;
    //動畫
    LottieAnimationView animation;
    //Foodtopia
    TextView text_logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);

        background = findViewById(R.id.background);
        animation = findViewById(R.id.animation);
        text_logo = findViewById(R.id.text_logo);

        Animation am = new AlphaAnimation(0.0f, 1.0f);
        am.setDuration(2000);
        am.setRepeatCount(0);
        text_logo.startAnimation(am);

        background.animate().translationY(-2000).setDuration(1000).setStartDelay(4000);
        animation.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
        text_logo.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
    }
}