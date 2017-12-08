package csc483.scoremaster;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.List;

public class GroupsScreen extends AppCompatActivity {

    private Spinner spinner;

	//ArrayList<Players> playerList;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups_screen);
		//final TableLayout playerTableLayout = (TableLayout)findViewById(playerTable);
		
		//init(playerTableLayout);
        addItemsOnSpinner();
        Button startGameButton = (Button)findViewById(R.id.startGameButton);
        startGameButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
				/*ArrayList<Players> finalPlayers;
                //iterate through players and count checks
				for(int i = 0; i <  playerTableLayout.getChildCount() ; i++)
				{
					if()//player is checked
					{
						playersNeeded++;
						//save the player to playerList;
					}
				}
						
				if(playersNeeded == 2)
				{
					finalPlayers.push(playerList[0]);
					finalPlayers.push(playerList[1]);
					Intent scoringScreen = new Intent(this, ScoringScreen.class);
					scoringScreen.putExtra("Players", finalPlayers);
					startActivity(scoringScreen);
				}
				else
				{
					//toast error
				}*/
				Intent scoringScreen = new Intent(GroupsScreen.this, ScoringScreen.class);
                //scoringScreen.putExtra("Players", finalPlayers);
                startActivity(scoringScreen);
            }
        });

		
        //addListenerOnButton();
        //addListenerOnSpinnerItemSelection();
    }

	public void init(TableLayout playerTableLayout)
	{
			int numberOfPlayers = 2; //change this to retrieve array size from group
			TableRow playerRow = new TableRow(this);
			playerRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
			
			CheckedTextView playername = new CheckedTextView(this);
            //playername.setLayoutParams(new TableRow.LayoutParams(dpToPx(120), dpToPx(50)));
            playername.setText("Thing");//change to getPlayerName() when class is done
            playername.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            playername.setBackgroundResource(android.R.drawable.alert_light_frame);
            playername.setTextAppearance(this,R.style.TextAppearance_AppCompat_Body1);
            playername.setTextColor(Color.BLACK);
            playername.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
			
			playerRow.addView(playername);
			playerTableLayout.addView(playerRow);
	}
	
	
    // add items into spinner dynamically
    public void addItemsOnSpinner() {

        spinner = (Spinner) findViewById(R.id.groupsSpinner);
        List<String> list = new ArrayList<String>();
        list.add("list 1"); //change these to retrieve users groups
        list.add("list 2");
        list.add("list 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

//    public void addListenerOnSpinnerItemSelection() {
//        spinner = (Spinner) findViewById(R.id.spinner1);
//        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
//    }
}
