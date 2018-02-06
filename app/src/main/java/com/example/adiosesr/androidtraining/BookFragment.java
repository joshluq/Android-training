package com.example.adiosesr.androidtraining;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adiosesr.androidtraining.models.Book;
import com.example.adiosesr.androidtraining.util.Extras;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookFragment extends Fragment {

    @BindView(R.id.tvName)
    TextView tvName;

    @BindView(R.id.valorId)
    TextView valorId;

    @BindView(R.id.valorNameBook)
    TextView valorNameBook;

    @BindView(R.id.valorPage)
    TextView valorPage;

    @BindView(R.id.valorAutor)
    TextView valorAutor;

    public BookFragment() {
        //empty constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this,view);
        printBooks();
    }
    public void printBooks()
    {
        Book b = (Book)getArguments().getSerializable(Extras.EXTRAS_BOOKS.getExtras());

        if(b != null) {
            String nameShow = getArguments().getString(Extras.EXTRAS_DATANAME.getExtras());

            tvName.setText(nameShow);

            valorId.setText(String.valueOf(b.getId()));
            valorNameBook.setText(b.getName());
            valorPage.setText(String.valueOf(b.getPages()));
            valorAutor.setText(String.format("%s %s", b.getAutor().getFirstName(), b.getAutor().getLastName()));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_book, container, false);
    }

}
