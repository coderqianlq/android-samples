package com.coderqian.chapter7;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.coderqian.R;
import com.coderqian.chapter7.service.CompareService;

/**
 * @author qianliqing
 * @date 2018/11/7 9:16 AM
 * email: qianlq0824@gmail.com
 */

public class ServiceActivity extends AppCompatActivity {

    public static int maxNum;

    public static Handler handler = new Handler();

    private static TextView result;

    private Button compare;
    private Button reset;

    private EditText one;
    private EditText two;

    public static void updateGui(int refreshDouble) {
        maxNum = refreshDouble;
        handler.post(RefreshLable);
    }

    public static Runnable RefreshLable = new Runnable() {
        public void run() {
            result.setText(String.valueOf(maxNum));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Bundle bundle = new Bundle();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        final Intent intent = new Intent(ServiceActivity.this, CompareService.class);

        result = (TextView) findViewById(R.id.result);
        compare = (Button) findViewById(R.id.compare);
        reset = (Button) findViewById(R.id.reset);
        one = (EditText) findViewById(R.id.one);
        two = (EditText) findViewById(R.id.two);

        compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("one", one.getText().toString());
                bundle.putString("two", two.getText().toString());
                intent.putExtras(bundle);
                startService(intent);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                one.setText(null);
                two.setText(null);
                result.setText(null);
            }
        });
    }
}
