package com.example.h.childmath;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DivActivity extends Activity {


    @Override
    protected void onRestart() {
        super.onRestart();

        ( (TextView) findViewById(R.id.tv_resulte)).setText("");

        ((TextView) findViewById(R.id.tv_score)).setText("0");

        ((TextView) findViewById(R.id.tv_time)).setText(getIntent().getStringExtra("time"));

        bool = true;

        Toast.makeText(getBaseContext() , "Restart" , Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        bool = false;
    }

    boolean bool = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_div);


        final TextView et_resulte = (TextView) findViewById(R.id.tv_resulte);
        final TextView tv_score = (TextView) findViewById(R.id.tv_score);

        final TextView tv_time = (TextView) findViewById(R.id.tv_time);

        final Button b_ok = (Button) findViewById(R.id.b_ok);

        if (MainApplication.getNormalMode()) {

            tv_time.setEnabled(false);
            tv_time.setVisibility(View.INVISIBLE);
        }

        else if (MainApplication.getTranMode()) {

            tv_time.setEnabled(false);
            tv_time.setVisibility(View.INVISIBLE);
            tv_score.setEnabled(false);
            tv_score.setVisibility(View.INVISIBLE);

        }

        else {

            tv_time.setEnabled(true);
            tv_time.setVisibility(View.VISIBLE);
            tv_score.setEnabled(true);
            tv_score.setVisibility(View.VISIBLE);

            // This is for Timer (countdown)

            final Handler handler = new Handler();

            final Runnable run_2 = new Runnable() {
                @Override
                public void run() {

                    while (Integer.parseInt(tv_time.getText().toString()) > 1 && bool) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        handler.post(new Runnable() {
                            @Override
                            public void run() {

                                String s = tv_time.getText().toString();
                                int x = Integer.parseInt(s);
                                x -= 1;
                                tv_time.setText(String.valueOf(x));

                                if (x < 1) {

                                    bool = false;
                                    Intent i = new Intent(DivActivity.this, ErrorActivity.class);
                                    i.putExtra("score", tv_score.getText().toString());

                                    startActivity(i);

                                }


                            }
                        });


                    }

                }

            };

            final Thread t1 = new Thread(run_2);

            if (!t1.isAlive()) {
                t1.start();

            }

        }

        Button b1 = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);
        Button b4 = (Button) findViewById(R.id.b_tran);
        Button b5 = (Button) findViewById(R.id.button5);
        Button b6 = (Button) findViewById(R.id.button6);
        Button b7 = (Button) findViewById(R.id.button7);
        Button b8 = (Button) findViewById(R.id.button8);
        Button b9 = (Button) findViewById(R.id.button9);
        Button b0 = (Button) findViewById(R.id.button0);
        Button bb = (Button) findViewById(R.id.button);


        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

