package com.example.tennistracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;

    int matchTeamA = 0;
    int matchTeamB = 0;

    int setTeamA = 0;
    int setTeamB = 0;

    int ad_flagA = 0;
    int ad_flagB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void displayForTeamA(int score, int set, int match){
        TextView scoreViewA = (TextView) findViewById(R.id.team_a_score);
        scoreViewA.setText(String.valueOf(score));

        TextView setViewA = (TextView) findViewById(R.id.team_a_set);
        setViewA.setText(String.valueOf(set));

        TextView matchViewA = (TextView) findViewById(R.id.team_a_match);
        matchViewA.setText(String.valueOf(match));
    }

    public void addScoreForTeamA(View v){
        TextView scoreViewA = (TextView) findViewById(R.id.team_a_score);
        TextView scoreViewB = (TextView) findViewById(R.id.team_b_score);

        String currentScoreA = scoreViewA.getText().toString();
        String currentScoreB = scoreViewB.getText().toString();

        if(currentScoreA.equals("Deuce") && ad_flagB == 1){
            String deuce = "Deuce";
            ad_flagA = 0;
            ad_flagB = 0;

            scoreViewA.setText(deuce);
            scoreViewB.setText(deuce);
        }

        if(scoreTeamA == 45){
            TextView setViewA = (TextView) findViewById(R.id.team_a_set);

            setTeamA++;
            scoreTeamA = 0;
            scoreTeamB = 0;

            setViewA.setText(String.valueOf(setTeamA));
            scoreViewA.setText(String.valueOf(scoreTeamA));
            scoreViewB.setText(String.valueOf(scoreTeamB));
        } else if (scoreTeamA < 45) {
            scoreTeamA = scoreTeamA + 15;
            scoreViewA.setText(String.valueOf(scoreTeamA));

            if (scoreTeamA == 45 && scoreTeamB == 45){
                String deuce = "Deuce";
                scoreTeamA = 100;
                scoreTeamB = 100;

                scoreViewA.setText(deuce);
                scoreViewB.setText(deuce);
            }
        }

        if(ad_flagA == 1){
            TextView setViewA = (TextView) findViewById(R.id.team_a_set);

            setTeamA++;
            scoreTeamA = 0;
            scoreTeamB = 0;
            ad_flagA = 0;

            setViewA.setText(String.valueOf(setTeamA));
            scoreViewA.setText(String.valueOf(scoreTeamA));
            scoreViewB.setText(String.valueOf(scoreTeamB));
        } else if(currentScoreA.equals("Deuce") && currentScoreB.equals("Deuce")) {
            String ad = "Ad";
            TextView setViewA = (TextView) findViewById(R.id.team_a_set);

            ad_flagA = 1;

            scoreViewA.setText(ad);
        }
    }

    public void addSetForTeamA(View v){
        setTeamA++;
        scoreTeamA = 0;

        ad_flagA = 0;
        ad_flagB = 0;

        displayForTeamA(scoreTeamA, setTeamA, matchTeamA);
    }

    public void addMatchForTeamA(View v){
        matchTeamA++;
        setTeamA = 0;
        scoreTeamA = 0;

        ad_flagA = 0;
        ad_flagB = 0;

        displayForTeamA(scoreTeamA, setTeamA, matchTeamA);
    }




    public void displayForTeamB(int score, int set, int match){
        TextView scoreViewB = (TextView) findViewById(R.id.team_b_score);
        scoreViewB.setText(String.valueOf(score));

        TextView setViewB = (TextView) findViewById(R.id.team_b_set);
        setViewB.setText(String.valueOf(set));

        TextView matchViewB = (TextView) findViewById(R.id.team_b_match);
        matchViewB.setText(String.valueOf(match));
    }

    public void addScoreForTeamB(View v){
        TextView scoreViewA = (TextView) findViewById(R.id.team_a_score);
        TextView scoreViewB = (TextView) findViewById(R.id.team_b_score);

        String currentScoreA = scoreViewA.getText().toString();
        String currentScoreB = scoreViewB.getText().toString();

        if(currentScoreB.equals("Deuce") && ad_flagA == 1){
            String deuce = "Deuce";
            ad_flagA = 0;
            ad_flagB = 0;

            scoreViewA.setText(deuce);
            scoreViewB.setText(deuce);
        }

        if(scoreTeamB == 45){
            TextView setViewB = (TextView) findViewById(R.id.team_b_set);

            setTeamB++;
            scoreTeamA = 0;
            scoreTeamB = 0;

            setViewB.setText(String.valueOf(setTeamB));
            scoreViewA.setText(String.valueOf(scoreTeamA));
            scoreViewB.setText(String.valueOf(scoreTeamB));
        } else if(scoreTeamB < 45){
            scoreTeamB = scoreTeamB + 15;
            scoreViewB.setText(String.valueOf(scoreTeamB));

            if (scoreTeamA == 45 && scoreTeamB == 45){
                String deuce = "Deuce";
                scoreTeamA = 100;
                scoreTeamB = 100;

                scoreViewA.setText(deuce);
                scoreViewB.setText(deuce);
            }
        }

        if(ad_flagB == 1){
            TextView setViewB = (TextView) findViewById(R.id.team_b_set);

            setTeamB++;
            scoreTeamA = 0;
            scoreTeamB = 0;
            ad_flagB = 0;

            setViewB.setText(String.valueOf(setTeamB));
            scoreViewA.setText(String.valueOf(scoreTeamA));
            scoreViewB.setText(String.valueOf(scoreTeamB));
        } else if(currentScoreA.equals("Deuce") && currentScoreB.equals("Deuce")) {
            String ad = "Ad";
            TextView setViewB = (TextView) findViewById(R.id.team_b_set);

            ad_flagB = 1;

            scoreViewB.setText(ad);
        }
    }

    public void addSetForTeamB(View v){
        setTeamB++;
        scoreTeamB = 0;

        ad_flagA = 0;
        ad_flagB = 0;

        displayForTeamB(scoreTeamB, setTeamB, matchTeamB);
    }

    public void addMatchForTeamB(View v){
        matchTeamB++;
        setTeamB = 0;
        scoreTeamB = 0;

        ad_flagA = 0;
        ad_flagB = 0;

        displayForTeamB(scoreTeamB, setTeamB, matchTeamB);
    }

    public void resetScore(View v){
        scoreTeamA = 0;
        scoreTeamB = 0;

        matchTeamA = 0;
        matchTeamB = 0;

        setTeamA = 0;
        setTeamB = 0;

        ad_flagA = 0;
        ad_flagB = 0;

        displayForTeamA(scoreTeamA, setTeamA, matchTeamA);
        displayForTeamB(scoreTeamB, setTeamB, matchTeamB);
    }
}
