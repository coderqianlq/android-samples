package com.coderqian.chapter2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.coderqian.R;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qianliqing
 * @since 2018-09-30 下午6:45
 * mail: qianlq0824@gmail.com
 */
public class Linear3Activity extends AppCompatActivity {

    private String[] names = {"钱立清", "刘尚楠", "许知宇", "陈振宇"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_3);
    }

    public void simple(View source) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("普通对话框")
                .setIcon(R.drawable.qianliqing)
                .setMessage("钱立清\nJava爬虫技术小白");

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        })
                .create()
                .show();
    }

    public void simpleList(final View source) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("简单列表项对话框")
                .setIcon(R.drawable.qianliqing)
                .setItems(names, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Toast.makeText(source.getContext(), names[i], Toast.LENGTH_LONG).show();
                    }
                });

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        })
                .create()
                .show();
    }

    public void singleChoice(final View source) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("单选列表项对话框")
                .setIcon(R.drawable.qianliqing)
                .setSingleChoiceItems(names, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Toast.makeText(source.getContext(), names[i], Toast.LENGTH_LONG).show();
                    }
                });

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        })
                .create()
                .show();
    }


    public void multiChoice(final View source) {
        final Set<String> set = new HashSet<>();
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("多选列表项对话框")
                .setIcon(R.drawable.qianliqing)
                .setMultiChoiceItems(names, new boolean[]{false, false, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i, boolean b) {
                        if (b) set.add(names[i]);
                        else set.remove(names[i]);
                        Toast.makeText(source.getContext(), set.toString(), Toast.LENGTH_LONG).show();
                    }
                });

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        })
                .create()
                .show();
    }
}
