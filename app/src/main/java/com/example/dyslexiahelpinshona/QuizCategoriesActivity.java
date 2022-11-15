package com.example.dyslexiahelpinshona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Objects;

public class QuizCategoriesActivity extends AppCompatActivity implements RecyclerViewInterface {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    public static ArrayList<QuizCategories> quizCategoriesList;
    QuizAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_categories);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);// back button
        getSupportActionBar().setTitle("Mibvunzo");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.pink_them)));
        getWindow().setStatusBarColor(ContextCompat.getColor(QuizCategoriesActivity.this,R.color.pink_them));

        quizCategoriesList = new ArrayList<>();
        populateCategoriesList();
        initRecyclerView();

    }

    @Override
    public boolean onSupportNavigateUp() {
        // closes the Activity when the back button on the action bar is pressed
        finish();
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateHighscores();
    }


    private void populateCategoriesList() {
        Highscores.open(this);
        QuizCategories alphabetQuizCategories = new QuizCategories("Arufabheti",
                R.drawable.alphabet_quiz,
                Highscores.getHighscore(MySQLiteHelper.COLUMN_ALPHABET),
                R.style.GreenTheme,
                MySQLiteHelper.COLUMN_ALPHABET);
        QuizCategories numbersQuizCategories = new QuizCategories("Nhamba",
                R.drawable.numbers_quiz,
                Highscores.getHighscore(MySQLiteHelper.COLUMN_NUMBERS),
                R.style.BlueTheme,
                MySQLiteHelper.COLUMN_NUMBERS);
        QuizCategories verbQuizCategories = new QuizCategories("Chiito",
                R.drawable.verb_quiz,
                Highscores.getHighscore(MySQLiteHelper.COLUMN_VERBS),
                R.style.PurpleTheme,
                MySQLiteHelper.COLUMN_VERBS);
        QuizCategories animalsQuizCategories = new QuizCategories("Mhuka",
                R.drawable.quiz_animals,
                Highscores.getHighscore(MySQLiteHelper.COLUMN_ANIMALS),
                R.style.GreenTheme,
                MySQLiteHelper.COLUMN_ANIMALS);
        QuizCategories professionQuizCategories = new QuizCategories("Mabasa",
                R.drawable.quiz_professions,
                Highscores.getHighscore(MySQLiteHelper.COLUMN_PROFESSIONS),
                R.style.PinkTheme,
                MySQLiteHelper.COLUMN_PROFESSIONS);
        QuizCategories colorQuizCategories = new QuizCategories("Ruvara",
                R.drawable.quiz_colors,
                Highscores.getHighscore(MySQLiteHelper.COLUMN_COLORS),
                R.style.BlueTheme,
                MySQLiteHelper.COLUMN_COLORS);
        QuizCategories relationsQuizCategories = new QuizCategories("Hukama",
                R.drawable.relations_quiz,
                Highscores.getHighscore(MySQLiteHelper.COLUMN_RELATIONS),
                R.style.PurpleTheme,
                MySQLiteHelper.COLUMN_RELATIONS);
        Highscores.close();

        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabt_a, "[a]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_b, "[ɓ]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_c, "[t͡ʃ]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_d, "[ɗ]" ));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_e,  "[e]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_f, "[f]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_g, "[ɡ̤]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_h, "[ɦ]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_i, "[i]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_j, "[d͡ʒ̤]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_k, "[k]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_m, "[m]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_n, "[n]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_o, "[o]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_p, "[p]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_r,  "[r]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_s, "[s]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_t,  "[t]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_u,  "[u]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_v, "[ʋ]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_w, "[w]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_y, "[j]"));
        alphabetQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.alphabet_z, "[z̤]"));

        numbersQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.number_1pr, "potsi"));
        numbersQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.number_2, "piri"));
        numbersQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.number_3,"tatu" ));
        numbersQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.number_4,"ina"));
        numbersQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.number_5, "shanu"));
        numbersQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.number_6, "tanhatu"));
        numbersQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.number_7, "nomwe"));
        numbersQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.number_8, "sere"));
        numbersQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.number_9, "pfumbamwe"));
        numbersQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.number_10,  "gumi"));



        verbQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.running_boy, "mhanya"));
        verbQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.jumping, "svetuka"));
        verbQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.walk, "famba"));
        verbQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.morty_cry, "chema"));
        verbQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.swimming,  "dhidha"));
        verbQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.skipping, "tomhuka"));
        verbQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.drinking, "kumwa"));
        verbQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.playing_music, "ridza"));
        verbQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.paint, "penda"));
        verbQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.writing, "nyora"));
        verbQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.cycling, "chovha"));
        verbQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.carry, "takura"));
        verbQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.dance, "tamba"));
        verbQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.applause, "uchira"));

        animalsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.cow,  "mombe"));
        animalsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.toucan_bird, "shiri"));
        animalsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.lion, "shumba"));
        animalsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.bat, "chiremwa"));
        animalsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.bulldog, "imbwa"));
        animalsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.butterfly,  "shavishavi"));
        animalsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.cat, "kitsi"));
        animalsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.chicken,  "huku"));
        animalsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.crocodile, "garwe"));
        animalsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.dance_monkey, "tsoko"));
        animalsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.duck, "dhadha"));
        animalsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.elephant,  "nzou"));
        animalsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.fish,  "hove"));
        animalsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.horse, "bhiza"));
        animalsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.pig, "nguruve"));
        animalsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.rabbit, "tsuro"));
        animalsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.frog, "datya"));


        professionQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.doctor, "chiremba"));
        professionQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.pilot,  "mutyairi"));
        professionQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.fishermen, "murauri"));
        professionQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.teacher,  "mudzidzisi"));
        professionQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.chef, "mubiki"));
        professionQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.cut,  "muvezi"));
        professionQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.playing_music, "muimbi"));

        colorQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.black_fluid, "tema"));
        colorQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.yellow_fluid, "yero"));
        colorQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.red_fluid,  "tsvuku"));
        colorQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.white_fluid, "chena"));
        colorQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.green_fluid, "girinhi"));
        colorQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.brown_fluid,  "bhurawuni"));
        colorQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.grey_fluid,  "gireyi"));
        colorQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.purple_fluid,  "pepuru"));


        relationsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.family,  "mhuri"));
        relationsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.mother_baby, "amai nemwana"));
        relationsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.grandmother,  "mbuya"));
        relationsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.granddad, "sekuru"));
        relationsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.father_children, "baba nevana"));
        relationsQuizCategories.addQuizQuestion(new QuizQuestion(R.raw.children, "vana"));



        quizCategoriesList.add(alphabetQuizCategories);
        quizCategoriesList.add(numbersQuizCategories);
        quizCategoriesList.add(verbQuizCategories);
        quizCategoriesList.add(animalsQuizCategories);
        quizCategoriesList.add(professionQuizCategories);
        quizCategoriesList.add(colorQuizCategories);
        quizCategoriesList.add(relationsQuizCategories);
    }

    private void initRecyclerView() {

        //Hooks and learnAdapter to convert the lists to views
        recyclerView = (RecyclerView) findViewById(R.id.quizRecycler);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new QuizAdapter(quizCategoriesList, this);
        recyclerView.setAdapter(adapter);

    }

    private void updateHighscores() {
        Highscores.open(this);
        for (QuizCategories c : quizCategoriesList) {
            int score = Highscores.getHighscore(c.columnName);
            c.setHighscore(score);
        }
        Highscores.close();
        // notifies the learnAdapter to display the latest Highscores
        // actually this method calls getView from CustomCategoryAdapter class
        adapter.notifyDataSetChanged();

    }

    @Override
    public void OnItemClick(int position) {
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("position" , position);
        startActivity(intent);
    }
}



