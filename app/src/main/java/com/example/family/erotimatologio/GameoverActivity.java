package com.example.family.erotimatologio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameoverActivity extends AppCompatActivity {

    private TextView fScoreView;
    private Button fBackButton;
    private Button fWelcomeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        fScoreView = (TextView)findViewById(R.id.fscore);
        fBackButton = (Button)findViewById(R.id.fBackButton);
        fWelcomeButton = (Button)findViewById(R.id.fWelcomeButton);

        Intent intent = getIntent();
        int fscore = intent.getIntExtra("fscore", 0);
        int fTries = intent.getIntExtra("fTries",0);

        fScoreView.setText(""+fscore+"/"+fTries);

        fBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restart = new Intent(GameoverActivity.this, QuizActivity.class);
               //gameover.putExtra("fscore", mScore);
                startActivity(restart);
                finish();
            }
        });

        fWelcomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent welcome = new Intent(GameoverActivity.this, Welcome.class);
                startActivity(welcome);
                finish();
            }
        });

    }

    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(GameoverActivity.this, Welcome.class));
        finish();

    }


}
