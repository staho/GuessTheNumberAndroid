package com.example.staho.zgadnijliczb;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class WonActivity extends AppCompatActivity {

    private String name = null;
    /*
     * Zapis do prefsów wygląda następująco
     * Najpierw zapisuje klucze imienia gracza i jego pozycję w tabeli np.: 1, "Kamil"
     * Potem zapisuje dla pozycji ilość prób czyli dla Kamila który jest pierwszy "1", 7 (ilość prób)
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = (TextView) findViewById(R.id.textView5);
        textView.setText("Ilość prób to: " + message);

        //SharedPreferences prefs = this.getSharedPreferences("com.example.staho.zgadnijliczb", Context.MODE_PRIVATE);


    }
    public void handleSubmitButton(){
        EditText editText = (EditText) findViewById(R.id.editText2);
        name = editText.getText().toString();
    }
    private class Score{
        private String name;
        private int score;

        public Score(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}
