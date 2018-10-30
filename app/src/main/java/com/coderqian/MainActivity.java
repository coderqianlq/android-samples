package com.coderqian;

import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.yalantis.euclid.library.EuclidActivity;
import com.yalantis.euclid.library.EuclidListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends EuclidActivity {

    private String[] strings = {"",
            "com.coderqian.chapter2.LinearActivity,com.coderqian.chapter2.Linear2Activity,com.coderqian.chapter2.Linear3Activity,com.coderqian.chapter2.RelativeActivity,com.coderqian.chapter2.TableActivity",
            "com.coderqian.chapter3.Tab2Activity,com.coderqian.chapter3.DialogActivity,com.coderqian.chapter3.ExpandableList2Activity,com.coderqian.chapter3.Launcher2Activity,com.coderqian.chapter3.List2Activity,com.coderqian.chapter3.Preference2Activity",
            "com.coderqian.chapter4.FragmentActivity,com.coderqian.chapter4.Fragment2Activity,com.coderqian.chapter4.IntentActivity,com.coderqian.chapter4.AnimatorActivity",
            "com.coderqian.chapter5.TweenActivity,com.coderqian.chapter5.FrameActivity,com.coderqian.chapter5.LeafLoadingActivity",
            "com.coderqian.chapter6.SQLiteActivity", "", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mButtonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Oh hi, CoderQian!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected BaseAdapter getAdapter() {
        Map<String, Object> profileMap;
        List<Map<String, Object>> profilesList = new ArrayList<>();

        int[] chapters = {
                R.drawable.chapter1,
                R.drawable.chapter2,
                R.drawable.chapter3,
                R.drawable.chapter4,
                R.drawable.chapter5,
                R.drawable.chapter6,
                R.drawable.chapter7,
                R.drawable.chapter8,
                R.drawable.chapter9};
        String[] homework = getResources().getStringArray(R.array.homework);
        String[] homeworkList = getResources().getStringArray(R.array.homework_list);
        String[] homeworkDetail = getResources().getStringArray(R.array.homework_detail);

        for (int i = 0; i < chapters.length; i++) {
            String[] content = strings[i].split(",");

            profileMap = new HashMap<>();
            profileMap.put(EuclidListAdapter.KEY_AVATAR, chapters[i]);
            profileMap.put(EuclidListAdapter.KEY_NAME, homework[i]);
            profileMap.put(EuclidListAdapter.KEY_DESCRIPTION_SHORT, homeworkList[i]);
            profileMap.put(EuclidListAdapter.KEY_DESCRIPTION_FULL, homeworkDetail[i]);
            profileMap.put(EuclidListAdapter.KEY_HOMEWORK_URL, content);
            profilesList.add(profileMap);
        }

        return new EuclidListAdapter(this, R.layout.list_item, profilesList);
    }
}

