package com.coderqian.chapter2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

/**
 * @author qianliqing
 * @since 2018-09-30 下午2:32
 * mail: qianlq0824@gmail.com
 */
public class Linear2Activity extends AppCompatActivity {

    private int[] data = new int[100];

    int hasData = 0;
    int status = 0;

    ProgressBar progress, seek;

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 0x111) {
                progress.setProgress(status);
                seek.setProgress(status);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_2);

        progress = findViewById(R.id.progress);
        seek = findViewById(R.id.seek);

        new Thread() {
            public void run() {
                while (status < 100) {
                    status = doWork();
                    handler.sendEmptyMessage(0x111);
                }
            }
        }.start();
    }

    private int doWork() {
        data[hasData++] = (int) Math.random() * 100;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hasData;
    }
}
