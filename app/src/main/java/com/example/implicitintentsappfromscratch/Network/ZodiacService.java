package com.example.implicitintentsappfromscratch.Network;

import com.example.implicitintentsappfromscratch.Model.ZodiacList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ZodiacService {
    @GET("/JDVila/storybook/master/zodiac.json")
    Call<ZodiacList> getZodiacList();

}


