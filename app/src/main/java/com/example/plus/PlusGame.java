package com.example.plus;

import java.util.ArrayList;
import java.util.List;

public class PlusGame {
    private List<PlusQuestion> questions;
    private int numberCorrect;

    private int numberIcorrect;
    private int totalQuestions;
    private int score;
    private PlusQuestion currentQuestion;

    public PlusGame(){
        numberCorrect=0;
        numberIcorrect=0;
        totalQuestions=0;
        score=0;
        currentQuestion=new PlusQuestion(10);
        questions=new ArrayList<PlusQuestion>();
    }
    public void makeNewQuestion(){
        currentQuestion=new PlusQuestion(totalQuestions*6+5);
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
    public List<PlusQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<PlusQuestion> questions) {
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

    public PlusQuestion getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(PlusQuestion currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
}
