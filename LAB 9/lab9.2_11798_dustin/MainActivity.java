package keymanage.android.lab92_11798_dustin;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static SensorManager sensorService;
    private MyCompassView compassView;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        compassView = new MyCompassView(this);
        setContentView(compassView);

        sensorService = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorService.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        if(sensor != null){
            sensorService.registerListener(mySensorEventListener, sensor, SensorManager. SENSOR_DELAY_NORMAL);
            Log.i("Compass MainActivity", "Registered for ORIENTATION Sensor");
        }else{
            Log.e("Compass MainActivity", "Registered for ORIENTATION Sensor");
            Toast.makeText(this, "ORIENTATION Sensor not found", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    private SensorEventListener mySensorEventListener = new SensorEventListener(){
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy){

        }
        @Override
        public void onSensorChanged(SensorEvent event){
            //angle between the magnetic north direction
            //0=North, 90=East, 180=South, 270=West
            float azimuth = event.values[0];
            compassView.updateData(azimuth);
        }
    };

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(sensor !=null){
            sensorService.unregisterListener(mySensorEventListener);
        }
    }
}
