package com.example.dyslexiahelpinshona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    public static ArrayList<Category> categoryList;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Makategori");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.pink_primary)));
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.pink_primary_dark));

        categoryList= new ArrayList<>();
        populateCategoriesList();
        initRecyclerView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        updateHighscores();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, QuizActivity.class);
        switch (item.getItemId()) {
            case R.id.quiz_alphabet:
                intent.putExtra("position", 0);
                startActivity(intent);
                return true;
            case R.id.quiz_vowels:
                intent.putExtra("position", 1);
                startActivity(intent);
                return true;
            case R.id.quiz_consonants:
                intent.putExtra("position", 2);
                startActivity(intent);
                return true;
            case R.id.quiz_verbs:
                intent.putExtra("position", 3);
                startActivity(intent);
                return true;
            case R.id.quiz_adjectives:
                intent.putExtra("position", 4);
                startActivity(intent);
                return true;
            case R.id.quiz_nouns:
                intent.putExtra("position", 5);
                startActivity(intent);
                return true;
            case R.id.quiz_pronouns:
                intent.putExtra("position", 6);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
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
        Category vowelsCategory = new Category("Nzvovera",
                R.drawable.vowels2,
                Highscores.getHighscore(MySQLiteHelper.COLUMN_VOWELS),
                getResources().getColor(R.color.blue_primary_dark),
                R.style.BlueTheme,
                MySQLiteHelper.COLUMN_VOWELS,
                R.drawable.ic_face_blue);
        Category consonantsCategory = new Category("Nzvanyira",
                R.drawable.consonants,
                Highscores.getHighscore(MySQLiteHelper.COLUMN_CONSONANTS),
                getResources().getColor(R.color.pink_primary_dark),
                R.style.PinkTheme,
                MySQLiteHelper.COLUMN_CONSONANTS,
                R.drawable.ic_face_pink);
        Category verbCategory = new Category("Chiito",
                R.drawable.alphabet,
                Highscores.getHighscore(MySQLiteHelper.COLUMN_VERB),
                getResources().getColor(R.color.purple_primary_dark),
                R.style.PurpleTheme,
                MySQLiteHelper.COLUMN_VERB,
                R.drawable.ic_face_purple);
        Category adjectiveCategory = new Category("Chipauro",
                R.drawable.vowels2,
                Highscores.getHighscore(MySQLiteHelper.COLUMN_ADJECTIVE),
                getResources().getColor(R.color.primary_dark),
                R.style.GreenTheme,
                MySQLiteHelper.COLUMN_ADJECTIVE,
                R.drawable.ic_face_green);
        Category nounCategory = new Category("Pazita",
                R.drawable.consonants,
                Highscores.getHighscore(MySQLiteHelper.COLUMN_NOUN),
                getResources().getColor(R.color.blue_primary_dark),
                R.style.BlueTheme,
                MySQLiteHelper.COLUMN_NOUN,
                R.drawable.ic_face_blue);
        Category pronounCategory = new Category("Sazitasingwi",
                R.drawable.alphabet,
                Highscores.getHighscore(MySQLiteHelper.COLUMN_PRONOUN),
                getResources().getColor(R.color.pink_primary_dark),
                R.style.PinkTheme,
                MySQLiteHelper.COLUMN_PRONOUN,
                R.drawable.ic_face_pink);
        Highscores.close();

        alphabetCategory.addThing(new Thing(R.raw.letter_a, R.raw.a, "a"));
        alphabetCategory.addThing(new Thing(R.raw.letter_b, R.raw.b, "b"));
        alphabetCategory.addThing(new Thing(R.raw.letter_c, R.raw.c, "c"));
        alphabetCategory.addThing(new Thing(R.raw.letter_d, R.raw.d, "d"));


        vowelsCategory.addThing(new Thing(R.drawable.char_a, R.raw.a, "a"));
        vowelsCategory.addThing(new Thing(R.drawable.char_e, R.raw.e, "e"));
        vowelsCategory.addThing(new Thing(R.drawable.char_i, R.raw.i, "i"));
        vowelsCategory.addThing(new Thing(R.drawable.char_o, R.raw.o, "o"));
        vowelsCategory.addThing(new Thing(R.drawable.char_u, R.raw.u, "u"));

        consonantsCategory.addThing(new Thing(R.drawable.char_b, R.raw.b, "b"));
        consonantsCategory.addThing(new Thing(R.drawable.char_c, R.raw.c, "c"));
        consonantsCategory.addThing(new Thing(R.drawable.char_d, R.raw.d, "d"));
        consonantsCategory.addThing(new Thing(R.drawable.char_f, R.raw.d, "f"));
        consonantsCategory.addThing(new Thing(R.drawable.char_g, R.raw.d, "g"));
        consonantsCategory.addThing(new Thing(R.drawable.char_h, R.raw.d, "h"));
        consonantsCategory.addThing(new Thing(R.drawable.char_j, R.raw.d, "j"));
        consonantsCategory.addThing(new Thing(R.drawable.char_k, R.raw.d, "k"));
        consonantsCategory.addThing(new Thing(R.drawable.char_l, R.raw.d, "l"));
        consonantsCategory.addThing(new Thing(R.drawable.char_m, R.raw.d, "m"));
        consonantsCategory.addThing(new Thing(R.drawable.char_n, R.raw.d, "n"));
        consonantsCategory.addThing(new Thing(R.drawable.char_p, R.raw.d, "p"));
        consonantsCategory.addThing(new Thing(R.drawable.char_q, R.raw.d, "q"));
        consonantsCategory.addThing(new Thing(R.drawable.char_r, R.raw.d, "r"));
        consonantsCategory.addThing(new Thing(R.drawable.char_s, R.raw.d, "s"));
        consonantsCategory.addThing(new Thing(R.drawable.char_t, R.raw.d, "t"));
        consonantsCategory.addThing(new Thing(R.drawable.char_v, R.raw.d, "v"));
        consonantsCategory.addThing(new Thing(R.drawable.char_w, R.raw.d, "w"));
        consonantsCategory.addThing(new Thing(R.drawable.char_x, R.raw.d, "x"));
        consonantsCategory.addThing(new Thing(R.drawable.char_y, R.raw.d, "y"));
        consonantsCategory.addThing(new Thing(R.drawable.char_z, R.raw.d, "z"));

        verbCategory.addThing(new Thing(R.raw.running_boy, R.raw.a, "mhanya"));
        verbCategory.addThing(new Thing(R.raw.run, R.raw.b, "mhanya"));
        verbCategory.addThing(new Thing(R.drawable.character_c, R.raw.c, "c"));

        adjectiveCategory.addThing(new Thing(R.drawable.character_o, R.raw.o, "o"));
        adjectiveCategory.addThing(new Thing(R.drawable.character_u, R.raw.u, "u"));
        adjectiveCategory.addThing(new Thing(R.drawable.character_u, R.raw.u, "u"));

        nounCategory.addThing(new Thing(R.drawable.character_e, R.raw.e, "e"));
        nounCategory.addThing(new Thing(R.drawable.character_i, R.raw.i, "i"));
        nounCategory.addThing(new Thing(R.drawable.character_i, R.raw.i, "i"));

        pronounCategory.addThing(new Thing(R.drawable.character_b, R.raw.b, "b"));
        pronounCategory.addThing(new Thing(R.drawable.character_c, R.raw.c, "c"));
        pronounCategory.addThing(new Thing(R.drawable.character_d, R.raw.d, "d"));

        categoryList.add(alphabetCategory);
        categoryList.add(vowelsCategory);
        categoryList.add(consonantsCategory);
        categoryList.add(verbCategory);
        categoryList.add(adjectiveCategory);
        categoryList.add(nounCategory);
        categoryList.add(pronounCategory);
    }

    private void initRecyclerView() {

        //Hooks and adapter to convert the lists to views
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(categoryList, this);
        recyclerView.setAdapter(adapter);

    }

    private void updateHighscores() {
        Highscores.open(this);
        for (Category c : categoryList) {
            c.updateHighscore();
        }
        Highscores.close();
        // notifies the adapter to display the latest Highscores
        // actually this method calls getView from CustomCategoryAdapter class
        adapter.notifyDataSetChanged();

    }

    @Override
    public void OnItemClick(int position) {
        Intent intent = new Intent(this, ThingsActivity.class);
        intent.putExtra("position" , position);
        startActivity(intent);
    }
}

