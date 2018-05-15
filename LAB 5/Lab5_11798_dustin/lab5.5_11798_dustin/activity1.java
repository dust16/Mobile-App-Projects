package com.example.dustin.lab55_11798_dustin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity1 extends AppCompatActivity {

    TextView name, nim, ps, kelamin, alasan, rating;
    Button pdata, questioner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        name = (TextView)findViewById(R.id.textView12);
        nim = (TextView)findViewById(R.id.textView13);
        ps = (TextView)findViewById(R.id.textView14);
        kelamin = (TextView)findViewById(R.id.textView15);
        alasan = (TextView)findViewById(R.id.textView16);
        rating = (TextView)findViewById(R.id.textView17);

        pdata = (Button)findViewById(R.id.button);
        questioner = (Button)findViewById(R.id.button2);

        pdata.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent intent=new Intent(getApplicationContext(),activity2.class);
                startActivityForResult(intent, 2);
            }

        });

        questioner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent intent=new Intent(getApplicationContext(),activity3.class);
                startActivityForResult(intent, 3);
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2){
            String message1=data.getStringExtra("MESSAGE1");
            name.setText(message1);

            String message2=data.getStringExtra("MESSAGE2");
            nim.setText(message2);

            String message3=data.getStringExtra("MESSAGE3");
            ps.setText(message3);

            String message4=data.getStringExtra("MESSAGE4");
            kelamin.setText(message4);
        }

        if(requestCode==3){
            String message5=data.getStringExtra("ALASAN");
            alasan.setText(message5);

            String message6=data.getStringExtra("RATE");
            rating.setText(message6);

        }
    }
}
