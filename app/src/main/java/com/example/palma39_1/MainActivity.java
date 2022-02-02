package com.example.palma39_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void registrar(View view){
        Intent intento= new Intent(this, Darse_Alta.class);
        startActivity(intento);
    }
    public void iniciar_sesion(View view){
        Intent intento = new Intent(this, IniciarSesion.class);
        startActivity(intento);
    }
}