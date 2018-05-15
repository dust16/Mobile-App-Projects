package android.problem1_11798_dustin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),Activity2.class);
                i.putExtra("Value1", "Dustin Pradipta");
                i.putExtra("Value2", "Student");
                startActivity(i);
            }
        });

        Button button2 = (Button) findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(),Activity3.class);
                i.putExtra("Value1", "Pak Hareva");
                i.putExtra("Value2", "Lecturer");
                startActivity(i);
            }
        });
    }
}
