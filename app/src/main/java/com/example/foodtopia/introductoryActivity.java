package com.example.foodtopia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
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

    //onboarding srceen
    private ViewPager viewPager;
    private ScreenSlidePagerAdpater pagerAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);

        background = findViewById(R.id.background);
        animation = findViewById(R.id.animation);
        text_logo = findViewById(R.id.text_logo);

        viewPager=findViewById(R.id.pager);
        pagerAdpater=new ScreenSlidePagerAdpater(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdpater);

        // change color of text_logo
        // 配色可能要改！
        String text = "Foodtopia";
        SpannableString spannableString = new SpannableString(text);

        ForegroundColorSpan yellow = new ForegroundColorSpan(getResources().getColor(R.color.my_yellow));
        ForegroundColorSpan green = new ForegroundColorSpan(getResources().getColor(R.color.my_green));
        ForegroundColorSpan red = new ForegroundColorSpan(getResources().getColor(R.color.my_red));

        spannableString.setSpan(yellow, 1, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(green, 2, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(red, 7, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        text_logo.setText(spannableString);

        // add animation of text_logo
        Animation am = new AlphaAnimation(0.0f, 1.0f);
        am.setDuration(2000);
        am.setRepeatCount(0);
        text_logo.startAnimation(am);

        background.animate().translationY(-2000).setDuration(1000).setStartDelay(4000);
        animation.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
        text_logo.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

    }
    private class ScreenSlidePagerAdpater extends FragmentStatePagerAdapter {


        public ScreenSlidePagerAdpater(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    OnBoardingFragment1 tab1=new OnBoardingFragment1();
                    return tab1;

                case 1:
                    OnBoardingFragment2 tab2=new OnBoardingFragment2();
                    return tab2;

                case 2:
                    OnBoardingFragment3 tab3=new OnBoardingFragment3();
                    return tab3;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}