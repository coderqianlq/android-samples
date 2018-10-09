package com.coderqian.chapter3;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

/**
 * @author qianliqing
 * @since 2018-10-09 下午5:05
 * mail: qianlq0824@gmail.com
 */
public class Launcher2Activity extends LauncherActivity {

    private String[] names = {"PreferenceActivity", "TabActivity", "ExpandableListActivity"};

    private Class<?>[] clazz = {Preference2Activity.class, Tab2Activity.class, ExpandableList2Activity.class};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);
    }

    @Override
    protected Intent intentForPosition(int i) {
        return new Intent(Launcher2Activity.this, clazz[i]);
    }
}
