package com.example.dyslexiahelpinshona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import java.util.ArrayList;

public class QuizCategories extends AppCompatActivity implements RecyclerViewInterface {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    public static ArrayList<Category> categoryList;
    QuizAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_categories);

        getSupportActionBar().setTitle("Mibvunzo");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.pink_them)));
        getWindow().setStatusBarColor(ContextCompat.getColor(QuizCategories.this,R.color.pink_them));

        categoryList= new ArrayList<>();
        initRecyclerView();
        populateCategoriesList();
    }

    private void populateCategoriesList() {
        Highscores.open(this);
        Category alphabetCategory = new Category("Arufabheti",
                R.drawable.alphabet,
                Highscores.getHighscore(MySQLiteHelper.COLUMN_ALPHABET),
                getResources().getColor(R.color.primary_dark),
                R.style.GreenTheme,
                MySQLiteHelper.COLUMN_ALPHABET,
                R.drawable.ic_face_green);
        Category numbersCategory = new Category("Nhamba",
                R.drawable.numbers,
                Highscores.getHighscore(MySQLiteHelper.COLUMN_NUMBERS),
                getResources().getColor(R.color.blue_primary_dark),
                R.style.BlueTheme,
                MySQLiteHelper.COLUMN_NUMBERS,
                R.drawable.ic_face_blue);
        Category verbCategory = new Category("Chiito",
                R.drawable.verb,
                Highscores.getHighscore(MySQLiteHelper.COLUMN_VERBS),
                getResources().getColor(R.color.purple_primary_dark),
                R.style.PurpleTheme,
                MySQLiteHelper.COLUMN_VERBS,
                R.drawable.ic_face_purple);
        Category animalsCategory = new Category("Mhuka",
                R.drawable.animals,
                Highscores.getHighscore(MySQLiteHelper.COLUMN_ANIMALS),
                getResources().getColor(R.color.primary_dark),
                R.style.GreenTheme,
                MySQLiteHelper.COLUMN_ANIMALS,
                R.drawable.ic_face_green);
        Category professionCategory = new Category("Mabasa",
                R.drawable.professions,
                Highscores.getHighscore(MySQLiteHelper.COLUMN_PROFESSIONS),
                getResources().getColor(R.color.pink_primary_dark),
                R.style.PinkTheme,
                MySQLiteHelper.COLUMN_PROFESSIONS,
                R.drawable.ic_face_pink);
        Category colorCategory = new Category("Ruvara",
                R.drawable.colors,
                Highscores.getHighscore(MySQLiteHelper.COLUMN_COLORS),
                getResources().getColor(R.color.blue_primary_dark),
                R.style.BlueTheme,
                MySQLiteHelper.COLUMN_COLORS,
                R.drawable.ic_face_blue);
        Category relationsCategory = new Category("Hukama",
                R.drawable.relations,
                Highscores.getHighscore(MySQLiteHelper.COLUMN_RELATIONS),
                getResources().getColor(R.color.purple_primary_dark),
                R.style.PurpleTheme,
                MySQLiteHelper.COLUMN_RELATIONS,
                R.drawable.ic_face_purple);
        Highscores.close();

    }

    private void initRecyclerView() {

        //Hooks and adapter to convert the lists to views
        recyclerView = findViewById(R.id.quizRecycler);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new QuizAdapter(categoryList, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    protected void onResume() {
        super.onResume();
        updateHighscores();
    }

    private void updateHighscores() {
        Highscores.open(this);
        for (Category c : categoryList) {
            int score = Highscores.getHighscore(c.columnName);
            c.setHighscore(score);
        }
        Highscores.close();
        // notifies the adapter to display the latest Highscores
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