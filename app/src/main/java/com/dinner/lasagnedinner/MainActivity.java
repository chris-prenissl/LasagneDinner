package com.dinner.lasagnedinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public int counter_person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("create");

        counter_person = getIntent().getIntExtra("count_person", 2);
    }

    public void onProcessing0 (View view) {
        Intent i = new Intent(this, ProcessingActivity.class);
        Bundle b = new Bundle();

        b.putInt("speise", 0);
        b.putInt("count_person", counter_person);
        i.putExtras(b);

        startActivity(i);

    }


    public void onProcessing1 (View view) {
        Intent i = new Intent(this, ProcessingActivity.class);
        Bundle b = new Bundle();

        b.putInt("speise", 1);
        b.putInt("count_person", counter_person);
        i.putExtras(b);

        startActivity(i);

    }

    public void onProcessing2 (View view) {
        Intent i = new Intent(this, ProcessingActivity.class);
        Bundle b = new Bundle();

        b.putInt("speise", 2);
        b.putInt("count_person", counter_person);
        i.putExtras(b);

        startActivity(i);

    }

    public void onProcessing3 (View view) {
        Intent i = new Intent(this, ProcessingActivity.class);
        Bundle b = new Bundle();

        b.putInt("speise", 3);
        b.putInt("count_person", counter_person);
        i.putExtras(b);

        startActivity(i);

    }
}
