package com.example.divide;

import java.util.ArrayList;
import java.util.List;

public class DivideGame {
    private List<DivideQuestion> questions;
    private int numberCorrect;

    private int numberIcorrect;
    private int totalQuestions;
    private int score;
    private DivideQuestion currentQuestion;

    public DivideGame(){
        numberCorrect=0;
        numberIcorrect=0;
        totalQuestions=0;
        score=0;
        currentQuestion=new DivideQuestion(10);
        questions=new ArrayList<DivideQuestion>();
    }
    public void makeNewQuestion(){
        currentQuestion=new DivideQuestion(totalQuestions*2+5);
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
    public List<DivideQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<DivideQuestion> questions) {
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

    public DivideQuestion getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(DivideQuestion currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
}
