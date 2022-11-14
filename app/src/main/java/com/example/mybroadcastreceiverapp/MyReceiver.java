package com.example.mybroadcastreceiverapp;

import static android.content.Context.MODE_PRIVATE;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class MyReceiver extends BroadcastReceiver {


    public MyReceiver() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("NEWSTACK", "Available for receiving");

        Log.d("NEWSTACK","action=> "+intent.getAction());


        String receivedMessage = intent.getStringExtra("Broadcast Message");
        Log.d("createdService", "message " + receivedMessage);
        Log.d("NEWSTACK", intent.getAction() + " message " + receivedMessage);


    }
}