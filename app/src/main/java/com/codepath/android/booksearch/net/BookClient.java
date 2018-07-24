package com.codepath.android.booksearch.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestHandle;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class BookClient {

    private static Gson gson;

    public static Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder().setLenient().create();
        }

        return gson;
    }

    private AsyncHttpClient client;
    private List<RequestHandle> requestHandles = new ArrayList<>();

    public BookClient() {
        this.client = new AsyncHttpClient();
    }
    // Method for accessing the search API

    public void getBooks(final String query, ApiCallback handler) {
        try {
            String url = HttpUtils.getRelativeUrl(EndPoints.PATH_QUERY_BOOKS);
            RequestHandle requestHandle = client.get(url + URLEncoder.encode(query, "utf-8"), handler);
            requestHandles.add(requestHandle);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void dispose() {
        for (RequestHandle requestHandle : requestHandles) {
            if (!requestHandle.isCancelled() && !requestHandle.isFinished())
                requestHandle.cancel(true);
        }
    }
}
