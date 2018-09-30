package com.coderqian.chapter2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

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

