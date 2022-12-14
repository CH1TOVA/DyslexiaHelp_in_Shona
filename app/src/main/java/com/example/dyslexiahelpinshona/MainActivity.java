package com.example.dyslexiahelpinshona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView learn, quiz, puzzle;

    long TIME_INTERVAL=2000;
    long backpress=0;

    @Override
    public void onBackPressed() {
        if (backpress + TIME_INTERVAL > System.currentTimeMillis())
        {
            super.onBackPressed();
            finish();
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory( Intent.CATEGORY_HOME );
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
        }

        else { Toast.makeText(getBaseContext(), "Dzvanya zvekare kuti uvhare!", Toast.LENGTH_SHORT).show(); } //press back again to exit

        backpress = System.currentTimeMillis();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.pink_them));

        learn = findViewById(R.id.learn_card);
        quiz = findViewById(R.id.quiz_card);
        puzzle = findViewById(R.id.puzzle_card);

        learn.setOnClickListener(this);
        quiz.setOnClickListener(this);
        puzzle.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.learn_card:
                intent = new Intent(this, LearnCategoriesActivity.class);
                startActivity(intent);
                break;

            case R.id.quiz_card:
                intent= new Intent(this, QuizCategoriesActivity.class);
                startActivity(intent);
                break;

            case R.id.puzzle_card:
                intent= new Intent(this, PuzzleImagesActivity.class);
                startActivity(intent);
                break;

        }

    }
}