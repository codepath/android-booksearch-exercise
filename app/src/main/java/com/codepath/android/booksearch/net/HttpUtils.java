package com.codepath.android.booksearch.net;

import com.codepath.android.booksearch.BuildConfig;

public class HttpUtils {

    private static final String API_BASE_URL = BuildConfig.BASE_URL;

    public static String getRelativeUrl(String relativeUrl){
        return API_BASE_URL + relativeUrl;
    }
}
