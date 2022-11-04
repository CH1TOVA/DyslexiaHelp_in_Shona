package com.example.dyslexiahelpinshona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener{

    Category currentCategory;
    ArrayList<Thing> things;
    private LottieAnimationView lottie;
    private RelativeLayout relativeLayout;
    private RadioButton answer1;
    private RadioButton answer2;
    private RadioButton answer3;
    private Thing thingAnswer;
    private TextView questionTextView;
    private TextView scoreTextView;
    private MediaPlayer mediaPlayer;

    private int score = 0;
    private int questionNumber = 1;

    // if this variable is set, the touch events are not processed (the UI is blocked)
    private boolean stopUserInteractions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();//return the intent that started this activity
        int position = intent.getIntExtra("position", 0);
        currentCategory = MainActivity.categoryList.get(position);
        setTheme(currentCategory.theme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// back button
        getSupportActionBar().setTitle("Mibvunzo");

        things = currentCategory.getListOfThings();
        relativeLayout = findViewById(R.id.quizLayout);
        lottie = findViewById(R.id.quizImage);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        scoreTextView = findViewById(R.id.scoreCounter);
        questionTextView = findViewById(R.id.questionCounter);

        answer1.setOnClickListener(this);
        answer2.setOnClickListener(this);
        answer3.setOnClickListener(this);

        updateResources();
    }
    @Override
    protected void onStop() {
        super.onStop();
        // it is considered good practice to release the Media Player object
        // when the activity is stopped
        releaseMediaPlayer();
    }
    @Override
    protected void onPause() {
        super.onPause();
        // it is considered good practice to release the Media Player object
        // when the activity is paused
        releaseMediaPlayer();
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // it won't process the touch events if this variable is set to true
        if (stopUserInteractions) {
            return true;
        } else {
            return super.dispatchTouchEvent(ev);
        }
    }

    protected void updateResources() {

        // if the quiz has just started
        if (questionNumber == 1) {
            scoreTextView.setText("Zvibodzwa: " + 0);
        } else if (questionNumber > 10) {
            this.finish();
            Highscores.open(this);
            if (Highscores.setHighscore(currentCategory.columnName, score))
                Toast.makeText(this, "Chibodzwa Chihombesa!", Toast.LENGTH_LONG).show();
            Highscores.close();
            return;
        }
        questionTextView.setText("Mubvunzo: " + questionNumber);
        questionNumber++;
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = this.getTheme(); //gets the current Theme

        theme.resolveAttribute(R.attr.colorPrimaryLight, typedValue, true);
        int primaryLightColor = typedValue.data;
        lottie.setBackgroundColor(primaryLightColor);
        relativeLayout.setBackgroundColor(primaryLightColor);

        Random r = new Random();
        Set<Integer> set = new HashSet<>();
        while (set.size() < 3) {
            set.add(r.nextInt(things.size()));
        }
        // three random Thing indexes. e.g., [2, 6, 9] which may represent:
        // [A, E, F]
        Integer[] answers = set.toArray(new Integer[set.size()]);
        // indexes [0, 1 , 2] to randomly fetch the Thing indexes:
        ArrayList<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 2));
        //a random index to set the picture question:
        int index = indexes.get(r.nextInt(indexes.size()));
        thingAnswer = things.get(answers[index]);

        lottie.setVisibility(View.INVISIBLE);
        lottie.setAnimation(thingAnswer.getLottieAnimationView());
        lottie.setVisibility(View.VISIBLE);

        setRandomAnswer(answer1, indexes, answers);
        setRandomAnswer(answer2, indexes, answers);
        setRandomAnswer(answer3, indexes, answers);
    }

    private void setRandomAnswer(RadioButton button, ArrayList<Integer> indexes, Integer[] answers) {
        // params:
        // e.g., indexes = [0, 1, 2]
        // e.g., answers [2, 6, 9]
        Random r = new Random();
        // random index from [0, 1, 2].
        int index = indexes.get(r.nextInt(indexes.size()));
        // e.g., remove the index 1 so it won't appear two times as answer
        indexes.remove(Integer.valueOf(index));
        // indexes = [0, 2]
        button.setText(things.get(answers[index]).getText());
    }


    @Override
    public void onClick(final View v) {
        if (v instanceof RadioButton) {
            if (((RadioButton) v).getText() == thingAnswer.getText()) {
                score++;
                scoreTextView.setText("Score: " + score);
                playSound(true);
            } else {
                playSound(false);
            }
        }
        // block UI so the user is not able to select answer before the new question appears
        stopUserInteractions = true;
        Handler handler = new Handler();
        // wait 2 seconds before going to the next question
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                updateResources();
                if (v instanceof RadioButton)
                    ((RadioButton) v).setChecked(false);
                stopUserInteractions = false; // enable UI again after the next question is displayed
            }
        }, 2000);
//        // lambda expression as a replacement for the Runnable anonymous class
//        handler.postDelayed(() -> updateResources(), 2000);
    }

    /**
     * Plays a random sound effect
     *
     * @param isCorrect true if the answer is correct, false otherwise
     */
    private void playSound(boolean isCorrect) {
        mediaPlayer = MediaPlayer.create(this,
                isCorrect ? randomCorrectSound() : randomWrongSound());
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer player) {
                player.reset();
            }
        });
    }
    /**
     * Populates a list with sound effects for correct answers and chooses
     * one of them randomly
     *
     * @return a randomly chosen sound effect from the list
     */
    private int randomCorrectSound() {
        List<Integer> correctSounds = new ArrayList<>();
        correctSounds.add(R.raw.correct1);
        correctSounds.add(R.raw.correct2);
        correctSounds.add(R.raw.correct3);
        correctSounds.add(R.raw.correct4);
        correctSounds.add(R.raw.correct5);
        Random rand = new Random();

        return correctSounds.get(rand.nextInt(correctSounds.size()));
    }

    /**
     * Populates a list with sound effects for wrong answers and chooses
     * one of them randomly
     *
     * @return a randomly chosen sound effect from the list
     */
    private int randomWrongSound() {
        List<Integer> wrongSounds = new ArrayList<>();
        wrongSounds.add(R.raw.wrong1);
        wrongSounds.add(R.raw.wrong2);
        wrongSounds.add(R.raw.wrong3);
        wrongSounds.add(R.raw.wrong4);
        Random rand = new Random();

        return wrongSounds.get(rand.nextInt(wrongSounds.size()));
    }

    /**
     * Releases the media player (if is not null) and sets it to null
     */
    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}