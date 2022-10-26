package com.example.dyslexiahelpinshona;

import java.util.ArrayList;

public class Category {
    ArrayList<Thing> things;
    int currentIndex=0;
    String title;
    int image;
    int highscore;
    int color;
    int theme;
    String columnName;
    int quizImage;

    public Category(String title, int image,int highscore,int color,int theme, String columnName, int quizImage ) {
        this.title = title;
        this.image = image;
        this.highscore=highscore;
        this.color=color;
        this.theme=theme;
        this.columnName=columnName;
        this.quizImage=quizImage;
        this.things=new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public void addThing(Thing thing){
        things.add(thing);
    }

    public ArrayList<Thing> getListOfThings(){
        return this.things;
    }

    public Thing nextThing() {
        return things.get(++currentIndex);
    }

    public Thing prevThing() {
        return things.get(--currentIndex);
    }

    public Thing currentThing() {
        return things.get(currentIndex);
    }

    boolean hasNextThing(){
        return currentIndex < things.size()-1;
    }

    boolean hasPrevThing(){
        return currentIndex > 0;
    }

    public void goToFirstThing(){
        currentIndex=0;
    }

    public int  getHighscore()
    {
        return highscore;
    }
    public void setHighscore(int score){
        this.highscore=score;
    }

}


