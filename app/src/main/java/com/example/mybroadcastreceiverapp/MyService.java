package com.example.mybroadcastreceiverapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.view.Display;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyService extends Service {
    public MyService() {
    }


    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        super.onStartCommand(intent, flags, startId);

        registerMyReceiver();
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        Log.d("createdService", "Service Created");


        registerMyReceiver();
    }

    @Override
    public void onDestroy() {

        Log.d("createdService", "app closed");
    }

    private void registerMyReceiver() {

        BroadcastReceiver myReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String receivedMessage = intent.getStringExtra("Broadcast Message");
                Log.d("createdService", "message " + receivedMessage);
//                MainActivity.textView.setText(receivedMessage);
//                MainActivity.receivedMessageFromAnotherApp = receivedMessage;

                if(MainActivity.textView!=null)
                {
                    MainActivity.textView.setText(receivedMessage);
                }

                SharedPreferences sp = getSharedPreferences("myBroadcastReceiverApp", MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("ReceivedMessage", receivedMessage);
                ed.apply();
            }
        };


        IntentFilter filter = new IntentFilter("com.jasshugarg.ultimateappsender");
        registerReceiver(myReceiver, filter);
    }

}