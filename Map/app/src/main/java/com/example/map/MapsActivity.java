package com.example.map;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.map.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private HashMap<String, Integer> visited = new HashMap<String, Integer>();

//  private List<Building> buildings = new ArrayList<Building>();

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
        //get latlong for corners for specified place
        LatLng one = new LatLng(34.0200, -118.2830);
        LatLng two = new LatLng(34.0230, -118.2855);

        // CREATE A MARKER FOR EACH BUILDING
        initializeBuildings(mMap);

        // LARGER VIEW
        // LatLng one = new LatLng(34.0234396,-118.291267);
        //  LatLng two = new LatLng(34.0195451, -118.2856951);

        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        //add them to builder
        builder.include(one);
        builder.include(two);

        LatLngBounds bounds = builder.build();

        //get width and height to current display screen
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;

        // 20% padding
        int padding = (int) (width * 0.20);

        //set latlong bounds
        mMap.setLatLngBoundsForCameraTarget(bounds);

        //move camera to fill the bound to screen
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding));

        //set zoom to level to current so that you won't be able to zoom out viz. move outside bounds
        mMap.setMinZoomPreference(mMap.getCameraPosition().zoom);

        mMap.setOnMarkerClickListener( new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                // on marker click we are getting the title of our marker
                // which is clicked and displaying it in a toast message.
                String markerName = marker.getTitle();
                if (!visited.containsKey(markerName)) {
                    Toast.makeText(MapsActivity.this, "Clicked location is " + markerName, Toast.LENGTH_SHORT).show();
                    visited.put(markerName, 1);
                } else {

                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            MapsActivity.this.startActivity(new Intent(MapsActivity.this, popupActivity.class));

                        }
                    }, 100);

                }
                return false;
            }
        });


    }

    public void initializeBuildings(GoogleMap googleMap) {
        LatLng leavyLibrary = new LatLng(34.0217, -118.2828);
        googleMap.addMarker(new MarkerOptions().position(leavyLibrary).title("Leavy Library"));
        LatLng cpa = new LatLng(34.0213, -118.2840);
        googleMap.addMarker(new MarkerOptions().position(cpa).title("Center of International and Public Affairs "));
        LatLng doheny = new LatLng(34.0202, -118.2837);
        googleMap.addMarker(new MarkerOptions().position(doheny).title("Doheny Library"));
        LatLng pe = new LatLng(34.0213, -118.2863);
        googleMap.addMarker(new MarkerOptions().position(pe).title("USC Physical Education Building"));
        LatLng bookstore = new LatLng(34.0206, -118.2865);
        googleMap.addMarker(new MarkerOptions().position(bookstore).title("USC bookstore"));
        LatLng markHall = new LatLng(34.0235, -118.2852);
        googleMap.addMarker(new MarkerOptions().position(markHall).title("Mark Taper Hall of Humanities"));
        LatLng kaprielianHall = new LatLng(34.0224, -118.2910);
        googleMap.addMarker(new MarkerOptions().position(kaprielianHall).title("Kaprielian Hall"));
        LatLng salHall = new LatLng(34.0224, -118.2910);
        googleMap.addMarker(new MarkerOptions().position(salHall).title("Grace Ford Salvatori Hall"));
        LatLng jep = new LatLng(34.0229, -118.2840);
        googleMap.addMarker(new MarkerOptions().position(jep).title("Joint Educational Project (JEP) House"));
        LatLng sgm = new LatLng(34.0212, -118.2891);
        googleMap.addMarker(new MarkerOptions().position(sgm).title("Seeley G. Mudd Building"));
        LatLng salCs = new LatLng(34.0195, -118.2891);
        googleMap.addMarker(new MarkerOptions().position(salCs).title("Salvatori Computer Science Center"));

    }
}