package com.example.implicitintentsappfromscratch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.implicitintentsappfromscratch.Controller.ZodiacAdapter;
import com.example.implicitintentsappfromscratch.Model.ZodiacList;
import com.example.implicitintentsappfromscratch.Network.RetrofitSingleton;
import com.example.implicitintentsappfromscratch.Network.ZodiacService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private ZodiacService zodiacService;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = RetrofitSingleton.getInstance();
        zodiacService = retrofit.create(ZodiacService.class);
        recyclerView = findViewById(R.id.recyclerview_maincontainer);
        final Call<ZodiacList> zodiacListCall = zodiacService.getZodiacList();
        zodiacListCall.enqueue(new Callback<ZodiacList>() {
            @Override
            public void onResponse(Call<ZodiacList> call, Response<ZodiacList> response) {
                Log.d("Meow TAG", "onResponse: " + response.body().getZodiacsigns().get(0).getName());
                recyclerView.setLayoutManager(new LinearLayoutManager((getApplicationContext())));
                recyclerView.setAdapter(new ZodiacAdapter(response.body().getZodiacsigns()));
            }

            @Override
            public void onFailure(Call<ZodiacList> call, Throwable t) {
                Log.d("Fail TAG", "onFailure: " + t.getMessage());
            }
        });


    }
}
