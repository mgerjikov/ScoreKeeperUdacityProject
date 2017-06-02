package com.example.android.courtcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    public static final String PLAYER_1 = "team_a_name";
    public static final String PLAYER_2 = "team_b_name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_start);

    }

    public void loginState(View view) {
        Intent startNewActivity = new Intent(this, ScoreActivity.class);

        EditText player1 = (EditText) findViewById(R.id.player_1);
        EditText player2 = (EditText) findViewById(R.id.player_2);

        String gamer1 = player1.getText().toString();
        String gamer2 = player2.getText().toString();

        startNewActivity.putExtra("team_a_name", gamer1);
        startNewActivity.putExtra("team_b_name", gamer2);

        startActivity(startNewActivity);

    }
}
