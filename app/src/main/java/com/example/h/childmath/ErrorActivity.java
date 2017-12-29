package com.example.h.childmath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class ErrorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

        String s = getIntent().getStringExtra("score");

        TextView tv_score = (TextView) findViewById(R.id.tv_score);

        tv_score.setText(s);


        Button b_ng = (Button) findViewById(R.id.b_ng);

        b_ng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
        Button b_home = (Button) findViewById(R.id.b_home);

            b_home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(ErrorActivity.this , StartActivity.class);
                    startActivity(i);

                }
            });
    }
}
