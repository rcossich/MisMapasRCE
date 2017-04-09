package com.example.ricardocossich.mismapasrce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public double latitud;
    public double longitud;
    public float zoom_inicial=12;
    public float zoom_maximo=20;
    public float zoom_minimo=10;
    public String lugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ClicBoton01(View v) {
        latitud = 14.5538596;  //14.5585707;
        longitud = -90.7294001; //-90.729523;
        zoom_inicial = 19;
        zoom_minimo=12;
        zoom_maximo=30;
        lugar = "Antigua Guatemala";
        LlamarMapa(v);
    }


    public void ClicBoton02(View v) {
        latitud = 14.739965; //14.6789708;
        longitud = -91.1630804; //-91.2715769;
        zoom_inicial = 15;
        zoom_minimo=12;
        zoom_maximo=30;
        lugar = "Lago de Atitlan";
        LlamarMapa(v);
    }

    public void ClicBoton03(View v) {
        latitud = 17.2220118; //17.222046;
        longitud = -89.6232462; //-89.6258936;
        zoom_inicial = 18;
        zoom_minimo=16;
        zoom_maximo=25;
        lugar = "Parque Nacional Tikal";
        LlamarMapa(v);
    }

    public void ClicBoton04(View v) {
        latitud = 14.6417018;
        longitud = -90.5125176;
        zoom_inicial = 18;
        zoom_minimo=12;
        zoom_maximo=30;
        lugar = "Catedral Metropolitana";
        LlamarMapa(v);
    }
    public void LlamarMapa(View v) {
        Intent i = new Intent(this,MapsActivity.class);
        i.putExtra("Latitud",latitud);
        i.putExtra("Longitud",longitud);
        i.putExtra("Lugar",lugar);
        i.putExtra("pzoommin",zoom_minimo);
        i.putExtra("pzoommax",zoom_maximo);
        i.putExtra("pzoomini",zoom_inicial);
        startActivity(i);
    }
}
