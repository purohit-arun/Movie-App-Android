package com.example.allinoneapppractise.handler_and_looperbycodinginflow;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

public class ExamplerLooperThread extends Thread {
    private static final String TAG = "ExamplerLooperThread";
    public Handler handler = new ExampleHandler();
    public Looper looper;


    @Override
    public void run() {
        Looper.prepare();

        looper = Looper.getMainLooper();

        //handler = new ExampleHandler();

        Log.i(TAG, "run: on the thread " + Thread.currentThread().getName());

        Looper.loop();


        /*for (int i = 0; i < 5; i++) {
            SystemClock.sleep(1000);
        }*/
        Log.d(TAG, "End of run");
    }
}
