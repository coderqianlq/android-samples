package com.coderqian.chapter3;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

import com.coderqian.R;

/**
 * @author qianliqing
 * @since 2018-10-09 下午2:39
 * mail: qianlq0824@gmail.com
 */
public class Preference2Activity extends PreferenceActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
    }

    public static class MyPreferenceFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
//            getView().setBackgroundColor(Color.BLACK);
            addPreferencesFromResource(R.xml.preference);
        }
    }
}