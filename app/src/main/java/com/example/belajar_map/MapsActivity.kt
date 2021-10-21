package com.example.belajar_map

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.example.belajar_map.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-6.3272478, 106.8391617)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Digitalindo"))

//        change setting zoom

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,16f))

//        setting zoom in out
        mMap.uiSettings.isZoomControlsEnabled = true

//
        mMap.uiSettings.isCompassEnabled = true


//        type map
//        mMap.mapType = googleMap.MAP_TYPE_HYBRID

//        add new marker
        val lang = LatLng(-6.2012823,106.9067767)
        mMap.addMarker(MarkerOptions()
//                merubah warna icon
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))

//                change icon
//            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher_background))

            .position(lang)
            .title("ini lokasi baru")
            .snippet("ini deskripsi"))

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lang,16f))

        val poly = PolylineOptions()
        poly.add(LatLng(-6.3272478, 106.8391617))
        poly.add(LatLng(-6.2012823,106.9067767))
        poly.color(Color.BLACK)
        poly.width(3f)
//        agar tikungan terlihat
        poly.geodesic(true)

        mMap.addPolyline(poly)

//
    }
}