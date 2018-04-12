package com.example.developer.education.soal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.developer.education.R;

import static com.example.developer.education.Splash.SCORE;

/**
 * A simple {@link Fragment} subclass.
 */
public class Soal1 extends Fragment {


    public Soal1() {
        // Required empty public constructor
    }

    private RadioButton A,B,C,D;
    public static int NILAI;
    private Button next;
    private RadioGroup radioGroup;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_soal1, container, false);

        A = (RadioButton)v.findViewById(R.id.jawabanA);
        B = (RadioButton)v.findViewById(R.id.jawabanB);
        C = (RadioButton)v.findViewById(R.id.jawabanC);
        D = (RadioButton)v.findViewById(R.id.jawabanD);
        next = (Button) v.findViewById(R.id.next);
        radioGroup = (RadioGroup) v.findViewById(R.id.rgroup);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(B.isChecked()){
                    NILAI = 0;
                    NILAI = NILAI + 50;
                }
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.contentSoal, new Soal2(), "h");
                fragmentTransaction.commit();
            }
        });

        return v;
    }

}
