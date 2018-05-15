package keymanage.android.lab91_11798_dustin;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    int iColor = 0;
    private View view;
    private Button button;
    private long lastUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(getWindow().FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = (View)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button);
        view.setBackgroundColor(Color.GREEN);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        lastUpdate = System.currentTimeMillis();
    }

    @Override
    public void onSensorChanged (SensorEvent sensorEvent)
    {
        getAccelerometer(sensorEvent);
    }

    private void getAccelerometer (SensorEvent event)
    {
        float[] values = event.values;
        //movement
        float x = values[0];
        float y = values[1];
        float z = values[2];

        float accelationSquareRoot = (x * x + y * y + z * z) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        long actualTime = event.timestamp;
        if ( accelationSquareRoot >= 2)
        {
            if(actualTime - lastUpdate < 200){
                return;
            }
            lastUpdate = actualTime;
            Toast.makeText(this, "Device was shuffled", Toast.LENGTH_SHORT).show();

            switch(iColor){
                case 1: button.setBackgroundColor (Color.GREEN);
                    break;
                case 2: button.setBackgroundColor (Color.BLUE);
                    break;
                case 3: button.setBackgroundColor (Color.CYAN);
                    break;
                case 4: button.setBackgroundColor (Color.DKGRAY);
                    break;
                case 5: button.setBackgroundColor (Color.RED);
                    break;
                case 6: button.setBackgroundColor (Color.MAGENTA);
                    break;
            }
            iColor += 1;
            if(iColor >= 6) iColor = 0;
        }
    }

    @Override
    public void onAccuracyChanged (Sensor sensor, int accuracy)
    {

    }

    @Override
    protected void onResume() {
        super.onResume();
        //register this class as a listener for the orientation and acceleromater sensors
        sensorManager.registerListener (this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause(){
        //unregister lsitener
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
