package com.td.pay.demo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by lukejun on 16/8/15.
 */
public class Servicemanager {
    private static Servicemanager instance;
    private Context context;

    private Servicemanager(){

    }

    public static Servicemanager getInstance(){
        if(null == instance) {
            instance = new Servicemanager();
        }

        return  instance;
    }

    public void setContext(Context context){
        this.context = context;
    }

    public void pay(String request, PayCallback callback){
        PayResultBroadcaseReceiver receiver = new PayResultBroadcaseReceiver(this.context, callback);
        IntentFilter filter = new IntentFilter("PayResultBroadcaseReceiver");
        this.context.registerReceiver(receiver, filter);
        jump(request);
    }

    private void jump(String request){
        Intent it = new Intent(context, PayActivity.class);
        //it.addFlags(268435457);
        it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        it.putExtra("request", request);
        context.startActivity(it);
    }
}