if (et_resulte.getText().toString().equals("")) {

    return;
}
                String s = et_resulte.getText().toString();
                String s2 = s.substring(0 , (et_resulte.getText().toString().length() - 1));
                et_resulte.setText(s2);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                et_resulte.setText(et_resulte.getText().toString() + "1");

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                et_resulte.setText(et_resulte.getText().toString() + "2");

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                et_resulte.setText(et_resulte.getText().toString() + "3");

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                et_resulte.setText(et_resulte.getText().toString() + "4");

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                et_resulte.setText(et_resulte.getText().toString() + "5");

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                et_resulte.setText(et_resulte.getText().toString() + "6");

            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                et_resulte.setText(et_resulte.getText().toString() + "7");

            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                et_resulte.setText(et_resulte.getText().toString() + "8");

            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                et_resulte.setText(et_resulte.getText().toString() + "9");

            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                et_resulte.setText(et_resulte.getText().toString() + "0");

            }
        });


        tv_time.setText(getIntent().getStringExtra("time"));


        if (getIntent().getBooleanExtra("sum", true)) {

            int min = 0;
            int max = 0;
            int min2 = 0;
            int max2 = 0;

            if (getIntent().getBooleanExtra("easy", true)) {

                min = 1;
                max = 10;
                min2 = 1;
                max2 = 10;
            }

            else if (getIntent().getBooleanExtra("normal", true)) {

                min = 31;
                max = 99;
                min2 = 11;
                max2 = 30;
            }

            else if (getIntent().getBooleanExtra("hard", true)) {

                min = 101;
                max = 1000;
                min2 = 21;
                max2 = 99;
            }

            else if (getIntent().getBooleanExtra("extreme", true)) {

                min = 1001;
                max = 5000;
                min2 = 101;
                max2 = 999;

            }

            else if (getIntent().getBooleanExtra("crazy", true)) {

                min = 5001;
                max = 9999;
                min2 = 1001;
                max2 = 5000;

            }


            ((TextView)findViewById(R.id.textView)).setText("+");



            final TextView tv1 = (TextView) findViewById(R.id.tv_num1);
            final TextView tv2 = (TextView) findViewById(R.id.tv_num2);



            int resulte = 0;

            int rand1 = min + (int)(Math.random() * ((max - min) + 1));
            int rand2 = min2 + (int)(Math.random() * ((max2 - min2) + 1));

            tv1.setText(String.valueOf(rand1));
            tv2.setText(String.valueOf(rand2));

            b_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (et_resulte.getText().toString().equals("")) {

                        return;
                    }

                    int min = 0;
                    int max = 0;
                    int min2 = 0;
                    int max2 = 0;

                    if (getIntent().getBooleanExtra("easy", true)) {

                        min = 1;
                        max = 10;
                        min2 = 1;
                        max2 = 10;
                    }

                    else if (getIntent().getBooleanExtra("normal", true)) {

                        min = 31;
                        max = 99;
                        min2 = 11;
                        max2 = 30;
                    }

                    else if (getIntent().getBooleanExtra("hard", true)) {

                        min = 101;
                        max = 1000;
                        min2 = 21;
                        max2 = 99;
                    }

                    else if (getIntent().getBooleanExtra("extreme", true)) {

                        min = 2000;
                        max = 6000;
                        min2 = 101;
                        max2 = 999;

                    }

                    else if (getIntent().getBooleanExtra("crazy", true)) {

                        min = 5001;
                        max = 9999;
                        min2 = 1001;
                        max2 = 5000;

                    }

                    int score = Integer.parseInt(tv_score.getText().toString());


                        int resulte = Integer.parseInt(tv1.getText().toString()) + Integer.parseInt(tv2.getText().toString());

                        if (resulte == Integer.parseInt(et_resulte.getText().toString())) {

                            score += 10;
                            tv_score.setText(String.valueOf(score));

                            int rand1 = min + (int)(Math.random() * ((max - min) + 1));
                            int rand2 = min2 + (int)(Math.random() * ((max2 - min2) + 1));

                            tv1.setText(String.valueOf(rand1));
                            tv2.setText(String.valueOf(rand2));
                            et_resulte.setText("");

                            tv_time.setText(getIntent().getStringExtra("time")); // set time for tv_time




                        }

                        else if (MainApplication.getTranMode()){

                            int rand1 = min + (int)(Math.random() * ((max - min) + 1));
                            int rand2 = min2 + (int)(Math.random() * ((max2 - min2 + 1)));

                            tv1.setText(String.valueOf(rand1));
                            tv2.setText(String.valueOf(rand2));

                            tv_score.setText("0");
                            et_resulte.setText("");

                        }


                        else {
                            bool = false;
                            Intent i = new Intent(DivActivity.this, ErrorActivity.class);
                            i.putExtra("score", tv_score.getText().toString());
                            startActivity(i);

                        }




                }
            });
        }

        if (getIntent().getBooleanExtra("sub", true)) {


            ((TextView)findViewById(R.id.textView)).setText("-");


            final TextView tv1 = (TextView) findViewById(R.id.tv_num1);
            final TextView tv2 = (TextView) findViewById(R.id.tv_num2);

            int min = 0;
            int max = 0;
            int min2 = 0;
            int max2 = 0;

            if (getIntent().getBooleanExtra("easy", true)) {

                min = 1;
                max = 10;
            }

            else if (getIntent().getBooleanExtra("normal", true)) {

                min = 31;
                max = 99;
                min2 = 11;
                max2 = 30;
            }

            else if (getIntent().getBooleanExtra("hard", true)) {

                min = 101;
                max = 1000;
                min2 = 21;
                max2 = 99;
            }

            else if (getIntent().getBooleanExtra("extreme", true)) {

                min = 2000;
                max = 6000;
                min2 = 101;
                max2 = 999;

            }

            else if (getIntent().getBooleanExtra("crazy", true)) {

                min = 5001;
                max = 9999;
                min2 = 1001;
                max2 = 5000;

            }

            int resulte = 0;

            int rand1 = min + (int)(Math.random() * ((max - min) + 1));
            int rand2 = min2 + (int)(Math.random() * ((max2 - min2) + 1));

            if (rand1 < rand2) {

                int x = rand1;
                rand1 = rand2;
                rand2 = x;
            }


            tv1.setText(String.valueOf(rand1));
            tv2.setText(String.valueOf(rand2));

            b_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if (et_resulte.getText().toString().equals("")) {

                        return;
                    }

                    int score = Integer.parseInt(tv_score.getText().toString());


                        int resulte = Integer.parseInt(tv1.getText().toString()) - Integer.parseInt(tv2.getText().toString());

                        if (resulte == Integer.parseInt(et_resulte.getText().toString())) {

                            score += 10;
                            tv_score.setText(String.valueOf(score));

                            int min = 0;
                            int max = 0;
                            int min2 = 0;
                            int max2 = 0;

                            if (getIntent().getBooleanExtra("easy", true)) {

                                min = 1;
                                max = 10;
                            }

                            else if (getIntent().getBooleanExtra("normal", true)) {

                                min = 31;
                                max = 99;
                                min2 = 11;
                                max2 = 30;
                            }

                            else if (getIntent().getBooleanExtra("hard", true)) {

                                min = 101;
                                max = 1000;
                                min2 = 21;
                                max2 = 99;
                            }

                            else if (getIntent().getBooleanExtra("extreme", true)) {

                                min = 2000;
                                max = 6000;
                                min2 = 101;
                                max2 = 999;

                            }

                            else if (getIntent().getBooleanExtra("crazy", true)) {

                                min = 5001;
                                max = 9999;
                                min2 = 1001;
                                max2 = 5000;

                            }

                            int rand1 = min + (int) (Math.random() * ((max - min) + 1));
                            int rand2 = min + (int) (Math.random() * ((max - min) + 1));

                            if (rand1 < rand2) {

                                int x = rand1;
                                rand1 = rand2;
                                rand2 = x;
                            }

                            tv1.setText(String.valueOf(rand1));
                            tv2.setText(String.valueOf(rand2));
                            et_resulte.setText("");

                            tv_time.setText(getIntent().getStringExtra("time")); // set time for tv_time


                        }     else if (MainApplication.getTranMode()){

                            int min = 0;
                            int max = 0;
                            int min2 = 0;
                            int max2 = 0;

                            if (getIntent().getBooleanExtra("easy", true)) {

                                min = 1;
                                max = 10;
                            }

                            else if (getIntent().getBooleanExtra("normal", true)) {

                                min = 31;
                                max = 99;
                                min2 = 11;
                                max2 = 30;
                            }

                            else if (getIntent().getBooleanExtra("hard", true)) {

                                min = 101;
                                max = 1000;
                                min2 = 21;
                                max2 = 99;
                            }

                            else if (getIntent().getBooleanExtra("extreme", true)) {

                                min = 2000;
                                max = 6000;
                                min2 = 101;
                                max2 = 999;

                            }

                            else if (getIntent().getBooleanExtra("crazy", true)) {

                                min = 5001;
                                max = 9999;
                                min2 = 1001;
                                max2 = 5000;

                            }

                            int rand1 = min + (int) (Math.random() * ((max - min) + 1));
                            int rand2 = min2 + (int) (Math.random() * ((max2 - min2) + 1));

                            if (rand1 < rand2) {

                                int x = rand1;
                                rand1 = rand2;
                                rand2 = x;
                            }

                            tv1.setText(String.valueOf(rand1));
                            tv2.setText(String.valueOf(rand2));

                            tv_score.setText("0");
                            et_resulte.setText("");
                        }

                        else {
                            bool = false;
                            Intent i = new Intent(DivActivity.this, ErrorActivity.class);
                            i.putExtra("score", tv_score.getText().toString());
                            startActivity(i);

                        }

                    }


            });
        }

        if (getIntent().getBooleanExtra("mul", true)) {

            ((TextView)findViewById(R.id.textView)).setText("×");



            final TextView tv1 = (TextView) findViewById(R.id.tv_num1);
            final TextView tv2 = (TextView) findViewById(R.id.tv_num2);


            int min = 0;
            int max = 0;
            int min2 = 0;
            int max2 = 0;

            if (getIntent().getBooleanExtra("easy", true)) {

                min = 1;
                max = 10;
                min2 = 1;
                max2 = 5;
            }

            else if (getIntent().getBooleanExtra("normal", true)) {

                min = 11;
                max = 20;
                min2 = 5;
                max2 = 9;
            }

            else if (getIntent().getBooleanExtra("hard", true)) {

                min = 40;
                max = 99;
                min2 = 12;
                max2 = 30;
            }

            else if (getIntent().getBooleanExtra("extreme", true)) {

                min = 101;
                max = 499;
                min2 = 50;
                max2 = 99;
            }

            else if (getIntent().getBooleanExtra("crazy", true)) {

                min = 101;
                max = 999;
                min2 = 101;
                max2 = 999;
            }


            int resulte = 0;

            int rand1 = min + (int)(Math.random() * ((max - min) + 1));
            int rand2 = min2 + (int)(Math.random() * ((max2 - min2) + 1));

            tv1.setText(String.valueOf(rand1));
            tv2.setText(String.valueOf(rand2));

            b_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if (et_resulte.getText().toString().equals("")) {

                        return;
                    }

                    int score = Integer.parseInt(tv_score.getText().toString());

                        int min = 0;
                        int max = 0;
                        int min2 = 0;
                        int max2 = 0;

                        if (getIntent().getBooleanExtra("easy", true)) {

                            min = 1;
                            max = 10;
                            min2 = 1;
                            max2 = 5;
                        }

                        else if (getIntent().getBooleanExtra("normal", true)) {

                            min = 6;
                            max = 11;
                            min2 = 1;
                            max2 = 10;
                        }

                        else if (getIntent().getBooleanExtra("hard", true)) {

                            min = 12;
                            max = 20;
                            min2 = 5;
                            max2 = 10;
                        }

                        else if (getIntent().getBooleanExtra("extreme", true)) {

                            min = 101;
                            max = 999;
                            min2 = 21;
                            max2 = 99;
                        }

                        else if (getIntent().getBooleanExtra("crazy", true)) {

                            min = 101;
                            max = 999;
                            min2 = 101;
                            max2 = 999;
                        }


                        int resulte = Integer.parseInt(tv1.getText().toString()) * Integer.parseInt(tv2.getText().toString());

                        if (resulte == Integer.parseInt(et_resulte.getText().toString())) {

                            score += 10;
                            tv_score.setText(String.valueOf(score));

                            int rand1 = min + (int)(Math.random() * ((max - min) + 1));
                            int rand2 = min2 + (int)(Math.random() * ((max2 - min2) + 1));

                            tv1.setText(String.valueOf(rand1));
                            tv2.setText(String.valueOf(rand2));

                            et_resulte.setText("");

                            tv_time.setText(getIntent().getStringExtra("time")); // set time for tv_time

                        }

                        else if (MainApplication.getTranMode()){

                            int rand1 = min + (int)(Math.random() * ((max - min) + 1));
                            int rand2 = min2 + (int)(Math.random() * ((max2 - min2) + 1));

                            tv1.setText(String.valueOf(rand1));
                            tv2.setText(String.valueOf(rand2));
                            tv_score.setText("0");
                            et_resulte.setText("");
                        }

                        else {
                            bool = false;
                            Intent i = new Intent(DivActivity.this, ErrorActivity.class);
                            i.putExtra("score", tv_score.getText().toString());
                            startActivity(i);

                        }




                    }


            });
        }

       else if (getIntent().getBooleanExtra("div", true)) {

            ((TextView)findViewById(R.id.textView)).setText("÷");


            final TextView tv1 = (TextView) findViewById(R.id.tv_num1);
            final TextView tv2 = (TextView) findViewById(R.id.tv_num2);

            int min = 0;
            int max = 0;
            int min2 = 0;
            int max2 = 0;

            if (getIntent().getBooleanExtra("easy", true)) {

                min = 1;
                max = 10;
                min2 = 1;
                max2 = 5;
            }

            else if (getIntent().getBooleanExtra("normal", true)) {

                min = 12;
                max = 20;
                min2 = 1;
                max2 = 9;
            }

            else if (getIntent().getBooleanExtra("hard", true)) {

                min = 5;
                max = 9;
                min2 = 12;
                max2 = 20;
            }

            else if (getIntent().getBooleanExtra("extreme", true)) {

                min = 12;
                max = 25;
                min2 = 20;
                max2 = 40;
            }

            else if (getIntent().getBooleanExtra("crazy", true)) {

                min = 20;
                max = 45;
                min2 = 50;
                max2 = 99;
            }



            int num1 = min + (int)(Math.random() * ((max - min) + 1));
            int num2 = min2 + (int)(Math.random() * ((max2 - min2) + 1));

            int re_mul = num1 * num2;



            re_mul = num1 * num2;

            tv1.setText(String.valueOf(re_mul));
            tv2.setText(String.valueOf(num2));

            int resulte = re_mul / num2;


            b_ok.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {


                    if (et_resulte.getText().toString().equals("")) {

                        return;
                    }

                    int score = Integer.parseInt(tv_score.getText().toString());

                    int resulte = ((int)Integer.parseInt(tv1.getText().toString()) / Integer.parseInt(tv2.getText().toString()));

                    if (resulte == Integer.parseInt(et_resulte.getText().toString())) {

                        score += 10;
                        tv_score.setText(String.valueOf(score));

                        int min = 0;
                        int max = 0;
                        int min2 = 0;
                        int max2 = 0;

                        if (getIntent().getBooleanExtra("easy", true)) {

                            min = 1;
                            max = 10;
                            min2 = 1;
                            max2 = 5;
                        }

                        else if (getIntent().getBooleanExtra("normal", true)) {

                            min = 12;
                            max = 20;
                            min2 = 1;
                            max2 = 9;
                        }

                        else if (getIntent().getBooleanExtra("hard", true)) {

                            min = 5;
                            max = 9;
                            min2 = 12;
                            max2 = 15;
                        }

                        else if (getIntent().getBooleanExtra("extreme", true)) {

                            min = 12;
                            max = 25;
                            min2 = 20;
                            max2 = 40;
                        }

                        else if (getIntent().getBooleanExtra("crazy", true)) {

                            min = 20;
                            max = 45;
                            min2 = 50;
                            max2 = 99;
                        }


                        int num1 = min + (int)(Math.random() * ((max - min) + 1));
                        int num2 = min2 + (int)(Math.random() * ((max2 - min2) + 1));

                        int re_mul = num1 * num2;

                        tv1.setText(String.valueOf(re_mul));
                        tv2.setText(String.valueOf(num2));

                        resulte = re_mul / num2;

                        et_resulte.setText("");


                        tv_time.setText(getIntent().getStringExtra("time")); // set time for tv_time
                    }

                    else if (MainApplication.getTranMode()){

                        int min = 0;
                        int max = 0;
                        int min2 = 0;
                        int max2 = 0;

                        if (getIntent().getBooleanExtra("easy", true)) {

                            min = 1;
                            max = 10;
                            min2 = 1;
                            max2 = 5;
                        }

                        else if (getIntent().getBooleanExtra("normal", true)) {

                            min = 12;
                            max = 20;
                            min2 = 1;
                            max2 = 9;
                        }

                        else if (getIntent().getBooleanExtra("hard", true)) {

                            min = 5;
                            max = 9;
                            min2 = 12;
                            max2 = 15;
                        }

                        else if (getIntent().getBooleanExtra("extreme", true)) {

                            min = 12;
                            max = 25;
                            min2 = 20;
                            max2 = 40;
                        }

                        else if (getIntent().getBooleanExtra("crazy", true)) {

                            min = 20;
                            max = 45;
                            min2 = 50;
                            max2 = 99;
                        }


                        int num1 = min + (int)(Math.random() * ((max - min) + 1));
                        int num2 = min2 + (int)(Math.random() * ((max2 - min2) + 1));

                        int re_mul = num1 * num2;

                        tv1.setText(String.valueOf(re_mul));
                        tv2.setText(String.valueOf(num1));


                        resulte = re_mul / num1;

                        tv_score.setText("0");
                        et_resulte.setText("");

                    }

                    else {
                        bool = false;
                        Intent i = new Intent(DivActivity.this, ErrorActivity.class);
                        i.putExtra("score", tv_score.getText().toString());
                        startActivity(i);

                    }

                }
            });
        }



    }


}



