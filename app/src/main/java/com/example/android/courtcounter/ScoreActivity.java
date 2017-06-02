package com.example.android.courtcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.courtcounter.MainActivity.PLAYER_1;
import static com.example.android.courtcounter.MainActivity.PLAYER_2;

public class ScoreActivity extends AppCompatActivity {

    static final String STATE_SCORE_HOME = "playerScoreHome";
    static final String STATE_YELLOW_HOME = "playerYellowHome";
    static final String STATE_RED_HOME = "playerRedHome";
    static final String STATE_SHOTS_HOME = "playerShotsHome";
    static final String STATE_CORNERS_HOME = "playerCornersHome";
    static final String STATE_KICK_HOME = "playerKicksHome";
    static final String STATE_SCORE_VISITOR = "playerScoreVisitor";
    static final String STATE_YELLOW_VISITOR = "playerYellowVisitor";
    static final String STATE_RED_VISITOR = "playerRedVisitor";
    static final String STATE_SHOTS_VISITOR = "playerShotsVisitor";
    static final String STATE_CORNERS_VISITOR = "playerCornersVisitor";
    static final String STATE_KICK_VISITOR = "playerKicksVisitor";

    int scoreHome = 0;
    int yellowCardHome = 0;
    int redCardHome = 0;
    int shotsOnTargetHome = 0;
    int cornersHome = 0;
    int freeKicksHome = 0;
    int scoreVisitor = 0;
    int yellowCardVisitor = 0;
    int redCardVisitor = 0;
    int shotsOnTargetVisitor = 0;
    int cornersVisitor = 0;
    int freeKicksVisitor = 0;

    String player1;
    String player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        displayForHome(scoreHome);
        displayYellowCardsHome(yellowCardHome);
        displayRedCardsHome(redCardHome);
        displayShotsOnTargetHome(shotsOnTargetHome);
        displayFreeKicksHome(freeKicksHome);
        displayCornersHome(cornersHome);

        displayForVisitor(scoreVisitor);
        displayYellowCardsVisitor(yellowCardVisitor);
        displayRedCardsVisitor(redCardVisitor);
        displayShotsOnTargetVisitor(shotsOnTargetVisitor);
        displayFreeKicksVisitor(freeKicksVisitor);
        displayCornersVisitor(cornersVisitor);

        // Saving current activity state with a collection of key-values pairs.
        //
        if (savedInstanceState != null) {
            scoreHome = savedInstanceState.getInt(STATE_SCORE_HOME);
            yellowCardHome = savedInstanceState.getInt(STATE_YELLOW_HOME);
            redCardHome = savedInstanceState.getInt(STATE_RED_HOME);
            shotsOnTargetHome = savedInstanceState.getInt(STATE_SHOTS_HOME);
            cornersHome = savedInstanceState.getInt(STATE_CORNERS_HOME);
            freeKicksHome = savedInstanceState.getInt(STATE_KICK_HOME);

            scoreVisitor = savedInstanceState.getInt(STATE_SCORE_VISITOR);
            yellowCardVisitor = savedInstanceState.getInt(STATE_YELLOW_VISITOR);
            redCardVisitor = savedInstanceState.getInt(STATE_RED_VISITOR);
            shotsOnTargetVisitor = savedInstanceState.getInt(STATE_SHOTS_VISITOR);
            cornersVisitor = savedInstanceState.getInt(STATE_CORNERS_VISITOR);
            freeKicksVisitor = savedInstanceState.getInt(STATE_KICK_VISITOR);

            displayForHome(scoreHome);
            displayYellowCardsHome(yellowCardHome);
            displayRedCardsHome(redCardHome);
            displayShotsOnTargetHome(shotsOnTargetHome);
            displayFreeKicksHome(freeKicksHome);
            displayCornersHome(cornersHome);

            displayForVisitor(scoreVisitor);
            displayYellowCardsVisitor(yellowCardVisitor);
            displayRedCardsVisitor(redCardVisitor);
            displayShotsOnTargetVisitor(shotsOnTargetVisitor);
            displayFreeKicksVisitor(freeKicksVisitor);
            displayCornersVisitor(cornersVisitor);

        }


