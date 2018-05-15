package com.example.dustin.lab43_11798_dustin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RatingBar rating;
    Button buttons;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();

    }

    private void addListenerOnButtonClick() {
        text = (TextView)  findViewById(R.id.textView);
        rating = (RatingBar) findViewById(R.id.ratingBar);
        buttons = (Button) findViewById(R.id.button);

        buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sRatingBar = String.valueOf(rating.getRating());
                text.setText(sRatingBar);
            }
        });
    }
}