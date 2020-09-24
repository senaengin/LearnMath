package com.example.denememath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.cross.CrossActivity;
import com.example.divide.DivideActivity;
import com.example.minus.MinusActivity;
import com.example.plus.PlusActivity;

public class GirisActivity extends AppCompatActivity {

    ImageView plusview,minusview,divideview,crossview;
    Animation animReturn;
    Button plusbutton,minusbutton,crossbutton,dividebutton,oyunButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_giris);


        plusview = (ImageView)findViewById(R.id.plusView);  // Animasyon için görüntüler tanımlandı.
        minusview= (ImageView)findViewById(R.id.minusView);
        crossview= (ImageView)findViewById(R.id.crossView);
        divideview= (ImageView)findViewById(R.id.divideView);

        animReturn= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anim);
        plusview.startAnimation(animReturn);//animasyonu başlatmak için
        minusview.startAnimation(animReturn);
        crossview.startAnimation(animReturn);
        divideview.startAnimation(animReturn);

        plusbutton=(Button)findViewById(R.id.plusButton); //Button tanımladım
        minusbutton=(Button)findViewById(R.id.button3);
        crossbutton=(Button)findViewById(R.id.button4);
        dividebutton=(Button)findViewById(R.id.button5);
        oyunButton=(Button)findViewById(R.id.oyunButton);

       plusbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(GirisActivity.this, PlusActivity.class);
               startActivity(intent);
           }
       });

       minusbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(GirisActivity.this, MinusActivity.class);
               startActivity(intent);
           }
       });

       crossbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(GirisActivity.this, CrossActivity.class);
               startActivity(intent);
           }
       });

       dividebutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(GirisActivity.this, DivideActivity.class);
               startActivity(intent);
           }
       });

       oyunButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(GirisActivity.this,OyunActivity.class);
               startActivity(intent);
           }
       });
    }


}