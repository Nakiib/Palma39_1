package com.example.palma39_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<PersonajeVo> listaPersonajes;
    RecyclerView recyclerPersonajes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        construirRecycler();
    }

    public void registrar(View view){
        Intent intento= new Intent(this, Darse_Alta.class);
        startActivity(intento);
        //yo que se
    }
    public void iniciar_sesion(View view){
        Intent intento = new Intent(this, IniciarSesion.class);
        startActivity(intento);
    }
    private void llenarPersonajes () {
        listaPersonajes.add(new PersonajeVo("Distrito 91 001","BlaBlaBlaBlaInfoInfoInfo",R.drawable.discoprimeroo));
        listaPersonajes.add(new PersonajeVo("Distrito 91 002","BlaBlaBlaBlaInfoInfoInfo",R.drawable.discosegundoo));
        listaPersonajes.add(new PersonajeVo("Distrito 91 003","BlaBlaBlaBlaInfoInfoInfo",R.drawable.discoterceroo));
        listaPersonajes.add(new PersonajeVo("Distrito 91 004","BlaBlaBlaBlaInfoInfoInfo",R.drawable.discocuartoo));
        listaPersonajes.add(new PersonajeVo("Hooded Rec 001","BlaBlaBlaBlaInfoInfoInfo",R.drawable.discoquintoo));
        listaPersonajes.add(new PersonajeVo("Hooded Rec 002","BlaBlaBlaBlaInfoInfoInfo",R.drawable.discosextoo));
        listaPersonajes.add(new PersonajeVo("Hooded Rec 003","BlaBlaBlaBlaInfoInfoInfo",R.drawable.discoseptimoo));
        listaPersonajes.add(new PersonajeVo("Hooded Rec 004","BlaBlaBlaBlaInfoInfoInfo",R.drawable.discooctavoo));
        listaPersonajes.add(new PersonajeVo("Hooded Rec 005","BlaBlaBlaBlaInfoInfoInfo",R.drawable.disconovenoo));

    }
    private void construirRecycler() {
        //instanciamos listapersoinajes
        listaPersonajes = new ArrayList<>();
        recyclerPersonajes = findViewById(R.id.RecyclerId);

        if (Utilidades.visualizacion==Utilidades.LIST){
            recyclerPersonajes.setLayoutManager(new LinearLayoutManager(this));
        } else {
            recyclerPersonajes.setLayoutManager(new GridLayoutManager(this,3));
        }
        /* COMENTAMOS ESTAS DOS LINEAS PORQUE SON DEL PRIMER RECYCLER SENCILLO.
         LO QUE HACEMOS ES METER LAS DOS EN EL IF PARA GENERAR LA LOGICA DE SELECCION DEPENDIENDO DE QUE BOTON PULSEMOS. lIST O GRID
        //recyclerPersonajes.setLayoutManager(new LinearLayoutManager(this)); lo comentamos para probar el gridLayout a priori lo volveremos a activar
        //recyclerPersonajes.setLayoutManager(new GridLayoutManager(this,3));//gridlayout con cantidad de columnas*/
        llenarPersonajes();

        AdaptadorPersonajes adapter = new AdaptadorPersonajes(listaPersonajes);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Seleccion: "+
                        listaPersonajes.get(recyclerPersonajes.getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_SHORT).show();

            }
        });
        recyclerPersonajes.setAdapter(adapter);


    }
}