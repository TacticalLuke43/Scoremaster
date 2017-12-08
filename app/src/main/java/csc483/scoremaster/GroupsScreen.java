package csc483.scoremaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class GroupsScreen extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups_screen);

        Button startGameButton = (Button)findViewById(R.id.startGameButton);
        startGameButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(GroupsScreen.this, ScoringScreen.class));
            }
        });

		
		TableLayout playersTableLayout = (TableLayout)findViewById(playerTable);
		
		init(playerTableLayout);
        addItemsOnSpinner();
        //addListenerOnButton();
        //addListenerOnSpinnerItemSelection();
    }

	public void init(TableLayout playerTableLayout)
	{
			int numberOfPlayers = 2; //change this to retrieve array size from group
			TableRow playerRow = new TableRow(this);
			gameRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
			
			CheckedTextView playername = new TextView(this);
            playername.setLayoutParams(new TableRow.LayoutParams(dpToPx(120), dpToPx(50)));
            playername.setText("Thing");//change to getPlayerName() when class is done
            playername.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            playername.setBackgroundResource(android.R.drawable.alert_light_frame);
            playername.setTextAppearance(this,R.style.TextAppearance_AppCompat_Body1);
            playername.setTextColor(Color.BLACK);
            playername.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
			
			playerRow.addView(playername);
			gamesTableLayout.addView(playerRow);
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
