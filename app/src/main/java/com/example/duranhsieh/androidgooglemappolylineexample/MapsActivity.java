package com.example.duranhsieh.androidgooglemappolylineexample;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Polyline mMutablePolyline;
    private static final LatLng A = new LatLng(23.36, 120.48);
    private static final LatLng B = new LatLng(23.57, 120.68);
    private static final LatLng C = new LatLng(23.78, 120.89);
    private static final LatLng D = new LatLng(23.99, 121.00);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng taiwan = new LatLng(23.97, 120.98);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(taiwan, 8));

        mMutablePolyline = mMap.addPolyline(new PolylineOptions()
                .add(A, B, C, D)
                .width(5)
                .color(Color.BLUE)
                .clickable(true));

        mMap.setOnPolylineClickListener(new GoogleMap.OnPolylineClickListener() {
            @Override
            public void onPolylineClick(Polyline polyline) {
                polyline.setColor(polyline.getColor() ^ 0x00ffffff);
            }
        });
    }
}
