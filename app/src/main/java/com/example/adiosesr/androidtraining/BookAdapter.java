package com.example.adiosesr.androidtraining;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.adiosesr.androidtraining.models.Book;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private List<Book> bookList;

    public BookAdapter(List<Book> bookList)
    {
        this.bookList = bookList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String title = bookList.get(position).getName();
        String description = bookList.get(position).getDescription();
        String image = bookList.get(position).getBanner();

        holder.tvTitle.setText(title);
        holder.tvDescription.setText(description);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView)itemView.findViewById(R.id.tvTitleBook);
            tvDescription =(TextView)itemView.findViewById(R.id.tvDescBook);
        }
    }
}
