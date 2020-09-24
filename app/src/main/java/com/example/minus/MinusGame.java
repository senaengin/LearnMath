package com.example.minus;

import java.util.ArrayList;
import java.util.List;

public class MinusGame {
    private List<MinusQuestion> questions;
    private int numberCorrect;

    private int numberIcorrect;
    private int totalQuestions;
    private int score;
    private MinusQuestion currentQuestion;

    public MinusGame(){
        numberCorrect=0;
        numberIcorrect=0;
        totalQuestions=0;
        score=0;
        currentQuestion=new MinusQuestion(10);
        questions=new ArrayList<MinusQuestion>();
    }
    public void makeNewQuestion(){
        currentQuestion=new MinusQuestion(totalQuestions*3+15);
        totalQuestions++;
        questions.add(currentQuestion);

    }

    public boolean checkAnswer(int submittedAnswer){
        boolean isCorrect;
        if( currentQuestion.getAnswer()==submittedAnswer){
            numberCorrect++;
            isCorrect=true;
        }else {

            numberIcorrect++;
            isCorrect=false;
        }
        score =numberCorrect*10-numberIcorrect*20;  //puanlama sistemi
        return isCorrect;
    }
    public List<MinusQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<MinusQuestion> questions) {
        this.questions = questions;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    public int getNumberIcorrect() {
        return numberIcorrect;
    }

    public void setNumberIcorrect(int numberIcorrect) {
        this.numberIcorrect = numberIcorrect;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public MinusQuestion getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(MinusQuestion currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
}
