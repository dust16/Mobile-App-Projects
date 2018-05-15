package keymanage.android.lab75_11798_dustin;

import android.content.Intent;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;

import android.widget.TextView;

import android.widget.Toast;


public class Activity3 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle bundle) {


        super.onCreate(bundle);

        TextView textView=new TextView(this);

        textView.setText("Activity Three");


        setContentView(R.layout.activity_3);


        Button button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                Intent i = new Intent(getApplicationContext(), MainActivity.class);


                startActivity(i);

            }

        });

    } 

}
