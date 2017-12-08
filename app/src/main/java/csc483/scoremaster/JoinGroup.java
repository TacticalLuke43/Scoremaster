package csc483.scoremaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class JoinGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_group);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width * 0.8), (int)(height * 0.8));

        Button c = (Button)findViewById(R.id.cancelButton);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button s = (Button)findViewById(R.id.submitButton);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String groupCode = ((EditText)findViewById(R.id.groupCode)).getText().toString();

                //if groupCode is a correct code
                if (Objects.equals(groupCode, "something"))
                {
                    //needs code to add user to group based on the code accepted

                    finish();
                }
                else
                {
                    // display some sort of error message to retype correct group code
                }


            }
        });
    }
}
