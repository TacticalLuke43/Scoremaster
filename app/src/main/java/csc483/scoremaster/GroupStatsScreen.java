package csc483.scoremaster;

import android.content.pm.ActivityInfo;
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


    TableLayout groupTable = (TableLayout)findViewById(R.id.groupStatTable);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_stats_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // replace placeholder 2 with getnumplayers() to get the number of players in the group
        int numberOfPlayers = 2;

        //loops through the players and dynamically creates new table rows for them
        //will likely need to change this depending on how we are storing data/what the group class looks like
        for (int i=0; i<numberOfPlayers; i++)
        {
            TableRow rowThing = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            rowThing.setLayoutParams(lp);

            TextView playername = new TextView(this);
            playername.setLayoutParams(new TableLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
            playername.setText("Thing");//change to getPlayerName() when class is done
            playername.setBackground(Drawable.createFromPath("@android:drawable/alert_light_frame"));
            playername.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);

            TextView avgInning = new TextView(this);
            avgInning.setLayoutParams(new TableLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
            avgInning.setText("0");//change to getAvgInning() when class is done
            avgInning.setBackground(Drawable.createFromPath("@android:drawable/alert_light_frame"));
            avgInning.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            avgInning.setGravity(View.TEXT_ALIGNMENT_CENTER);

            TextView matchWin = new TextView(this);
            matchWin.setLayoutParams(new TableLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
            matchWin.setText("0");//change to getMatchWins() when class is done
            matchWin.setBackground(Drawable.createFromPath("@android:drawable/alert_light_frame"));
            matchWin.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            matchWin.setGravity(View.TEXT_ALIGNMENT_CENTER);

            TextView matchPlayed = new TextView(this);
            matchPlayed.setLayoutParams(new TableLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
            matchPlayed.setText("0");//change to getMatchesPlayed() when class is done
            matchPlayed.setBackground(Drawable.createFromPath("@android:drawable/alert_light_frame"));
            matchPlayed.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            matchPlayed.setGravity(View.TEXT_ALIGNMENT_CENTER);

            TextView winPercent = new TextView(this);
            winPercent.setLayoutParams(new TableLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
            winPercent.setText("0%");//change to getWinPercentage() when class is done
            winPercent.setBackground(Drawable.createFromPath("@android:drawable/alert_light_frame"));
            winPercent.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            winPercent.setGravity(View.TEXT_ALIGNMENT_CENTER);

            rowThing.addView(playername);
            rowThing.addView(avgInning);
            rowThing.addView(matchWin);
            rowThing.addView(matchPlayed);
            rowThing.addView(winPercent);
            groupTable.addView(rowThing, i);

        }

    }
}
