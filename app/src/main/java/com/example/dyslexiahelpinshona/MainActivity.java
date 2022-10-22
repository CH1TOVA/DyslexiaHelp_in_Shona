package com.example.dyslexiahelpinshona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<Category> categoryList;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initRecyclerView();


    }

    private void initData() {
        categoryList = new ArrayList<>();
        categoryList.add(new Category(R.drawable.alphabet,"Arufabheti"));
        categoryList.add(new Category(R.drawable.vowels2,"Nzvovera"));
        categoryList.add(new Category(R.drawable.consonants,"Nzvanyira"));
        categoryList.add(new Category(R.drawable.consonants,"Chisazitasingwi"));
        categoryList.add(new Category(R.drawable.consonants,"Chiito"));
        categoryList.add(new Category(R.drawable.consonants,"Pazita"));
        categoryList.add(new Category(R.drawable.consonants,"Chipauro"));

    }

    private void initRecyclerView() {

        //Hooks
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter (categoryList);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

}

