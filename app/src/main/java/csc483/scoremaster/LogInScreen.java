package csc483.scoremaster;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogInScreen extends AppCompatActivity{

    private EditText txtEmail;
    private EditText txtPass;

    private Button btnLogin;
    private Button btnRegister;

    private ProgressDialog mProgress;

    //firebase


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);
    }
}
