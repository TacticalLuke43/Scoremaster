package csc483.scoremaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class CreateGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        Button s = (Button)findViewById(R.id.createButton);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String groupName = ((EditText)findViewById(R.id.groupName)).getText().toString();

                //if groupName is not taken
                if (!Objects.equals(groupName, "something"))//needs to be getGroupList()
                {
                    //create a group with user added

                    finish();
                }
                else
                {
                    //  retry
                    Toast.makeText(CreateGroup.this,
                            "Name Already taken or is invalid, try again", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}
