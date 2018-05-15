package com.example.dustin.lab55_11798_dustin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.button;

public class activity2 extends AppCompatActivity {

    EditText name, nim;
    Spinner ps;
    RadioGroup radioSexGroup;
    RadioButton radioSexButton;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        name = (EditText)findViewById(R.id.editText5);
        nim = (EditText)findViewById(R.id.editText6);

        ps = (Spinner)findViewById(R.id.spinner);
        List<String> jurusan = new ArrayList<String>();
        jurusan.add("Teknik Informatika");
        jurusan.add("Sistem Informasi");
        jurusan.add("Sistem Komputer");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, jurusan);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ps.setAdapter(dataAdapter);

        radioSexGroup=(RadioGroup)findViewById(R.id.group);


        //HAPUS TEXT PAS DICLICK
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
            }
        });
        nim.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nim.setText("");
            }
        });


        button = (Button)findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId=radioSexGroup.getCheckedRadioButtonId();
                radioSexButton=(RadioButton)findViewById(selectedId);

                String message1 = name.getText().toString();
                String message2 = nim.getText().toString();

                String message3 = radioSexButton.getText().toString();
                String message4 = ps.getSelectedItem().toString();


                Intent intent = new Intent();
                intent.putExtra("MESSAGE1", message1);
                intent.putExtra("MESSAGE2", message2);
                intent.putExtra("MESSAGE3", message3);
                intent.putExtra("MESSAGE4", message4);
                setResult(2, intent);
                finish();
            }
        });
    }

}