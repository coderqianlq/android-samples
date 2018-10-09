package com.coderqian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.coderqian.chapter2.Linear2Activity;
import com.coderqian.chapter2.Linear3Activity;
import com.coderqian.chapter2.LinearActivity;
import com.coderqian.chapter2.RelativeActivity;
import com.coderqian.chapter2.TableActivity;
import com.coderqian.chapter3.DialogActivity;
import com.coderqian.chapter3.ExpandableList2Activity;
import com.coderqian.chapter3.Launcher2Activity;
import com.coderqian.chapter3.List2Activity;
import com.coderqian.chapter3.Preference2Activity;
import com.coderqian.chapter3.Tab2Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button linear = findViewById(R.id.jumpLinear);
        linear.setOnClickListener(new ButtonListener(LinearActivity.class));

        Button linear2 = findViewById(R.id.jumpLinear2);
        linear2.setOnClickListener(new ButtonListener(Linear2Activity.class));

        Button linear3 = findViewById(R.id.jumpLinear3);
        linear3.setOnClickListener(new ButtonListener(Linear3Activity.class));

        Button table = findViewById(R.id.jumpTable);
        table.setOnClickListener(new ButtonListener(TableActivity.class));

        Button relative = findViewById(R.id.jumpRelative);
        relative.setOnClickListener(new ButtonListener(RelativeActivity.class));

        Button tab = findViewById(R.id.jumpTab);
        tab.setOnClickListener(new ButtonListener(Tab2Activity.class));

        Button preference = findViewById(R.id.jumpPreference);
        preference.setOnClickListener(new ButtonListener(Preference2Activity.class));

        Button launcher = findViewById(R.id.jumpLauncher);
        launcher.setOnClickListener(new ButtonListener(Launcher2Activity.class));

        Button expandable = findViewById(R.id.jumpExpandableList);
        expandable.setOnClickListener(new ButtonListener(ExpandableList2Activity.class));

        Button list = findViewById(R.id.jumpList);
        list.setOnClickListener(new ButtonListener(List2Activity.class));

        Button dialog = findViewById(R.id.jumpDialog);
        dialog.setOnClickListener(new ButtonListener(DialogActivity.class));
    }


    class ButtonListener implements OnClickListener {

        private Class clazz;

        ButtonListener(Class clazz) {
            this.clazz = clazz;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, clazz);
            startActivity(intent);
        }
    }
}

