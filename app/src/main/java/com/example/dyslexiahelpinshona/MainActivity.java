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

        alphabetCategory.addThing(new Thing(R.raw.alphabt_a, R.raw.a, "a"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_b, R.raw.b, "b"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_c, R.raw.c, "c"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_d, R.raw.d, "d"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_e, R.raw.e, "e"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_f, R.raw.d, "f"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_g, R.raw.d, "g"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_h, R.raw.d, "h"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_i, R.raw.i, "i"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_j, R.raw.d, "j"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_k, R.raw.i, "k"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_l, R.raw.o, "l"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_m, R.raw.u, "m"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_n, R.raw.u, "n"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_o, R.raw.u, "o"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_p, R.raw.u, "p"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_q, R.raw.u, "q"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_r, R.raw.u, "r"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_s, R.raw.u, "s"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_t, R.raw.u, "t"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_u, R.raw.u, "u"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_v, R.raw.u, "v"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_w, R.raw.u, "w"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_x, R.raw.u, "x"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_y, R.raw.u, "y"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_z, R.raw.u, "z"));


        vowelsCategory.addThing(new Thing(R.raw.alphabt_a, R.raw.a, "a [aa]"));
        vowelsCategory.addThing(new Thing(R.raw.alphabet_e, R.raw.e, "e [ee]"));
        vowelsCategory.addThing(new Thing(R.raw.alphabet_i, R.raw.i, "i [ie]"));
        vowelsCategory.addThing(new Thing(R.raw.alphabet_o, R.raw.o, "o [oo]"));
        vowelsCategory.addThing(new Thing(R.raw.alphabet_u, R.raw.u, "u [uu]"));

        consonantsCategory.addThing(new Thing(R.raw.alphabet_b, R.raw.b, "b"));
        consonantsCategory.addThing(new Thing(R.raw.alphabet_c, R.raw.c, "c"));
        consonantsCategory.addThing(new Thing(R.raw.alphabet_d, R.raw.d, "d"));
        consonantsCategory.addThing(new Thing(R.raw.alphabet_f, R.raw.d, "f"));
        consonantsCategory.addThing(new Thing(R.raw.alphabet_g, R.raw.d, "g"));
        consonantsCategory.addThing(new Thing(R.raw.alphabet_h, R.raw.d, "h"));
        consonantsCategory.addThing(new Thing(R.raw.alphabet_j, R.raw.d, "j"));
        consonantsCategory.addThing(new Thing(R.raw.alphabet_k, R.raw.d, "k"));
        consonantsCategory.addThing(new Thing(R.raw.alphabet_l, R.raw.d, "l"));
        consonantsCategory.addThing(new Thing(R.raw.alphabet_m, R.raw.d, "m"));
        consonantsCategory.addThing(new Thing(R.raw.alphabet_n, R.raw.d, "n"));
        consonantsCategory.addThing(new Thing(R.raw.alphabet_p, R.raw.d, "p"));
        consonantsCategory.addThing(new Thing(R.raw.alphabet_q, R.raw.d, "q"));
        consonantsCategory.addThing(new Thing(R.raw.alphabet_r, R.raw.d, "r"));
        consonantsCategory.addThing(new Thing(R.raw.alphabet_s, R.raw.d, "s"));
        consonantsCategory.addThing(new Thing(R.raw.alphabet_t, R.raw.d, "t"));
        consonantsCategory.addThing(new Thing(R.raw.alphabet_v, R.raw.d, "v"));
        consonantsCategory.addThing(new Thing(R.raw.alphabet_w, R.raw.d, "w"));
        consonantsCategory.addThing(new Thing(R.raw.alphabet_x, R.raw.d, "x"));
        consonantsCategory.addThing(new Thing(R.raw.alphabet_y, R.raw.d, "y"));
        consonantsCategory.addThing(new Thing(R.raw.alphabet_z, R.raw.d, "z"));

        verbCategory.addThing(new Thing(R.raw.running_boy, R.raw.a, "mhanya"));
        verbCategory.addThing(new Thing(R.raw.jumping, R.raw.a, "svetuka"));
        verbCategory.addThing(new Thing(R.raw.walk, R.raw.a, "famba"));
        verbCategory.addThing(new Thing(R.raw.morty_cry, R.raw.a, "chema"));
        verbCategory.addThing(new Thing(R.raw.swimming, R.raw.a, "dhidha"));
        verbCategory.addThing(new Thing(R.raw.skipping_rope, R.raw.a, "tomhuka"));
        verbCategory.addThing(new Thing(R.raw.drinking, R.raw.a, "kumwa"));
        verbCategory.addThing(new Thing(R.raw.playing_music, R.raw.a, "ridza"));
        verbCategory.addThing(new Thing(R.raw.paint, R.raw.a, "penda"));
        verbCategory.addThing(new Thing(R.raw.writing, R.raw.a, "nyora"));
        verbCategory.addThing(new Thing(R.raw.cycling, R.raw.a, "chovha"));
        verbCategory.addThing(new Thing(R.raw.carry, R.raw.a, "takura"));
        verbCategory.addThing(new Thing(R.raw.dance, R.raw.a, "tamba"));


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
        Intent intent = new Intent(this, ThingsActivity.class);
        intent.putExtra("position" , position);
        startActivity(intent);
    }
}

