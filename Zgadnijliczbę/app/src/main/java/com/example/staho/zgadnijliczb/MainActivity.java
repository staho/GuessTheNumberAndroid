package com.example.staho.zgadnijliczb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int toGuessInt;
    private int triesNumber = 0;
    public static final String EXTRA_MESSAGE = "com.example.staho.zgadnijliczb.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateNewInt();
    }
    public void checkAnswer(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        int answerInt = Integer.parseInt(editText.getText().toString());

        TextView textViewAnswerCheck = (TextView) findViewById(R.id.textView3);

        if(answerInt == toGuessInt){
            handleWin(textViewAnswerCheck);
        }
        else if(answerInt > toGuessInt){
            textViewAnswerCheck.setText("Za dużo!");
            triesNumber++;
        } else {
            textViewAnswerCheck.setText("Za mało!");
            triesNumber++;
        }
    }
    private void handleWin(TextView textViewAnswerCheck){
        textViewAnswerCheck.setText("");
        Intent intent = new Intent(this, WonActivity.class);
        intent.putExtra(EXTRA_MESSAGE, Integer.toString(triesNumber));
        startActivity(intent);
        //textViewAnswerCheck.setText("Wygrana!\nIlość prób to: " + triesNumber);
        generateNewInt();
    }
    private void generateNewInt(){
        Random generator = new Random();
        toGuessInt = generator.nextInt(101);
        System.out.println("Answer: " + toGuessInt);
        triesNumber = 0;
    }
}
