package csc483.scoremaster;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInScreen extends AppCompatActivity {


    private EditText emailText;
    private EditText passWordText;

    private Button btnLogin;
    private Button btnCreate;

    private ProgressDialog mProgress;

    //firebase

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);

        mAuth = FirebaseAuth.getInstance();

        Button btnCreate = (Button) findViewById(R.id.btnCreate);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogInScreen.this, CreateAccountActivity.class));
            }
        });
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //User is signed in
                    startActivity(new Intent(LogInScreen.this, MainMenu.class));
                } else {
                    //User is signed out
                }
            }
        };
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText emailText = (EditText) findViewById(R.id.emailText);
                EditText passWordText = (EditText) findViewById(R.id.passWordText);

                if (!emailText.getText().toString().equals("") && !passWordText.getText().toString().equals("")) {
                    mAuth.signInWithEmailAndPassword(emailText.getText().toString(), passWordText.getText().toString())
                            .addOnCompleteListener(LogInScreen.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    //If sign in fails, display a message to the user.  If sign in succeeds
                                    //the auth state listener will be notified and logic to handle the
                                    //signed in user can be handled in the listener.
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(LogInScreen.this, "Authentication failed!", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(LogInScreen.this, "Loging in!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(LogInScreen.this, MainMenu.class));
                                    }
                                }
                            });

                } else {
                    Toast.makeText(LogInScreen.this, "Username or password is blank!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public void onStart() {
        super.onStart();
        //Check if User is signed in
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //   updateUI(currentUser);
    }

    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
}}


