package com.example.implicitintentsappfromscratch.Controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.implicitintentsappfromscratch.Model.ZodiacSign;
import com.example.implicitintentsappfromscratch.R;
import com.example.implicitintentsappfromscratch.Views.ZodiacViewHolder;

import java.util.List;

public class ZodiacAdapter extends RecyclerView.Adapter<ZodiacViewHolder> {
    private List<ZodiacSign> zodiacList;


    public ZodiacAdapter(List<ZodiacSign> zodiacList) {
        this.zodiacList = zodiacList;
    }

    @NonNull
    @Override
    public ZodiacViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.itemview_zodiaclist, viewGroup, false);

        return new ZodiacViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZodiacViewHolder zodiacViewHolder, int position) {
        zodiacViewHolder.onBind(zodiacList.get(position));


    }

    @Override
    public int getItemCount() {
        return zodiacList.size();
    }
}
