package com.example.deneme.sqlite2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Listele extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listele);

        final EditText txtMusteriListesi =(EditText)findViewById(R.id.txtMusteriListesi);
        Database db=new Database(getApplicationContext());

        List<Musteri> musteriList=new ArrayList<Musteri>();
        musteriList=db.getirMusteriListesi();

        StringBuilder sb=new StringBuilder();

               for(Musteri _musteri:musteriList)
        {

            String icerik="";
            icerik="ID: " + _musteri.getId() + "Adı: "+ _musteri.getAd() + "Adresi: " + _musteri.getAdress() + "\n\n";
            sb.append(icerik);
        }

        txtMusteriListesi.setText(sb);
    }
}
