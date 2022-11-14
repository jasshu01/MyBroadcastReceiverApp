package com.example.mybroadcastreceiverapp;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.view.Display;
import android.widget.TextView;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

public class MyService extends Service {
    public MyService() {
    }

    MyReceiver myReceiver;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return START_STICKY;
    }


    @Override
    public void onCreate() {
        Log.d("NEWSTACK", "Service create");
        registerMyReceiver();

    }


    @Override
    public void onDestroy() {

        unregisterReceiver(myReceiver);
        super.onDestroy();
        Log.d("NEWSTACK", "Service destroy");
    }

    private void registerMyReceiver() {


        Log.d("NEWSTACK", "Available for receiving");

        BroadcastReceiver myReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String receivedMessage = intent.getStringExtra("Broadcast Message");
                Log.d("NEWSTACK", intent.getAction() + " message " + receivedMessage);

                if (MainActivity.textView != null) {
                    MainActivity.textView.setText(receivedMessage);
                }

                SharedPreferences sp = getSharedPreferences("myBroadcastReceiverApp", MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("ReceivedMessage", receivedMessage);
                ed.apply();

                Intent intent1 = new Intent(context, MyService.class);
                context.startService(intent1);


            }
        };


        IntentFilter filter = new IntentFilter("com.jasshugarg.ultimateappsender");
        registerReceiver(myReceiver, filter);


    }

}