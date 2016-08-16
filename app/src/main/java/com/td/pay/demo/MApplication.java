package com.td.pay.demo;

import android.app.Application;

import com.td.pay.demo.sdk.Servicemanager;

/**
 * Created by lukejun on 16/8/15.
 */
public class MApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Servicemanager.getInstance().setContext(this.getApplicationContext());
    }
}
