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
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.pink_them)));
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.pink_them));

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
            case R.id.quiz_numbers:
                intent.putExtra("position", 1);
                startActivity(intent);
                return true;
            case R.id.quiz_verbs:
                intent.putExtra("position", 2);
                startActivity(intent);
                return true;
            case R.id.quiz_animals:
                intent.putExtra("position", 3);
                startActivity(intent);
                return true;
            case R.id.quiz_professions:
                intent.putExtra("position", 4);
                startActivity(intent);
                return true;
            case R.id.quiz_colors:
                intent.putExtra("position", 5);
                startActivity(intent);
                return true;
            case R.id.quiz_relations:
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

        alphabetCategory.addThing(new Thing(R.raw.alphabt_a, R.raw.a_sound, "[aa]","varamwana: a", "mupanda : nzvovera" ));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_b, R.raw.b_sound, "[bee]", "varamwana: b", "mupanda: nzvanyira"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_c, R.raw.non_existent, "haiko", "varamwana: c", "mupanda:nzvanyira "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_d, R.raw.d_sound, "[dee]" , "varamwana: d", "mupanda:nzvanyira "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_e, R.raw.e_sound, "[ee]", "varamwana: e", "mupanda:nzvovera "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_f, R.raw.f_sound, "[fee]", "varamwana: f", "mupanda:nzvanyira "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_g, R.raw.g_sound, "[gee]", "varamwana: g", "mupanda:nzvanyira "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_h, R.raw.h_sound, "[hee]", "varamwana: h", "mupanda:nzvanyira "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_i, R.raw.i_sound, "[ii]", "varamwana: i", "mupanda:nzvovera "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_j, R.raw.j_sound, "[jee]", "varamwana: j", "mupanda:nzvanyira "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_k, R.raw.k_sound, "[kee]", "varamwana: k", "mupanda:nzvanyira "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_l, R.raw.non_existent, "haiko", "varamwana: l", "mupanda:nzvanyira "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_m, R.raw.m_sound, "[mi]", "varamwana: m", "mupanda:nzvanyira "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_n, R.raw.n_sound, "[ni]", "varamwana: n", "mupanda:nzvanyira "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_o, R.raw.o_sound, "[oo]", "varamwana: o", "mupanda:nzvovera "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_p, R.raw.p_sound, "[pi]", "varamwana: p", "mupanda:nzvanyira "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_q, R.raw.non_existent, "haiko", "varamwana: q", "mupanda:nzvanyira "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_r, R.raw.r_sound, "[rw]", "varamwana: r", "mupanda:nzvanyira "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_s, R.raw.s_sound, "[see]", "varamwana: s", "mupanda:nzvanyira "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_t, R.raw.t_sound, "[ti]", "varamwana: t", "mupanda:nzvanyira "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_u, R.raw.u_sound, "[uu]", "varamwana: u", "mupanda:nzvovera "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_v, R.raw.v_sound, "[vi]", "varamwana: v", "mupanda:nzvanyira "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_w, R.raw.w_sound, "[wee]", "varamwana: w", "mupanda:nzvanyira "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_x, R.raw.non_existent, "haiko", "varamwana: x", "mupanda:nzvanyira "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_y, R.raw.y_sound, "[yuh]", "varamwana: y", "mupanda:nzvanyira "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_z, R.raw.z_sound, "[zee]", "varamwana: z", "mupanda:nzvanyira "));

        numbersCategory.addThing(new Thing(R.raw.number_1pr, R.raw.sound_1, "potsi", null, null));
        numbersCategory.addThing(new Thing(R.raw.number_2, R.raw.sound_2, "piri", null, null));
        numbersCategory.addThing(new Thing(R.raw.number_3, R.raw.sound_3, "tatu", null, null));
        numbersCategory.addThing(new Thing(R.raw.number_4, R.raw.sound_4, "ina", null, null));
        numbersCategory.addThing(new Thing(R.raw.number_5, R.raw.sound_5, "shanu", null, null));
        numbersCategory.addThing(new Thing(R.raw.number_6, R.raw.sound_6, "nhanhatu", null, null));
        numbersCategory.addThing(new Thing(R.raw.number_7, R.raw.sound_7, "nomwe", null, null));
        numbersCategory.addThing(new Thing(R.raw.number_8, R.raw.sound_8, "sere", null, null));
        numbersCategory.addThing(new Thing(R.raw.number_9, R.raw.sound_9, "pfumbamwe", null, null));
        numbersCategory.addThing(new Thing(R.raw.number_10, R.raw.sound_10, "gumi", null, null));



        verbCategory.addThing(new Thing(R.raw.running_boy, R.raw.run_sound, "mhanya", null, null));
        verbCategory.addThing(new Thing(R.raw.jumping, R.raw.jump_sound, "svetuka", null, null));
        verbCategory.addThing(new Thing(R.raw.walk, R.raw.walk_sound, "famba", null, null));
        verbCategory.addThing(new Thing(R.raw.morty_cry, R.raw.cry_sound, "chema",null, null));
        verbCategory.addThing(new Thing(R.raw.swimming, R.raw.swim_sound, "dhidha",null, null));
        verbCategory.addThing(new Thing(R.raw.skipping, R.raw.skip_sound, "tomhuka", null, null));
        verbCategory.addThing(new Thing(R.raw.drinking, R.raw.drink_sound, "kumwa", null, null));
        verbCategory.addThing(new Thing(R.raw.playing_music, R.raw.music_sound, "ridza", null, null));
        verbCategory.addThing(new Thing(R.raw.paint, R.raw.paint_sound, "penda", null, null));
        verbCategory.addThing(new Thing(R.raw.writing, R.raw.write_sound, "nyora", null, null));
        verbCategory.addThing(new Thing(R.raw.cycling, R.raw.cycling_sound, "chovha", null, null));
        verbCategory.addThing(new Thing(R.raw.carry, R.raw.carry_sound, "takura", null, null));
        verbCategory.addThing(new Thing(R.raw.dance, R.raw.dance_sound, "tamba",null, null));
        verbCategory.addThing(new Thing(R.raw.applause, R.raw.applause_sound, "uchira",null, null));

        animalsCategory.addThing(new Thing(R.raw.cow, R.raw.cow_sound, "mombe", null, null));
        animalsCategory.addThing(new Thing(R.raw.toucan_bird, R.raw.bird_sound, "shiri", null, null));
        animalsCategory.addThing(new Thing(R.raw.lion, R.raw.lion_sound, "shumba", null, null));
        animalsCategory.addThing(new Thing(R.raw.bat, R.raw.bat_sound, "chiremwa", null, null));
        animalsCategory.addThing(new Thing(R.raw.bulldog, R.raw.dog_sound, "imbwa", null, null));
        animalsCategory.addThing(new Thing(R.raw.butterfly, R.raw.butterfly_sound, "shavishavi", null, null));
        animalsCategory.addThing(new Thing(R.raw.cat, R.raw.cat_sound, "kitsi", null, null));
        animalsCategory.addThing(new Thing(R.raw.chicken, R.raw.chicken_sound, "huku", null, null));
        animalsCategory.addThing(new Thing(R.raw.crocodile, R.raw.crocodile_sound, "garwe", null, null));
        animalsCategory.addThing(new Thing(R.raw.dance_monkey, R.raw.monkey_sound, "tsoko", null, null));
        animalsCategory.addThing(new Thing(R.raw.duck, R.raw.duck_sound, "dhadha", null, null));
        animalsCategory.addThing(new Thing(R.raw.elephant, R.raw.nzou_sound, "nzou", null, null));
        animalsCategory.addThing(new Thing(R.raw.fish, R.raw.hove_sound, "hove", null, null));
        animalsCategory.addThing(new Thing(R.raw.horse, R.raw.horse_sound, "bhiza", null, null));
        animalsCategory.addThing(new Thing(R.raw.pig, R.raw.pig_sound, "nguruve", null, null));
        animalsCategory.addThing(new Thing(R.raw.rabbit, R.raw.rabbit_sound, "tsuro", null, null));
        animalsCategory.addThing(new Thing(R.raw.tiger, R.raw.ingwe_sound, "ingwe", null, null));


        professionCategory.addThing(new Thing(R.raw.doctor, R.raw.doctor_sound, "chiremba", null, null));
        professionCategory.addThing(new Thing(R.raw.pilot, R.raw.pilot_sound, "mutyairi", null, null));
        professionCategory.addThing(new Thing(R.raw.fishermen, R.raw.fisherman_sound, "murauri", null, null));

        colorCategory.addThing(new Thing(R.raw.black, R.raw.black_sound, "tema", null, null));
        colorCategory.addThing(new Thing(R.raw.yellow, R.raw.yellow_sound, "yero", null, null));
        colorCategory.addThing(new Thing(R.raw.red, R.raw.red_sound, "tsvuku", null, null));

        relationsCategory.addThing(new Thing(R.raw.family, R.raw.family_sound, "mhuri", null, null));
        relationsCategory.addThing(new Thing(R.raw.mother_baby, R.raw.mother_sound, "amai", null, null));
        relationsCategory.addThing(new Thing(R.raw.grandmother, R.raw.granny_sound, "mbuya","amai vemubereki wako", null));



        categoryList.add(alphabetCategory);
        categoryList.add(numbersCategory);
        categoryList.add(verbCategory);
        categoryList.add(animalsCategory);
        categoryList.add(professionCategory);
        categoryList.add(colorCategory);
        categoryList.add(relationsCategory);
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

