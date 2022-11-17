package com.example.dyslexiahelpinshona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import java.util.ArrayList;

public class LearnCategoriesActivity extends AppCompatActivity implements RecyclerViewInterface {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    public static ArrayList<LearnCategories> learncategoryList;
    LearnAdapter learnAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_categories);
        getSupportActionBar().setTitle("Dzidziso");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// back button
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.pink_them)));
        getWindow().setStatusBarColor(ContextCompat.getColor(LearnCategoriesActivity.this,R.color.pink_them));

        learncategoryList= new ArrayList<>();
        populateCategoriesList();
        initRecyclerView();

    }

    @Override
    public boolean onSupportNavigateUp() {
        // closes the Activity when the back button on the action bar is pressed
        finish();
        return true;
    }

    private void populateCategoriesList() {
        LearnCategories alphabetCategory = new LearnCategories("Arufabheti",
                R.drawable.alphabet,
                R.style.GreenTheme);
        LearnCategories numbersCategory = new LearnCategories("Nhamba",
                R.drawable.numbers,
                R.style.BlueTheme);
        LearnCategories verbCategory = new LearnCategories("Chiito",
                R.drawable.verb,
                R.style.PurpleTheme);
        LearnCategories animalsCategory = new LearnCategories("Mhuka",
                R.drawable.animals,
                R.style.GreenTheme );
        LearnCategories professionCategory = new LearnCategories("Mabasa",
                R.drawable.professions,
                R.style.PinkTheme);
        LearnCategories colorCategory = new LearnCategories("Ruvara",
                R.drawable.colors,
                R.style.BlueTheme);
        LearnCategories relationsCategory = new LearnCategories("Hukama",
                R.drawable.relations,
                R.style.PurpleTheme);

        alphabetCategory.addThing(new Thing(R.raw.alphabt_a, R.raw.a_sound, "[a]","varamwana: a", "kategori : nzvovera" ));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_b, R.raw.b_sound, "[ɓ]", "varamwana: b", "ba,be,bi,bo,bu"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_c, R.raw.ch_sound, "[t͡ʃ]", "varamwana: c", "cha,che,chi,cho,chu"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_d, R.raw.d_sound, "[ɗ]" , "varamwana: d", "da,de,di,do,du"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_e, R.raw.e_sound, "[e]", "varamwana: e", "kategori:nzvovera "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_f, R.raw.f_sound, "[f]", "varamwana: f", "fa,fe,fi,fo,fu"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_g, R.raw.g_sound, "[ɡ̤]", "varamwana: g", "ga,ge,gi,go,gu"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_h, R.raw.h_sound, "[ɦ]", "varamwana: h", "ha,he,hi,ho,hu"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_i, R.raw.i_sound, "[i]", "varamwana: i", "kategori:nzvovera "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_j, R.raw.j_sound, "[d͡ʒ̤]", "varamwana: j", "je,je,ji,jo,ju"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_k, R.raw.k_sound, "[k]", "varamwana: k", "ka,ke,ki,ko,ku"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_m, R.raw.m_sound, "[m]", "varamwana: m", "ma,me,mi,mo,mu"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_n, R.raw.n_sound, "[n]", "varamwana: n", "na,ne,ni,no,nu"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_o, R.raw.o_sound, "[o]", "varamwana: o", "kategori:nzvovera "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_p, R.raw.p_sound, "[p]", "varamwana: p", "pa,pe,pi,po,pu"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_r, R.raw.r_sound, "[r]", "varamwana: r", "ra,re,ri,ro,ru"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_s, R.raw.s_sound, "[s]", "varamwana: s", "sa,se,si,so,su"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_t, R.raw.t_sound, "[t]", "varamwana: t", "ta,te,ti,to,tu"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_u, R.raw.u_sound, "[u]", "varamwana: u", "kategori:nzvovera "));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_v, R.raw.v_sound, "[ʋ]", "varamwana: v", "va,ve,vi,vo,vu"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_w, R.raw.w_sound, "[w]", "varamwana: w", "wa,we,wi,wo,wu"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_y, R.raw.y_sound, "[j]", "varamwana: y", "ya,ye,yi,yo,yu"));
        alphabetCategory.addThing(new Thing(R.raw.alphabet_z, R.raw.z_sound, "[z̤]", "varamwana: z", "za,ze,zi,zo,zu"));

        numbersCategory.addThing(new Thing(R.raw.number_1pr, R.raw.sound_1, "poshi", null, "nhamba yechi-poshi"));
        numbersCategory.addThing(new Thing(R.raw.number_2, R.raw.sound_2, "piri", null, "nhamba yechi-piri"));
        numbersCategory.addThing(new Thing(R.raw.number_3, R.raw.sound_3, "tatu", null, "nhamba yechi-tatu"));
        numbersCategory.addThing(new Thing(R.raw.number_4, R.raw.sound_4, "ina", null, "nhamba yech-ina"));
        numbersCategory.addThing(new Thing(R.raw.number_5, R.raw.sound_5, "shanu", null, "nhamba yechi-shanu"));
        numbersCategory.addThing(new Thing(R.raw.number_6, R.raw.sound_6, "tanhatu", null, "nhamba yechi-tanhatu"));
        numbersCategory.addThing(new Thing(R.raw.number_7, R.raw.sound_7, "nomwe", null, "nhamba yechi-nomwe"));
        numbersCategory.addThing(new Thing(R.raw.number_8, R.raw.sound_8, "sere", null, "nhamba yechi-sere"));
        numbersCategory.addThing(new Thing(R.raw.number_9, R.raw.sound_9, "pfumbamwe", null, "nhamba ye-pfumbamwe"));
        numbersCategory.addThing(new Thing(R.raw.number_10, R.raw.sound_10, "gumi", null, "nhamba ye-gumi"));


        verbCategory.addThing(new Thing(R.raw.running_boy, R.raw.run_sound, "mhanya", "dudzirachiito:", "ku-mhanya, ano-mhanya"));
        verbCategory.addThing(new Thing(R.raw.jumping, R.raw.jump_sound, "svetuka", "dudzirachiito:", "ku-svetuka, ano-svetuka"));
        verbCategory.addThing(new Thing(R.raw.walk, R.raw.walk_sound, "famba", "dudzirachiito:", "ku-famba, vaka-famba"));
        verbCategory.addThing(new Thing(R.raw.morty_cry, R.raw.cry_sound, "chema","dudzirachiito:", "ku-chema, aka-chema"));
        verbCategory.addThing(new Thing(R.raw.swimming, R.raw.swim_sound, "dhidha","dudzirachiito:", "ku-dhidha, aka-dhidha"));
        verbCategory.addThing(new Thing(R.raw.skipping, R.raw.skip_sound, "tomhuka", "dudzirachiito:","ku-tomhuka, a-tomhuka" ));
        verbCategory.addThing(new Thing(R.raw.drinking, R.raw.drink_sound, "imwa", "dudzirachiito:", "ku-mwa, aka-mwa"));
        verbCategory.addThing(new Thing(R.raw.playing_music, R.raw.music_sound, "ridza", "dudzirachiito:", "ku-ridza, ano-ridza"));
        verbCategory.addThing(new Thing(R.raw.paint, R.raw.paint_sound, "penda", "dudzirachiito:", "ku-penda, aka-penda"));
        verbCategory.addThing(new Thing(R.raw.writing, R.raw.write_sound, "nyora", "dudzirachiito:", "ku-nyora, aka-nyora"));
        verbCategory.addThing(new Thing(R.raw.cycling, R.raw.cycling_sound, "chovha", "dudzirachiito:", "ku-chovha, aka-chovha"));
        verbCategory.addThing(new Thing(R.raw.carry, R.raw.carry_sound, "takura", "dudzirachiito:", "ku-takura, aka-takura"));
        verbCategory.addThing(new Thing(R.raw.dancing, R.raw.dance_sound, "tamba","dudzirachiito:", "ku-tamba, vaka-tamba"));
        verbCategory.addThing(new Thing(R.raw.applause, R.raw.applause_sound, "ombera","dudzirachiito:", "ku-ombera, va-ombera"));

        animalsCategory.addThing(new Thing(R.raw.cow, R.raw.cow_sound, "mombe", "mwana wemombe: ", "mhuru", R.raw.cow_mooing));
        animalsCategory.addThing(new Thing(R.raw.toucan_bird, R.raw.bird_sound, "shiri", "mwana weshiri: ", "nyana"));
        animalsCategory.addThing(new Thing(R.raw.lion, R.raw.lion_sound, "shumba", "mwana weshumba: ", "handa", R.raw.lionnoise));
        animalsCategory.addThing(new Thing(R.raw.bat, R.raw.bat_sound, "chiremwa","mwana wechiremwaremwa:" , "nyana"));
        animalsCategory.addThing(new Thing(R.raw.bulldog, R.raw.dog_sound, "imbwa", "mwana wembwa: ", "mbwanana", R.raw.dog_barking));
        animalsCategory.addThing(new Thing(R.raw.cat, R.raw.cat_sound, "kitsi", "mwana wekitsi:", "chidharimbo", R.raw.catnoise));
        animalsCategory.addThing(new Thing(R.raw.chicken, R.raw.chicken_sound, "huku", "mwana wehuku: ", "chitiyo", R.raw.rooster));
        animalsCategory.addThing(new Thing(R.raw.frog, R.raw.frog_sound, "datya", "mwana wedatya: ", "buruuru"));
        animalsCategory.addThing(new Thing(R.raw.dance_monkey, R.raw.monkey_sound, "tsoko", "rusvava", "rusvava", R.raw.monkeynoise));
        animalsCategory.addThing(new Thing(R.raw.duck, R.raw.duck_sound, "dhadha", "mwana wedhadha", "dhadhana", R.raw.ducknoise));
        animalsCategory.addThing(new Thing(R.raw.elephant, R.raw.nzou_sound, "nzou", "mwana wenzou", "mhuru", R.raw.elephant_trumpets));
        animalsCategory.addThing(new Thing(R.raw.fish, R.raw.hove_sound, "hove", "mwana wehove: ", "dakataka"));
        animalsCategory.addThing(new Thing(R.raw.horse, R.raw.horse_sound, "bhiza", "mwana webhiza", "njenjeta", R.raw.stallion));
        animalsCategory.addThing(new Thing(R.raw.pig, R.raw.pig_sound, "nguruve", "mwana wenguruve: ", "humbanana", R.raw.pig_grunting));
        animalsCategory.addThing(new Thing(R.raw.rabbit, R.raw.rabbit_sound, "tsuro", "mwwana wetsuro: ", "nhowa"));

        professionCategory.addThing(new Thing(R.raw.doctor, R.raw.doctor_sound, "chiremba", null, "munhu anorapa"));
        professionCategory.addThing(new Thing(R.raw.fishermen, R.raw.fisherman_sound, "murauri", null, "munhu anoraura hove"));
        professionCategory.addThing(new Thing(R.raw.teacher, R.raw.teacher_sound, "mudzidzisi", null, "munhu anodzidzisa"));
        professionCategory.addThing(new Thing(R.raw.chef, R.raw.chef_sound, "mubiki", null, "munhu anobika chikafu"));
        professionCategory.addThing(new Thing(R.raw.cut, R.raw.carpenter_sound, "muvezi", null, "munhu anoveza mapuranga"));
        professionCategory.addThing(new Thing(R.raw.playing_music, R.raw.musician_sound, "muimbi", null, "munhu anoimba"));
        professionCategory.addThing(new Thing(R.raw.pilot, R.raw.pilot_sound, "mutyairi", null, "munhu anotyaira ndege"));

        colorCategory.addThing(new Thing(R.raw.black_fluid, R.raw.black_sound, "tema", null, "ruvara ru-tema"));
        colorCategory.addThing(new Thing(R.raw.yellow_fluid, R.raw.yellow_sound, "yero", null, "ruvara rwe-yero"));
        colorCategory.addThing(new Thing(R.raw.red_fluid, R.raw.red_sound, "tsvuku", null, "ruvara ru-tsvuku"));
        colorCategory.addThing(new Thing(R.raw.white_fluid, R.raw.red_sound, "chena", null, "ruvara ru-chena"));
        colorCategory.addThing(new Thing(R.raw.green_fluid, R.raw.red_sound, "girinhi", null, "ruvara rwe-girinhi"));
        colorCategory.addThing(new Thing(R.raw.brown_fluid, R.raw.red_sound, "bhurawuni", null, "ruvara rwebhurawuni"));
        colorCategory.addThing(new Thing(R.raw.grey_fluid, R.raw.red_sound, "gireyi", null, "ruvara rwe-gireyi"));
        colorCategory.addThing(new Thing(R.raw.purple_fluid, R.raw.red_sound, "pepuru", null, "ruvara rwe-pepuru"));


        relationsCategory.addThing(new Thing(R.raw.family, R.raw.family_sound, "mhuri", null, null));
        relationsCategory.addThing(new Thing(R.raw.mother_baby, R.raw.mother_sound, "amai nemwana", null, "mai vanozvara mwana"));
        relationsCategory.addThing(new Thing(R.raw.grandmother, R.raw.granny_sound, "mbuya", null,"amai vemubereki"));
        relationsCategory.addThing(new Thing(R.raw.granddad, R.raw.grandad_sound, "sekuru", null, "baba vemubereki"));
        relationsCategory.addThing(new Thing(R.raw.father_children, R.raw.father_sound, "baba nevana",null,"baba vanozvara vana"));
        relationsCategory.addThing(new Thing(R.raw.children, R.raw.children_sound, "vana",null, null));


        learncategoryList.add(alphabetCategory);
        learncategoryList.add(numbersCategory);
        learncategoryList.add(verbCategory);
        learncategoryList.add(animalsCategory);
        learncategoryList.add(professionCategory);
        learncategoryList.add(colorCategory);
        learncategoryList.add(relationsCategory);
    }

    private void initRecyclerView() {

        //Hooks and learnAdapter to convert the lists to views
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        learnAdapter = new LearnAdapter(learncategoryList, this);
        recyclerView.setAdapter(learnAdapter);
        learnAdapter.notifyDataSetChanged();

    }

    @Override
    public void OnItemClick(int position) {
        Intent intent = new Intent(this, ThingsActivity.class);
        intent.putExtra("position" , position);
        startActivity(intent);
    }
}

