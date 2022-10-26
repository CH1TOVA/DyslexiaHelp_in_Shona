package com.example.dyslexiahelpinshona;

import com.airbnb.lottie.LottieAnimationView;

public class Thing {
    private int lottieAnimationView;
    private int sound;
    private String text;
    private int noise;


    public Thing(int lottieAnimationView, int sound, String text, int noise  ) {
        this.lottieAnimationView = lottieAnimationView;
        this.sound = sound;
        this.text = text;
        this.noise = noise;

    }

    public Thing(int lottieAnimationView, int sound, String text) {
        this(lottieAnimationView, sound, text, 0);
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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


