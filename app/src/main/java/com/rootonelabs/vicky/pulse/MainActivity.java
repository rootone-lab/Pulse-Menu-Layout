package com.rootonelabs.vicky.pulse;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gigamole.library.PulseView;

public class MainActivity extends AppCompatActivity {


    PulseView pulseView;
    Button btnStart, btnStop;
    ImageView gear;
    ImageButton icon1,icon2,icon3,icon4,icon5,icon6;
    int chkClick = 0;
    TextView bottomText;
    ConstraintLayout buttons_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pulseView = (PulseView)findViewById(R.id.pv);
        pulseView.startPulse();
        bottomText = (TextView)findViewById(R.id.bottomText);

        icon1 = (ImageButton)findViewById(R.id.icon1);
        icon2 = (ImageButton)findViewById(R.id.icon2);
        icon3 = (ImageButton)findViewById(R.id.icon3);
        icon4 = (ImageButton)findViewById(R.id.icon4);
        icon5 = (ImageButton)findViewById(R.id.icon5);
        icon6 = (ImageButton)findViewById(R.id.icon6);

        gear = (ImageView)findViewById(R.id.gear);

        buttons_layout = (ConstraintLayout)findViewById(R.id.buttons_layout);

        //buttons_layout.setVisibility(View.GONE);
        buttons_layout.setAlpha(0);
        buttons_layout.setClickable(false);
        buttonOff();

        gear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icon1 = findViewById(R.id.icon1);
                if(chkClick==0)
                {
                    pulseView.animate().alpha(0).setDuration(500);
                    gear.animate().scaleX(1.6f).scaleY(1.6f).setDuration(500);
                    buttons_layout.animate().alpha(1f).setDuration(500);
                    //buttons_layout.setVisibility(View.VISIBLE);
                    buttons_layout.setClickable(true);
                    pulseView.finishPulse();
                    chkClick = 1;
                    bottomText.animate().alpha(0).setDuration(500);
                    buttonOn();

                }else{
                    pulseView.animate().alpha(1f).setDuration(500);
                    buttons_layout.animate().alpha(0).setDuration(500);
                    gear.animate().scaleX(1f).scaleY(1f).setDuration(500);
                    pulseView.startPulse();
                    //buttons_layout.setVisibility(View.GONE);
                    buttons_layout.setClickable(false);
                    bottomText.animate().alpha(1f).setDuration(500);
                    chkClick = 0;
                    buttonOff();
                }

            }
        });

    }

    public void buttonOff()
    {
        icon1.setClickable(false);
        icon2.setClickable(false);
        icon3.setClickable(false);
        icon4.setClickable(false);
        icon5.setClickable(false);
        icon6.setClickable(false);
    }
    public void buttonOn()
    {
        icon1.setClickable(true);
        icon2.setClickable(true);
        icon3.setClickable(true);
        icon4.setClickable(true);
        icon5.setClickable(true);
        icon6.setClickable(true);
    }


    public void buttonPressed(View view){
        switch (view.getId())
        {
            case R.id.icon1:
            {
                Toast.makeText(this, "Event Teaser", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.icon2:
            {
                Toast.makeText(this, "Event Schedule", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.icon3:
            {
                Toast.makeText(this, "Events Going To", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.icon4:
            {
                Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show();
                finish();
                break;
            }
            case R.id.icon5:
            {
                Toast.makeText(this, "Results", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.icon6:
            {
                Toast.makeText(this, "Team Members", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }



}
