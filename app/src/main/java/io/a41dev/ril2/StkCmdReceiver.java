package io.a41dev.ril2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Shadaï ALI on 23/11/16.
 */
public class StkCmdReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("rcv",intent.toString());
        Log.e("rcv",intent.getExtras().toString());


    }
}
