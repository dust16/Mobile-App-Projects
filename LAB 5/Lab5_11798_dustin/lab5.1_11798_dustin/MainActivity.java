package android.lab51_11798_dustin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("LifeCycle","OnCreated Invoked");

    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("LifeCycle", "OnStart Invoked");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("LifeCycle", "OnResume Invoked");
    }


    @Override
    protected void onPause(){
        super.onPause();
        Log.d("LifeCycle", "OnPause Invoked");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("LifeCycle", "OnRestart Invoked");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("LifeCycle", "OnDestroy Invoked");
    }
}
