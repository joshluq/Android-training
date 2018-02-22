package com.example.adiosesr.androidtraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.example.adiosesr.androidtraining.models.Book;
import com.example.adiosesr.androidtraining.util.Extras;

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
    @BindView(R.id.tvIntroductionBook)
    TextView tvIntroduction;
    @BindView(R.id.tvPage)
    TextView tvPages;
    @BindView(R.id.tvFirstName)
    TextView tvFirstName;
    @BindView(R.id.tvLastName)
    TextView tvLastName;
    @BindView(R.id.tvLanguage)
    TextView tvLanguage;
    @BindView(R.id.tvEditor)
    TextView tvEditor;
    @BindView(R.id.tvIsbn)
    TextView tvIsbn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        ButterKnife.bind(this);
        book();
    }
    public void book() {

        Book b = (Book) getIntent().getSerializableExtra(String.valueOf(Extras.EXTRAS_BOOKS));
        Glide.with(this).load(b.getBanner()).into(ivBanner);
        Glide.with(this).load(b.getUrl()).into(ivFront);
        tvNameBook.setText(b.getName());
        tvDescBook.setText(String.format(getString(R.string.labelDate),b.getPubliDate()));
        tvLanguage.setText(b.getCountryEd());
        tvEditor.setText(b.getEditor());
        tvPages.setText(String.format(getString(R.string.labelPage), b.getPages()));
        tvTag01.setText(b.getTags().get(0).getNameTag());
        tvTag02.setText(b.getTags().get(1).getNameTag());
        tvTag03.setText(b.getTags().get(2).getNameTag());
        tvIntroduction.setText(b.getDescription());
        tvIsbn.setText(b.getIsbn());
        tvFirstName.setText(String.format(getString(R.string.labelFistName), b.getAuthor().getFirstName()));
        tvLastName.setText(String.format(getString(R.string.labelLastName), b.getAuthor().getLastName()));
    }
}