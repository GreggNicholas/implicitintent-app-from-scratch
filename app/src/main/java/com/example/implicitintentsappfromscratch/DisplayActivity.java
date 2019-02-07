package com.example.implicitintentsappfromscratch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DisplayActivity extends AppCompatActivity {
    private TextView nameView;
    private TextView dateView;
    private ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        nameView = findViewById(R.id.zodiacname_displayactivity);
        dateView = findViewById(R.id.zodiacnumber_displayactivity);
        imageView = findViewById(R.id.zodiacimage_displayactivity);

        Intent intent = getIntent();
        if (intent == null) {
            String name = intent.getStringExtra("name");
            String date = intent.getStringExtra("number");
            String image = intent.getStringExtra("image");

            nameView.setText(name);
            dateView.setText(date);
            Picasso.get()
                    .load(image)
                    .into(imageView);


            startActivity(intent);
        }
    }
}
