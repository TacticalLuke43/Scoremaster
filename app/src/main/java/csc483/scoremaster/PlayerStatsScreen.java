package csc483.scoremaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

//Import PlayerStats class

public class PlayerStatsScreen extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_stats_screen);

        //Text View Stuff
        TextView Break = (TextView)findViewById(R.id.OnBreak);
        TextView Run = (TextView)findViewById(R.id.BallAndRun);
        TextView Outofturn = (TextView)findViewById(R.id.OutOfTurn);
        TextView Scratch = (TextView)findViewById(R.id.ScratchOn8);
        TextView Wins = (TextView)findViewById(R.id.MatchWins);
        TextView Played = (TextView)findViewById(R.id.MatchPlayed);
        TextView WinPercent = (TextView)findViewById(R.id.WinPercent);
        TextView Innings = (TextView)findViewById(R.id.AvgInnings);

        //Getting stats info and placing into strings
        //commented out until database works
        //R.string.PlayerStats_Break = String.valueOf(getBreaks());
        //R.string.PlayerStats_Run = String.valueOf(getRuns());
        //R.string.PlayerStats_Outofturn = String.valueOf(getOutofturn());
        //R.string.PlayerStats_Scratch = String.valueOf(getScratchOn8());
        //R.string.PlayerStats_Wins = String.valueOf(getMatchesWon());
        //R.string.PlayerStats_Played = String.valueOf(getMatchesPlayed());
        //R.string.PlayerStats_WinPercent = String.format(calcWinPercent(), percent);
        //R.string.PlayerStats_Innings = String.valueOf(calcAverageInnings());

        //Setting the TextViews
        Break.setText(R.string.PlayerStats_Break);
        Run.setText(R.string.PlayerStats_Run);
        Outofturn.setText(R.string.PlayerStats_Outofturn);
        Scratch.setText(R.string.PlayerStats_Scratch);
        Wins.setText(R.string.PlayerStats_Wins);
        Played.setText(R.string.PlayerStats_Played);
        WinPercent.setText(R.string.PlayerStats_WinPercent);
        Innings.setText(R.string.PlayerStats_Innings);

    }
}
