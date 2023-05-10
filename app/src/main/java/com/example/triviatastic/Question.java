package com.example.triviatastic;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Question {
    private String text;
    private String[] answerOptions;
    private int correctAnswerIndex;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Questions");

    public Question(String text, String[] answerOptions, int correctAnswerIndex) {
        this.text = text;
        this.answerOptions = answerOptions;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getText() {
        return text;
    }

    public String[] getAnswerOptions() {
        return answerOptions;
    }
    public String getAnswerOption1() {
        return answerOptions[0];
    }
    public String getAnswerOption2() {
        return answerOptions[1];
    }
    public String getAnswerOption3() {
        return answerOptions[2];
    }
    public String getAnswerOption4() {
        return answerOptions[3];
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
    public String getAnswer(int index){
        return answerOptions[index];
    }
    public void Questioninitialization(){

    }

}