        // Get the message from the intent
        Intent intent = getIntent();


        player1 = intent.getStringExtra(PLAYER_1);
        player2 = intent.getStringExtra(PLAYER_2);

        TextView nameA;
        TextView nameB;


        nameA = (TextView) findViewById(R.id.teamNameA);
        nameB = (TextView) findViewById(R.id.teamNameB);
        nameA.setText(player1);
        nameB.setText(player2);

        // This activates if the name fields are left empty. It goes to the string resources
        // and get "HOME" and "VISITOR" names
        if (player1.isEmpty()) {
            nameA.setText(getResources().getString(R.string.home_name));
        }

        if (player2.isEmpty()) {
            nameB.setText(getResources().getString(R.string.visitor_name));
        }


        // Toast message just to make things spicier
        Toast.makeText(this, "Passion has it's place...",
                Toast.LENGTH_LONG).show();


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current state
        savedInstanceState.putInt(STATE_SCORE_HOME, scoreHome);
        savedInstanceState.putInt(STATE_YELLOW_HOME, yellowCardHome);
        savedInstanceState.putInt(STATE_RED_HOME, redCardHome);
        savedInstanceState.putInt(STATE_SHOTS_HOME, shotsOnTargetHome);
        savedInstanceState.putInt(STATE_CORNERS_HOME, cornersHome);
        savedInstanceState.putInt(STATE_KICK_HOME, freeKicksHome);

        savedInstanceState.putInt(STATE_SCORE_VISITOR, scoreVisitor);
        savedInstanceState.putInt(STATE_YELLOW_VISITOR, yellowCardVisitor);
        savedInstanceState.putInt(STATE_RED_VISITOR, redCardVisitor);
        savedInstanceState.putInt(STATE_SHOTS_VISITOR, shotsOnTargetVisitor);
        savedInstanceState.putInt(STATE_CORNERS_VISITOR, cornersVisitor);
        savedInstanceState.putInt(STATE_KICK_VISITOR, freeKicksVisitor);


