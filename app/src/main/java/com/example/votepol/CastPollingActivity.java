package com.example.votepol;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class CastPollingActivity extends AppCompatActivity {

    SeekBar seekBar1, seekBar2, seekBar3, seekBar4;
    TextView tvoption1, tvoption2, tvoption3, tvoption4;
    TextView tvpercent1, tvpercent2, tvpercent3, tvpercent4;
    double count1=1, count2=1, count3=1, count4=1;
    boolean flag1 = true, flag2 = true, flag3=true, flag4=true;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cast_polling);

        seekBar1 = findViewById(R.id.seekbar1);
        seekBar2 = findViewById(R.id.seekbar2);
        seekBar3 = findViewById(R.id.seekbar3);
        seekBar4 = findViewById(R.id.seekbar4);

        tvoption1 = findViewById(R.id.option1);
        tvoption2 = findViewById(R.id.option2);
        tvoption3 = findViewById(R.id.option3);
        tvoption4 = findViewById(R.id.option4);

        tvpercent1 = findViewById(R.id.percent1);
        tvpercent2 = findViewById(R.id.percent2);
        tvpercent3 = findViewById(R.id.percent3);
        tvpercent4 = findViewById(R.id.percent4);

        seekBar1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        tvoption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag1) {
                    //When flag 1 is true
                    count1++;
                    count2 = 1;
                    count3 = 1;
                    count4 = 1;
                    flag1 =false;
                    flag2 =true;
                    flag3 =true;
                    flag4 =true;
                    //Calculate Percentage
                    calculatePercent();
                }
                }
            });

        seekBar2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        tvoption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag2) {
                    //When flag 2 is true
                    count1 = 1;
                    count2++;
                    count3 = 1;
                    count4 = 1;
                    flag1 =true;
                    flag2 =false;
                    flag3 =true;
                    flag4 =true;
                    //Calculate Percentage
                    calculatePercent();
                }
            }
        });

        seekBar3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        tvoption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag3) {
                    //When flag 3 is true
                    count1 = 1;
                    count2 = 1;
                    count3++;
                    count4 = 1;
                    flag1 =true;
                    flag2 =true;
                    flag3 =false;
                    flag4 =true;
                    //Calculate Percentage
                    calculatePercent();
                }
            }
        });

        seekBar4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        tvoption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag4) {
                    //When flag 4 is true
                    count1 = 1;
                    count2 = 1;
                    count3 = 1;
                    count4++;
                    flag1 =true;
                    flag2 =true;
                    flag3 =true;
                    flag4 =false;
                    //Calculate Percentage
                    calculatePercent();
                }
            }
        });
        }

    private void calculatePercent() {
        //Calculate total
        double total =count1+count2+count3+count4;
        //Calculate percentage
        double percent1 = (count1/total)*100;
        double percent2 = (count2/total)*100;
        double percent3 = (count3/total)*100;
        double percent4 = (count4/total)*100;
        //Set percent on textview
        tvpercent1.setText(String.format("%.0f%%",percent1));
        //Set progress on SeekBar
        seekBar1.setProgress((int)percent1);
        tvpercent2.setText(String.format("%.0f%%",percent2));
        seekBar2.setProgress((int)percent2);
        tvpercent3.setText(String.format("%.0f%%",percent3));
        seekBar3.setProgress((int)percent3);
        tvpercent4.setText(String.format("%.0f%%",percent4));
        seekBar4.setProgress((int)percent4);
    };
}