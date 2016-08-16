package com.td.pay.demo.sdk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.td.pay.demo.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lukejun on 16/8/15.
 */
public class PayActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_pay);
        String request = getIntent().getStringExtra("request");
        TextView tv = (TextView) this.findViewById(R.id.textview);
        tv.setText(request);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PayActivity.this, PayResultActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        back();
    }

    private void back(){
        JSONObject obj = new JSONObject();
        try {
            obj.put("code", "101");
            obj.put("msg", "取消支付");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent("PayResultBroadcaseReceiver");
        intent.putExtra("code", obj.toString());
        this.sendBroadcast(intent);

    }
}
