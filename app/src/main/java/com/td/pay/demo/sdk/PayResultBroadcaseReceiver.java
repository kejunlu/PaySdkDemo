package com.td.pay.demo.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lukejun on 16/8/15.
 */
public class PayResultBroadcaseReceiver extends BroadcastReceiver{

    private PayCallback callback;
    private Context context;

    public PayResultBroadcaseReceiver(Context context,PayCallback callback){
        this.callback = callback;
        this.context = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String response = intent.getStringExtra("code");
        this.context.unregisterReceiver(this);
        if(TextUtils.isEmpty(response)){
            JSONObject obj = new JSONObject();
            try {
                obj.put("code", "100");
                obj.put("msg", "返回数据为空");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.callback.callback(obj.toString());
        } else {
            this.callback.callback(response);
        }

    }
}
