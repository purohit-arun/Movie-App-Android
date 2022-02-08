package com.example.allinoneapppractise.handler_and_looperbycodinginflow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.allinoneapppractise.R;

public class MainActivity extends AppCompatActivity {
    private Handler mainHandler = new Handler();
    private Button buttonStartThread;
    private Button buttonStopThread;
    private Button buttonTaskA;
    private Button buttonTaskB;
    private volatile boolean stopThread = false;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        buttonStartThread = findViewById(R.id.button_start_thread);
        buttonStopThread = findViewById(R.id.button_stop_thread);
        buttonTaskA = findViewById(R.id.button_task_a);
        buttonTaskB = findViewById(R.id.button_task_b);

        buttonStartThread.setOnClickListener(v ->
                startThread(v));

        buttonTaskA.setOnClickListener(v ->
                taskA(v));
        buttonTaskB.setOnClickListener(v ->
                taskB(v));

    }

    public void startThread(View view) {
        ExamplerLooperThread examplerLooperThread = new ExamplerLooperThread();
        examplerLooperThread.start();
    }

    public void stopThread(View view) {

    }

    public void taskA(View view) {
        ExamplerLooperThread examplerLooperThread = new ExamplerLooperThread();
        examplerLooperThread.handler.post(() -> {
            for (int i = 0; i < 5; i++) {
                Log.i(TAG, "taskA: " + i);
                //SystemClock.sleep(2000);
            }
        });
    }

    public void taskB(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {

//                Looper.prepare();
//
////                Looper looper = Looper.getMainLooper();
//
//                Log.i(TAG, "run: on the thread " + Thread.currentThread().getName());
//                Looper.loop();

                runOnUiThread(() -> Toast.makeText(MainActivity.this, "Ui on Main Thread", Toast.LENGTH_SHORT).show());

            }
        }).start();
    }
}