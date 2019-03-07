package com.example.lasagnedinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Objects;

public class ProcessingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processing);
        Toolbar toolbar = findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }

        int speiseNr = getIntent().getIntExtra("speise", 0);

        System.out.println(speiseNr);

        TextView target;

        switch (speiseNr) {
            case 1:
                target = findViewById(R.id.zutatenTitel);
                target.getParent().getParent().getParent().requestChildFocus(target,target);
                break;

            case 2:
                target = findViewById(R.id.schritt4);
                target.getParent().getParent().getParent().requestChildFocus(target,target);
                break;
        }


    }

}
