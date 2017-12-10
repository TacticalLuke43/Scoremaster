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
    /*TextView Break = (TextView) findViewById(R.id.OnBreak);
    TextView Run = (TextView) findViewById(R.id.BallAndRun);
    TextView Outofturn = (TextView) findViewById(R.id.OutOfTurn);
    TextView Scratch = (TextView) findViewById(R.id.ScratchOn8);
    TextView Wins = (TextView) findViewById(R.id.MatchWins);
    TextView Played = (TextView) findViewById(R.id.MatchPlayed);
    TextView WinPercent = (TextView) findViewById(R.id.WinPercent);
    TextView Innings = (TextView) findViewById(R.id.AvgInnings);
*/
        //Getting stats info and placing into strings
        //commented out until database works
        //R.string.PlayerStats_Break = String.valueOf(getEightOnBreaks());
        //R.string.PlayerStats_Run = String.valueOf(getEightBreakRuns());
        //R.string.PlayerStats_Outofturn = String.valueOf(getOutofturn());
        //R.string.PlayerStats_Scratch = String.valueOf(getScratchOn8());
        //R.string.PlayerStats_Wins = String.valueOf(getMatchesWon());
        //R.string.PlayerStats_Played = String.valueOf(getMatchesPlayed());
        //R.string.PlayerStats_WinPercent = String.format(calcWinPercent(), percent);
        //R.string.PlayerStats_Innings = String.valueOf(calcAverageInnings());

        //Setting the TextViews
        /*Break.setText("8");
        Run.setText("12");
        Outofturn.setText("2");
        Scratch.setText("4");
        Wins.setText("22");
        Played.setText("52");
        WinPercent.setText("42%");
        Innings.setText("2");*/
}

}
