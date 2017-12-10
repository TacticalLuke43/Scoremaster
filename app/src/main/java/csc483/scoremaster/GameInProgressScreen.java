package csc483.scoremaster;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GameInProgressScreen extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    String roomCode = "temp";
    int gameCount = 1;
    TextView textView27;
    TextView textView38;
    TextView textView39;
    TextView textView40;
    TextView matchCodeText;
    CheckBox checkBox3;
    CheckBox checkBox4;
    CheckBox checkBox5;
    CheckBox checkBox6;
    CheckBox checkBox7;
    CheckBox checkBox8;
    CheckBox checkBox9;
    CheckBox checkBox10;
    CheckBox checkBox11;
    CheckBox checkBox12;
    CheckBox checkBox13;
    CheckBox checkBox14;
    CheckBox checkBox15;
    CheckBox checkBox16;
    CheckBox checkBox17;
    CheckBox checkBox18;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    RadioButton radioButton5;
    RadioButton radioButton6;
    CheckBox player18OB;
    CheckBox player28OB;
    CheckBox player18BR;
    CheckBox player28BR;
    CheckBox player18OT;
    CheckBox player28OT;
    CheckBox player1SO8;
    CheckBox player2SO8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_in_progress_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //retrieve the room code
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                roomCode= null;
            } else {
                roomCode= extras.getString("GiveRoomCode");
            }
        } else {
            roomCode= (String) savedInstanceState.getSerializable("GiveRoomCode");
        }




        textView27 = (TextView)findViewById(R.id.textView27);
        textView38 = (TextView)findViewById(R.id.textView38);
        textView39 = (TextView)findViewById(R.id.textView39);
        textView40 = (TextView)findViewById(R.id.textView40);
        player18OB  = (CheckBox)findViewById(R.id.player18OB);
        player28OB  = (CheckBox)findViewById(R.id.player28OB);
        player18BR  = (CheckBox)findViewById(R.id.player18BR);
        player28BR  = (CheckBox)findViewById(R.id.player28BR);
        player18OT  = (CheckBox)findViewById(R.id.player18OT);
        player28OT  = (CheckBox)findViewById(R.id.player28OT);
        player1SO8  = (CheckBox)findViewById(R.id.player1SO8);
        player2SO8  = (CheckBox)findViewById(R.id.player2SO8);
        checkBox3 = (CheckBox)findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox)findViewById(R.id.checkBox4);
        checkBox5 = (CheckBox)findViewById(R.id.checkBox5);
        checkBox6 = (CheckBox)findViewById(R.id.checkBox6);
        checkBox7 = (CheckBox)findViewById(R.id.checkBox7);
        checkBox8 = (CheckBox)findViewById(R.id.checkBox8);
        checkBox9 = (CheckBox)findViewById(R.id.checkBox9);
        checkBox10 = (CheckBox)findViewById(R.id.checkBox10);
        checkBox11 = (CheckBox)findViewById(R.id.checkBox11);
        checkBox12 = (CheckBox)findViewById(R.id.checkBox12);
        checkBox13 = (CheckBox)findViewById(R.id.checkBox13);
        checkBox14 = (CheckBox)findViewById(R.id.checkBox14);
        checkBox15 = (CheckBox)findViewById(R.id.checkBox15);
        checkBox16 = (CheckBox)findViewById(R.id.checkBox16);
        checkBox17 = (CheckBox)findViewById(R.id.checkBox17);
        checkBox18 = (CheckBox)findViewById(R.id.checkBox18);
        radioGroup2 = (RadioGroup)findViewById(R.id.radioGroup2);
        radioGroup3 = (RadioGroup)findViewById(R.id.radioGroup3);
        radioButton1 = (RadioButton)findViewById(R.id.radioPlayer1);
        radioButton2 = (RadioButton)findViewById(R.id.radioPlayer2);
        radioButton3 = (RadioButton)findViewById(R.id.radioButton);
        radioButton4 = (RadioButton)findViewById(R.id.radioButton2);
        radioButton5 = (RadioButton)findViewById(R.id.radioButton3);
        radioButton6 = (RadioButton)findViewById(R.id.radioButton4);
        myRef = database.getInstance().getReference().child("matches").child(roomCode);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Integer value = dataSnapshot.getValue(Integer.class);
                gameCount = value;
                refreshItems();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
        //refreshItems();

        Button refreshBut = (Button)findViewById(R.id.refreshButton);
        refreshBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshItems();
            }
        });
        Button finishBut = (Button)findViewById(R.id.finishButton);
        finishBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GameInProgressScreen.this, PostGameScreen.class));
            }
        });
    }


    public void refreshItems() {
        if(gameCount >= 1) {
            myRef = database.getInstance().getReference().child("matches").child(roomCode).child("game1");
            myRef.child("player18OB").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        player18OB.setChecked(true);
                    else
                        player18OB.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player28OB").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        player28OB.setChecked(true);
                    else
                        player28OB.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player18BR").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        player18BR.setChecked(true);
                    else
                        player18BR.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player28BR").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        player28BR.setChecked(true);
                    else
                        player28BR.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player18OT").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        player18OT.setChecked(true);
                    else
                        player18OT.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player28OT").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        player28OT.setChecked(true);
                    else
                        player28OT.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player1SO8").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        player1SO8.setChecked(true);
                    else
                        player1SO8.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player2SO8").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        player2SO8.setChecked(true);
                    else
                        player2SO8.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player18win").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        radioButton1.setChecked(true);
                    else
                        radioButton1.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player28win").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        radioButton2.setChecked(true);
                    else
                        radioButton2.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
        }
        //end up game1 update


        //start of game2 update
        if(gameCount >= 2) {
            textView27.setVisibility(View.VISIBLE);
            textView38.setVisibility(View.VISIBLE);
            checkBox3.setVisibility(View.VISIBLE);
            checkBox4.setVisibility(View.VISIBLE);
            checkBox5.setVisibility(View.VISIBLE);
            checkBox6.setVisibility(View.VISIBLE);
            checkBox7.setVisibility(View.VISIBLE);
            checkBox8.setVisibility(View.VISIBLE);
            checkBox9.setVisibility(View.VISIBLE);
            checkBox10.setVisibility(View.VISIBLE);
            radioGroup2.setVisibility(View.VISIBLE);
            myRef = database.getInstance().getReference().child("matches").child(roomCode).child("game2");
            myRef.child("player18OB").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        checkBox3.setChecked(true);
                    else
                        checkBox3.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player28OB").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        checkBox4.setChecked(true);
                    else
                        checkBox4.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player18BR").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        checkBox5.setChecked(true);
                    else
                        checkBox5.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player28BR").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        checkBox6.setChecked(true);
                    else
                        checkBox6.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player18OT").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        checkBox7.setChecked(true);
                    else
                        checkBox7.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player28OT").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        checkBox8.setChecked(true);
                    else
                        checkBox8.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player1SO8").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        checkBox9.setChecked(true);
                    else
                        checkBox9.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player2SO8").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        checkBox10.setChecked(true);
                    else
                        checkBox10.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player18win").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        radioButton3.setChecked(true);
                    else
                        radioButton3.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player28win").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        radioButton4.setChecked(true);
                    else
                        radioButton4.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
        }
        //end of game2 update


        //start of game3 update
        if(gameCount >=3)
        {
            textView39.setVisibility(View.VISIBLE);
            textView40.setVisibility(View.VISIBLE);
            checkBox11.setVisibility(View.VISIBLE);
            checkBox12.setVisibility(View.VISIBLE);
            checkBox13.setVisibility(View.VISIBLE);
            checkBox14.setVisibility(View.VISIBLE);
            checkBox15.setVisibility(View.VISIBLE);
            checkBox16.setVisibility(View.VISIBLE);
            checkBox17.setVisibility(View.VISIBLE);
            checkBox18.setVisibility(View.VISIBLE);
            radioGroup3.setVisibility(View.VISIBLE);
            myRef = database.getInstance().getReference().child("matches").child(roomCode).child("game3");
            myRef.child("player18OB").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        checkBox11.setChecked(true);
                    else
                        checkBox11.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player28OB").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        checkBox12.setChecked(true);
                    else
                        checkBox12.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player18BR").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        checkBox13.setChecked(true);
                    else
                        checkBox13.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player28BR").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        checkBox14.setChecked(true);
                    else
                        checkBox14.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player18OT").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        checkBox15.setChecked(true);
                    else
                        checkBox15.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player28OT").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        checkBox16.setChecked(true);
                    else
                        checkBox16.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player1SO8").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        checkBox17.setChecked(true);
                    else
                        checkBox17.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player2SO8").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        checkBox18.setChecked(true);
                    else
                        checkBox18.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player18win").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        radioButton5.setChecked(true);
                    else
                        radioButton5.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
            myRef.child("player28win").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boolean value = dataSnapshot.getValue(Boolean.class);
                    if (value)
                        radioButton6.setChecked(true);
                    else
                        radioButton6.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                }
            });
        }
        //end of game3 updates

    }
}
