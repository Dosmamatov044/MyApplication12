package com.example.myapplication;




import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Random Random;
    private SeekBar seekBar;
    private Button button;
    private int progress, randomNumber,score = 0;
    private TextView scoreTextView, progressTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random = new Random();
        seekBar = findViewById(R.id.seek_bar);
        button = findViewById(R.id.image_button);
        scoreTextView = findViewById(R.id.score);
        progressTextView = findViewById(R.id.number);
        randomNumber = getRandomNumber();
        progress = seekBar.getProgress();
        setProgress();
    }

    private void setProgress() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                progressTextView.setText(String.valueOf(progress));



            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });
    }

    private void setScore(int points) {
        score +=points;


        scoreTextView.setText("Score:" + score);

    }



    private Integer getRandomNumber() {
        return Random.nextInt(100) + 1;
    }

    public void onClick(View view) {
        startGame();
    }

    private void startGame() {
            randomNumber = getRandomNumber();
            progress = seekBar.getProgress();
            int change = Math.abs(progress - randomNumber);
            if (change == 0){
                setScore(100);
                Toast.makeText(this,"невероятно!!! ты получил опять бонус " + randomNumber,Toast.LENGTH_LONG).show() ;
            }else if (change < 10){
                setScore(50);
                Toast.makeText(this,"хорошая работа!!! ты получил бонус " + randomNumber,Toast.LENGTH_LONG).show();
            }else if (change > 10 && change < 20 ){
                setScore(50);
                Toast.makeText(this,"не плохо!!!получен бонус "+ randomNumber,Toast.LENGTH_LONG).show();
            }else if (change > 30){
                setScore(-50);
                Toast.makeText(this,"Вы проиграли!!! " + randomNumber,Toast.LENGTH_LONG).show();
            }

    }

}
