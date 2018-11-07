package com.coderqian.chapter7.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.coderqian.chapter7.ServiceActivity;

/**
 * @author qianliqing
 * @since 2018/11/7 10:21 AM
 * email: qianlq0824@gmail.com
 */

public class CompareService extends Service {
    private Thread thread;
    Bundle bundle;
    int one = 0, two = 0;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        thread = new Thread(null, backgroundWork, "workThread");
    }

    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        bundle = intent.getExtras();
        String c1 = bundle.getString("one");
        String c2 = bundle.getString("two");
        if (!c1.equals("") && !c2.equals("")) {
            one = Integer.parseInt(c1);
            two = Integer.parseInt(c2);
        }
        if (!thread.isAlive()) {
            thread.start();
        }
    }

    private Runnable backgroundWork = new Runnable() {
        @Override
        public void run() {
            int randomDouble = IntCompare(one, two);
            ServiceActivity.updateGui(randomDouble);
            stopSelf();
        }
    };

    int IntCompare(int a, int b) {
        return a >= b ? a : b;
    }
}
