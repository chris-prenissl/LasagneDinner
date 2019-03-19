package com.dinner.lasagnedinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Objects;

public class ProcessingBananaActivity extends AppCompatActivity {

    public int counter_int = 2;

    public static double bananen_factor = 1;
    public static double vanille_factor = 1;
    public static double rum_factor = 25;
    public static double bananenlikoer_factor = 25;
    public static double butter_factor = 25;
    public static double zucker_factor = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processingbanana);
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView counter_person = findViewById(R.id.count_person);

        counter_person.setText(String.valueOf(counter_int));

        if (toolbar != null) {

            toolbar.setTitle("Flambierte Bananen");

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
        setItemCounter(R.id.countNBananen, bananen_factor, "st");
        setItemCounter(R.id.countNButter, butter_factor, "g");
        setItemCounter(R.id.countNBananenlikoer, bananenlikoer_factor, "ml");
        setItemCounter(R.id.countNVanilleEis, vanille_factor, "Kugel");
        setItemCounter(R.id.countNRum, rum_factor, "ml");
        setItemCounter(R.id.countNButter, butter_factor, "g");
        setItemCounter(R.id.countNZucker, zucker_factor, "g");
    }

    public void setItemCounter (int viewId, double count, String unit) {
        DecimalFormat df = new DecimalFormat("#.##");
        String text = String.valueOf(df.format(count*counter_int)) + " " + unit;

        TextView view = findViewById(viewId);
        view.setText(text);
    }

}
