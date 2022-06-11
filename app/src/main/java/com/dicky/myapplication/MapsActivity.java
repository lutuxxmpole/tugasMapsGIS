package com.dicky.myapplication;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.dicky.myapplication.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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

        // Add a marker in Untad and move the camera
        LatLng untad = new LatLng(-0.8365181870862147, 119.89368345419328);
        int tinggi = 100;
        int lebar = 100;
        BitmapDrawable bitmapDraw = (BitmapDrawable) getResources().getDrawable(R.drawable.pin_marker_biru);
        Bitmap b = bitmapDraw.getBitmap();
        Bitmap markerKecil = Bitmap.createScaledBitmap(b, lebar, tinggi, false);
        mMap.addMarker(new MarkerOptions().position(untad).title("Ini adalah Kampus Universitas Tadulako")
                .snippet("Ini adalah kampus kami")
                .icon(BitmapDescriptorFactory.fromBitmap(markerKecil)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(untad, 13.5f));

        LatLng danau = new LatLng(-1.3085490654824001, 120.0732282167644);
        mMap.addMarker(new MarkerOptions().position(danau).title("Marker in Danau Lindu"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(danau));

        LatLng talise = new LatLng(-0.880809, 119.837632);
        mMap.addMarker(new MarkerOptions().position(talise).title("Pantai Talise"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(talise));

        LatLng citraland = new LatLng(-0.8317868729977969, 119.88323762666253);
        mMap.addMarker(new MarkerOptions().position(citraland).title("Citraland Palu "));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(citraland));

        LatLng polda = new LatLng(-0.8866804860893348, 119.8860344462495);
        mMap.addMarker(new MarkerOptions().position(polda).title("Polda Sulteng"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(polda));

        mMap.addPolyline(new PolylineOptions().add(
                talise,
                new LatLng(-0.883463, 119.846599),
                new LatLng(-0.884128, 119.848080),
                new LatLng(-0.886102, 119.847007),
                new LatLng(-0.888591, 119.850097),
                new LatLng(-0.896186, 119.858980),
                new LatLng(-0.897216, 119.867864),
                new LatLng(-0.889277, 119.870610),
                new LatLng(-0.884557, 119.871554),
                new LatLng(-0.870740, 119.875245),
                new LatLng(-0.865591, 119.878893),
                new LatLng(-0.860055, 119.881682),
                new LatLng(-0.853147, 119.883528),
                new LatLng(-0.845466, 119.882884),
                citraland
                        ).width(10)
                        .color(Color.GREEN)
        );

    }
}