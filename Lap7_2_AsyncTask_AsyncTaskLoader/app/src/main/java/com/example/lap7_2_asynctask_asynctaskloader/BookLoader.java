package com.example.lap7_2_asynctask_asynctaskloader;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class BookLoader extends AsyncTaskLoader<String> {
    private String mQueryString;

    public BookLoader(Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }

    public BookLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetworkUtils.getBookInfo(mQueryString);
    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
        // super.onStartLoading();
    }

    @Override
    public void forceLoad() {
        super.forceLoad();
    }
}