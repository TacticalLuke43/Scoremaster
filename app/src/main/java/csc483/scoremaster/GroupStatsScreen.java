package csc483.scoremaster;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
        TableLayout groupTable = (TableLayout)findViewById(R.id.groupStatTable);
        //isnt adding rows for some reason, will look at it again tomorrow
        init(groupTable);

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
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            rowThing.setLayoutParams(lp);

            TextView playername = new TextView(this);
            playername.setLayoutParams(new TableLayout.LayoutParams(120, 50));
            playername.setText("Thing");//change to getPlayerName() when class is done
            playername.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            playername.setBackground(Drawable.createFromPath("@android:drawable/alert_light_frame"));
            playername.setTextColor(Color.BLACK);
            playername.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            rowThing.addView(playername);

            TextView avgInning = new TextView(this);
            avgInning.setLayoutParams(new TableLayout.LayoutParams(100, 50));
            avgInning.setText("0");//change to getAvgInning() when class is done
            avgInning.setBackground(Drawable.createFromPath("@android:drawable/alert_light_frame"));
            avgInning.setTextColor(Color.BLACK);
            avgInning.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            avgInning.setGravity(View.TEXT_ALIGNMENT_CENTER);

            TextView matchWin = new TextView(this);
            matchWin.setLayoutParams(new TableLayout.LayoutParams(100, 50));
            matchWin.setText("0");//change to getMatchWins() when class is done
            matchWin.setBackground(Drawable.createFromPath("@android:drawable/alert_light_frame"));
            matchWin.setTextColor(Color.BLACK);
            matchWin.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            matchWin.setGravity(View.TEXT_ALIGNMENT_CENTER);

            TextView matchPlayed = new TextView(this);
            matchPlayed.setLayoutParams(new TableLayout.LayoutParams(100, 50));
            matchPlayed.setText("0");//change to getMatchesPlayed() when class is done
            matchPlayed.setBackground(Drawable.createFromPath("@android:drawable/alert_light_frame"));
            matchPlayed.setTextColor(Color.BLACK);
            matchPlayed.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            matchPlayed.setGravity(View.TEXT_ALIGNMENT_CENTER);

            TextView winPercent = new TextView(this);
            winPercent.setLayoutParams(new TableLayout.LayoutParams(100, 50));
            winPercent.setText("0%");//change to getWinPercentage() when class is done
            winPercent.setBackground(Drawable.createFromPath("@android:drawable/alert_light_frame"));
            winPercent.setTextColor(Color.BLACK);
            winPercent.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            winPercent.setGravity(View.TEXT_ALIGNMENT_CENTER);

            TextView breaks = new TextView(this);
            breaks.setLayoutParams(new TableLayout.LayoutParams(100, 50));
            breaks.setText("0%");//change to getWinPercentage() when class is done
            breaks.setBackground(Drawable.createFromPath("@android:drawable/alert_light_frame"));
            breaks.setTextColor(Color.BLACK);
            breaks.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            breaks.setGravity(View.TEXT_ALIGNMENT_CENTER);

            TextView runs = new TextView(this);
            runs.setLayoutParams(new TableLayout.LayoutParams(100, 50));
            runs.setText("0%");//change to getWinPercentage() when class is done
            runs.setBackground(Drawable.createFromPath("@android:drawable/alert_light_frame"));
            runs.setTextColor(Color.BLACK);
            runs.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            runs.setGravity(View.TEXT_ALIGNMENT_CENTER);

            TextView outOfTurn = new TextView(this);
            outOfTurn.setLayoutParams(new TableLayout.LayoutParams(100, 50));
            outOfTurn.setText("0%");//change to getWinPercentage() when class is done
            outOfTurn.setBackground(Drawable.createFromPath("@android:drawable/alert_light_frame"));
            outOfTurn.setTextColor(Color.BLACK);
            outOfTurn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            outOfTurn.setGravity(View.TEXT_ALIGNMENT_CENTER);

            TextView scratchOn8 = new TextView(this);
            scratchOn8.setLayoutParams(new TableLayout.LayoutParams(100, 50));
            scratchOn8.setText("0%");//change to getWinPercentage() when class is done
            scratchOn8.setBackground(Drawable.createFromPath("@android:drawable/alert_light_frame"));
            scratchOn8.setTextColor(Color.BLACK);
            scratchOn8.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            scratchOn8.setGravity(View.TEXT_ALIGNMENT_CENTER);

            //rowThing.addView(playername);
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