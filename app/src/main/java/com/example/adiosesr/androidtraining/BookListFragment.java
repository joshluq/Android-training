package com.example.adiosesr.androidtraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.adiosesr.androidtraining.adapter.BookAdapter;
import com.example.adiosesr.androidtraining.adapter.BookClickListener;
import com.example.adiosesr.androidtraining.models.Book;
import com.example.adiosesr.androidtraining.models.BookRow;
import com.example.adiosesr.androidtraining.network.BookResponse;
import com.example.adiosesr.androidtraining.network.Service;
import com.example.adiosesr.androidtraining.util.ApiUtil;
import com.example.adiosesr.androidtraining.util.Extras;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookListFragment extends Fragment {

    private static final String LOGTAG = "LogsAndroid";

    @BindView(R.id.rvBook)
    RecyclerView rvBook;

    BookAdapter mAdapater;
    Service mService;

    List<Book> mBookList;

    public BookListFragment() {
        //empty constructor
    }

    @Override
    public void onViewCreated(@NonNull final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mService = ApiUtil.getService();
        mAdapater = new BookAdapter(new BookClickListener() {
            @Override
            public void onClick(Book book) {
                if (BuildConfig.FLAVOR.equals("gratis")) {
                    Toast.makeText(getActivity(), "Por favor Comprar el App", Toast.LENGTH_LONG).show();
                    Log.d(LOGTAG, "Seleccionado");
                } else {
                    Intent intent = new Intent(getActivity(), StoreActivity.class);
                    intent.putExtra(Extras.EXTRAS_BOOKS.getExtra(), book);
                    startActivity(intent);
                }
            }
        });
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this.getContext());
        rvBook.setLayoutManager(layout);
        rvBook.setAdapter(mAdapater);
        rvBook.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this.getContext(),
                        DividerItemDecoration.VERTICAL);
        rvBook.addItemDecoration(itemDecoration);

        fillList();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_book_list, container, false);
    }


    private void fillList() {
        mService.getBooks().enqueue(new Callback<BookResponse>() {
            @Override
            public void onResponse(@NonNull Call<BookResponse> call, @NonNull Response<BookResponse> response) {
                if (response.isSuccessful()) {

                    mBookList = response.body().getBody().getBooks();
                    List<BookRow> filteredBooks = new ArrayList<>();

                    filteredBooks.addAll(bookRowListLanguage("Español"));
                    filteredBooks.addAll(bookRowListLanguage("Ingles"));

                    mAdapater.updateBooks(filteredBooks);

                    Log.d(LOGTAG, "Loaded ");
                } else {
                    Log.d(LOGTAG, " Problem ");
                }
            }

            @Override
            public void onFailure(@NonNull Call<BookResponse> call, @NonNull Throwable t) {
                Log.d(LOGTAG, "Error loading");
            }
        });
    }

    List<BookRow> bookRowListLanguage(String language)
    {
        List<BookRow> lisLanguage = transform(filterBookLanguage(language));

        BookRow languageHeader = new BookRow();
        languageHeader.setHeader(true);
        languageHeader.setName(language);

        lisLanguage.add(0,languageHeader);

       return lisLanguage;
    }

    public List<Book> filterBookLanguage(String key) {
        List<Book> filterBook = new ArrayList<>();

        for (Book book : mBookList) {
            if (book.getCountryEd().equals(key)) {
                filterBook.add(book);
            }
        }
        return filterBook;
    }

    private BookRow transform(Book mBook) {
        BookRow mBookRow = new BookRow();
        mBookRow.setBook(mBook);

        return mBookRow;
    }

    private List<BookRow> transform(List<Book> listBook) {
        List<BookRow> mListBookRow = new ArrayList<>();

        if (listBook != null) {
            for (Book mBook : listBook) {
                mListBookRow.add(transform(mBook));
            }
        }
        return mListBookRow;
    }
}