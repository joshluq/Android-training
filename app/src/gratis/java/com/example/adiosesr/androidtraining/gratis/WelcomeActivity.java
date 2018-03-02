package com.example.adiosesr.androidtraining.gratis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.adiosesr.androidtraining.MainActivity;
import com.example.adiosesr.androidtraining.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeActivity extends AppCompatActivity {
    @BindView(R.id.btnBuy)
    Button btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSkip)
    public void skip() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}