package com.codepath.android.booksearch.remote.retrofitconfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class ApiCallback<T> implements Callback<T> {
    public abstract void onSuccess(T response);

    public abstract void onFailure(int code, String response);

    public abstract void onFailure(Throwable t);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            T body = response.body();
            onSuccess(body);
        } else {
            try {
                int code = response.code();
                String errorBody = null;

                if (response.errorBody() != null)
                    errorBody = response.errorBody().string();

                onFailure(code, errorBody);
            } catch (Exception e) {
                onFailure(e);
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onFailure(t);
    }
}
