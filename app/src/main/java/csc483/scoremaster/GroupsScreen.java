package csc483.scoremaster;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GroupsScreen extends AppCompatActivity {

    private Spinner spinner;
    public static final String MY_PREFS_NAME = "SharedPrefs";
	//ArrayList<Players> playerList;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser user;
    ArrayList<String> groupList = new ArrayList<String>();
    ArrayList<String> groupNameList = new ArrayList<String>();
    List<String> list = new ArrayList<String>();

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups_screen);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
            }
        };

        //groupList.add("ABC123");
        //groupList.add("ABC125");
        //groupList.add("ABC124");
        //myRef.child("players").child("AAA111").child("groupList").setValue(groupList);
		final TableLayout playerTableLayout = (TableLayout)findViewById(R.id.playerTable);

        /*
        *       FIREBASE EXAMPLE STUFFFFFFF
        *       Check out the database on the firebase console to see exactly what this code did
        *
        //FOR WRITING
        //nestle .child("childname") as many times as you need to go deeper
        myRef.child("tests").child("testEntry").setValue("dog"); //writes "dog" to a child
        int snake = 1;
        myRef.child("tests").child("otherTest").setValue(snake); //writes your variable to that child

        //FOR READING
        //Set myRef to whatever level youre after using
        myRef = database.getReference().child("tests");
        myRef.child("testEntry").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class); //set this class to the type of variable youre expecting
                myRef.child("new value").setValue(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });*/


        //end of firebase example stuff


        groupList.clear();

        myRef = database.getInstance().getReference().child("players").child("AAA111");
        myRef.child("groupList").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<ArrayList<String>> t = new GenericTypeIndicator<ArrayList<String>>() {};
                //ArrayList<String> yourStringArray = dataSnapshot.getValue(t);
                groupList = dataSnapshot.getValue(t);
                addItemsOnSpinner();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                groupList.add("I messed up");
            }
        });

        Button playersBut = (Button)findViewById(R.id.updatePlayerButton);
        playersBut.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                init(playerTableLayout);
                spinner = (Spinner) findViewById(R.id.groupsSpinner);
                String selectedGroup = String.valueOf(spinner.getSelectedItem());
                if(selectedGroup.equals("Friday League"))
                {

                }

            }
        });
        Button startGameButton = (Button)findViewById(R.id.startGameButton);
        startGameButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {/*
				ArrayList<String> finalPlayers;
				int playersNeeded = 0;
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
					finalPlayers.add(playerList[0]);
					finalPlayers.add(playerList[1]);
					Intent scoringScreen = new Intent(GroupsScreen.this, ScoringScreen.class);
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
			int numberOfPlayers = 4; //change this to retrieve array size from group

        playerTableLayout.removeAllViews();
        for (int i=0; i<numberOfPlayers; i++) {
            TableRow playerRow = new TableRow(this);
            playerRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            CheckBox playername = new CheckBox(this);
            playername.setLayoutParams(new TableRow.LayoutParams(800, 150));
            playername.setText("TestPlayer"+Integer.toString(i));//change to getPlayerName() when class is done
            //playername.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            playername.setTextAppearance(this, R.style.TextAppearance_AppCompat_Body1);
            //playername.setTextColor(Color.BLACK);
            playername.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

            playerRow.addView(playername);
            playerTableLayout.addView(playerRow);
        }
	}
	
	
    // add items into spinner dynamically
    public void addItemsOnSpinner() {
        //groupList.clear();
        //groupList is size 0 here
        list.clear();
        myRef = database.getInstance().getReference().child("groups");
        spinner = (Spinner) findViewById(R.id.groupsSpinner);
        list.add("Select a Group");
        for(int i = 0; i < groupList.size() ; i++)
        {
            //read the group names
            myRef.child(groupList.get(i)).child("name").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    String value = dataSnapshot.getValue(String.class); //set this class to the type of variable youre expecting
                    list.add(value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });


        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        //spinner.setBackgroundColor(Color.BLACK);
    }

//    public void addListenerOnSpinnerItemSelection() {
//        spinner = (Spinner) findViewById(R.id.spinner1);
//        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
//    }
}
