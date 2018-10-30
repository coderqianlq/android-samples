package com.coderqian.chapter6;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.coderqian.R;
import com.coderqian.chapter6.providers.People;

/**
 * @author qianliqing
 * @since 2018-10-30 下午8:51
 * mail: qianlq0824@gmail.com
 */
public class ResolverActivity extends AppCompatActivity {

    private Button add, delete, view, clear, id_delete, id_query, id_update;
    private EditText name, age, height, wid;
    private TextView query_num, query_all;
    private ContentResolver resolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resolver);
        add = (Button) findViewById(R.id.add);
        delete = (Button) findViewById(R.id.delete);
        view = (Button) findViewById(R.id.view);
        clear = (Button) findViewById(R.id.clear);
        id_delete = (Button) findViewById(R.id.id_delete);
        id_query = (Button) findViewById(R.id.id_query);
        id_update = (Button) findViewById(R.id.id_update);
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        height = (EditText) findViewById(R.id.height);
        wid = (EditText) findViewById(R.id.wid);
        query_num = (TextView) findViewById(R.id.value_num);
        query_all = (TextView) findViewById(R.id.value_query);

        resolver = this.getContentResolver();
        add.setOnClickListener(addButtonListener);
        delete.setOnClickListener(deleteAllButtonListener);
        view.setOnClickListener(queryAllButtonListener);
        clear.setOnClickListener(clearButtonListener);

        id_update.setOnClickListener(updateButtonListener);
        id_query.setOnClickListener(queryButtonListener);
        id_delete.setOnClickListener(deleteButtonListener);


    }

    View.OnClickListener addButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ContentValues values = new ContentValues();
            values.put(People.KEY_NAME, name.getText().toString());
            values.put(People.KEY_AGE, Integer.parseInt(age.getText().toString()));
            values.put(People.KEY_HEIGHT, Float.parseFloat(height.getText().toString()));

            Uri newUri = resolver.insert(People.CONTENT_URI, values);
            query_num.setText("添加成功,URI:" + newUri);
        }
    };
    View.OnClickListener queryAllButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Cursor cursor = resolver.query(People.CONTENT_URI, new String[]{People.KEY_ID, People.KEY_NAME, People.KEY_AGE, People.KEY_HEIGHT}, null, null, null);
            if (cursor == null) {
                query_num.setText("数据库中没有数据");
                return;
            }
            query_num.setText("数据库:" + String.valueOf(cursor.getCount()) + "条记录");

            String msg = "";
            if (cursor.moveToFirst()) {
                do {
                    msg += "ID:" + cursor.getInt(cursor.getColumnIndex(People.KEY_ID)) + ",";
                    msg += "姓名:" + cursor.getString(cursor.getColumnIndex(People.KEY_NAME)) + ",";
                    msg += "年龄:" + cursor.getInt(cursor.getColumnIndex(People.KEY_AGE)) + ",";
                    msg += "身高:" + cursor.getFloat(cursor.getColumnIndex(People.KEY_HEIGHT)) + "\n";
                } while (cursor.moveToNext());
            }
            query_all.setText(msg);
        }
    };
    View.OnClickListener clearButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            query_all.setText("");
        }
    };
    View.OnClickListener deleteAllButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            resolver.delete(People.CONTENT_URI, null, null);
            String msg = "数据全部删除";
            query_num.setText(msg);
            query_all.setText("");
        }
    };

    View.OnClickListener queryButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Uri uri = Uri.parse(People.CONTENT_URI_STRING + "/" + wid.getText().toString());
            Cursor cursor = resolver.query(uri, new String[]{People.KEY_ID, People.KEY_NAME, People.KEY_AGE, People.KEY_HEIGHT}, null, null, null);
            if (cursor == null) {
                query_num.setText("数据库中没有数据");
                return;
            }
            String msg = "";
            if (cursor.moveToFirst()) {
                msg += "ID:" + cursor.getInt(cursor.getColumnIndex(People.KEY_ID)) + ",";
                msg += "姓名:" + cursor.getString(cursor.getColumnIndex(People.KEY_NAME)) + ",";
                msg += "年龄:" + cursor.getInt(cursor.getColumnIndex(People.KEY_AGE)) + ",";
                msg += "身高:" + cursor.getFloat(cursor.getColumnIndex(People.KEY_HEIGHT)) + "\n";
            }
            query_num.setText("数据库:");
            query_all.setText(msg);

        }
    };

    View.OnClickListener deleteButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Uri uri = Uri.parse(People.CONTENT_URI_STRING + "/" + wid.getText().toString());
            int result = resolver.delete(uri, null, null);
            String msg = "删除ID为" + wid.getText().toString() + "的数据:" + (result > 0 ? "成功" : "失败");
            query_num.setText(msg);
        }
    };

    View.OnClickListener updateButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ContentValues values = new ContentValues();
            values.put(People.KEY_NAME, name.getText().toString());
            values.put(People.KEY_AGE, Integer.parseInt(age.getText().toString()));
            values.put(People.KEY_HEIGHT, Float.parseFloat(height.getText().toString()));

            Uri uri = Uri.parse(People.CONTENT_URI_STRING + "/" + wid.getText().toString());
            int result = resolver.update(uri, values, null, null);

            String msg = "更新ID为" + wid.getText().toString() + "的数据:" + (result > 0 ? "成功" : "失败");
            query_num.setText(msg);
        }
    };

}
