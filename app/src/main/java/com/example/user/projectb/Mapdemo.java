package com.example.user.projectb;

import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class Mapdemo extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapdemo);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


public void search(View view){
    EditText editText= (EditText) findViewById(R.id.address);
    List<Address> addressList=null;
    String location=editText.getText().toString();
    if (location !=null||!equals("")){
        Geocoder geocoder=new Geocoder(this);
        try {
            addressList= geocoder.getFromLocationName(location,1);
            Address address=addressList.get(0);
            String add=addressList.get(0).getAddressLine(0);
            String city =addressList.get(0).getLocality();
            String contry=addressList.get(0).getCountryName();
            String postalcode=addressList.get(0).getPostalCode();
            String state=addressList.get(0).getAdminArea();
           
            String totaol_address=""+add+",   "+city+",  " +contry+",  "+postalcode+",  " +state+"";
            LatLng latLng=new LatLng(address.getLatitude(),address.getLongitude());


            mMap.addMarker(new MarkerOptions().position(latLng).title(totaol_address));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
       /* LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
    }
}
