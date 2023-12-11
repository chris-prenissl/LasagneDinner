package com.dinner.lasagnedinner;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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

        updateGrocerylist();

    }

    public void updateGrocerylist() {

        setItemCounter(R.id.countVTomaten, tomato_factor, "kg");
        setItemCounter(R.id.countVZwiebeln, onions_factor, "st");
        setItemCounter(R.id.countVKnoblauch, garlic_factor, "st");
        setItemCounter(R.id.countVBasilikum, basil_factor, "Bund");
        setItemCounter(R.id.countVCiabatta, ciabatta_factor, "st");

    }

    public void setItemCounter (int viewId, double count, String unit) {
        DecimalFormat df = new DecimalFormat("#.##");
        String text = String.valueOf(df.format(count*counter_int)) + " " + unit;

        TextView view = findViewById(viewId);
        view.setText(text);
    }

}
