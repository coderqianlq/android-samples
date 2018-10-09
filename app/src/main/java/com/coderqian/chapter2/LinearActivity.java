package com.coderqian.chapter2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.coderqian.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qianliqing
 * @since 2018-09-30 上午11:27
 * mail: qianlq0824@gmail.com
 */
public class LinearActivity extends AppCompatActivity {

    private String[] names = {"钱立清", "刘尚楠", "许知宇", "陈振宇"};

    private String[] descs = {"Java爬虫技术小白", "区块链应用开发", "前端开发第一人", "计算机视觉大佬"};

    private int[] imageIds = new int[]{R.drawable.qianliqing, R.drawable.liushangnan, R.drawable.xuzhiyu, R.drawable.chenzhenyu};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        List<Map<String, Object>> listItems = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("header", imageIds[i]);
            listItem.put("name", names[i]);
            listItem.put("desc", descs[i]);
            listItems.add(listItem);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.simple_item,
                new String[]{"name", "header", "desc"}, new int[]{R.id.name, R.id.header, R.id.desc});
        ListView list = findViewById(R.id.myList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext())
                        .setTitle("学生介绍")
                        .setIcon(imageIds[i])
                        .setMessage(names[i] + "\n" + descs[i]);

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                })
                        .create()
                        .show();
            }
        });
    }
}
