package com.coderqian.chapter4;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.coderqian.R;

/**
 * @author qianliqing
 * @since 2018-10-23 下午2:43
 * mail: qianlq0824@gmail.com
 */
public class FragmentActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView channel;
    private TextView message;
    private TextView better;
    private TextView setting;
    private FrameLayout content;

    //Fragment Object
    private MyFragment fg1, fg2, fg3, fg4;
    private FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tab);
        fManager = getFragmentManager();
        bindViews();
        channel.performClick();   //模拟一次点击，既进去后选择第一项
    }

    //UI组件初始化与事件绑定
    private void bindViews() {
        channel = findViewById(R.id.channel);
        message = findViewById(R.id.message);
        better = findViewById(R.id.better);
        setting = findViewById(R.id.setting);
        content = findViewById(R.id.content);

        channel.setOnClickListener(this);
        message.setOnClickListener(this);
        better.setOnClickListener(this);
        setting.setOnClickListener(this);
    }

    //重置所有文本的选中状态
    private void setSelected() {
        channel.setSelected(false);
        message.setSelected(false);
        better.setSelected(false);
        setting.setSelected(false);
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (fg1 != null) fragmentTransaction.hide(fg1);
        if (fg2 != null) fragmentTransaction.hide(fg2);
        if (fg3 != null) fragmentTransaction.hide(fg3);
        if (fg4 != null) fragmentTransaction.hide(fg4);
    }


    @Override
    public void onClick(View v) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (v.getId()) {
            case R.id.channel:
                setSelected();
                channel.setSelected(true);
                if (fg1 == null) {
                    fg1 = new MyFragment("第一个Fragment");
                    fTransaction.add(R.id.content, fg1);
                } else {
                    fTransaction.show(fg1);
                }
                break;
            case R.id.message:
                setSelected();
                message.setSelected(true);
                if (fg2 == null) {
                    fg2 = new MyFragment("第二个Fragment");
                    fTransaction.add(R.id.content, fg2);
                } else {
                    fTransaction.show(fg2);
                }
                break;
            case R.id.better:
                setSelected();
                better.setSelected(true);
                if (fg3 == null) {
                    fg3 = new MyFragment("第三个Fragment");
                    fTransaction.add(R.id.content, fg3);
                } else {
                    fTransaction.show(fg3);
                }
                break;
            case R.id.setting:
                setSelected();
                setting.setSelected(true);
                if (fg4 == null) {
                    fg4 = new MyFragment("第四个Fragment");
                    fTransaction.add(R.id.content, fg4);
                } else {
                    fTransaction.show(fg4);
                }
                break;
        }
        fTransaction.commit();
    }
}
