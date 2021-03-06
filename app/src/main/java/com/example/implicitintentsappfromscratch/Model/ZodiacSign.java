package com.example.implicitintentsappfromscratch.Model;

public class ZodiacSign {

    private String name;
    private String number;
    private String image;

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getImage() {
        return image;
    }

    public ZodiacSign(String name, String number, String image) {
        this.name = name;
        this.number = number;
        this.image = image;
    }
}
