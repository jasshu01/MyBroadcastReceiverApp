package com.example.mybroadcastreceiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MyInAppReceiver extends BroadcastReceiver {
    TextView textView;

    public MyInAppReceiver(TextView txtView) {
        this.textView = txtView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        String receivedMessage = intent.getStringExtra("broadcastedMessage");
        Log.d("yesssss", "recieved:in app here " + receivedMessage);


        textView.setText(receivedMessage);

        Log.d("yesssss", "recieved:in app here text " + textView.getText());
//        textView.setText("receivedMessage");
        Toast.makeText(context, "Message Received "
                +receivedMessage, Toast.LENGTH_LONG).show();

    }
}