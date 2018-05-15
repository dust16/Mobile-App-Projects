package com.example.dustin.lab41_11798_dustin;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import java.util.ArrayList;
        import java.util.List;
        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;
        import android.widget.AdapterView.OnItemSelectedListener;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView country = (TextView) findViewById(R.id.textView3);
        TextView etnichs = (TextView) findViewById(R.id.textView4);
        country.setText("Country List");
        etnichs.setText("Ethnics List");

        final Spinner spinner = (Spinner) findViewById(R.id.spinner3);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner4);

        Button button = (Button) findViewById(R.id.button);


        List<String>countryl =  new ArrayList<String>();
        countryl.add("Indonesia");
        countryl.add("Thailand");
        countryl.add("Philippines");
        countryl.add("Singapore");
        countryl.add("Malaysia");
        countryl.add("Vietnam");

        List<String>ethnicsl =  new ArrayList<String>();
        ethnicsl.add("Javanese");
        ethnicsl.add("Sundanese");
        ethnicsl.add("Malay");
        ethnicsl.add("Batak");
        ethnicsl.add("Balinese");
        ethnicsl.add("Filipino");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, countryl);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ethnicsl);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter1);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                StringBuffer result = new StringBuffer();
                result.append(String.format("Spinner1 : %s", spinner.getSelectedItem()));
                StringBuffer result2 = new StringBuffer();
                result2.append(String.format("Spinner2 : %s", spinner2.getSelectedItem()));
                Toast.makeText(getApplicationContext(),"Hasil Pilihan "+result.toString()+"  "+result2.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }



}
