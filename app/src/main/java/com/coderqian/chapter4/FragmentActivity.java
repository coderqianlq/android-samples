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
import com.coderqian.chapter4.fragment.MyFragment;

/**
 * @author qianliqing
 * @since 2018-10-23 下午2:43
 * mail: qianlq0824@gmail.com
 */
public class FragmentActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView chat;
    private TextView friend;
    private TextView find;
    private TextView account;
    private FrameLayout content;

    //Fragment Object
    private MyFragment fg1, fg2, fg3, fg4;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tab);
        manager = getFragmentManager();
        bindViews();
        chat.performClick();   //模拟一次点击，既进去后选择第一项
    }

    //UI组件初始化与事件绑定
    private void bindViews() {
        chat = findViewById(R.id.chat);
        friend = findViewById(R.id.friend);
        find = findViewById(R.id.find);
        account = findViewById(R.id.account);
        content = findViewById(R.id.content);

        chat.setOnClickListener(this);
        friend.setOnClickListener(this);
        find.setOnClickListener(this);
        account.setOnClickListener(this);
    }

    //重置所有文本的选中状态
    private void setSelected() {
        chat.setSelected(false);
        friend.setSelected(false);
        find.setSelected(false);
        account.setSelected(false);
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
        FragmentTransaction fTransaction = manager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (v.getId()) {
            case R.id.chat:
                setSelected();
                chat.setSelected(true);
                if (fg1 == null) {
                    fg1 = new MyFragment("第一个Fragment");
                    fTransaction.add(R.id.content, fg1);
                } else {
                    fTransaction.show(fg1);
                }
                break;
            case R.id.friend:
                setSelected();
                friend.setSelected(true);
                if (fg2 == null) {
                    fg2 = new MyFragment("第二个Fragment");
                    fTransaction.add(R.id.content, fg2);
                } else {
                    fTransaction.show(fg2);
                }
                break;
            case R.id.find:
                setSelected();
                find.setSelected(true);
                if (fg3 == null) {
                    fg3 = new MyFragment("第三个Fragment");
                    fTransaction.add(R.id.content, fg3);
                } else {
                    fTransaction.show(fg3);
                }
                break;
            case R.id.account:
                setSelected();
                account.setSelected(true);
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
