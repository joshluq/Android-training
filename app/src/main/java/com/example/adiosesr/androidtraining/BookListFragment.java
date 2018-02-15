package com.example.adiosesr.androidtraining;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.adiosesr.androidtraining.models.Book;
import com.example.adiosesr.androidtraining.util.Extras;
import java.util.ArrayList;
import java.util.List;

public class BookListFragment extends Fragment {
   RecyclerView recycle;
   ArrayList<Book>bookList;

    public BookListFragment()
    {
        //empty constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_book_list, container, false);
        bookList = new ArrayList<>();
        recycle = view.findViewById(R.id.rvBook);
        recycle.setLayoutManager(new LinearLayoutManager(getContext()));

        fillList();

        BookAdapter adapter = new BookAdapter(bookList);
        recycle.setAdapter(adapter);

        return view;
    }
    @SuppressWarnings("unchecked cast")
    private void fillList() {
        List<Book>listaBook = (List<Book>) getArguments().getSerializable(Extras.EXTRAS_LISTBOOKS.getExtra());

        if (listaBook != null) {
            bookList.add(new Book(String.format("%s1", listaBook.get(0).getName()), listaBook.get(0).getDescription()));
            bookList.add(new Book(String.format("%s2", listaBook.get(1).getName()), listaBook.get(1).getDescription()));
            bookList.add(new Book(String.format("%s3", listaBook.get(2).getName()), listaBook.get(2).getDescription()));
            bookList.add(new Book(String.format("%s4", listaBook.get(3).getName()), listaBook.get(3).getDescription()));
            bookList.add(new Book(String.format("%s5", listaBook.get(4).getName()), listaBook.get(4).getDescription()));
            bookList.add(new Book(String.format("%s6", listaBook.get(5).getName()), listaBook.get(5).getDescription()));
            bookList.add(new Book(String.format("%s7", listaBook.get(6).getName()), listaBook.get(6).getDescription()));
            bookList.add(new Book(String.format("%s8", listaBook.get(7).getName()), listaBook.get(7).getDescription()));
            bookList.add(new Book(String.format("%s9", listaBook.get(8).getName()), listaBook.get(8).getDescription()));
        }
    }
}