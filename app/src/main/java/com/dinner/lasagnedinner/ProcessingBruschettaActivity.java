package com.dinner.lasagnedinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Objects;

public class ProcessingBruschettaActivity extends AppCompatActivity {

    public int counter_int = 2;


    public static double tomato_factor = 0.25;
    public static double onions_factor = 0.5;
    public static double garlic_factor = 1;
    public static double basil_factor = 0.5;
    public static double ciabatta_factor = 0.2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processingbruschetta);
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView counter_person = findViewById(R.id.count_person);



        counter_person.setText(String.valueOf(counter_int));

        if (toolbar != null) {

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

        setItemCounter(R.id.countVTomaten, tomato_factor);
        setItemCounter(R.id.countVZwiebeln, onions_factor);
        setItemCounter(R.id.countVKnoblauch, garlic_factor);
        setItemCounter(R.id.countVBasilikum, basil_factor);
        setItemCounter(R.id.countVCiabatta, ciabatta_factor);

    }

    public void setItemCounter (int viewId, double count) {
        DecimalFormat df = new DecimalFormat("#.##");

        TextView view = findViewById(viewId);
        view.setText(String.valueOf(df.format(count*counter_int)));
    }

}
