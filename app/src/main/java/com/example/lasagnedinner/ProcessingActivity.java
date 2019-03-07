package com.example.lasagnedinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

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

        Bundle b = getIntent().getBundleExtra("bundle");
        int buttonId = b.getInt("speise");
        System.out.println(buttonId);

        switch (buttonId) {
            case R.id.vorspeiseButton:
                System.out.println("Vorspeise");
            case R.id.hauptspeiseButton:
                System.out.println("Hauptspeise");
            case R.id.nachspeiseButton:
                System.out.println("Nachspeise");
        }



    }

}
