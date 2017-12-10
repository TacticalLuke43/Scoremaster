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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.ThreadLocalRandom;

public class ScoringScreen extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser user;

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
        setContentView(R.layout.activity_scoring_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);



        Button finishBut = (Button)findViewById(R.id.finishButton);
        finishBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameCount == 3)
                {
                    myRef = database.getInstance().getReference().child("matches");
                    myRef.child(roomCode).child("game3").child("player18OB").setValue(checkBox11.isChecked());
                    myRef.child(roomCode).child("game3").child("player28OB").setValue(checkBox12.isChecked());
                    myRef.child(roomCode).child("game3").child("player18BR").setValue(checkBox13.isChecked());
                    myRef.child(roomCode).child("game3").child("player28BR").setValue(checkBox14.isChecked());
                    myRef.child(roomCode).child("game3").child("player18OT").setValue(checkBox15.isChecked());
                    myRef.child(roomCode).child("game3").child("player28OT").setValue(checkBox16.isChecked());
                    myRef.child(roomCode).child("game3").child("player1SO8").setValue(checkBox17.isChecked());
                    myRef.child(roomCode).child("game3").child("player2SO8").setValue(checkBox18.isChecked());
                    myRef.child(roomCode).child("game3").child("player18win").setValue(radioButton5.isChecked());
                    myRef.child(roomCode).child("game3").child("player28win").setValue(radioButton6.isChecked());
                    myRef.child(roomCode).child("gameCount").setValue(gameCount);
                }
                startActivity(new Intent(ScoringScreen.this, PostGameScreen.class));
            }
        });
        Button nextBut = (Button)findViewById(R.id.nextGameButton);
        matchCodeText = (TextView)findViewById(R.id.matchCodeText);
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


        RandomGen gen = new RandomGen(6, ThreadLocalRandom.current());
        roomCode = gen.nextString();
        matchCodeText.setText(roomCode);
        myRef = database.getInstance().getReference().child("matches");
        myRef.child(roomCode).child("player1").setValue("AAA111");
        myRef.child(roomCode).child("player2").setValue("AAA112");
        myRef.child(roomCode).child("group").setValue("ABC123");
        myRef.child(roomCode).child("innings").setValue(8);
        myRef.child(roomCode).child("gameCount").setValue(gameCount);


        nextBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameCount == 1)
                {
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
                    myRef = database.getInstance().getReference().child("matches");
                    myRef.child(roomCode).child("game1").child("player18OB").setValue(player18OB.isChecked());
                    myRef.child(roomCode).child("game1").child("player28OB").setValue(player28OB.isChecked());
                    myRef.child(roomCode).child("game1").child("player18BR").setValue(player18BR.isChecked());
                    myRef.child(roomCode).child("game1").child("player28BR").setValue(player28BR.isChecked());
                    myRef.child(roomCode).child("game1").child("player18OT").setValue(player18OT.isChecked());
                    myRef.child(roomCode).child("game1").child("player28OT").setValue(player28OT.isChecked());
                    myRef.child(roomCode).child("game1").child("player1SO8").setValue(player1SO8.isChecked());
                    myRef.child(roomCode).child("game1").child("player2SO8").setValue(player2SO8.isChecked());
                    myRef.child(roomCode).child("game1").child("player18win").setValue(radioButton1.isChecked());
                    myRef.child(roomCode).child("game1").child("player28win").setValue(radioButton2.isChecked());
                    gameCount++;
                }
                else if(gameCount == 2)
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
                    myRef = database.getInstance().getReference().child("matches");
                    myRef.child(roomCode).child("game2").child("player18OB").setValue(checkBox3.isChecked());
                    myRef.child(roomCode).child("game2").child("player28OB").setValue(checkBox4.isChecked());
                    myRef.child(roomCode).child("game2").child("player18BR").setValue(checkBox5.isChecked());
                    myRef.child(roomCode).child("game2").child("player28BR").setValue(checkBox6.isChecked());
                    myRef.child(roomCode).child("game2").child("player18OT").setValue(checkBox7.isChecked());
                    myRef.child(roomCode).child("game2").child("player28OT").setValue(checkBox8.isChecked());
                    myRef.child(roomCode).child("game2").child("player1SO8").setValue(checkBox9.isChecked());
                    myRef.child(roomCode).child("game2").child("player2SO8").setValue(checkBox10.isChecked());
                    myRef.child(roomCode).child("game2").child("player18win").setValue(radioButton3.isChecked());
                    myRef.child(roomCode).child("game2").child("player28win").setValue(radioButton4.isChecked());
                    myRef.child(roomCode).child("gameCount").setValue(gameCount);
                    gameCount++;
                }
            }
        });
    }
}
