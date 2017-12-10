package csc483.scoremaster;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ScoringScreen extends AppCompatActivity {
    int gameCount = 1;
    TextView textView27;
    TextView textView38;
    TextView textView39;
    TextView textView40;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);



        Button finishBut = (Button)findViewById(R.id.finishButton);
        finishBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScoringScreen.this, PostGameScreen.class));
            }
        });

        Button nextBut = (Button)findViewById(R.id.nextGameButton);
        textView27 = (TextView)findViewById(R.id.textView27);
        textView38 = (TextView)findViewById(R.id.textView38);
        textView39 = (TextView)findViewById(R.id.textView39);
        textView40 = (TextView)findViewById(R.id.textView40);
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
                    gameCount++;
                }
            }
        });
    }
}
