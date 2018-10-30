package com.coderqian.chapter6.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * @author qianliqing
 * @since 2018-10-30 下午8:42
 * mail: qianlq0824@gmail.com
 */
public class FirstProvider extends ContentProvider {

    @Override
    public boolean onCreate() {
        Toast.makeText(this.getContext(), "Oh hi, CoderQian", Toast.LENGTH_LONG).show();
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String where, @Nullable String[] whereArgs, @Nullable String sortOrder) {
        Toast.makeText(this.getContext(), where, Toast.LENGTH_LONG).show();
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        Toast.makeText(this.getContext(), "Oh hi, CoderQian", Toast.LENGTH_LONG).show();
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
