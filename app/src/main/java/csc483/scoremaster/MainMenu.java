package csc483.scoremaster;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainMenu extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button quickPlayButton = (Button)findViewById(R.id.quickPlayButton);
        Button viewGameButton = (Button)findViewById(R.id.viewGamebutton);
        Button groupPlayButton = (Button)findViewById(R.id.groupPlayButton);
        Button groupManButton = (Button)findViewById(R.id.groupManButton);
        Button statsButton = (Button)findViewById(R.id.statsButton);
        final Button logOutButton = (Button)findViewById(R.id.LogOutbutton);
        mAuth = FirebaseAuth.getInstance();
        quickPlayButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(MainMenu.this, ScoringScreen.class));
            }
        });
        viewGameButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //startActivity(new Intent(MainMenu.this, ScoringScreen.class));
            }
        });
        groupManButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(MainMenu.this, GroupManagementScreen.class));
            }
        });
        groupPlayButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(MainMenu.this, GroupsScreen.class));
            }
        });
        statsButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(MainMenu.this, StatsMenu.class));
            }
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //User is signed in
                    logOutButton.setText("Log Out");
                    logOutButton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            //mAuth.auth().signOut();
                        }
                    });
                } else {
                    //User is signed out
                    logOutButton.setText("Log In");
                    logOutButton.setOnClickListener(new View.OnClickListener()
                    {
                        public void onClick(View v)
                        {

                            startActivity(new Intent(MainMenu.this, LogInScreen.class));
                        }
                    });
                }
            }
        };

    }
}
