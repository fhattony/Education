package com.example.developer.education.soal;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.developer.education.Login;
import com.example.developer.education.Nilai;
import com.example.developer.education.R;

import static com.example.developer.education.Splash.SCORE;
import static com.example.developer.education.soal.Soal1.NILAI;

/**
 * A simple {@link Fragment} subclass.
 */
public class Soal2 extends Fragment {


    public Soal2() {
        // Required empty public constructor
    }
    private RadioButton A,B,C,D;
    private Button selesai;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_soal2, container, false);

        A = (RadioButton)v.findViewById(R.id.jawabanA);
        B = (RadioButton)v.findViewById(R.id.jawabanB);
        C = (RadioButton)v.findViewById(R.id.jawabanC);
        D = (RadioButton)v.findViewById(R.id.jawabanD);
        selesai = (Button)v.findViewById(R.id.selsai);

        selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(D.isChecked()){
                    NILAI = NILAI + 50;
                }
                Intent i = new Intent(getContext(), Nilai.class);
                startActivity(i);
                getActivity().finish();
            }
        });


        return v;
    }



}
