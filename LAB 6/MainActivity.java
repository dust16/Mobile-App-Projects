package com.example.dustin.lab60_11798_dustin;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements fragment1.OnFragmentInteractionListener{



    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container,new fragment1()).commit();

        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.add(R.id.container1,new fragment2()).commit();
    }

    @Override
    public void onFragmentInteraction(String string) {
        bundle=new Bundle();
        bundle.putString("teks",string);
        fragment2 fragmen2 = new fragment2();
        fragmen2.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.container1,fragmen2).commit();

    }
}
