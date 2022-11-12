package com.example.dyslexiahelpinshona;

public class QuizQuestion {
    private int lottieAnimationView;
    private String text;


    public QuizQuestion(int lottieAnimationView, String text) {
        this.lottieAnimationView = lottieAnimationView;
        this.text = text;

    }
    public String getText() {
        return text;
    }


    public int getLottieAnimationView(){
        return lottieAnimationView;
    }

    public void setLottieAnimationView(int lottieAnimationView){this.lottieAnimationView= lottieAnimationView;}

}

