package com.coderqian.chapter4.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coderqian.R;

/**
 * @author qianliqing
 * @since 2018-10-23 下午2:37
 * mail: qianlq0824@gmail.com
 */
public class MyFragment extends Fragment {

    private String content;

    public MyFragment() {
        super();
    }

    @SuppressLint("ValidFragment")
    public MyFragment(String content) {
        this.content = content;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment, container, false);
        TextView txt_content = view.findViewById(R.id.txt_content);
        txt_content.setText(content);
        return view;
    }
}