        super.onSaveInstanceState(savedInstanceState);
    }

    /*
        Adding +1 goal to Home team, when clicked
     */
    public void addGoalHome(View view) {
        scoreHome = scoreHome + 1;
        displayForHome(scoreHome);
    }

    /*
    Adding +1 yellow card to Home team, when clicked
     */
    public void addYellowCardHome(View view) {
        yellowCardHome = yellowCardHome + 1;
        displayYellowCardsHome(yellowCardHome);
    }

    /*
    Adding +1 red card to Home team, when clicked
     */
    public void addRedCardHome(View view) {
        redCardHome = redCardHome + 1;
        displayRedCardsHome(redCardHome);
    }

    /*
    Adding +1 shot on target to Home team, when clicked
     */
    public void addShotsOnTargetHome(View view) {
        shotsOnTargetHome = shotsOnTargetHome + 1;
        displayShotsOnTargetHome(shotsOnTargetHome);
    }

    /*
    Adding +1 corner to Home team, when clicked
     */
    public void addCornersHome(View view) {
        cornersHome = cornersHome + 1;
        displayCornersHome(cornersHome);
    }

    /*
    Adding +1 free kick to Home team, when clicked
     */
    public void addFreeKicksHome(View view) {
        freeKicksHome = freeKicksHome + 1;
        displayFreeKicksHome(freeKicksHome);
    }

    /*
    Adding +1 goal to Visitor team, when clicked
     */
    public void addGoalVisitor(View view) {
        scoreVisitor = scoreVisitor + 1;
        displayForVisitor(scoreVisitor);
    }

    /*
    Adding +1 yellow card to Visitor team, when clicked
     */
    public void addYellowCardsVisitor(View view) {
        yellowCardVisitor = yellowCardVisitor + 1;
        displayYellowCardsVisitor(yellowCardVisitor);
    }

    /*
    Adding +1 red card to Visitor team, when clicked
     */
    public void addRedCardVisitor(View view) {
        redCardVisitor = redCardVisitor + 1;
        displayRedCardsVisitor(redCardVisitor);
    }

    /*
    Adding +1 shot on target to Visitor team, when clicked
     */
    public void addShotsOnTargetVisitor(View view) {
        shotsOnTargetVisitor = shotsOnTargetVisitor + 1;
        displayShotsOnTargetVisitor(shotsOnTargetVisitor);
    }

    /*
    Adding +1 corner to Visitor team, when clicked
     */
    public void addCornersVisitor(View view) {
        cornersVisitor = cornersVisitor + 1;
        displayCornersVisitor(cornersVisitor);
    }

    /*
    Adding +1 free kick to Visitor team, when clicked
     */
    public void addFreeKicksVisitor(View view) {
        freeKicksVisitor = freeKicksVisitor + 1;
        displayFreeKicksVisitor(freeKicksVisitor);
    }

    /*
    Reset all the results in the app
     */
    public void resetAll(View view) {

        scoreHome = 0;
        yellowCardHome = 0;
        redCardHome = 0;
        shotsOnTargetHome = 0;
        cornersHome = 0;
        freeKicksHome = 0;

        scoreVisitor = 0;
        yellowCardVisitor = 0;
        redCardVisitor = 0;
        shotsOnTargetVisitor = 0;
        cornersVisitor = 0;
        freeKicksVisitor = 0;
        displayForHome(scoreHome);
        displayYellowCardsHome(yellowCardHome);
        displayRedCardsHome(redCardHome);
        displayShotsOnTargetHome(shotsOnTargetHome);
        displayFreeKicksHome(freeKicksHome);
        displayCornersHome(cornersHome);

        displayForVisitor(scoreVisitor);
        displayYellowCardsVisitor(yellowCardVisitor);
        displayRedCardsVisitor(redCardVisitor);
        displayShotsOnTargetVisitor(shotsOnTargetVisitor);
        displayFreeKicksVisitor(freeKicksVisitor);
        displayCornersVisitor(cornersVisitor);
    }


    /**
     * Methods displaying different statistic (Score, yellow and red cards, shots on
     * target, etc , for Team A.
     */
    public void displayForHome(int score) {
        TextView scoreView = (TextView) findViewById(R.id.home_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayYellowCardsHome(int score) {
        TextView scoreView = (TextView) findViewById(R.id.yellow_cards_home);
        scoreView.setText(String.valueOf(score));
    }

    public void displayRedCardsHome(int score) {
        TextView scoreView = (TextView) findViewById(R.id.red_cards_home);
        scoreView.setText(String.valueOf(score));
    }

    public void displayShotsOnTargetHome(int score) {
        TextView scoreView = (TextView) findViewById(R.id.shots_home);
        scoreView.setText(String.valueOf(score));
    }

    public void displayFreeKicksHome(int score) {
        TextView scoreView = (TextView) findViewById(R.id.free_kicks_home);
        scoreView.setText(String.valueOf(score));
    }

    public void displayCornersHome(int score) {
        TextView scoreView = (TextView) findViewById(R.id.corners_home);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Methods displaying different statistic (Score, yellow and red cards, shots on
     * target, etc , for Team B.
     */

    public void displayForVisitor(int score) {
        TextView scoreView = (TextView) findViewById(R.id.visitor_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayYellowCardsVisitor(int score) {
        TextView scoreView = (TextView) findViewById(R.id.yellow_cards_visitor);
        scoreView.setText(String.valueOf(score));
    }

    public void displayRedCardsVisitor(int score) {
        TextView scoreView = (TextView) findViewById(R.id.red_cards_visitor);
        scoreView.setText(String.valueOf(score));
    }

    public void displayShotsOnTargetVisitor(int score) {
        TextView scoreView = (TextView) findViewById(R.id.shots_visitor);
        scoreView.setText(String.valueOf(score));
    }

    public void displayFreeKicksVisitor(int score) {
        TextView scoreView = (TextView) findViewById(R.id.free_kicks_visitor);
        scoreView.setText(String.valueOf(score));
    }

    public void displayCornersVisitor(int score) {
        TextView scoreView = (TextView) findViewById(R.id.corners_visitor);
        scoreView.setText(String.valueOf(score));
    }
}
