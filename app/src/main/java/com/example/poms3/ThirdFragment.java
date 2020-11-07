package com.example.poms3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ThirdFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FirstFragment f1 = new FirstFragment();
        SecondFragment f2 = new SecondFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragSecond2,f2).commit();
        getFragmentManager().beginTransaction().replace(R.id.fragOne2,f1).commit();

        return inflater.inflate(R.layout.fragment_third, container, false);
    }
}