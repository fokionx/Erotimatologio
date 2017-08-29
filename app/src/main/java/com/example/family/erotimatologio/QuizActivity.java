package com.example.family.erotimatologio;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.concurrent.RunnableFuture;

import android.os.Handler;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class QuizActivity extends AppCompatActivity {

    final Handler handler = new Handler();

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
   //private TextView mResultView;
    private Button mButtonQuit;
    private int mCount=-1;
    private String mAnswer;
    private int mScore = 0;
    private Random rand = new Random();
    int mQuestionNumber = rand.nextInt(mQuestionLibrary.getLength());

    //private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        //mResultView = (TextView)findViewById(R.id.result);
        mButtonQuit = (Button)findViewById(R.id.quit);

        updateQuestion();

        //Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mButtonChoice1.getText()== mAnswer){
                    mButtonChoice1.setBackgroundColor(getResources().getColor(R.color.rightChoiceColor));
                    mScore++;
                    updateScore(mScore);
                    handler.postDelayed(new Runnable(){
                        @Override
                        public void run() {
                            updateQuestion();
                            mButtonChoice1.setBackgroundColor(getResources().getColor(R.color.choiceColor));
                        }
                    },2000);
                    //mResultView.setTextColor(Color.parseColor("#388E3C"));
                    //mResultView.setText("Σωστά!");

                }else{
                    if(mButtonChoice2.getText()==mAnswer){
                        mButtonChoice2.setBackgroundColor(getResources().getColor(R.color.rightChoiceColor));
                    }else{
                        mButtonChoice3.setBackgroundColor(getResources().getColor(R.color.rightChoiceColor));
                    }
                    mButtonChoice1.setBackgroundColor(getResources().getColor(R.color.wrongChoiceColor));
                    handler.postDelayed(new Runnable(){
                        @Override
                        public void run() {
                            updateQuestion();
                            mButtonChoice1.setBackgroundColor(getResources().getColor(R.color.choiceColor));
                        }
                    },2000);
                    //mResultView.setTextColor(Color.parseColor("#F50057"));
                    //mResultView.setText("Λάθος!");
                    //Toast.makeText(QuizActivity.this, "Λάθος", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mButtonChoice2.getText()== mAnswer){
                    mButtonChoice2.setBackgroundColor(getResources().getColor(R.color.rightChoiceColor));
                    mScore++;
                    updateScore(mScore);
                    handler.postDelayed(new Runnable(){
                        @Override
                        public void run() {
                            updateQuestion();
                            mButtonChoice2.setBackgroundColor(getResources().getColor(R.color.choiceColor));
                        }
                    },2000);
                    //mResultView.setText("Σωστά!");

                }else{
                    if(mButtonChoice1.getText()==mAnswer){
                        mButtonChoice1.setBackgroundColor(getResources().getColor(R.color.rightChoiceColor));
                    }else{
                        mButtonChoice3.setBackgroundColor(getResources().getColor(R.color.rightChoiceColor));
                    }
                    mButtonChoice2.setBackgroundColor(getResources().getColor(R.color.wrongChoiceColor));
                    handler.postDelayed(new Runnable(){
                        @Override
                        public void run() {
                            updateQuestion();
                            mButtonChoice2.setBackgroundColor(getResources().getColor(R.color.choiceColor));
                        }
                    },2000);
                }
            }
        });

        //Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mButtonChoice3.getText()== mAnswer){
                    mButtonChoice3.setBackgroundColor(getResources().getColor(R.color.rightChoiceColor));
                    mScore++;
                    updateScore(mScore);
                    handler.postDelayed(new Runnable(){
                        @Override
                        public void run() {
                            updateQuestion();
                            mButtonChoice3.setBackgroundColor(getResources().getColor(R.color.choiceColor));
                        }
                    },2000);
                    //mResultView.setTextColor(Color.parseColor("#388E3C"));
                    //mResultView.setText("Σωστά!");

                }else{
                    if(mButtonChoice1.getText()==mAnswer){
                        mButtonChoice1.setBackgroundColor(getResources().getColor(R.color.rightChoiceColor));
                    }else{
                        mButtonChoice2.setBackgroundColor(getResources().getColor(R.color.rightChoiceColor));
                    }
                    mButtonChoice3.setBackgroundColor(getResources().getColor(R.color.wrongChoiceColor));
                    handler.postDelayed(new Runnable(){
                        @Override
                        public void run() {
                            updateQuestion();
                            mButtonChoice3.setBackgroundColor(getResources().getColor(R.color.choiceColor));
                        }
                    },2000);
                    //mResultView.setTextColor(Color.parseColor("#F50057"));
                    //mResultView.setText("Λάθος!");
                    //Toast.makeText(QuizActivity.this, "Λάθος", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mButtonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gameover = new Intent(QuizActivity.this, GameoverActivity.class);
                gameover.putExtra("fscore", mScore);
                gameover.putExtra("fTries", mCount);
                startActivity(gameover);
                mCount=0;
                finish();

            }
        });

    }

    public void updateQuestion(){
        mButtonChoice1.setBackgroundColor(getResources().getColor(R.color.choiceColor));
        mButtonChoice2.setBackgroundColor(getResources().getColor(R.color.choiceColor));
        mButtonChoice3.setBackgroundColor(getResources().getColor(R.color.choiceColor));
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));

        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber = rand.nextInt(mQuestionLibrary.getLength());
        mCount++;
        //mQuestionNumber++;

    }

    private void updateScore(int mScore) {
        mScoreView.setText(""+mScore);
    }

    public void onBackPressed() {

        AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(this);
        alertDialog2.setTitle("Τερματισμός");
        alertDialog2.setMessage("Τερματισμός εξέτασης και επιστροφή στο αρχικό μενού");
        // Add the buttons
        alertDialog2.setPositiveButton("Εντάξει", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                mCount=0;
                Intent returnMenu = new Intent(QuizActivity.this, Welcome.class);
                startActivity(returnMenu);
                finish();
            }
        });
        alertDialog2.setNegativeButton("Άκυρο", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        alertDialog2.show();
    }


    /*public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(QuizActivity.this, Welcome.class));
        finish();
    }
*/


}
