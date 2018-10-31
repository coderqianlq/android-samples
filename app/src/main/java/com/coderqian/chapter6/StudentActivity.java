package com.coderqian.chapter6;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.coderqian.R;
import com.coderqian.chapter6.providers.StudentProvider;

/**
 * @author qianliqing
 * @since 2018-10-31 上午9:00
 * mail: qianlq0824@gmail.com
 */
public class StudentActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onClickAddName(View view) {
        // Add a new student record
        ContentValues values = new ContentValues();

        values.put(StudentProvider.NAME,
                ((EditText) findViewById(R.id.editText2)).getText().toString());

        values.put(StudentProvider.GRADE,
                ((EditText) findViewById(R.id.editText3)).getText().toString());

        Uri uri = getContentResolver().insert(
                StudentProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),
                uri.toString(), Toast.LENGTH_LONG).show();
    }

    public void onClickRetrieveStudents(View view) {

        Cursor c = managedQuery(StudentProvider.CONTENT_URI, null, null, null, "name");

        if (c.moveToFirst()) {
            do {
                Toast.makeText(this,
                        c.getString(c.getColumnIndex(StudentProvider._ID)) +
                                ", " + c.getString(c.getColumnIndex(StudentProvider.NAME)) +
                                ", " + c.getString(c.getColumnIndex(StudentProvider.GRADE)),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
    }
}
