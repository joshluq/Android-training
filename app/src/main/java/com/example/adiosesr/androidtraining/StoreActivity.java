package com.example.adiosesr.androidtraining;


import android.annotation.SuppressLint;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.example.adiosesr.androidtraining.models.Book;
import com.example.adiosesr.androidtraining.util.Extras;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @BindView(R.id.Ratin01)
    RatingBar ratin01;
    @BindView(R.id.buttonSelector)
    Button btnSelector01;
    @BindView(R.id.buttonSelector2)
    Button btnSelector02;
    @BindView(R.id.tbToolbar)
    Toolbar tbToolBar;
    @BindView(R.id.btnCommentary)
    Button btnComentary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        ButterKnife.bind(this);
        book();
        ratin01.setRating(5);

        setSupportActionBar(tbToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @OnClick(R.id.buttonSelector)
    public void buttonSelector() {
        unSelectedButton();
        selectButton(btnSelector01);
    }

    @OnClick(R.id.buttonSelector2)
    public void buttonSelector02() {
        unSelectedButton();
        selectButton(btnSelector02);
    }

    public void unSelectedButton() {
        btnSelector01.setSelected(false);
        btnSelector02.setSelected(false);
    }

    public void selectButton(Button button) {
        button.setSelected(true);
    }

    @OnClick(R.id.btnCommentary)
    public void commentary() {
        myDialog();
    }

    private void myDialog() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(StoreActivity.this);
        @SuppressLint("InflateParams") View view = getLayoutInflater().inflate(R.layout.dialog_commentary, null);
        mBuilder.setView(view);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        Button btnOk = (Button) view.findViewById(R.id.btnComentaryOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }


    public void book() {

        Book b = (Book) getIntent().getSerializableExtra(Extras.EXTRAS_BOOKS.getExtra());
        Glide.with(this).load(b.getBanner()).thumbnail(0.1f).into(ivBanner);
        Glide.with(this).load(b.getUrl()).into(ivFront);
        tvNameBook.setText(b.getName());
        tvDescBook.setText(String.format(getString(R.string.labelDate), b.getPubliDate()));
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