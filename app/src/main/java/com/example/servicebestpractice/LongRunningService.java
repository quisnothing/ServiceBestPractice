package com.example.servicebestpractice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import java.util.Date;

/**
 * Created by 渠不与 on 2016/8/7 0007.
 */
public class LongRunningService extends Service {
    public IBinder onBind(Intent intent){
        return null;
    }

    public int onStartCommand(Intent intent,int flags,int startId){
        new Thread(new Runnable(){
            public void run(){
                Log.d("LongRunningService","executed at "+new Date().toString());
            }
        }).start();
        AlarmManager manager=(AlarmManager)getSystemService(ALARM_SERVICE);
        int anHour=60*1000;//这是一分钟的毫秒数
        long triggerAtTime= SystemClock.elapsedRealtime()+anHour;
        Intent i=new Intent(this,AlarmReciever.class);
        PendingIntent pi=PendingIntent.getBroadcast(this,0,i,0);//指定了处理定时任务的广播接收器为AlarmReceiver
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pi);
        return super.onStartCommand(intent,flags,startId);
    }
}
