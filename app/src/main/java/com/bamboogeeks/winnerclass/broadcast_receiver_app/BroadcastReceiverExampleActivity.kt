package com.bamboogeeks.winnerclass.broadcast_receiver_app

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bamboogeeks.winnerclass.R

class BroadcastReceiverExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_receiver_example)

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also { intentFilter ->
            registerReceiver(AirPlaneModeChangedReceiver(),intentFilter)
        }
    }
}