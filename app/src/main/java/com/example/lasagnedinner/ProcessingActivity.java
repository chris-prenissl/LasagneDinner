package com.example.lasagnedinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.view.View.OnClickListener;


import java.text.DecimalFormat;
import java.util.Objects;

public class ProcessingActivity extends AppCompatActivity {

    public int counter_int = 2;

    //Chiabatta
    public static double tomato_factor = 0.25;
    public static double onions_factor = 0.5;
    public static double garlic_factor = 1;
    public static double basil_factor = 0.5;
    public static double ciabatta_factor = 0.2;

    //Lasagne
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

    //Bananen
    public static double bananen_factor = 1;
    public static double vanille_factor = 1;
    public static double rum_factor = 25;
    public static double bananenlikoer_factor = 25;
    public static double butter_factor = 25;
    public static double zucker_factor = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processing);
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView counter_person = findViewById(R.id.count_person);

        counter_int = getIntent().getIntExtra("count_person", 2);


        counter_person.setText(String.valueOf(counter_int));

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        }

        updateGrocerylist();

        int speiseNr = getIntent().getIntExtra("speise", 0);

        TextView target;

        switch (speiseNr) {

            case 0:
                target = findViewById(R.id.zutatenTitel);
                target.getParent().requestChildFocus(target,target);
                //TODO: get exact scrolling pos.
                break;

            case 1:
                target = findViewById(R.id.schritt2);
                target.getParent().requestChildFocus(target,target);
                //TODO: get exact scrolling pos.
                break;

            case 2:
                target = findViewById(R.id.schritt4);
                target.getParent().requestChildFocus(target,target);
                break;
        }


    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        Bundle b = new Bundle();

        System.out.println("back");

        b.putInt("count_person", counter_int);
        i.putExtras(b);
        startActivity(i);

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
        DecimalFormat df = new DecimalFormat("#.##");

        //Chiabatta
        TextView tomato_amount = findViewById(R.id.countVTomaten);
        tomato_amount.setText(String.valueOf(df.format(tomato_factor*counter_int)));
        TextView onion_amount = findViewById(R.id.countVZwiebeln);
        onion_amount.setText(String.valueOf(df.format(onions_factor*counter_int)));
        TextView garlic_amount = findViewById(R.id.countVKnoblauch);
        garlic_amount.setText(String.valueOf(df.format(garlic_factor*counter_int)));
        TextView basil_amount = findViewById(R.id.countVBasilikum);
        basil_amount.setText(String.valueOf(df.format(basil_factor*counter_int)));
        TextView ciabatta_amount = findViewById(R.id.countVCiabatta);
        ciabatta_amount.setText(String.valueOf(df.format(ciabatta_factor*counter_int)));

        //Lasagne
        TextView lasagneplatten_amount = findViewById(R.id.countHLasagneplatten);
        lasagneplatten_amount.setText(String.valueOf(df.format(lasagne_factor*counter_int)));
        TextView hackfleisch_amount = findViewById(R.id.countHHackfleisch);
        hackfleisch_amount.setText(String.valueOf(df.format(hackfleisch_factor*counter_int)));
        TextView pastomaten_amount = findViewById(R.id.countHpassierteTomaten);
        pastomaten_amount.setText(String.valueOf(df.format(pastomaten_factor*counter_int)));
        TextView zwiebeln_amount = findViewById(R.id.countHZwiebeln);
        zwiebeln_amount.setText(String.valueOf(df.format(zwiebeln_factor*counter_int)));
        TextView knoblauch_amount = findViewById(R.id.countHKnoblauch);
        knoblauch_amount.setText(String.valueOf(df.format(knoblauch_factor*counter_int)));
        TextView karotten_amount = findViewById(R.id.countHKarotten);
        karotten_amount.setText(String.valueOf(df.format(karotten_factor*counter_int)));
        TextView milch_amount = findViewById(R.id.countHMilch);
        milch_amount.setText(String.valueOf(df.format(milch_factor*counter_int)));

        setItemCounter(R.id.countHMozzarella,mozzarella_factor);
        setItemCounter(R.id.countHMehl, mehl_factor);
        setItemCounter(R.id.countHRotwein, rotwein_factor);

        setItemCounter(R.id.countNBananen, bananen_factor);
        setItemCounter(R.id.countNButter, butter_factor);
        setItemCounter(R.id.countNBananenlikoer, bananenlikoer_factor);
        setItemCounter(R.id.countNVanilleEis, vanille_factor);
        setItemCounter(R.id.countNRum, rum_factor);
        setItemCounter(R.id.countNButter, butter_factor);
        setItemCounter(R.id.countNZucker, zucker_factor);
    }

    public void setItemCounter (int viewId, double count) {
        DecimalFormat df = new DecimalFormat("#.##");

        TextView view = findViewById(viewId);
        view.setText(String.valueOf(df.format(count*counter_int)));
    }

}
