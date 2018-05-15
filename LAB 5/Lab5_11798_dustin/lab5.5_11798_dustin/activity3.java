package com.example.dustin.lab55_11798_dustin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class activity3 extends AppCompatActivity {

    CheckBox box1, box2, box3, box4;
    RatingBar rate;
    Button button;
    String message5 = "", message6="";

    public void check(CheckBox box)
    {
        if(box.isChecked()==true)
        {
            if(message5 == "")
            {
                message5 += " ";
            }
            else
            {
                message5 += ", \n ";
            }

            message5 += box.getText().toString();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);

        box1 = (CheckBox) findViewById(R.id.checkBox2);
        box2 = (CheckBox) findViewById(R.id.checkBox3);
        box3 = (CheckBox) findViewById(R.id.checkBox4);
        box4 = (CheckBox) findViewById(R.id.checkBox5);
        rate = (RatingBar) findViewById(R.id.ratingBar);

        button = (Button)findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check(box1);
                check(box2);
                check(box3);
                check(box4);

                message6+=rate.getRating();

                Intent intent = new Intent();
                intent.putExtra("ALASAN", message5);
                intent.putExtra("RATE", message6);

                setResult(3, intent);
                finish();
            }
        });
    }



}