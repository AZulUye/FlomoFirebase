package com.example.flom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SaluranAirActivity extends AppCompatActivity {

    String[] merekSmartphone = {"07:32:00 = 115 cm", "07:32:15 = 123 cm", "07:32:30 = 120 cm", "07:32:45 = 118 cm"
            , "07:33:00 = 124 cm", "07:33:15 = 119 cm", "07:33:30 = 122 cm", "07:33:45 = 117 cm", "07:34:00 = 120 cm", "07:34:15 = 123 cm", "07:34:30 = 118 cm"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saluran_air);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, merekSmartphone);

        ListView listView = findViewById(R.id.list); // menemukan id listview,
        listView.setAdapter(arrayAdapter); //setAdapter menggunakan arrayAdapter
    }


    public void home(View view) {
        Intent intent = new Intent(this, Success.class);
        startActivity(intent);
        finish();
    }

    public void grafik(View view) {
        Intent intent = new Intent(this, KetinggianAirActivity.class);
        startActivity(intent);
        finish();
    }
}