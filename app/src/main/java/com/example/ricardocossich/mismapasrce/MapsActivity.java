package com.example.ricardocossich.mismapasrce;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double platitud=-34; //dejamos por defecto las de Sydney
    private double plongitud=151; //dejamos por defecto las de Sydney
    private float pzoommin=10;
    private float pzoommax=20;
    private float pzoomini=18;
    private String plugar = "Marker in Sydney";   //dejamos por defecto las de Sydney

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Bundle parametros = getIntent().getExtras();
        if (parametros!= null) {
            platitud = parametros.getDouble(getResources().getString(R.string.platitud));
            plongitud = parametros.getDouble(getResources().getString(R.string.plongitud));
            plugar = parametros.getString(getResources().getString(R.string.plugar));
            pzoommin = parametros.getFloat(getResources().getString(R.string.pzoommin));
            pzoommax = parametros.getFloat(getResources().getString(R.string.pzoommax));
            pzoomini = parametros.getFloat(getResources().getString(R.string.pzoomini));
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng punto = new LatLng(platitud, plongitud);
        mMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(plugar)
                .snippet("Conocer "+plugar)
                .visible(true)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.guatemala48))
        );
        mMap.setBuildingsEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);
        mMap.setMinZoomPreference(pzoommin);
        mMap.setMaxZoomPreference(pzoommax);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(punto)
                .zoom(pzoomini)
                .bearing(75)
                .tilt(3)
                .build();
        mMap.moveCamera(CameraUpdateFactory
                .newLatLngZoom(punto,pzoommin)
        );
        mMap.animateCamera(CameraUpdateFactory.zoomTo(pzoomini),8000,null);
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),2000,null);
    }
}
