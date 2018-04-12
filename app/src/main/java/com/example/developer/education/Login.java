package com.example.developer.education;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.developer.education.Splash.SCORE;

public class Login extends AppCompatActivity {

    public static String NAMA;
    private EditText ednama;
    private TextView score;
    private Button mulai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ednama = (EditText)findViewById(R.id.nama);
        score = (TextView)findViewById(R.id.score);
        mulai = (Button)findViewById(R.id.mulai);

        ednama.setImeOptions(EditorInfo.IME_ACTION_DONE);
        score.setText("Score terakhir = "+String.valueOf(SCORE));

        mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NAMA = ednama.getText().toString();
                if (NAMA.isEmpty()){
                    ednama.setError("Tulis nama lebih dulu");
                    return;
                }else {
                    Intent i = new Intent(Login.this, Soal.class);
                    startActivity(i);
                    finish();
                }

            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
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
