package com.codepath.android.booksearch.databinding;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.ImageView;

import com.codepath.android.booksearch.GlideApp;

public class DataAdapter {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView iv, String url) {
        GlideApp.with(iv.getContext()).load(Uri.parse(url)).into(iv);
    }
}
