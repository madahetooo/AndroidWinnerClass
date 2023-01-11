package com.bamboogeeks.winnerclass.notification_app

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.bamboogeeks.winnerclass.R
import com.bamboogeeks.winnerclass.databinding.ActivityNotificationExampleBinding

class NotificationExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotificationExampleBinding
    val CHANNEL_ID = "normalChannelID"
    val CHANNEL_NAME = "normalChannelName"
    val NOTIFICATION_ID = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createNotificationChannel()


        val intent = Intent(this,NotificationExampleActivity::class.java)

        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0,PendingIntent.FLAG_IMMUTABLE)
        }


        val normalNotification = NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("Normal Notification")
            .setContentText("This is a Normal Notification Example")
            .setSmallIcon(R.drawable.ic_notification)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()


        val notificationManger = NotificationManagerCompat.from(this)

        binding.btnSendNotification.setOnClickListener {
            notificationManger.notify(NOTIFICATION_ID,normalNotification)
        }

    }

    fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT).apply {
//                lightColor = Color.GREEN
//                enableLights(true)
            }

           val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}