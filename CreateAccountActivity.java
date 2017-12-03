package csc483.scoremaster;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateAccountActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //User is signed in
                    Log.d("SignIn", "onAuthStateChanged:signed_in:" + user.getUid());
                }else {
                    //User is signed out
                    Log.d("SignIn", "onAuthStateChanged:signed_out");
                }
            }
        };

        final EditText email = (EditText) findViewById(R.id.emailText);
        final EditText password = (EditText) findViewById(R.id.passWordText);

        mAuth = FirebaseAuth.getInstance();

        //Placeholder intent until DB works
        Button createAccountButton = (Button) findViewById(R.id.CreateAccountButton);

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (password.getText() == null || email.getText() == null) {
                    Toast.makeText(CreateAccountActivity.this, "Please enter valid username and password!", Toast.LENGTH_LONG).show();
                } else {
                    mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(CreateAccountActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.d("Create", "createUserWithEmail:onComplete:" + task.isSuccessful());

                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.
                            if (!task.isSuccessful()) {
                                Toast.makeText(CreateAccountActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            } else {
                                DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference();
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                startActivity(new Intent(CreateAccountActivity.this, LogInScreen.class));
                            }
                        }
                    });
                }
            }
        });
    }}