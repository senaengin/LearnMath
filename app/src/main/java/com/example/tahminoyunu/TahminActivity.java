package com.example.tahminoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.denememath.R;

import java.util.Random;

public class TahminActivity extends AppCompatActivity {
    private EditText editTextGirdi;
    private TextView textViewKalanHak, textViewYardim;
    private Button buttonTahmin;

    private int rastgeleSayi;
    private int sayac=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahmin);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        editTextGirdi=(EditText)findViewById(R.id.editTextGirdi);
        textViewKalanHak=(TextView)findViewById(R.id.textViewKalanHak);
        textViewYardim=(TextView)findViewById(R.id.textViewYardim);
        buttonTahmin=(Button)findViewById(R.id.buttonTahmin);

            Random r = new Random();
            rastgeleSayi = r.nextInt(16);//0 ile 15 arasoı üretir.
            Log.e("Rastgele sayı:", String.valueOf(rastgeleSayi));


        buttonTahmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayac = sayac - 1; //Her tahminde bir azalt.

                int tahmin = Integer.parseInt(editTextGirdi.getText().toString()); // Edittexte girilen veriler string şeklinde olduğu için dönüştürdük.

                if (tahmin == rastgeleSayi) {
                    Intent intent=new Intent(TahminActivity.this,SonucActivity.class);
                    intent.putExtra("sonuc",true); //kazandınız, kaybettiniz yazdırmak için.
                    startActivity(intent);
                    finish();
                    return;
                }

                if (tahmin > rastgeleSayi) {
                    textViewYardim.setText("Azalt");
                    textViewKalanHak.setText("Kalan Hak: " + sayac);

                }

                if (tahmin < rastgeleSayi) {
                    textViewYardim.setText("Arttır");
                    textViewKalanHak.setText("Kalan Hak: " + sayac);
                }

                if(sayac==0){
                    Intent intent=new Intent(TahminActivity.this,SonucActivity.class);
                    intent.putExtra("sonuc",false); //kazandınız, kaybettiniz yazdırmak için.
                    startActivity(intent);
                    finish();
                }

                editTextGirdi.setText(""); // Son tahminde bulunduğumuz sayının ekranda kalmaması için.
            }
        });
    }}