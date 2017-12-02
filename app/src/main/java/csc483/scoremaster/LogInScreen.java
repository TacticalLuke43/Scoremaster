package csc483.scoremaster;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInScreen extends AppCompatActivity{

    private EditText txtEmail;
    private EditText txtPass;

    private Button btnLogin;
    private Button btnCreate;

    private ProgressDialog mProgress;

    //firebase

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);

        mAuth = FirebaseAuth.getInstance();

        Button createaccountbtn = (Button)findViewById(R.id.btnCreate);
        Button loginbtn = (Button)findViewById(R.id.btnLogin);

        createaccountbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogInScreen.this, CreateAccountActivity.class));
            }
        });
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //User is signed in
                    startActivity(new Intent(LogInScreen.this, MainMenu.class));
                }else{
                    //User is signed out
                }
            }
        };
        loginbtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText email = (EditText) findViewById(R.id.emailText);
                EditText password = (EditText) findViewById(R.id.passwordText);
            }
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
    }


}
