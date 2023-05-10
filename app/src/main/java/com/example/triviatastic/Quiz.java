package com.example.triviatastic;

import com.example.triviatastic.Question;

import java.util.List;

public class Quiz {
    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    public boolean isLastQuestion() {
        return currentQuestionIndex == questions.size() - 1;
    }

    public void answerQuestion(int answerIndex) {
        if (answerIndex == questions.get(currentQuestionIndex).getCorrectAnswerIndex()) {
            score++;
        }
    }

    public Question getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }

    public int getScore() {
        return score;
    }

    public void moveToNextQuestion() {
        currentQuestionIndex++;
    }
}
