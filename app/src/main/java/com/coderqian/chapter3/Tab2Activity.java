package com.coderqian.chapter3;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * @author qianliqing
 * @since 2018-10-09 下午2:15
 * mail: qianlq0824@gmail.com
 */
public class Tab2Activity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TabHost tabHost = getTabHost();
        tabHost.addTab(tabHost.newTabSpec("list").setIndicator("列表")
                .setContent(new Intent(this, List2Activity.class)));
        tabHost.addTab(tabHost.newTabSpec("preference").setIndicator("设置")
                .setContent(new Intent(this, Preference2Activity.class)));
        tabHost.addTab(tabHost.newTabSpec("expandable").setIndicator("扩展列表")
                .setContent(new Intent(this, ExpandableList2Activity.class)));
    }
}
