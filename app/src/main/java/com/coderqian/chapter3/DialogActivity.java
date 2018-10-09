package com.coderqian.chapter3;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.MultiSelectListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.util.Log;

import com.coderqian.R;

/**
 * @author qianliqing
 * @since 2018-10-09 下午9:32
 * mail: qianlq0824@gmail.com
 */
public class DialogActivity extends PreferenceActivity {

    private final static String PHONE = "phone";

    private final static String CLAZZ = "clazz";

    private final static String LANGUAGES = "languages";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new DialogActivity.DialogPreferenceFragment()).commit();
    }

    public static class DialogPreferenceFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
//            getView().setBackgroundColor(Color.BLACK);
            addPreferencesFromResource(R.xml.dialog);

            new PrefListener(PHONE);

            new PrefListener(CLAZZ);

            new PrefListener(LANGUAGES);
        }

        public class PrefListener implements Preference.OnPreferenceChangeListener {

            public PrefListener(String key) {
                super();
                Preference preference = findPreference(key);

                if (EditTextPreference.class.isInstance(preference)) {
                    EditTextPreference editTextPreference = (EditTextPreference) preference;
                    System.out.println(editTextPreference.getText());
                    onPreferenceChange(preference, editTextPreference.getText());
                } else if (ListPreference.class.isInstance(preference)) {
                    ListPreference listPreference = (ListPreference) preference;
                    onPreferenceChange(listPreference, listPreference.getValue());
                } else if (MultiSelectListPreference.class.isInstance(preference)) {
                    MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) preference;
                    onPreferenceChange(multiSelectListPreference, multiSelectListPreference.getValues());
                } else {
                    Log.e("SettingActivity", "不支持的Preference类型");
                }

                preference.setOnPreferenceChangeListener(this);
            }

            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                if (o == null) {
                    preference.setSummary(preference.getSummary());
                    return false;
                }
                preference.setSummary(o.toString().replace("[", "").replace("]", ""));
                return true;
            }
        }
    }
}
