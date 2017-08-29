package com.example.family.erotimatologio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {

    private Button mButtonOulgou;
    private Button mButtonPeninta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mButtonOulgou = (Button)findViewById(R.id.btnOulgou);
        mButtonPeninta = (Button)findViewById(R.id.btnPeninta);

        mButtonOulgou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startOulgou = new Intent(Welcome.this, QuizActivity.class);
                startActivity(startOulgou);
                finish();
            }
        });

        mButtonPeninta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent startPeninta = new Intent(Welcome.this, QuizPenintaActivity.class);
               startActivity(startPeninta);
                finish();
            }
        });
    }
}
