package com.example.lasagnedinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Objects;

public class ProcessingActivity extends AppCompatActivity {

    public int counter_int = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processing);
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView counter_person = findViewById(R.id.count_person);

        counter_person.setText("2");

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }

        int speiseNr = getIntent().getIntExtra("speise", 0);

        System.out.println(speiseNr);

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

    public void onPersonClick(View view) {
        int id = view.getId();
        TextView counter_person = findViewById(R.id.count_person);

        /*switch (id) {
            case R.id.button_minus:
                counter_int--;
                counter_person.setText(counter_int);
                break;

            case R.id.button_plus:
                counter_int++;
                counter_person.setText(counter_int);
                break;



        }*/
    }

}
