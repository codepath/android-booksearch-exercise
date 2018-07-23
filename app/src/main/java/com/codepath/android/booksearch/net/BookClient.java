package com.codepath.android.booksearch.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class BookClient {
    private AsyncHttpClient client;

    private static Gson gson;

    public static Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder().setLenient().create();
        }

        return gson;
    }

    public BookClient() {
        this.client = new AsyncHttpClient();
    }

    // Method for accessing the search API
    public void getBooks(final String query, ApiCallback handler) {
        try {
            String url = HttpUtils.getRelativeUrl(EndPoints.PATH_QUERY_BOOKS);
            client.get(url + URLEncoder.encode(query, "utf-8"), handler);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
