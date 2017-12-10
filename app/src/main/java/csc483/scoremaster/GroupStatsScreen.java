package csc483.scoremaster;

import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.media.RatingCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

//import GroupStats class

public class GroupStatsScreen extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_stats_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //TableLayout groupTable = (TableLayout)findViewById(R.id.groupStatTable);

        //init(groupTable);

    }
    public static int dpToPx(int dp)
    {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }


    public void init(TableLayout groupTable)
    {


        // replace placeholder 2 with getnumplayers() to get the number of players in the group
        int numberOfPlayers = 8;

        //loops through the players and dynamically creates new table rows for them
        //will likely need to change this depending on how we are storing data/what the group class looks like
        for (int i=0; i<numberOfPlayers; i++)
        {
            TableRow rowThing = new TableRow(this);
            rowThing.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

            TextView playername = new TextView(this);
            playername.setLayoutParams(new TableRow.LayoutParams(dpToPx(120), dpToPx(50)));
            playername.setText("Thing");//change to getPlayerName() when class is done
            playername.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            playername.setBackgroundResource(android.R.drawable.alert_light_frame);
            playername.setTextAppearance(this,R.style.TextAppearance_AppCompat_Body1);
            playername.setTextColor(Color.BLACK);
            playername.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);


            TextView avgInning = new TextView(this);
            avgInning.setLayoutParams(new TableRow.LayoutParams(dpToPx(100), dpToPx(50)));
            avgInning.setText("0");//change to getAvgInning() when class is done
            avgInning.setBackgroundResource(android.R.drawable.alert_light_frame);
            avgInning.setTextAppearance(this,R.style.TextAppearance_AppCompat_Body1);
            avgInning.setTextColor(Color.BLACK);
            avgInning.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            avgInning.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            TextView matchWin = new TextView(this);
            matchWin.setLayoutParams(new TableRow.LayoutParams(dpToPx(100), dpToPx(50)));
            matchWin.setText("0");//change to getMatchWins() when class is done
            matchWin.setBackgroundResource(android.R.drawable.alert_light_frame);
            matchWin.setTextAppearance(this,R.style.TextAppearance_AppCompat_Body1);
            matchWin.setTextColor(Color.BLACK);
            matchWin.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            matchWin.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            TextView matchPlayed = new TextView(this);
            matchPlayed.setLayoutParams(new TableRow.LayoutParams(dpToPx(100), dpToPx(50)));
            matchPlayed.setText("0");//change to getMatchesPlayed() when class is done
            matchPlayed.setBackgroundResource(android.R.drawable.alert_light_frame);
            matchPlayed.setTextAppearance(this,R.style.TextAppearance_AppCompat_Body1);
            matchPlayed.setTextColor(Color.BLACK);
            matchPlayed.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            matchPlayed.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            TextView winPercent = new TextView(this);
            winPercent.setLayoutParams(new TableRow.LayoutParams(dpToPx(100), dpToPx(50)));
            winPercent.setText("0%");//change to getWinPercentage() when class is done
            winPercent.setBackgroundResource(android.R.drawable.alert_light_frame);
            winPercent.setTextAppearance(this,R.style.TextAppearance_AppCompat_Body1);
            winPercent.setTextColor(Color.BLACK);
            winPercent.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            winPercent.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            TextView breaks = new TextView(this);
            breaks.setLayoutParams(new TableRow.LayoutParams(dpToPx(100), dpToPx(50)));
            breaks.setText("0");//change to getBreaks() when class is done
            breaks.setBackgroundResource(android.R.drawable.alert_light_frame);
            breaks.setTextAppearance(this,R.style.TextAppearance_AppCompat_Body1);
            breaks.setTextColor(Color.BLACK);
            breaks.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            breaks.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            TextView runs = new TextView(this);
            runs.setLayoutParams(new TableRow.LayoutParams(dpToPx(100), dpToPx(50)));
            runs.setText("0");//change to getRuns() when class is done
            runs.setBackgroundResource(android.R.drawable.alert_light_frame);
            runs.setTextAppearance(this,R.style.TextAppearance_AppCompat_Body1);
            runs.setTextColor(Color.BLACK);
            runs.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            runs.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            TextView outOfTurn = new TextView(this);
            outOfTurn.setLayoutParams(new TableRow.LayoutParams(dpToPx(100), dpToPx(50)));
            outOfTurn.setText("0");//change to getOutOfTurns() when class is done
            outOfTurn.setBackgroundResource(android.R.drawable.alert_light_frame);
            outOfTurn.setTextAppearance(this,R.style.TextAppearance_AppCompat_Body1);
            outOfTurn.setTextColor(Color.BLACK);
            outOfTurn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            outOfTurn.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            TextView scratchOn8 = new TextView(this);
            scratchOn8.setLayoutParams(new TableRow.LayoutParams(dpToPx(100), dpToPx(50)));
            scratchOn8.setText("0");//change to getScratchOn8s() when class is done
            scratchOn8.setBackgroundResource(android.R.drawable.alert_light_frame);
            scratchOn8.setTextAppearance(this,R.style.TextAppearance_AppCompat_Body1);
            scratchOn8.setTextColor(Color.BLACK);
            scratchOn8.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            scratchOn8.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            rowThing.addView(playername);
            rowThing.addView(avgInning);
            rowThing.addView(matchWin);
            rowThing.addView(matchPlayed);
            rowThing.addView(winPercent);
            rowThing.addView(breaks);
            rowThing.addView(runs);
            rowThing.addView(outOfTurn);
            rowThing.addView(scratchOn8);
            groupTable.addView(rowThing);
        }

    }
}