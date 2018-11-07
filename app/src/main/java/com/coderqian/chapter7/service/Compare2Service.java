package com.coderqian.chapter7.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * @author qianliqing
 * @since 2018/11/7 11:32 AM
 * email: qianlq0824@gmail.com
 */

public class Compare2Service extends Service {

    private final IBinder iBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        public Compare2Service getService() {
            return Compare2Service.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    public int IntCompare(int a, int b) {
        return a >= b ? a : b;
    }
}
