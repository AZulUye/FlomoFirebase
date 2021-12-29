package com.example.flom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Success extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
    }

    public void camera(View view) {
        Intent intent = new Intent(this, KondisiAirActivity.class);
        startActivity(intent);
        finish();
    }

    public void water(View view) {
        Intent intent = new Intent(this, SaluranAirActivity.class);
        startActivity(intent);
        finish();
    }
}