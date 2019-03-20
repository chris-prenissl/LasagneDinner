package com.dinner.lasagnedinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Objects;

public class ProcessingLasagneActivity extends AppCompatActivity {

    public int counter_int = 2;


    public static double lasagne_factor = 100;
    public static double hackfleisch_factor = 100;
    public static double pastomaten_factor = 200;
    public static double zwiebeln_factor = 0.5;
    public static double knoblauch_factor = 0.5;
    public static double karotten_factor = 0.5;
    public static double milch_factor = 100;
    public static double mozzarella_factor = 0.5;
    public static double mehl_factor = 50;
    public static double rotwein_factor = 50;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processinglasagne);
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView counter_person = findViewById(R.id.count_person);

        counter_person.setText(String.valueOf(counter_int));

        if (toolbar != null) {

            toolbar.setTitle("Lasagne Bolognese");

            setSupportActionBar(toolbar);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);

        }

        updateGrocerylist();


    }


    public void onPersonClick(View view) {
        int id = view.getId();
        TextView counter_person = findViewById(R.id.count_person);

        switch (id) {
            case R.id.button_minus:
                if (counter_int > 1) {
                    counter_int--;
                    counter_person.setText(String.valueOf(counter_int));
                }
                break;

            case R.id.button_plus:
                if (counter_int < 6) {
                    counter_int++;
                    counter_person.setText(String.valueOf(counter_int));
                }
                break;
        }
        updateGrocerylist();

    }

    public void updateGrocerylist() {

        setItemCounter(R.id.countHLasagneplatten, lasagne_factor, "g");
        setItemCounter(R.id.countHHackfleisch, hackfleisch_factor, "g");
        setItemCounter(R.id.countHpassierteTomaten, pastomaten_factor, "ml");
        setItemCounter(R.id.countHZwiebeln, zwiebeln_factor, "st");
        setItemCounter(R.id.countHKnoblauch, knoblauch_factor, "st");
        setItemCounter(R.id.countHKarotten, karotten_factor, "st");
        setItemCounter(R.id.countHMilch, milch_factor, "ml");
        setItemCounter(R.id.countHMozzarella,mozzarella_factor, "pck");
        setItemCounter(R.id.countHMehl, mehl_factor, "g");
        setItemCounter(R.id.countHRotwein, rotwein_factor, "ml");
    }

    public void setItemCounter (int viewId, double count, String unit) {
        DecimalFormat df = new DecimalFormat("#.##");
        String text = String.valueOf(df.format(count*counter_int)) + " " + unit;

        TextView view = findViewById(viewId);
        view.setText(text);
    }

}
