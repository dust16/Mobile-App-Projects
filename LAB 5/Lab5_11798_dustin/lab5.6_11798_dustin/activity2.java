package com.example.dustin.lab56_11798_dustin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity2 extends AppCompatActivity {

    EditText edittext;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        edittext = (EditText)findViewById(R.id.editText);

        //HAPUS TEXT PAS DICLICK
        edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext.setText("");
            }
        });

        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = edittext.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("MESSAGE", message);
                setResult(2, intent);
                finish();
            }
        });
    }
}
