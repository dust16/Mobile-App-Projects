package com.example.dustin.lab42_11798_dustin;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoComplete;

    String[] city={"Jakarta ","Bogor","Depok","Tangerang","Bekasi","Semarang","Surakarta","Tegal","Surabaya","Salatiga"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoComplete = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        autoComplete.setWidth(650);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item, city);

        autoComplete.setThreshold(1);
        autoComplete.setAdapter(aa);
        autoComplete.setTextColor(Color.BLUE);
    }
}

