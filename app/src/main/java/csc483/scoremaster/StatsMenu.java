package csc483.scoremaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StatsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_menu);

        Button statsButton = (Button) findViewById(R.id.personalStats);
        statsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(StatsMenu.this, PlayerStatsScreen.class));
            }
        });


        Button personalHistory = (Button) findViewById(R.id.personalHistory);
        personalHistory.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                startActivity(new Intent(StatsMenu.this, GameHistoryScreen.class));
            }
        });


        Button groupStats = (Button) findViewById(R.id.groupStats);
        groupStats.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                startActivity(new Intent(StatsMenu.this, GroupStatsScreen.class));
            }
        });


        Button groupGameHistory = (Button) findViewById(R.id.groupGameHistory);
        groupGameHistory.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                startActivity(new Intent(StatsMenu.this, GroupStatsScreen.class));
            }
        });
    }
}
