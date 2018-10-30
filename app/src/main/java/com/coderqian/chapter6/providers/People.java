package com.coderqian.chapter6.providers;

import android.net.Uri;

/**
 * @author qianliqing
 * @since 2018-10-30 下午9:15
 * mail: qianlq0824@gmail.com
 */
public class People {

    public static final String MIME_DIR_PREFIX = "vnd.android.cursor.dir";
    public static final String MIME_ITEM_PREFIX = "vnd.android.cursor.item";
    public static final String MIME_ITEM = "vnd.zju.people";
    public static final String MIME_TYPE_SINGLE = MIME_ITEM_PREFIX + "/" + MIME_ITEM;
    public static final String MIME_TYPE_MULTIPLE = MIME_DIR_PREFIX + "/" + MIME_ITEM;

    public static final String AUTHORITY = "com.coderqian.chapter6.providers.PeopleProvider";
    public static final String PATH_SINGLE = "people/#";
    public static final String PATH_MULTIPLE = "people";
    public static final String CONTENT_URI_STRING = "content://" + AUTHORITY + "/" + PATH_MULTIPLE;
    public static final Uri CONTENT_URI = Uri.parse(CONTENT_URI_STRING);

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_AGE = "age";
    public static final String KEY_HEIGHT = "height";
}
