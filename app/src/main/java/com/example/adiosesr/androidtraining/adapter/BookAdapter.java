package com.example.adiosesr.androidtraining.adapter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.adiosesr.androidtraining.BuildConfig;
import com.example.adiosesr.androidtraining.R;
import com.example.adiosesr.androidtraining.models.Book;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> mBooks;
    private BookClickListener mBookListener;


    public BookAdapter(BookClickListener mBookListener) {
        this.mBookListener = mBookListener;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        return new BookViewHolder(LayoutInflater.from(context).inflate(R.layout.book_list_row, parent, false),
                this.mBookListener);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        holder.bindView(mBooks.get(holder.getLayoutPosition()));
    }

    @Override
    public int getItemCount() {
        return mBooks == null ? 0 : mBooks.size();
    }

    public void updateBooks(List<Book> books) {
        mBooks = books;
        notifyDataSetChanged();
    }

    class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private BookClickListener mItemListener;
        @BindView(R.id.tvTitleBook)
        TextView tvTitle;
        @BindView(R.id.tvPrice)
        TextView tvPrice;
        @BindView(R.id.tvSimbol)
        TextView tvSimbol;
        @BindView(R.id.tvTag01)
        TextView tvTag01;
        @BindView(R.id.tvTag02)
        TextView tvTag02;
        Book mBook;
        @BindView(R.id.tvTag03)
        TextView tvTag03;
        @BindView(R.id.ivBook)
        ImageView ivBook;

        BookViewHolder(View itemView, BookClickListener bookClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            this.mItemListener = bookClickListener;
        }

        private void bindView(Book book) {
            mBook = book;

            tvTitle.setText(book.getName());
            tvPrice.setText(String.valueOf(book.getPrice()));
            tvTag01.setText(book.getTags().get(0).getNameTag());
            tvTag02.setText(book.getTags().get(1).getNameTag());
            tvTag03.setText(book.getTags().get(2).getNameTag());
            Glide.with(itemView).load(book.getUrl()).into(ivBook);

            if (BuildConfig.FLAVOR.equals("pago")) {
                tvSimbol.setVisibility(View.INVISIBLE);
                tvPrice.setVisibility(View.INVISIBLE);
            } else {
                tvSimbol.setVisibility(View.VISIBLE);
                tvPrice.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onClick(View v) {
            mItemListener.onClick(mBook);
        }
    }
}