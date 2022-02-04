package com.example.allinoneapppractise.handler_and_looperbycodinginflow;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.allinoneapppractise.R;

public class MainActivity extends AppCompatActivity {
    private Handler mainHandler = new Handler();
    private Button buttonStartThread;
    private Button buttonStopThread;
    private volatile boolean stopThread = false;
    private ExamplerLooperThread examplerLooperThread = new ExamplerLooperThread();
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        buttonStartThread = findViewById(R.id.button_start_thread);
        buttonStopThread = findViewById(R.id.button_stop_thread);

    }

    public void startThread(View view) {
        examplerLooperThread.start();
    }

    public void stopThread(View view) {

    }

    public void taskA(View view) {
        examplerLooperThread.handler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    Log.i(TAG, "taskA: " + i);
                    SystemClock.sleep(2000);
                }
            }
        });
    }

    public void taskB(View view) {

    }
}