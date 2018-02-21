package com.example.adiosesr.androidtraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.adiosesr.androidtraining.models.Book;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoreActivity extends AppCompatActivity {
    @BindView(R.id.ivBanner)
    ImageView ivBanner;
    @BindView(R.id.ivFront)
    ImageView ivFront;
    @BindView(R.id.tvNameBook)
    TextView tvNameBook;
    @BindView(R.id.tvDetailBook)
    TextView tvDescBook;
    @BindView(R.id.tvTag01)
    TextView tvTag02;
    @BindView(R.id.tvTag02)
    TextView tvTag03;
    @BindView(R.id.tvTag03)
    TextView tvTag01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        ButterKnife.bind(this);
        book();

    }
    public void book()
    {
      Book b = (Book) getIntent().getSerializableExtra("books");
        Glide.with(this).load(b.getBanner()).into(ivBanner);
        Glide.with(this).load(b.getUrl()).into(ivFront);
        tvNameBook.setText(b.getName());
        tvDescBook.setText(b.getDescription());
        tvTag01.setText(b.getTags().get(0).getNameTag());
        tvTag02.setText(b.getTags().get(1).getNameTag());
        tvTag03.setText(b.getTags().get(2).getNameTag());
    }
}