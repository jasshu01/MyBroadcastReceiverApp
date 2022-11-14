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
////                MainActivity.textView.setText(receivedMessage);
////                MainActivity.receivedMessageFromAnotherApp = receivedMessage;
//
//        if (MainActivity.textView != null) {
//            MainActivity.textView.setText(receivedMessage);
//        }
////
//        SharedPreferences sp =  context.getSharedPreferences("myBroadcastReceiverApp", MODE_PRIVATE);
//        SharedPreferences.Editor ed = sp.edit();
//        ed.putString("ReceivedMessage", receivedMessage);
//        ed.apply();
//
//
//        Intent intent1=new Intent(context,MyService.class);
//        context.startService(intent1);
//        ContextCompat.startForegroundService( context,intent1);


    }
}