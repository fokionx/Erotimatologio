package com.example.family.erotimatologio;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private Button mButtonOulgou;
    private Button mButtonPeninta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(Welcome.this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
