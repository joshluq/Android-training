package com.example.adiosesr.androidtraining.pago;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.adiosesr.androidtraining.MainActivity;
import com.example.adiosesr.androidtraining.R;
import com.example.adiosesr.androidtraining.pago.adapter.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class WelcomeActivity extends AppCompatActivity {


    @BindView(R.id.ibtnNext)
    ImageButton ibtnNext;

    @BindView(R.id.btnEnd)
    Button btnEnd;

    @BindView(R.id.btnSkiPager)
    Button btnSkiPager;

    @BindView(R.id.ibtnBack)
    ImageButton ibtnBack;

    @BindView(R.id.ivIndicator1)
    ImageView ivIndicator1;

    @BindView(R.id.ivIndicator2)
    ImageView ivIndicator2;

    @BindView(R.id.ivIndicator3)
    ImageView ivIndicator3;

    @BindView(R.id.container)
    ViewPager container;


    ViewPagerAdapter mPagerAdapter;
    ImageView[] indicators;
    int page = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        ButterKnife.bind(this);

        ButterKnife.bind(this);

        mPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        indicators = new ImageView[]{ivIndicator1, ivIndicator2, ivIndicator3};

        container.setAdapter(mPagerAdapter);
        container.setCurrentItem(page);

        final int color1 = ContextCompat.getColor(this, R.color.colorPagerOne);
        final int color2 = ContextCompat.getColor(this, R.color.colorPagerTwo);
        final int color3 = ContextCompat.getColor(this, R.color.colorPagerThree);

        final int[] colorList = new int[]{color1, color2, color3};

        final ArgbEvaluator evaluator = new ArgbEvaluator();

        container.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int colorUpdate = (Integer) evaluator.evaluate(positionOffset, colorList[position], colorList[position == 2 ? position : position + 1]);
                container.setBackgroundColor(colorUpdate);
            }

            @Override
            public void onPageSelected(int position) {
                page = position;
                updateIndicators(page);

                if (page == 0) container.setBackgroundColor(color1);
                else if (page == 1) container.setBackgroundColor(color2);
                else container.setBackgroundColor(color3);

                ibtnNext.setVisibility(position == 2 ? View.GONE : View.VISIBLE);
                btnEnd.setVisibility(position == 2 ? View.VISIBLE : View.GONE);
                btnSkiPager.setVisibility(position == 0 ? View.VISIBLE : View.GONE);
                ibtnBack.setVisibility(position == 0 ? View.GONE : View.VISIBLE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick(R.id.btnSkiPager)
    public void btnSkipPager() {
        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.ibtnNext)
    public void ibtnNext() {
        page += 1;
        container.setCurrentItem(page, true);
    }

    @OnClick(R.id.ibtnBack)
    public void ibtnBack() {
        page -= 1;
        container.setCurrentItem(page, true);
    }

    @OnClick(R.id.btnEnd)
    public void btnEnd() {
        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void updateIndicators(int position) {
        for (int i = 0; i < indicators.length; i++) {
            indicators[i].setBackgroundResource(i == position ? R.drawable.indicator_selected : R.drawable.indicator_unselected);
        }
    }
}
