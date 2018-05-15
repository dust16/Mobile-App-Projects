package com.example.dustin.lab94_11798_dustin;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private final float FACTOR_FRICTION = 0.5f; // imaginary friction on the screen
    private final float GRAVITY = 9.8f;
    private final float mDeltaT = 0.8f;
    private float mAx, mAy, mAz;
    private Ball bola;
    private SensorManager mSensorManager;
    private Sensor mSensor;
    Display display;
    int mWidthScreen, mHeightScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        display = ((WindowManager)this.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        mWidthScreen = display.getWidth();
        mHeightScreen = display.getHeight();


        bola = new Ball(this, 500, 500, 50, mWidthScreen, mHeightScreen);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        runnable.run();
        setContentView(bola);

    }

    Runnable runnable = new Runnable() {
        public void run() {


            bola.invalidate(); //will trigger the onDraw
            bola.move(mAx,mAy,mDeltaT);
            bola.postDelayed(this,1);

        }
    };

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);



    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {

        mAx = event.values[0];
        mAy = event.values[1];
        mAz = event.values[2];

        mAx = Math.signum(mAx) * Math.abs(mAx) * (1 - FACTOR_FRICTION * Math.abs(mAz) / GRAVITY);
        mAy = Math.signum(mAy) * Math.abs(mAy) * (1 - FACTOR_FRICTION * Math.abs(mAz) / GRAVITY);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}