package csc483.scoremaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

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

public class StatsMenu extends AppCompatActivity {
    List<String> list = new ArrayList<String>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser user;
    ArrayList<String> groupList = new ArrayList<String>();
    private Spinner spinner;
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

        Button groupStats = (Button) findViewById(R.id.groupStats);
        groupStats.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                startActivity(new Intent(StatsMenu.this, GroupStatsScreen.class));
            }
        });

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
    }

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
}
