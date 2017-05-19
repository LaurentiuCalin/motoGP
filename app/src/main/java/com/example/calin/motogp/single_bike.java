package com.example.calin.motogp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class single_bike extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_bike);

        String bike_name = getIntent().getStringExtra("bike_name");

        TextView single_bike_name = (TextView) findViewById(R.id.single_bike_name);

        single_bike_name.setText(bike_name);

        ImageView bike_main_picture = (ImageView) findViewById(R.id.bike_main_picture);

        bike_main_picture.setImageResource(R.drawable.suzuki);
    }

    public void playEngineSound(View v){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.moto1);
        mp.start();
    }
}
