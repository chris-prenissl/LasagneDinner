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

    public void onProcessing (View view) {
        Intent i = new Intent(this, ProcessingActivity.class);
        Bundle b = new Bundle();
        int buttonId = view.getId();

        b.putInt("speise", buttonId);
        i.putExtra("bundle", b);

        startActivity(i);

    }
}
