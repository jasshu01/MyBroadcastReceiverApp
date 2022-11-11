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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SenderActivity extends AppCompatActivity {
    EditText messageToBroadcast;
    TextView receivedBroadcastInSameActivity;

    @Override
    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);

        messageToBroadcast = findViewById(R.id.messageToBroadcast);
        receivedBroadcastInSameActivity = findViewById(R.id.receivedBroadcastInSameActivity);
        Button broadcastMsg = findViewById(R.id.broadcastMessagebtn);

        broadcastMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = String.valueOf(messageToBroadcast.getText());
                LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(SenderActivity.this);
                Intent intent = new Intent("com.jasshugarg.myinnerappbroadcast");
                intent.putExtra("broadcastedMessage", str);
                Log.d("yessssssss", "message sent" + str);
                lbm.sendBroadcast(intent);
                messageToBroadcast.setText("");
                Toast.makeText(SenderActivity.this, "Message Broadcasted", Toast.LENGTH_SHORT).show();
            }
        });


        IntentFilter intentFilter = new IntentFilter("com.jasshugarg.myinnerappbroadcast");
//        MyInAppReceiver myreceiver = new MyInAppReceiver(receivedMessage);

        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(SenderActivity.this);
        lbm.registerReceiver(myreceiver, intentFilter);


    }

    private BroadcastReceiver myreceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String str = intent.getStringExtra("broadcastedMessage");
            Log.d("yesssss", "recieved:in app here " + str);


            receivedBroadcastInSameActivity.setText(str);
            Log.d("yesssss", "recieved:in app here text " + receivedBroadcastInSameActivity.getText());
        }
    };
}