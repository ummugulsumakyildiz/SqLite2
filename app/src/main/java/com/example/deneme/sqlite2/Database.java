package com.example.deneme.sqlite2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper{

    private static final String veritabani_adi="veritabani_musteri";
    private static final String musteri_tablosu="tbl_Ogrenci";
    private static final int veritabani_versiyon= 1;
    private static final String COLUMN_CUSTOMER_NAME = "MusteriAdi";
    private static final String COLUMN_CUSTOMER_ADRES = "MusteriAdres";
    public Database(Context context){
        super(context, veritabani_adi, null, veritabani_versiyon);
    }

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql_musteriTablosu="CREATE TABLE "+ musteri_tablosu +"(ID INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_CUSTOMER_NAME +" TEXT, "+COLUMN_CUSTOMER_ADRES + " TEXT)";

        db.execSQL(sql_musteriTablosu);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST" + musteri_tablosu);
    }

    public long ekleMusteri(Musteri musteri) {

        SQLiteDatabase db=this.getWritableDatabase() ;

        ContentValues cv=new ContentValues();
        cv.put(COLUMN_CUSTOMER_NAME, musteri.getAd());
        cv.put(COLUMN_CUSTOMER_ADRES, musteri.getAdress());

        long id= db.insert(musteri_tablosu, null, cv);
        return id ;

    }

    public List<Musteri> getirMusteriListesi() {
        List<Musteri> musteriList=new ArrayList<Musteri>();
        SQLiteDatabase db=this.getReadableDatabase();

        String sqlSorgusu="Select * from " + musteri_tablosu;
        Cursor c=db.rawQuery(sqlSorgusu, null);
        int siraNoId=c.getColumnIndex("ID");
        int siraNoAd=c.getColumnIndex(COLUMN_CUSTOMER_NAME);
        int siraNoAdres=c.getColumnIndex(COLUMN_CUSTOMER_ADRES);

        try {
            while (c.moveToNext()){
                Musteri _musteri=new Musteri();
                _musteri.setId(c.getInt(siraNoId));
                _musteri.setAd(c.getString(siraNoAd));
                _musteri.setAdress(c.getString(siraNoAdres));
                musteriList.add(_musteri);

            }
        }
        finally {
            c.close();
            db.close();
        }
        System.out.println("Müşteri Listesi "+musteriList.size());
        for (int i=0;i<musteriList.size();i++)
        {
            System.out.println(musteriList.get(i).getAd());
        }
        return musteriList;
    }
}
