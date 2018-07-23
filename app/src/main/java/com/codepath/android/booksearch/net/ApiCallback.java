package com.codepath.android.booksearch.net;

import com.google.gson.Gson;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public abstract class ApiCallback<T> extends JsonHttpResponseHandler {

    private Class<T> clazz;

    public ApiCallback(Class<T> clazz) {
        this.clazz = clazz;
    }

    public abstract void onSuccess(T response);

    @Override
    public void onSuccess(int statusCode, Header[] headers, String responseString) {
        super.onSuccess(statusCode, headers, responseString);

        parseAndDeliverResponse(responseString);
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        super.onSuccess(statusCode, headers, response);
        parseAndDeliverResponse(response.toString());
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
        super.onSuccess(statusCode, headers, response);
        parseAndDeliverResponse(response.toString());
    }

    private void parseAndDeliverResponse(String responseString) {
        T response = BookClient.getGson().fromJson(responseString, clazz);
        onSuccess(response);
    }


}
