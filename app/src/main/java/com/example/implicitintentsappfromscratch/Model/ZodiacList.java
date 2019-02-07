package com.example.implicitintentsappfromscratch.Model;

import java.util.List;

public class ZodiacList {

    private List<ZodiacSign> zodiac;

    public List<ZodiacSign> getZodiacsigns() {
        return zodiac;
    }

    public ZodiacList(List<ZodiacSign> zodiac) {
        this.zodiac = zodiac;
    }
}
