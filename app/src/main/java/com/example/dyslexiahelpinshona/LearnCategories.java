package com.example.dyslexiahelpinshona;

import java.util.ArrayList;

public class LearnCategories {
    ArrayList<Thing> things;
    int currentIndex=0;
    String title;
    int image;
    int theme;

    public LearnCategories(String title, int image,int theme) {
        this.title = title;
        this.image = image;
        this.theme=theme;
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

}

