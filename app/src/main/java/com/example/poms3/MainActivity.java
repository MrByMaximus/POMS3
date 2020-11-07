package com.example.poms3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    int NumCheck = 0;

    FirstFragment f1 = new FirstFragment();
    SecondFragment f2 = new SecondFragment();
    ThirdFragment f3 = new ThirdFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) {
            String result1=savedInstanceState.getString("result1");
            String result2=savedInstanceState.getString("result2");
            if(result1 != null)
                f1.TextResult = result1;
            if(result2 != null)
                f2.TextResult = result2;
        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            getSupportFragmentManager().beginTransaction().replace(R.id.frag,f1,"new").commit();
        }
        else {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragOne,f1,"new").commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragSecond,f2,"new").commit();
        }

        setContentView(R.layout.activity_main);
    }
    public void change(View view){
        switch (NumCheck % 3) {
            case 1: {
                getSupportFragmentManager().beginTransaction().replace(R.id.frag,f1,"new").commit();
                break;
            }
            case 2: {
                getSupportFragmentManager().beginTransaction().replace(R.id.frag,f2,"second").commit();
                break;
            }
            case 0: {
                getSupportFragmentManager().beginTransaction().replace(R.id.frag,f3,"second").commit();
            }
        }
        NumCheck++;
        }

    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("result2",f2.TextResult);
        savedInstanceState.putString("result1",f1.TextResult);
    }
}