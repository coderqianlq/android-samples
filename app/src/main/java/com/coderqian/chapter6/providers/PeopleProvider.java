package com.coderqian.chapter6.providers;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * @author qianliqing
 * @since 2018-10-30 下午9:14
 * mail: qianlq0824@gmail.com
 */
public class PeopleProvider extends ContentProvider {
    private static final String DB_NAME = "people.db";
    private static final String DB_TABLE = "peopleinfo";
    private static final int DB_VERSION = 1;

    private SQLiteDatabase db;
    private DBOpenHelper helper;

    private static final int MULTIPLE_PEOPLE = 1;
    private static final int SINGLE_PEOPLE = 2;

    private static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(People.AUTHORITY, People.PATH_MULTIPLE, MULTIPLE_PEOPLE);
        uriMatcher.addURI(People.AUTHORITY, People.PATH_SINGLE, SINGLE_PEOPLE);
    }

    @Override
    public boolean onCreate() {
        Context context = getContext();
        helper = new DBOpenHelper(context, DB_NAME, null, DB_VERSION);
        db = helper.getWritableDatabase();
        if (db == null){
            return false;}
        else
            return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(DB_TABLE);
        switch (uriMatcher.match(uri)) {
            case SINGLE_PEOPLE:
                qb.appendWhere(People.KEY_ID + "=" + uri.getPathSegments().get(1));
                break;
            default:
                break;
        }
        Cursor cursor = qb.query(db, strings, s, strings1, null, null, s1);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);


        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case MULTIPLE_PEOPLE:
                return People.MIME_TYPE_MULTIPLE;
            case SINGLE_PEOPLE:
                return People.MIME_TYPE_SINGLE;
            default:
                throw new IllegalArgumentException("Unknown uri:" + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        long id = db.insert(DB_TABLE, null, contentValues);
        if (id > 0) {
            Uri newUri = ContentUris.withAppendedId(People.CONTENT_URI, id);
            getContext().getContentResolver().notifyChange(newUri, null);
            return newUri;
        }
        throw new SQLException("Failed to insert row into" + uri);
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case MULTIPLE_PEOPLE:
                count = db.delete(DB_TABLE, s, strings);
                break;
            case SINGLE_PEOPLE:
                String segment = uri.getPathSegments().get(1);
                count = db.delete(DB_TABLE, People.KEY_ID + "=" + segment, strings);
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI" + uri);

        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        int count;
        switch (uriMatcher.match(uri)) {
            case MULTIPLE_PEOPLE:
                count = db.update(DB_TABLE, contentValues, s, strings);
                break;
            case SINGLE_PEOPLE:
                String segment = uri.getPathSegments().get(1);
                count = db.update(DB_TABLE, contentValues, People.KEY_ID + "=" + segment, strings);
                break;
            default:
                throw new IllegalArgumentException("Unknown uri:" + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}
