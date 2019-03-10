package com.example.lasagnedinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onProcessing0 (View view) {
        Intent i = new Intent(this, ProcessingActivity.class);
        Bundle b = new Bundle();

        b.putInt("speise", 0);
        i.putExtras(b);

        startActivity(i);

    }


    public void onProcessing1 (View view) {
        Intent i = new Intent(this, ProcessingActivity.class);
        Bundle b = new Bundle();

        b.putInt("speise", 1);
        i.putExtras(b);

        startActivity(i);

    }

    public void onProcessing2 (View view) {
        Intent i = new Intent(this, ProcessingActivity.class);
        Bundle b = new Bundle();

        b.putInt("speise", 2);
        i.putExtras(b);

        startActivity(i);

    }
}
