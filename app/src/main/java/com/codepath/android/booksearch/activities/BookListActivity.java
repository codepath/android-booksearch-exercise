package com.codepath.android.booksearch.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.codepath.android.booksearch.R;
import com.codepath.android.booksearch.adapters.BookAdapter;
import com.codepath.android.booksearch.databinding.BookListingBinding;
import com.codepath.android.booksearch.models.Book;
import com.codepath.android.booksearch.models.converters.BookConverter;
import com.codepath.android.booksearch.models.remote.BookQueryResponse;
import com.codepath.android.booksearch.remote.retrofitconfig.ApiCallback;
import com.codepath.android.booksearch.remote.BookClient;

import java.util.ArrayList;
import java.util.List;


public class BookListActivity extends AppCompatActivity {
    private BookAdapter bookAdapter;
    private BookClient client;
    private ArrayList<Book> abooks;

    private BookListingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_book_list);

        abooks = new ArrayList<>();

        bookAdapter = new BookAdapter(abooks);
        binding.rvBooks.setAdapter(bookAdapter);
        binding.rvBooks.setLayoutManager(new LinearLayoutManager(this));

        client = new BookClient();

        // Fetch the data remotely
        fetchBooks("Oscar Wilde");
    }

    private void fetchBooks(String query) {
        client.getBooks(query, new ApiCallback<BookQueryResponse>() {
            @Override
            public void onSuccess(BookQueryResponse response) {
                List<Book> books = BookConverter.getBooks(response);
                abooks.clear();

                // Load model objects into the adapter
                abooks.addAll(books);
                bookAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int code, String response) {
                // todo: handle this
            }

            @Override
            public void onFailure(Throwable t) {
                //todo: show internet not available
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        client.dispose();
    }
}
