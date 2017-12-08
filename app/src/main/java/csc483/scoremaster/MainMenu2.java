package csc483.scoremaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainMenu2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu2);

        Button quickPlayButton = (Button)findViewById(R.id.quickPlayButton);
        Button viewGameButton = (Button)findViewById(R.id.viewGamebutton);
        Button loginButton = (Button)findViewById(R.id.Loginbutton);

        quickPlayButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(MainMenu2.this, ScoringScreen.class));
            }
        });
        viewGameButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity(new Intent(MainMenu2.this, ScoringScreen.class));
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(MainMenu2.this, "Redirecting to Log in Screen!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainMenu2.this, LogInScreen.class));
            }
        });
    }
}
