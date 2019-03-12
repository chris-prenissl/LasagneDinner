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

    public static double tomato_factor = 0.25;
    public static double onions_factor = 0.5;
    public static double garlic_factor = 1;
    public static double basil_factor = 0.5;
    public static double ciabatta_factor = 0.2;


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


    }

}
