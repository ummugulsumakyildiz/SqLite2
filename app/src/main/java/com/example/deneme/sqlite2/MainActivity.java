package com.example.deneme.sqlite2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtAd=(EditText)findViewById(R.id.txtAd);
        final EditText txtAdres=(EditText)findViewById(R.id.txtAdres);

        Button btnKaydet=(Button)findViewById(R.id.KaydetBtn);
        Button btnListele=(Button)findViewById(R.id.ListeleBtn);

        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ad=txtAd.getText().toString();
                String adres=txtAdres.getText().toString();

                if(ad.isEmpty() || adres.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Alanları boş bırakmayınız.",Toast.LENGTH_LONG).show();
                    return;
                }

                Musteri musteri =new Musteri(ad,adres);
                Database db =new Database(getApplicationContext());
                long id = db.ekleMusteri(musteri);

                if(id>0)
                {
                    Toast.makeText(getApplicationContext(),"Kayıt başarılı! ID="+ id,Toast.LENGTH_LONG).show();
                    txtAd.setText("");
                    txtAdres.setText("");

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Kayıt Başarısız",Toast.LENGTH_LONG).show();
                }

            }
        });

        btnListele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),Listele.class);
                startActivity(intent);
            }
        });

    }
}
