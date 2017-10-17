package com.example.jsordones.lenguajes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LenguajeAdapter.onLenguajeSelectedListener{

    RecyclerView lenguajeRecyclerView;
    LenguajeAdapter lenguajeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lenguajeRecyclerView = (RecyclerView) findViewById(R.id.recycler_main);
        lenguajeRecyclerView.setHasFixedSize(true);
        lenguajeRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        lenguajeAdapter = new LenguajeAdapter(this,this);

        llenarDatos();

        lenguajeRecyclerView.setAdapter(lenguajeAdapter);
    }

    private void llenarDatos() {
        List<Lenguaje> lista = new ArrayList<>();
        lista.add(new Lenguaje(R.drawable.java, "Java", getString(R.string.Descripcion_Java)));
        lista.add(new Lenguaje(R.drawable.c, "C", getString(R.string.Descripcion_C)));
        lista.add(new Lenguaje(R.drawable.cpp, "C++", getString(R.string.Descripcion_CPP)));
        lista.add(new Lenguaje(R.drawable.cgato, "C#", getString(R.string.Descripcion_CS)));
        lista.add(new Lenguaje(R.drawable.python, "Phython", getString(R.string.Descripcion_PH)));
        lista.add(new Lenguaje(R.drawable.vbnet, "VisualBasic.net", getString(R.string.Descripcion_VB)));
        lista.add(new Lenguaje(R.drawable.php, "PHP", getString(R.string.Descripcion_PHP)));
        lista.add(new Lenguaje(R.drawable.javascript, "JavaScript", getString(R.string.Descripcion_JS)));
        lista.add(new Lenguaje(R.drawable.delphi, "Delphy-Object Pascal", getString(R.string.Descripcion_DH)));
        lista.add(new Lenguaje(R.drawable.swift, "SWIFT", getString(R.string.Descripcion_SW)));

        lenguajeAdapter.setDataset(lista);
    }

    @Override
    public void onLenguajeSelected(Lenguaje len) {
        Intent intent = new Intent(getApplicationContext(), DetalleActivity.class);
        intent.putExtra("equipo", len);
        startActivity(intent);
    }

}
