package csc483.scoremaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class CreateGroup extends AppCompatActivity {
    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        Button s = (Button)findViewById(R.id.createButton);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String groupName = ((EditText)findViewById(R.id.groupName)).getText().toString();
                //randomly generate group code
                RandomGen gen = new RandomGen(6, ThreadLocalRandom.current());
                String groupID = gen.nextString();
                //gen = group code
                //create group
                myRef = FirebaseDatabase.getInstance().getReference().child("groups").child(groupID);
                myRef.child("name").setValue(groupName);
                myRef.child("playerList").child("player1").setValue("AAA111");
                //add player to group
                myRef = FirebaseDatabase.getInstance().getReference().child("players").child("AAA111");
                myRef.child("groupList").child("3").setValue(groupID);
                finish();
            }
        });
    }
}
