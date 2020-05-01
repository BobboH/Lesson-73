package com.example.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btnRoll = findViewById(R.id.btnRollTheDice);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);
        final ImageView diceImage1 = findViewById(R.id.imgDice1);
        final ImageView diceImage2 = findViewById(R.id.imgDice2);
        final int [] diceImages ={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
    btnRoll.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Log.i("MyDiceApp", "Button was Tapped");
        Random rndObject = new Random();
        int myRandomInt = rndObject.nextInt(6);
        Log.i("MyDiceApp",myRandomInt + "");
        diceImage1.setImageResource(diceImages[myRandomInt]);
        myRandomInt = rndObject.nextInt(6);
        diceImage2.setImageResource(diceImages[myRandomInt]);
       // btnRoll.setText(myRandomInt + "");
        YoYo.with(Techniques.Shake)
                .duration(400)
                .repeat(0)
                .playOn(diceImage1);
        YoYo.with(Techniques.Shake)
                .duration(400)
                .repeat(0)
                .playOn(diceImage2);
        mp.start();
    }
});
    }
}
