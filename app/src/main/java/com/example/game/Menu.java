package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    public void b3(View view){
        Intent i;
        i = new Intent(this, singlemod1.class);
        startActivity(i);
    }

    public void back(View view){
        Button b1=findViewById(R.id.b1);
        Button b2=findViewById(R.id.b2);
        Button b3=findViewById(R.id.b3);
        Button b4=findViewById(R.id.b4);
        View back=findViewById(R.id.back);
        b3.setVisibility(b3.VISIBLE);
        b4.setVisibility(b4.VISIBLE);
        b1.setVisibility(b1.GONE);
        b2.setVisibility(b2.GONE);
        back.setVisibility(back.GONE);
    }

    public void onClick(View view) {
        Button b1=findViewById(R.id.b1);
        Button b2=findViewById(R.id.b2);
        Button b3=findViewById(R.id.b3);
        Button b4=findViewById(R.id.b4);
        View back=findViewById(R.id.back);
        Intent i;
        i = new Intent(this, MainActivity.class);
        startActivity(i);
        b3.setVisibility(b3.VISIBLE);
        b4.setVisibility(b4.VISIBLE);
        b1.setVisibility(b1.GONE);
        b2.setVisibility(b2.GONE);
        back.setVisibility(back.GONE);
    }
    public void b4(View view){
        Button b1=findViewById(R.id.b1);
        Button b2=findViewById(R.id.b2);
        Button b3=findViewById(R.id.b3);
        Button b4=findViewById(R.id.b4);
        View back=findViewById(R.id.back);

        b3.setVisibility(b3.GONE);
        b4.setVisibility(b4.GONE);
        b1.setVisibility(b1.VISIBLE);
        b2.setVisibility(b2.VISIBLE);
        back.setVisibility(back.VISIBLE);
    }
}