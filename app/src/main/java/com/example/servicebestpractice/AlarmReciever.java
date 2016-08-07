package com.example.servicebestpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by 渠不与 on 2016/8/7 0007.
 */
public class AlarmReciever extends BroadcastReceiver {
    //一旦接收到广播就启动
    public void onReceive(Context context,Intent intent){
        Intent i=new Intent(context,LongRunningService.class);
        context.startService(i);
    }
}
