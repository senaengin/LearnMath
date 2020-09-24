package com.example.plus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.denememath.R;

public class PlusActivity extends AppCompatActivity {

    Button btn_start,btn_answer0,btn_answer1,btn_answer2,btn_answer3;
    TextView tv_score,tv_questions,tv_timer,tv_bottommessage;
    ProgressBar prog_timer;

    PlusGame g = new PlusGame();
    int secondsRemaining=60;

    CountDownTimer timer= new CountDownTimer(60000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            secondsRemaining--;
            tv_timer.setText(Integer.toString(secondsRemaining) + " sn ");
            prog_timer.setProgress(60 - secondsRemaining);
        }

        @Override
        public void onFinish() {
            btn_answer0.setEnabled(false);
            btn_answer1.setEnabled(false);
            btn_answer2.setEnabled(false);
            btn_answer3.setEnabled(false);
            tv_bottommessage.setText("Süre Doldu! " + g.getNumberCorrect()+ " / " + (g.getTotalQuestions()-1)) ;

            final Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn_start.setVisibility(View.VISIBLE);
                }
            }, 4000 );
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_plus);

        btn_start=findViewById(R.id.btn_start);
        btn_answer0=findViewById(R.id.btn_answer0);
        btn_answer1=findViewById(R.id.btn_answer1);
        btn_answer2=findViewById(R.id.btn_answer2);
        btn_answer3=findViewById(R.id.btn_answer3);
        tv_score=findViewById(R.id.tv_score);
        tv_bottommessage=findViewById(R.id.tv_bottommessage);
        tv_questions=findViewById(R.id.tv_questions);
        tv_timer=findViewById(R.id.tv_timer);
        prog_timer=findViewById(R.id.prog_timer);

        tv_timer.setText("0 saniye");
        tv_questions.setText("");
        tv_bottommessage.setText("Başlat");
        tv_score.setText("0 puan");
        prog_timer.setProgress(0);

        View.OnClickListener StartButtonClickListener= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button start_button=(Button) v;
                start_button.setVisibility(View.INVISIBLE);
                nextTurn();
                timer.start();
            }
        };

        View.OnClickListener answerButtonClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonClicked= (Button) v;
                int answerSelected=Integer.parseInt(buttonClicked.getText().toString()) ;
                // Toast.makeText(MainActivity.this,"Seçilen Cevap : "+answerSelected,Toast.LENGTH_SHORT).show();

                g.checkAnswer(answerSelected);
                tv_score.setText(Integer.toString(g.getScore()));
                nextTurn();
            }
        };

        btn_start.setOnClickListener(StartButtonClickListener);

        btn_answer0.setOnClickListener(answerButtonClickListener);
        btn_answer1.setOnClickListener(answerButtonClickListener);
        btn_answer2.setOnClickListener(answerButtonClickListener);
        btn_answer3.setOnClickListener(answerButtonClickListener);


    }

    private void nextTurn(){
        g.makeNewQuestion();
        int answer []= g.getCurrentQuestion().getAnswerArray();
        btn_answer0.setText(Integer.toString(answer[0]));
        btn_answer1.setText(Integer.toString(answer[1]));
        btn_answer2.setText(Integer.toString(answer[2]));
        btn_answer3.setText(Integer.toString(answer[3]));

        btn_answer0.setEnabled(true);
        btn_answer1.setEnabled(true);
        btn_answer2.setEnabled(true);
        btn_answer3.setEnabled(true);


        tv_questions.setText(g.getCurrentQuestion().getQuestionPhrase());

        tv_bottommessage.setText(g.getNumberCorrect()+"/"+(g.getTotalQuestions()-1));
    }
}