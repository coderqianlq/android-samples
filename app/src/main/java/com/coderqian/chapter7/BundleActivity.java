package com.coderqian.chapter7;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.coderqian.R;
import com.coderqian.chapter7.service.Compare2Service;

/**
 * @author qianliqing
 * @since 2018/11/7 11:25 AM
 * email: qianlq0824@gmail.com
 */

public class BundleActivity extends AppCompatActivity {

    private boolean isBundle = false;

    private Compare2Service compare2Service;

    int a, b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        final TextView result = (TextView) findViewById(R.id.result);
        Button compare = (Button) findViewById(R.id.compare);
        final Button reset = (Button) findViewById(R.id.reset);
        final EditText one = (EditText) findViewById(R.id.one);
        final EditText two = (EditText) findViewById(R.id.two);

        if (!isBundle) {
            Intent intent = new Intent(BundleActivity.this, Compare2Service.class);
            bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
        }

        compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c1 = one.getText().toString();
                String c2 = two.getText().toString();
                if (!c1.equals("") && !c2.equals("")) {
                    a = Integer.parseInt(c1);
                    b = Integer.parseInt(c2);
                }
                result.setText(String.valueOf(compare2Service.IntCompare(a, b)));
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

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            compare2Service = ((Compare2Service.LocalBinder) iBinder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            compare2Service = null;
        }
    };
}
