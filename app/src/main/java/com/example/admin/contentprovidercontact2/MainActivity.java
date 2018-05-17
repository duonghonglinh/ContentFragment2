package com.example.admin.contentprovidercontact2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();



        // anh xa Fragment vo Activity
        ContactFragment contactFragment = new ContactFragment();
        fragmentTransaction.add(R.id.fram, contactFragment);
        fragmentTransaction.commit();

    }

}
