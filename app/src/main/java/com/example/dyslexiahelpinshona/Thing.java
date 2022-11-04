package com.example.dyslexiahelpinshona;

import com.airbnb.lottie.LottieAnimationView;

public class Thing {
    private int lottieAnimationView;
    private int sound;
    private String text;
    private String text2;
    private String text3;
    private int noise;


    public Thing(int lottieAnimationView, int sound, String text, String text2, String text3,int noise ) {
        this.lottieAnimationView = lottieAnimationView;
        this.sound = sound;
        this.text = text;
        this.text2 = text2;
        this.text3 = text3;
        this.noise = noise;
    }

    public Thing(int lottieAnimationView, int sound, String text, String text2, String text3) {
        this(lottieAnimationView, sound, text, text2, text3,  0);
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public int getNoise() {
        return noise;
    }

    public boolean hasNoise() {
        return this.noise != 0;
    }

    public int getSound() { return sound; }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public int getLottieAnimationView(){
        return lottieAnimationView;
    }

    public void setLottieAnimationView(int lottieAnimationView){this.lottieAnimationView= lottieAnimationView;}

}


