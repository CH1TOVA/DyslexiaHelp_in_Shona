package com.example.dyslexiahelpinshona;

import java.util.ArrayList;

public class QuizCategories {
    ArrayList<QuizQuestion> quizQuestions;
    int currentIndex=0;
    String title;
    int image;
    int highscore;
    int theme;
    String columnName;

    public QuizCategories(String title, int image, int highscore, int theme, String columnName) {
        this.title = title;
        this.image = image;
        this.highscore=highscore;
        this.theme=theme;
        this.columnName=columnName;
        this.quizQuestions =new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public void addQuizQuestion(QuizQuestion quizQuestion){
        quizQuestions.add(quizQuestion);
    }

    public ArrayList<QuizQuestion> getListOfQuizzes(){
        return this.quizQuestions;
    }

    public QuizQuestion nextQuiz() {
        return quizQuestions.get(++currentIndex);
    }

    public QuizQuestion prevQuiz() {
        return quizQuestions.get(--currentIndex);
    }

    public QuizQuestion currentQuiz() {
        return quizQuestions.get(currentIndex);
    }

    boolean hasNextQuiz(){
        return currentIndex < quizQuestions.size()-1;
    }

    boolean hasPrevQuiz(){
        return currentIndex > 0;
    }

    public void goToFirstQuiz(){
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


