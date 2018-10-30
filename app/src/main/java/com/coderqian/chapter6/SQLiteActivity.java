package com.coderqian.chapter6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.coderqian.R;
import com.coderqian.chapter6.entity.People;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianliqing
 * @since 2018-10-30 下午3:32
 * mail: qianlq0824@gmail.com
 */
public class SQLiteActivity extends AppCompatActivity implements Button.OnClickListener {

    private SQLiteDatabase db;
    private String DB_TABLE;

    private EditText nameEditText;
    private EditText ageEditText;
    private EditText heightEditText;

    private Button addButton;
    private Button showButton;
    private Button clearButton;
    private Button deleteButton;
    private Button IDdeleteButton;
    private Button IDsearchButton;
    private Button IDupdateButton;

    private EditText idEditText;
    private TextView largeTexView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        db = SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString() + "/my.db3", null);
        DB_TABLE = "people";

        nameEditText = (EditText) findViewById(R.id.name_edtTxt);
        ageEditText = (EditText) findViewById(R.id.age_edtTxt);
        heightEditText = (EditText) findViewById(R.id.height_edtTxt);
        addButton = (Button) findViewById(R.id.add_btn);
        showButton = (Button) findViewById(R.id.show_btn);
        clearButton = (Button) findViewById(R.id.clear_btn);
        deleteButton = (Button) findViewById(R.id.delete_btn);

        IDdeleteButton = (Button) findViewById(R.id.IDdelete_btn);
        IDsearchButton = (Button) findViewById(R.id.IDsearch_btn);
        IDupdateButton = (Button) findViewById(R.id.IDupdate_btn);

        addButton.setOnClickListener(this);
        showButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
        IDdeleteButton.setOnClickListener(this);
        IDsearchButton.setOnClickListener(this);
        IDupdateButton.setOnClickListener(this);

        idEditText = (EditText) findViewById(R.id.id_edtTxt);
        largeTexView = (TextView) findViewById(R.id.large_tv);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (db != null && db.isOpen())
            db.close();
    }

    @Override
    public void onClick(View view) {
        People people;
        switch (view.getId()) {
            case R.id.add_btn:
                people = new People(nameEditText.getText().toString(), Integer.parseInt(ageEditText.getText().toString()),
                        Double.parseDouble(heightEditText.getText().toString()));
                insert(people);
                break;
            case R.id.show_btn:
                show();
                break;
            case R.id.delete_btn:
                deleteAll();
                break;
            case R.id.clear_btn:
                largeTexView.setText(null);
                break;
            case R.id.IDdelete_btn:
                deleteById(Integer.parseInt(idEditText.getText().toString()));
                break;
            case R.id.IDsearch_btn:
                showById(Integer.parseInt(idEditText.getText().toString()));
                break;
            case R.id.IDupdate_btn:
                people = new People(nameEditText.getText().toString(), Integer.parseInt(ageEditText.getText().toString()),
                        Double.parseDouble(heightEditText.getText().toString()));
                update(Integer.parseInt(idEditText.getText().toString()), people);
                break;
        }
    }

    private long insert(People people) {
        ContentValues newValues = new ContentValues();

        newValues.put("name", people.Name);
        newValues.put("age", people.Age);
        newValues.put("height", people.Height);
        db.execSQL("create table if not exists " + DB_TABLE + " (ID integer " +
                " primary key autoincrement, " +
                " name varchar(20)," +
                " age integer," +
                " height double)");
        return db.insert(DB_TABLE, null, newValues);
    }

    private void show() {
        Cursor cursor = db.rawQuery("select * from " + DB_TABLE, null);
        List<People> peoples = ConvertToPeople(cursor);
        if (peoples != null) {
            for (int i = 0; i < peoples.size(); i++) {
                largeTexView.append(peoples.get(i).toString() + "\n");
            }
        }
        cursor.close();
    }

    public void showById(long id) {
        if (!idEditText.getText().toString().equals("")) {
            id = Integer.parseInt(idEditText.getText().toString());
            Cursor cursor = db.query(DB_TABLE, new String[]{"ID",
                    "name", "age", "height"}, " ID" + "=" + id, null, null, null, null);
            List<People> peopleList = ConvertToPeople(cursor);
            // 清楚显示的数据
            largeTexView.setText(null);
            if (peopleList != null) {
                for (int i = 0; i < peopleList.size(); i++) {
                    largeTexView.append(peopleList.get(i).toString() + "\n");
                }
            }
            cursor.close();
        }
    }

    private static List<People> ConvertToPeople(Cursor cursor) {
        List<People> peopleList = new ArrayList<>();
        while (cursor.moveToNext()) {
            People people = new People(cursor.getString(cursor.getColumnIndex("name")), Integer.parseInt(cursor.getString(cursor.getColumnIndex("age"))), Double.parseDouble(cursor.getString(cursor.getColumnIndex("height"))));
            peopleList.add(people);
        }
        return peopleList;
    }

    private long update(long id, People people) {
        ContentValues updateValues = new ContentValues();
        updateValues.put("name", people.Name);
        updateValues.put("age", people.Age);
        updateValues.put("height", people.Height);
        return db.update(DB_TABLE, updateValues, "ID = " + id, null);
    }


    private long deleteById(long id) {
        return db.delete(DB_TABLE, "ID" + "=" + id, null);
    }

    private long deleteAll() {
        return db.delete(DB_TABLE, null, null);
    }
}
