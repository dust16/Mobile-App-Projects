package android.problem1_11798_dustin;

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
        textView.setText("third Activity");

        setContentView(R.layout.activity_3);

        Bundle extras = getIntent().getExtras();
        String value1 = extras.getString("Value1");
        String value2 = extras.getString("Value2");
        Toast.makeText(getApplicationContext(),"Values are : \n First Value: " + value1 + " \n Second Value: " + value2, Toast.LENGTH_LONG).show();

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), Activity1.class);
                i.putExtra("Value1","Kembali ke Activity 1");
                startActivity(i);
            }
        });

        Button button2 = (Button) findViewById(R.id.button3);

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), Activity2.class);
                i.putExtra("Value1","Ke Activity 2");
                startActivity(i);
            }
        });
    }
}
