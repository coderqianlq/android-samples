package com.coderqian.chapter3;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * @author qianliqing
 * @since 2018-10-09 下午8:33
 * mail: qianlq0824@gmail.com
 */
public class List2Activity extends ListActivity {

    private String[] names = {"钱立清", "刘尚楠", "许知宇", "陈振宇"};

    private String[] descs = {"Java爬虫技术小白", "区块链应用开发", "前端开发第一人", "计算机视觉大佬"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int i, long id) {
        Toast.makeText(v.getContext(), names[i], Toast.LENGTH_LONG).show();
//        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext())
//                .setTitle("学生介绍")
//                .setMessage(names[position] + "\n" + descs[position]);
//
//        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int i) {
//
//            }
//        })
//                .create()
//                .show();
    }
}
