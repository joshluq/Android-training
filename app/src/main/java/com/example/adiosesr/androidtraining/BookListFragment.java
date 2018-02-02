package com.example.adiosesr.androidtraining;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.adiosesr.androidtraining.models.Book;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */

public class BookListFragment extends Fragment {

    @BindView(R.id.tv1)
    TextView tv1;

    @BindView(R.id.tv2)
    TextView tv2;

    @BindView(R.id.tv3)
    TextView tv3;

    @BindView(R.id.tv4)
    TextView tv4;

    @BindView(R.id.tv5)
    TextView tv5;

    public BookListFragment()
    {
        //empty constructor
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        listBooks();
    }

    @SuppressWarnings("unchecked cast")
    private void listBooks() {
        List<Book>listaBook = (List<Book>) getArguments().getSerializable("listBook");
        if(listaBook !=null) {
            tv1.setText(String.format("1.%s", String.valueOf(listaBook.get(0).getName())));
            tv2.setText(String.format("2.%s", String.valueOf(listaBook.get(1).getId())));
            tv3.setText(String.format("3.%s", String.valueOf(listaBook.get(2).getPages())));
            tv4.setText(String.format("4.%s", String.valueOf(listaBook.get(3).getName())));
            tv5.setText(String.format("5.%s", String.valueOf(listaBook.get(4).getPages())));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_list, container, false);
    }
}