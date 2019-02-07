package com.example.implicitintentsappfromscratch.Views;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.implicitintentsappfromscratch.DisplayActivity;
import com.example.implicitintentsappfromscratch.Model.ZodiacSign;
import com.example.implicitintentsappfromscratch.R;
import com.squareup.picasso.Picasso;

public class ZodiacViewHolder extends RecyclerView.ViewHolder {
    private TextView nameView;
    private TextView numberView;
    private ImageView imageView;

    public ZodiacViewHolder(@NonNull View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.zodiacname_itemview);
        numberView = itemView.findViewById(R.id.zodiacnumber_itemview);
        imageView = itemView.findViewById(R.id.zodiacimage_itemview);
    }

    public void onBind(final ZodiacSign zodiac) {
        nameView.setText(zodiac.getName());
        numberView.setText(zodiac.getNumber());
        Picasso.get()
                .load(zodiac.getImage())
                .into(imageView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DisplayActivity.class);
                intent.putExtra("name", zodiac.getName());
                intent.putExtra("number", zodiac.getNumber());
                intent.putExtra("image", zodiac.getImage());
                v.getContext().startActivity(intent);
            }
        });


    }

}
