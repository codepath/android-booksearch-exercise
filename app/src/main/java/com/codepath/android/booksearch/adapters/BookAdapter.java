package com.codepath.android.booksearch.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.codepath.android.booksearch.R;
import com.codepath.android.booksearch.databinding.BookAdapterBinding;
import com.codepath.android.booksearch.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<Book> mBooks;

    public BookAdapter(ArrayList<Book> aBooks) {
        mBooks = aBooks;
    }

    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        BookAdapterBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_book, parent, false);
        return new BookAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BookAdapter.ViewHolder viewHolder, int position) {
        Book book = mBooks.get(position);
        viewHolder.setData(book);
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private BookAdapterBinding binding;

        public ViewHolder(BookAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setData(Book book) {
            binding.setViewModel(book);
            binding.executePendingBindings();
        }
    }
}
