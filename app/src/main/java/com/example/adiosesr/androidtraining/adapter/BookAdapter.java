package com.example.adiosesr.androidtraining.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        @BindView(R.id.tvDescBook)
        TextView tvDescription;
        Book mBook;

        BookViewHolder(View itemView, BookClickListener bookClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            this.mItemListener = bookClickListener;
        }

        private void bindView(Book book) {
            mBook = book;
            tvTitle.setText(book.getName());
            tvDescription.setText(book.getDescription());
        }

        @Override
        public void onClick(View v) {
            mItemListener.onClick(mBook);
        }
    }
}