package com.example.onbesPuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.denememath.R;

public class PuzzleActivity extends AppCompatActivity {

    private Button puzzleStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        puzzleStartButton=findViewById(R.id.puzzleStartButton);

        puzzleStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(PuzzleActivity.this,GameActivity.class);
                startActivity(intent);
            }
        });
    }
}