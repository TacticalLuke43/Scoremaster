package csc483.scoremaster;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

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

public class GroupManagementScreen extends AppCompatActivity {

    //private ProgressDialog progressDialog = null;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser user;
    ArrayList<String> groupList = new ArrayList<String>();
    List<String> list = new ArrayList<String>();
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_management_screen);



        //Taylors intent to start joingroup popup and createGroup
        Button joinGroup = (Button)findViewById(R.id.joinGroupButton);
        joinGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GroupManagementScreen.this, JoinGroup.class));
            }
        });
        Button createGroup = (Button)findViewById(R.id.createGroupButton);
        createGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GroupManagementScreen.this, CreateGroup.class));
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



        //startActivity(new Intent(GroupManagementScreen.this, MainMenu.class));
    }
    public void addItemsOnSpinner() {
        //groupList.clear();
        //groupList is size 0 here
        list.clear();
        myRef = database.getInstance().getReference().child("groups");
        spinner = (Spinner) findViewById(R.id.spinner);
        list.add("Select a Group");
        for(int i = 0; i < groupList.size() ; i++)
        {
            //read the group names
            myRef.child(groupList.get(i)).child("name").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
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
    }

}

