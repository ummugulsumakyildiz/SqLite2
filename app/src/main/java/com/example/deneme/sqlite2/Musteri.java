package com.example.deneme.sqlite2;

/**
 * Created by deneme on 15.12.2017.
 */

public class Musteri {


    int Id;
    private String Ad;
    private String Adress;
    public Musteri(){}

    public Musteri(String ad, String adress) {
        Ad = ad;
        Adress = adress;
    }

    public void setAd(String ad) {
        Ad = ad;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getAd() {
        return Ad;
    }

    public String getAdress() {
        return Adress;
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
