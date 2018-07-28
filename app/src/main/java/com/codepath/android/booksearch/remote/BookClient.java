package com.codepath.android.booksearch.remote;

import com.codepath.android.booksearch.models.remote.BookQueryResponse;
import com.codepath.android.booksearch.remote.retrofitconfig.ApiCallback;
import com.codepath.android.booksearch.remote.retrofitconfig.ApiClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;

public class BookClient {

    BookService bookService = ApiClient.getRetrofit().create(BookService.class);
    private static Gson gson;

    public static Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder().setLenient().create();
        }

        return gson;
    }

    private List<Call> requestCalls = new ArrayList<>();

    public BookClient() {
    }
    // Method for accessing the search API

    public void getBooks(final String query, ApiCallback<BookQueryResponse> handler) {
        Call<BookQueryResponse> queryCall = bookService.queryForBooks(query);
        queryCall.enqueue(handler);


        requestCalls.add(queryCall);
    }

    public void dispose() {
        for (Call call : requestCalls) {
            if(!call.isCanceled())
                call.cancel();

        }
    }
}
