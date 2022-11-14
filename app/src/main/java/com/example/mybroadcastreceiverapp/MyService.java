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
//        super.onStartCommand(intent, flags, startId);

//        Intent intent1=new Intent(getBaseContext(),MainActivity.class);
//        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent1);


//        Log.d("NEWSTACK", "Service onstart");

//        if (intent.getAction() != null)
            Log.d("NEWSTACK", "actions = " + intent.getAction());
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            startForegroundService(intent);
//        }

//        registerMyReceiver();
        return START_STICKY;
    }


    @Override
    public void onCreate() {
//        Log.d("createdService", "Service Created");
//
        Log.d("NEWSTACK", "Service create");

//        String CHANNEL_ID = "my_channel_01";
//        NotificationChannel channel = null;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            channel = new NotificationChannel(CHANNEL_ID,
//                    "Channel human readable title",
//                    NotificationManager.IMPORTANCE_DEFAULT);
//            ((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE)).createNotificationChannel(channel);
//        }


//        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
//                .setContentTitle("")
//                .setContentText("").build();
//
//        startForeground(1, notification);

        myReceiver = new MyReceiver();

        IntentFilter filter = new IntentFilter("com.jasshugarg.ultimateappsender");
        registerReceiver(myReceiver, filter);


//        registerMyReceiver();
//        registerMyReceiver();
    }


    @Override
    public void onDestroy() {

        unregisterReceiver(myReceiver);
        super.onDestroy();
        Log.d("createdService", "app closed");

        Log.d("NEWSTACK", "Service destroy");
    }
//
//    private void registerMyReceiver() {
//
//
//        Log.d("NEWSTACK", "Available for receiving");
//
//        BroadcastReceiver myReceiver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                String receivedMessage = intent.getStringExtra("Broadcast Message");
//                Log.d("NEWSTACK", intent.getAction() + " message " + receivedMessage);
////                MainActivity.textView.setText(receivedMessage);
////                MainActivity.receivedMessageFromAnotherApp = receivedMessage;
//
//                if (MainActivity.textView != null) {
//                    MainActivity.textView.setText(receivedMessage);
//                }
//
//                SharedPreferences sp = getSharedPreferences("myBroadcastReceiverApp", MODE_PRIVATE);
//                SharedPreferences.Editor ed = sp.edit();
//                ed.putString("ReceivedMessage", receivedMessage);
//                ed.apply();
//
//                Intent intent1 = new Intent(context, MyService.class);
//        context.startService(intent1);
////                ContextCompat.startForegroundService(context, intent1);
//
//            }
//        };
//
//
//        IntentFilter filter = new IntentFilter("com.jasshugarg.ultimateappsender");
//        registerReceiver(myReceiver, filter);
//
//
//    }

}