package com.example.adiosesr.androidtraining.gratis;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.adiosesr.androidtraining.R;
import com.example.adiosesr.androidtraining.util.Extras;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlaceHolderFragment extends Fragment {

    @BindView(R.id.section_label)
    TextView tvSectionLabel;

    @BindView(R.id.section_img)
    ImageView ivSectionImage;

    @BindView(R.id.btnBuyPager)
    Button btnBuyPager;

    @BindView(R.id.PagerDescription)
    TextView pagerDescription;

    int[] imageBack = new int[]{
            R.drawable.onlinebooks,
            R.drawable.online_booking,
            R.drawable.buy
    };

    public PlaceHolderFragment() {
    }

    public static PlaceHolderFragment newInstance(int sectionNumber) {

        Bundle args = new Bundle();

        PlaceHolderFragment fragment = new PlaceHolderFragment();
        args.putInt(Extras.EXTRAS_SECTION_NUMBER.getExtra(), sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        ButterKnife.bind(this, view);
        int position = getArguments().getInt(Extras.EXTRAS_SECTION_NUMBER.getExtra()) + 1;

        tvSectionLabel.setText(getString(R.string.section_format, position));
        if (position == 1) {
            pagerDescription.setText(R.string.descPag01);
        } else {
            if (position == 2) {
                pagerDescription.setText(R.string.descPag02);
            } else {
                pagerDescription.setText(R.string.descPag03);
            }
        }


        Glide.with(this).load(imageBack[getArguments().getInt(Extras.EXTRAS_SECTION_NUMBER.getExtra())]).into(ivSectionImage);
        if (position == 3) {
            btnBuyPager.setVisibility(View.VISIBLE);
        } else {
            btnBuyPager.setVisibility(View.GONE);
        }
        return view;
    }
}
