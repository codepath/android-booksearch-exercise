package com.codepath.android.booksearch.remote;

import com.codepath.android.booksearch.models.remote.BookQueryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookService {
    @GET(EndPoints.PATH_QUERY_BOOKS)
    Call<BookQueryResponse> queryForBooks(@Query("q") String queryParam);
}
