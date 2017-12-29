package com.example.h.childmath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


public class OptionsActivity extends Activity {

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(getBaseContext() , "Restart" , Toast.LENGTH_SHORT).show();
    }


    @Override
    public void setRequestedOrientation(int requestedOrientation) {
        super.setRequestedOrientation(requestedOrientation);
    return;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        RadioButton rb1 = (RadioButton) findViewById(R.id.radio10);
        RadioButton rb2 = (RadioButton) findViewById(R.id.radio30);
        RadioButton rb3 = (RadioButton) findViewById(R.id.radio45);
        RadioButton rb4 = (RadioButton) findViewById(R.id.radio60);
        RadioButton rb5 = (RadioButton) findViewById(R.id.radio90);

        RadioButton rb6 = (RadioButton) findViewById(R.id.radio1m);
        RadioButton rb7 = (RadioButton) findViewById(R.id.radio2m);
        RadioButton rb8 = (RadioButton) findViewById(R.id.radio3m);
        RadioButton rb9 = (RadioButton) findViewById(R.id.radio5m);
        RadioButton rb10=(RadioButton) findViewById(R.id.radio10m);

        final RadioButton rbeasy = (RadioButton) findViewById(R.id.radioEasy);
        final RadioButton rbnormal =(RadioButton) findViewById(R.id.radioNormal);
        final RadioButton rbhard = (RadioButton) findViewById(R.id.radioHard);
        final RadioButton rbExtreme =(RadioButton) findViewById(R.id.radioExtreme);
        final RadioButton rbcrazy =(RadioButton) findViewById(R.id.radioCrazy);

        final RadioButton rb10sec = (RadioButton) findViewById(R.id.radio10);
        final RadioButton rb30sec =(RadioButton) findViewById(R.id.radio30);
        final RadioButton rb45sec = (RadioButton) findViewById(R.id.radio45);
        final RadioButton rb60sec =(RadioButton) findViewById(R.id.radio60);
        final RadioButton rb90sec =(RadioButton) findViewById(R.id.radio90);

        Button sum = (Button) findViewById(R.id.b_sum);
        Button sub = (Button) findViewById(R.id.b_sub);
        Button mul = (Button) findViewById(R.id.b_mul);
        Button div = (Button) findViewById(R.id.b_div);


        Intent i = getIntent();

        boolean bool = i.getBooleanExtra("show_speed" , true);
        boolean bool2 = i.getBooleanExtra("show_time" , true);

        if (bool) {

            rb1.setVisibility(View.VISIBLE);
            rb2.setVisibility(View.VISIBLE);
            rb3.setVisibility(View.VISIBLE);
            rb4.setVisibility(View.VISIBLE);
            rb5.setVisibility(View.VISIBLE);
        }

        else {

            rb1.setVisibility(View.INVISIBLE);
            rb2.setVisibility(View.INVISIBLE);
            rb3.setVisibility(View.INVISIBLE);
            rb4.setVisibility(View.INVISIBLE);
            rb5.setVisibility(View.INVISIBLE);

        }

        if (bool2) {

            rb6.setVisibility(View.VISIBLE);
            rb7.setVisibility(View.VISIBLE);
            rb8.setVisibility(View.VISIBLE);
            rb9.setVisibility(View.VISIBLE);
            rb10.setVisibility(View.VISIBLE);
        }

        else {

            rb6.setVisibility(View.INVISIBLE);
            rb7.setVisibility(View.INVISIBLE);
            rb8.setVisibility(View.INVISIBLE);
            rb9.setVisibility(View.INVISIBLE);
            rb10.setVisibility(View.INVISIBLE);
        }

        rb10sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rb30sec.setChecked(false);
                rb45sec.setChecked(false);
                rb60sec.setChecked(false);
                rb90sec.setChecked(false);
            }
        });

        rb30sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rb10sec.setChecked(false);
                rb45sec.setChecked(false);
                rb60sec.setChecked(false);
                rb90sec.setChecked(false);
            }
        });

        rb45sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rb30sec.setChecked(false);
                rb10sec.setChecked(false);
                rb60sec.setChecked(false);
                rb90sec.setChecked(false);
            }
        });

        rb60sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rb30sec.setChecked(false);
                rb45sec.setChecked(false);
                rb10sec.setChecked(false);
                rb90sec.setChecked(false);
            }
        });

        rb90sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rb30sec.setChecked(false);
                rb45sec.setChecked(false);
                rb60sec.setChecked(false);
                rb10sec.setChecked(false);
            }
        });


        rbeasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rbnormal.setChecked(false);
                rbhard.setChecked(false);
                rbExtreme.setChecked(false);
                rbcrazy.setChecked(false);
            }
        });

        rbnormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rbeasy.setChecked(false);
                rbhard.setChecked(false);
                rbExtreme.setChecked(false);
                rbcrazy.setChecked(false);
            }
        });

        rbhard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rbnormal.setChecked(false);
                rbeasy.setChecked(false);
                rbExtreme.setChecked(false);
                rbcrazy.setChecked(false);
            }
        });

        rbExtreme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rbnormal.setChecked(false);
                rbhard.setChecked(false);
                rbeasy.setChecked(false);
                rbcrazy.setChecked(false);
            }
        });

        rbcrazy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rbnormal.setChecked(false);
                rbhard.setChecked(false);
                rbExtreme.setChecked(false);
                rbeasy.setChecked(false);
            }
        });




        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(OptionsActivity.this , DivActivity.class);


                i.putExtra("easy", rbeasy.isChecked());
                i.putExtra("normal", rbnormal.isChecked());
                i.putExtra("hard", rbhard.isChecked());
                i.putExtra("extreme", rbExtreme.isChecked());
                i.putExtra("crazy", rbcrazy.isChecked());

                if (rb10sec.isChecked()) {

                    i.putExtra("time", "10");
                }

                else if (rb30sec.isChecked()) {

                    i.putExtra("time", "30");
                }
                else if (rb45sec.isChecked()) {

                    i.putExtra("time", "45");
                }
                else if (rb60sec.isChecked()) {

                    i.putExtra("time", "60");
                }
                else if (rb90sec.isChecked()) {

                    i.putExtra("time", "90");
                }

                i.putExtra("sum", true);
                i.putExtra("mul", false);
                i.putExtra("sub", false);
                i.putExtra("div", false);

                startActivity(i);


            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(OptionsActivity.this , DivActivity.class);
                i.putExtra("easy", rbeasy.isChecked());
                i.putExtra("normal", rbnormal.isChecked());
                i.putExtra("hard", rbhard.isChecked());
                i.putExtra("extreme", rbExtreme.isChecked());
                i.putExtra("crazy", rbcrazy.isChecked());

                if (rb10sec.isChecked()) {

                    i.putExtra("time", "10");
                }

                else if (rb30sec.isChecked()) {

                    i.putExtra("time", "30");
                }
                else if (rb45sec.isChecked()) {

                    i.putExtra("time", "45");
                }
                else if (rb60sec.isChecked()) {

                    i.putExtra("time", "60");
                }
                else if (rb90sec.isChecked()) {

                    i.putExtra("time", "90");
                }


                i.putExtra("sum", false);
                i.putExtra("mul", true);
                i.putExtra("sub", false);
                i.putExtra("div", false);
                startActivity(i);


            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(OptionsActivity.this , DivActivity.class);
                i.putExtra("easy", rbeasy.isChecked());
                i.putExtra("normal", rbnormal.isChecked());
                i.putExtra("hard", rbhard.isChecked());
                i.putExtra("extreme", rbExtreme.isChecked());
                i.putExtra("crazy", rbcrazy.isChecked());

                if (rb10sec.isChecked()) {

                    i.putExtra("time", "10");
                }

                else if (rb30sec.isChecked()) {

                    i.putExtra("time", "30");
                }
                else if (rb45sec.isChecked()) {

                    i.putExtra("time", "45");
                }
                else if (rb60sec.isChecked()) {

                    i.putExtra("time", "60");
                }
                else if (rb90sec.isChecked()) {

                    i.putExtra("time", "90");
                }


                i.putExtra("sum", false);
                i.putExtra("mul", false);
                i.putExtra("sub", true);
                i.putExtra("div", false);
                startActivity(i);


            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(OptionsActivity.this , DivActivity.class);
                i.putExtra("easy", rbeasy.isChecked());
                i.putExtra("normal", rbnormal.isChecked());
                i.putExtra("hard", rbhard.isChecked());
                i.putExtra("extreme", rbExtreme.isChecked());
                i.putExtra("crazy", rbcrazy.isChecked());

                if (rb10sec.isChecked()) {

                    i.putExtra("time", "10");
                }

                else if (rb30sec.isChecked()) {

                    i.putExtra("time", "30");
                }
                else if (rb45sec.isChecked()) {

                    i.putExtra("time", "45");
                }
                else if (rb60sec.isChecked()) {

                    i.putExtra("time", "60");
                }
                else if (rb90sec.isChecked()) {

                    i.putExtra("time", "90");
                }


                i.putExtra("sum", false);
                i.putExtra("mul", false);
                i.putExtra("sub", false);
                i.putExtra("div", true);

                startActivity(i);

            }
        });

    }


}

