package com.example.adiosesr.androidtraining;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adiosesr.androidtraining.adapter.BookAdapter;
import com.example.adiosesr.androidtraining.adapter.BookClickListener;
import com.example.adiosesr.androidtraining.models.Book;
import com.example.adiosesr.androidtraining.network.BookResponse;
import com.example.adiosesr.androidtraining.network.Service;
import com.example.adiosesr.androidtraining.util.ApiUtil;

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

    public BookListFragment() {
        //empty constructor
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);


        mService = ApiUtil.getService();
        mAdapater = new BookAdapter(new BookClickListener() {
            @Override
            public void onClick(Book name) {
                //Empty
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_book_list, container, false);
    }

    @SuppressWarnings("unchecked cast")
    private void fillList() {
        mService.getBooks().enqueue(new Callback<BookResponse>() {
            @Override
            public void onResponse(Call<BookResponse> call, Response<BookResponse> response) {
                if (response.isSuccessful()) {
                    mAdapater.updateBooks(response.body().getBody().getBooks());
                    Log.d(LOGTAG, "Loaded ");
                } else {
                    Log.d(LOGTAG, " Problem ");
                }
            }

            @Override
            public void onFailure(Call<BookResponse> call, Throwable t) {
                Log.d(LOGTAG, "Error loading");
            }
        });

    }
}