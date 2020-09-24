package com.example.denememath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.tv.TvContract;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     ImageView image,run;
     TextView logo,slogan;
     Animation topAnim,bottomAnim,runAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);  // Status cubugu kaldırma
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.imageView); //mainde tanımlama
        logo = findViewById(R.id.textView);
        slogan = findViewById(R.id.textView2);
        run = findViewById(R.id.runView);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim); //animasyon tanımlama
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
        runAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
//Set animation to elements
        image.setAnimation(topAnim); //animasyon görüntületme, hazırlatma
        logo.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);
        run.setAnimation(bottomAnim);



        slogan=(TextView)findViewById(R.id.textView2);// Texte tıklandığında diğer sayfa geçişi
        slogan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GirisActivity.class);
                startActivity(intent);
            }
        });

        run=(ImageView)findViewById(R.id.runView);  //Resime tıklandığında diğer sayfa geçişi
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,GirisActivity.class);
                startActivity(intent);

            }
        });
    }
}