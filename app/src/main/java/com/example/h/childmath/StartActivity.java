package com.example.h.childmath;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final Button b_normal = (Button) findViewById(R.id.b_normal);
        Button b_speed = (Button) findViewById(R.id.b_speed);
        Button b_time = (Button) findViewById(R.id.b_Time);
        Button b_tran = (Button) findViewById(R.id.b_tran);

        b_speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i_speed = new Intent(StartActivity.this, OptionsActivity.class);
                i_speed.putExtra("show_speed" , true);
                i_speed.putExtra("show_time" , false);
                MainApplication.setSpeedModeTrue();
                startActivity(i_speed);
            }
        });

        b_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i_normal = new Intent(StartActivity.this, OptionsActivity.class);
                i_normal.putExtra("show_speed" , false);
                i_normal.putExtra("show_time" , false);
                MainApplication.setNormalModeTrue();
                startActivity(i_normal);

            }
        });

        b_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i_time = new Intent(StartActivity.this, OptionsActivity.class);
                i_time.putExtra("show_speed" , false);
                i_time.putExtra("show_time" , true);
                MainApplication.setTimeModeTrue();
                startActivity(i_time);

            }
        });



        b_tran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i_time = new Intent(StartActivity.this, OptionsActivity.class);
                i_time.putExtra("show_speed" , false);
                i_time.putExtra("show_time" , false);
                MainApplication.setTranModeTrue();
                startActivity(i_time);

            }
        });

    }
}
