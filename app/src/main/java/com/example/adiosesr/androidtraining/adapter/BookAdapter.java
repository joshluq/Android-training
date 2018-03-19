package com.example.adiosesr.androidtraining.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
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
import com.example.adiosesr.androidtraining.models.BookRow;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int SECTION_VIEW = 0;
    private static final int CONTENT_VIEW = 1;

    private Context context;

    private List<BookRow> listBookRow;


    private BookClickListener mBookListener;

    public BookAdapter(BookClickListener mBookListener) {
        this.mBookListener = mBookListener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        if (viewType == SECTION_VIEW) {
            return new SectionViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content, parent, false));
        } else {
            return new BookViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_row, parent, false), this.mBookListener);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BookViewHolder) {
            ((BookViewHolder) holder).bindView(listBookRow.get(position).getBook());
        } else {
            ((SectionViewHolder) holder).bindView(listBookRow.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        return listBookRow == null ? 0 : listBookRow.size();
    }

    @Override
    public int getItemViewType(int position) {
        return listBookRow.get(position).isHeader() ? SECTION_VIEW : CONTENT_VIEW;
    }

    public void updateBooks(List<BookRow> bookRows) {
        listBookRow = bookRows;
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

    class SectionViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cvLanguage)
        CardView cvLanguage;
        @BindView(R.id.tvTitle)
        TextView tvTitle;


         SectionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bindView(String name) {
            tvTitle.setText(name);
            if(name.equals("Español"))
            {
                cvLanguage.setBackgroundColor(ContextCompat.getColor(context,R.color.colorPagerOne));
            }
            else {
                cvLanguage.setBackgroundColor(ContextCompat.getColor(context,R.color.colorPagerTwo));
            }
        }
    }
}