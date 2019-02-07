package com.example.implicitintentsappfromscratch;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URI;

public class DisplayActivity extends AppCompatActivity {
    private TextView nameView;
    private TextView dateView;
    private ImageView imageView;
    private Button button;

    private final String ADDRESS = "https://www.astrology.com/horoscope/daily/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        nameView = findViewById(R.id.zodiacname_displayactivity);
        dateView = findViewById(R.id.zodiacnumber_displayactivity);
        imageView = findViewById(R.id.zodiacimage_displayactivity);
        button = findViewById(R.id.button_display);


        Intent intent = getIntent();


            final String name = intent.getStringExtra("name");
            String date = intent.getStringExtra("number");
            String image = intent.getStringExtra("image");

            nameView.setText(name);
            dateView.setText(date);
            Picasso.get()
                    .load(image)
                    .into(imageView);


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse(ADDRESS + name + ".html");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });

    }
}
