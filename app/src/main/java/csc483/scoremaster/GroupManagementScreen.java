package csc483.scoremaster;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class GroupManagementScreen extends AppCompatActivity {

    private ProgressDialog progressDialog = null;
    //private ArrayList<m_8BallGroup> groupsArray = null;
    //private GroupAdapter groupAdapter;
    //private Runnable viewGroups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_management_screen);



        //Taylors intent to start joingroup popup
        Button joinGroup = (Button)findViewById(R.id.joinGroupButton);
        joinGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GroupManagementScreen.this, JoinGroup.class));
            }
        });




        //Button gallerybtn = (Button)findViewById(R.id.galleryButton);
        //Button gallerybtn = (Button)findViewById(R.id.galleryButton);

        //startActivity(new Intent(GroupManagementScreen.this, MainMenu.class));
    }

    /*private class GroupAdapter extends ArrayAdapter<m_8BallGroup> {
        private ArrayList<m_8BallGroup> groupList;

        public GroupAdapter(Context context, int textViewResourceId, ArrayList<m_8BallGroup> groupList) {
            super(context, textViewResourceId, groupList);
            this.groupList = groupList;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            View v = convertView;
            if(v==null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.group_row, null);
            }
            m_8BallGroup g = groupList.get(position);
            if(g != null) {
                TextView tt = (TextView) v.findViewById(R.id.groupNameText);
                if(tt != null) {
                    tt.setText(g.getGroupName());
                }
            }
            return v;
        }
    }*/
}

