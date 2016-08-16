package com.td.pay.demo.sdk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.td.pay.demo.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lukejun on 16/8/15.
 */
public class PayResultActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_pay_result);

        findViewById(R.id.result_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                success();
                finish();
            }
        });
    }

    private void success(){
        JSONObject obj = new JSONObject();
        try {
            obj.put("code", "100");
            obj.put("msg", "支付成功");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println("payresult-->" + obj.toString());
        Intent intent = new Intent("PayResultBroadcaseReceiver");
        intent.putExtra("code", obj.toString());
        this.sendBroadcast(intent);
    }
}
