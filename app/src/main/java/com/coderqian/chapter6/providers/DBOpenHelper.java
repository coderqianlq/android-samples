package com.coderqian.chapter6.providers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author qianliqing
 * @since 2018-10-30 下午9:18
 * mail: qianlq0824@gmail.com
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    final String DB_CREATE = "create table peopleinfo" +
            "(" + People.KEY_ID + " integer primary key autoincrement," +
            People.KEY_NAME + " text not null," + People.KEY_AGE + " integer,"
            + People.KEY_HEIGHT + " float);";

    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DB_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS peopleinfo");
        onCreate(sqLiteDatabase);
    }
}
