package com.example.developer.education;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.developer.education.Login.NAMA;
import static com.example.developer.education.Splash.SCORE;
import static com.example.developer.education.soal.Soal1.NILAI;

public class Nilai extends AppCompatActivity {

    private TextView nama, score;
    private Button menu, mainulang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilai);

        nama =(TextView)findViewById(R.id.nama);
        score =(TextView)findViewById(R.id.score);
        menu =(Button) findViewById(R.id.kembali);
        mainulang =(Button)findViewById(R.id.mainulang);

        nama.setText(NAMA);
        SCORE = NILAI;
        score.setText(String.valueOf(SCORE));
        NILAI = 0;

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Nilai.this, Login.class);
                startActivity(i);
                finish();
            }
        });
        mainulang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Nilai.this, Soal.class);
                startActivity(i);
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Yakin kamu akan keluar?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}
