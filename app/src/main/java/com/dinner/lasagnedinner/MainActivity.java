package com.dinner.lasagnedinner;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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
        Intent i = new Intent(this, ProcessingBruschettaActivity.class);

        startActivity(i);

    }


    public void onProcessing1 (View view) {
        Intent j = new Intent(this, ProcessingLasagneActivity.class);

        startActivity(j);

    }

    public void onProcessing2 (View view) {
        Intent k = new Intent(this, ProcessingBananaActivity.class);

        startActivity(k);

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("App schließen")
                .setMessage("Willst du die App wirklich beenden?")
                .setPositiveButton("Ja", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("Nein", null)
                .show();
    }
}
