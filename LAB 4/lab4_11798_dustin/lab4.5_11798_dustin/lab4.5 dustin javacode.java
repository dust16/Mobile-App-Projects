package com.example.dustin.lab45_11798_dustin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    SeekBar Seek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Seek=(SeekBar)findViewById(R.id.seekBar);
        Seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {



            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(getApplicationContext(), "seek bar progress: " + progress, Toast.LENGTH_LONG).show();
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), " Tracking Touch Start", Toast.LENGTH_LONG).show();
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "Tracking Touch Start", Toast.LENGTH_LONG).show();
            }



        });
    }
}
