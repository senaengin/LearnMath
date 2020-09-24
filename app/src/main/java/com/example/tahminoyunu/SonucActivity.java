package com.example.tahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.denememath.R;

public class SonucActivity extends AppCompatActivity {

    private ImageView imageViewSonuc;
    private TextView textViewSonuc;
    private Button buttonTekrar;
    int RastgeleSayi;


    private boolean sonuc;  //putextradan çekmek için.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageViewSonuc=findViewById(R.id.imageViewSonuc);
        textViewSonuc=findViewById(R.id.textViewSonuc);
        buttonTekrar=findViewById(R.id.buttonTekrar);

        sonuc=getIntent().getBooleanExtra("sonuc",false);
        if(sonuc){
            textViewSonuc.setText("KAZANDINIZ");
            imageViewSonuc.setImageResource(R.drawable.ic_mutlu);

        }
        else{
            textViewSonuc.setText("KAYBETTİNİZ");
            imageViewSonuc.setImageResource(R.drawable.ic_mutsuz);
        }
        buttonTekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SonucActivity.this,TahminActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}