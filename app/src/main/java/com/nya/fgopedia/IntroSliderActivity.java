package com.nya.fgopedia;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.nya.fgopedia.adapterSlider.SliderAdapter;

public class IntroSliderActivity extends AppCompatActivity {

    private static final int MAX_STEP = 3;

    private ImageView[] dots;
    private SliderAdapter sliderAdapter;
    private int mCurrentPage;
    private Button prev, next, finish, skip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_slider);
        initComponent();
    }

    private void initComponent() {
        final ViewPager viewPager = findViewById(R.id.slide);
        next = findViewById(R.id.Next);
        prev = findViewById(R.id.prev);
        finish = findViewById(R.id.Finish);
        skip = findViewById(R.id.skip);




        bottomProgressDots(0);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(IntroSliderActivity.this, NavActivity.class);
                startActivity(i);
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(IntroSliderActivity.this, NavActivity.class);
                startActivity(i);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(mCurrentPage + 1);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(mCurrentPage -1);
            }
        });
    }

    private void bottomProgressDots(int index) {
        LinearLayout dotsLayout = findViewById(R.id.dotslayout);
        dots = new ImageView[MAX_STEP];

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this);
            int width_height = 15;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(width_height, width_height));
            params.setMargins(10, 10, 10, 10);
            dots[i].setLayoutParams(params);
            dots[i].setImageResource(R.drawable.dot);
            dots[i].setColorFilter(getResources().getColor(R.color.bluedark), PorterDuff.Mode.SRC_IN);
            dotsLayout.addView(dots[i]);
        }

        dots[index].setImageResource(R.drawable.dot);
        dots[index].setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
    }


    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(final int position) {
            bottomProgressDots(position);
            mCurrentPage = position;

            if (position == 0){
                next.setEnabled(true);
                prev.setEnabled(false);
                finish.setEnabled(false);
                skip.setEnabled(true);
                finish.setBackgroundColor(Color.TRANSPARENT);

                next.setText("Next");
                skip.setText("Skip");
                prev.setText("");
                finish.setText("");
            } else if (position == dots.length -1) {
                next.setEnabled(false);
                prev.setEnabled(true);
                skip.setEnabled(false);
                finish.setEnabled(true);
                prev.setVisibility(View.VISIBLE);
                finish.setVisibility(View.VISIBLE);
                finish.setBackgroundResource(R.drawable.btn_finish);

                skip.setText("");
                next.setText("");
                prev.setText("Back");
                finish.setText("Finish");
            } else {
                next.setEnabled(true);
                prev.setEnabled(true);
                finish.setEnabled(false);
                skip.setEnabled(false);
                prev.setVisibility(View.VISIBLE);
                finish.setBackgroundColor(Color.TRANSPARENT);

                skip.setText("");
                next.setText("Next");
                prev.setText("Back");
                finish.setText("");
            }

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };
}