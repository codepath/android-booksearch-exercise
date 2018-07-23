package com.codepath.android.booksearch.net;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class BookClient {
    private AsyncHttpClient client;

    public BookClient() {
        this.client = new AsyncHttpClient();
    }

    // Method for accessing the search API
    public void getBooks(final String query, JsonHttpResponseHandler handler) {
        try {
            String url = HttpUtils.getRelativeUrl(EndPoints.PATH_QUERY_BOOKS);
            client.get(url + URLEncoder.encode(query, "utf-8"), handler);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
