package com.example.calin.motogp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class motorcyclesByBrand extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motorcycles_by_brand);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] motorcycles_array = {"YZR-M1", "XT125R", "IT250H", "WR400F", "YZ85"};

        ArrayList<String> motorcycles_list = new ArrayList<>();

        Collections.addAll(motorcycles_list, motorcycles_array);

        final ArrayAdapter<String> motorcycles_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, motorcycles_list);

        final ListView motorcycles_list_view = (ListView) findViewById(R.id.motorcycles_list);

        motorcycles_list_view.setAdapter(motorcycles_adapter);

        final Intent single_bike = new Intent(this, single_bike.class);

        AdapterView.OnItemClickListener motorcycle_list_clicked = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String bike_name = motorcycles_list_view.getItemAtPosition(position).toString();
                single_bike.putExtra("bike_name", bike_name);

                startActivity(single_bike);
            }
        };

        motorcycles_list_view.setOnItemClickListener(motorcycle_list_clicked);

    }


}
