package com.example.mybroadcastreceiverapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String receivedMessageFromSameApp = "Waiting for message";
    public static String receivedMessageFromAnotherApp = "Waiting for message";

public static TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         textView = findViewById(R.id.showBroadCastMessage);

//        IntentFilter intentFilter = new IntentFilter("com.jasshugarg.ultimateappsender");
//        MyReceiver myreceiver = new MyReceiver(textView);
//        registerReceiver(myreceiver, intentFilter);



//        textView.setText(receivedMessageFromAnotherApp);
//        Toast.makeText(this, "Received Message "+receivedMessageFromAnotherApp, Toast.LENGTH_SHORT).show();

//        Intent intent=new Intent(this,MyService.class);
//        startService(intent);
//        ContextCompat.startForegroundService(this,intent);


//        Log.d("createdService"," static string :"+receivedMessageFromAnotherApp);
        Log.d("createdService"," sp string :"+getSharedPreferences("myBroadcastReceiverApp", MODE_PRIVATE).getString("ReceivedMessage","Received No Message"));
textView.setText(getSharedPreferences("myBroadcastReceiverApp", MODE_PRIVATE).getString("ReceivedMessage","Received No Message"));
//        Log.d("createdService","Service starting");

//        Button senderActivity,receiverActivity;


//
//        senderActivity=findViewById(R.id.gotoSenderActivity);
//        receiverActivity=findViewById(R.id.goToReceiverActivity);
//
//        senderActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(MainActivity.this,SenderActivity.class);
//                startActivity(intent);
//            }
//        });
//        receiverActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(MainActivity.this,ReceiverActivity.class);
//                startActivity(intent);
//            }
//        });


    }


    @Override
    protected void onStop() {
        super.onStop();

//        Intent intent=new Intent(this,MyService.class);
//        startService(intent);

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
//
//        Intent intent=new Intent(this,MyService.class);
//        startService(intent);
    }
}