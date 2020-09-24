package com.example.denememath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.onbesPuzzle.PuzzleActivity;
import com.example.tahminoyunu.OyunTahminActivity;

public class OyunActivity extends AppCompatActivity {

    Button oyunTahminButton,puzzleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        oyunTahminButton=findViewById(R.id.oyunTahminButton);
        puzzleButton=findViewById(R.id.puzzleButton);

        oyunTahminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OyunActivity.this, OyunTahminActivity.class);
                startActivity(intent);
            }
        });

        puzzleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OyunActivity.this, PuzzleActivity.class);
                startActivity(intent);
            }
        });
    }
}