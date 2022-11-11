package com.example.mybroadcastreceiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

public class MyReceiver extends BroadcastReceiver {


    public MyReceiver() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {

        String receivedMessage = intent.getStringExtra("Broadcast Message");
        Log.d("createdService", "message " + receivedMessage);
        MainActivity.textView.setText(receivedMessage);
        MainActivity.receivedMessageFromAnotherApp = receivedMessage;

    }
}