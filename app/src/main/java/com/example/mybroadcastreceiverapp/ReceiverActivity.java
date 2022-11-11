package com.example.mybroadcastreceiverapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ReceiverActivity extends AppCompatActivity {
    private static ReceiverActivity ins;
    TextView receivedMessage;
    String rcvdmsg = MainActivity.receivedMessageFromSameApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        Log.d("msgrcvd", "rcvdmsg +" + rcvdmsg);
        receivedMessage = findViewById(R.id.receiveMessageFromSameApp);
        receivedMessage.setText(rcvdmsg);

        IntentFilter intentFilter = new IntentFilter("com.jasshugarg.myinnerappbroadcast");
        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(ReceiverActivity.this);
        lbm.registerReceiver(myreceiver, intentFilter);

        ins = this;

    }

    private BroadcastReceiver myreceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String str = intent.getStringExtra("broadcastedMessage");
            MainActivity.receivedMessageFromSameApp = str;
            Log.d("msgfromanother",str);
            Toast.makeText(context, "Received Message "+str, Toast.LENGTH_LONG).show();
        }
    };

}

