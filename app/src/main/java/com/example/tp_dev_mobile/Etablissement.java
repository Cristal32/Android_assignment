package com.example.tp_dev_mobile;

public class Etablissement {
    private String label;
    private String name;
    private int img;

    //constructeur
    public Etablissement(String label, String name, int img){
        this.label = label;
        this.name = name;
        this.img = img;
    }

    //getters
    public String getLabel(){
        return label;
    }

    public String getName(){
        return name;
    }

    public int getImg(){
        return img;
    }
}
