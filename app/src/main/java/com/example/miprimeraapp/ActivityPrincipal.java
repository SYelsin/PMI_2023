package com.example.miprimeraapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityPrincipal extends AppCompatActivity {

    Button btningresar;
    Button btnlista;
    Button btncombo;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btningresar = (Button) findViewById(R.id.btningresar);
        btnlista = (Button) findViewById(R.id.btnlista);
        btncombo = (Button) findViewById(R.id.btncombo);
        btningresar.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });

        btnlista.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),ActivityListView.class);
            startActivity(intent);
        });

        btncombo.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),activity_combo.class);
            startActivity(intent);
        });

    }
}