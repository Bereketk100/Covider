package com.example.firebaselogin.activities;

import static com.example.firebaselogin.activities.MainActivity.mFirestore;
import static com.example.firebaselogin.activities.MainActivity.mUsers;
import static com.example.firebaselogin.activities.MainActivity.thisUser;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.example.firebaselogin.BuildingQuestion;
import com.example.firebaselogin.R;
import com.example.firebaselogin.classes.USCMap;
import com.example.firebaselogin.classes.User;
import com.example.firebaselogin.databinding.ActivityMapsBinding;
import com.example.firebaselogin.enums.Status;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private HashMap<String, Integer> visited = new HashMap<String, Integer>();
    private Button prof;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private Button btnChekIn, btnViewRisk, btnViewStats, back, riskDone;
    private FirebaseAuth mAuth;

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
        Button logout, homepage;
        mMap = googleMap;
        //get latlong for corners for specified place
        LatLng one = new LatLng(34.02171266975199, -118.29074167058317);
        LatLng two = new LatLng(34.02092529998721, -118.2796865021559);

        // CREATE A MARKER FOR EACH BUILDING
        initializeBuildings(mMap);

        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        //add them to builder
        builder.include(one);
        builder.include(two);

        LatLngBounds bounds = builder.build();

        //get width and height to current display screen
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;

        // 10% padding
        int padding = (int) (width * 0.10);

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
                if (thisUser.getStatus() == Status.Infected) {
                    showSnackBar(MapsActivity.this, "You are Infected, please quarantine and schedule a test!");
                    //return false;
                }
                String markerName = marker.getTitle();
                if (!visited.containsKey(markerName)) {
                    Toast.makeText(MapsActivity.this, "Clicked location is " + markerName, Toast.LENGTH_SHORT).show();
                    visited.put(markerName, 1);
                } else {

                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {

                            createNewContactDialog();
                            btnChekIn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Log.d("BUTTON", "Check in btn pressed!");
                                    //updating list of buildings
                                    System.out.println(markerName);

                                    if(markerName.equals("Fertitta Hall") || markerName.equals("Leavey Library") ||markerName.equals("Kaprielian Hall") || markerName.equals("Lyon Center") || markerName.equals("Leventhal School of Accounting")) {
                                        Toast.makeText(MapsActivity.this, "Form Required!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(MapsActivity.this, BuildingQuestion.class));
                                    } else {
                                        CollectionReference buildingsRef = mFirestore.collection("buildings");
                                        //query for specific building
                                        Query buildingQuery = buildingsRef.whereEqualTo("name", markerName);
                                        //execute query
                                        buildingQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                if (task.isSuccessful()) {
                                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                                        Log.d("QUERY", document.getId() + " => " + document.getData());
                                                        DocumentReference docRef = document.getReference();

                                                        Date d = new Date();
                                                        docRef.collection("presentUsers").document(d.toString()).set(thisUser).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                            @Override
                                                            public void onSuccess(Void unused) {
                                                                Log.d("ADD", "Student Document has been saved!");
                                                            }
                                                        }).addOnFailureListener(new OnFailureListener() {
                                                            @Override
                                                            public void onFailure(@NonNull Exception e) {
                                                                Log.d("ADD", "Document was not saved", e);
                                                            }
                                                        });
                                                    }
                                                } else {
                                                    Log.d("QUERY", "Error getting documents: ", task.getException());
                                                }
                                            }
                                        });

                                    }
                                    //restarts activity
                                    startActivity(new Intent(MapsActivity.this, MapsActivity.class));


                                }
                            });
                            btnViewRisk.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    createRiskPopup();
                                }
                            });


                        }
                    }, 100);

                }
                return false;
            }
        });

        logout = findViewById(R.id.btnLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });


        prof = findViewById(R.id.btnprof);
        prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchProf();
            }
        });

        homepage = findViewById(R.id.home);
        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home();
            }
        });

    }


    public void logout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(MapsActivity.this, LoginActivity.class));
    }

    public void home() {
        startActivity(new Intent(MapsActivity.this, MainActivity.class));
    }

    public void showSnackBar(Activity activity, String message){
        View rootView = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar.make(rootView, message, 1000).show();
    }

    public void fetchProf(){
        startActivity(new Intent(MapsActivity.this, ProfileActivity.class));
        //maybe add onFailureListener
    }


    public void initializeBuildings(GoogleMap googleMap) {
        USCMap uscMap = new USCMap();
        LatLng leavyLibrary = new LatLng(34.0217, -118.2828);
        googleMap.addMarker(new MarkerOptions().position(leavyLibrary).title("Leavey Library"));
        LatLng cpa = new LatLng(34.0213, -118.2840);
        googleMap.addMarker(new MarkerOptions().position(cpa).title("Center of International and Public Affairs "));
        LatLng doheny = new LatLng(34.0202, -118.2837);
        googleMap.addMarker(new MarkerOptions().position(doheny).title("Doheny Memorial Library"));
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
        LatLng lrc = new LatLng(34.024273982347424, -118.28844182109525);
        googleMap.addMarker(new MarkerOptions().position(lrc).title("Lyon Center"));
        LatLng uac = new LatLng(34.02398408084013, -118.28842171842793);
        googleMap.addMarker(new MarkerOptions().position(uac).title("Uytengsu Aquatics Center"));
        LatLng jmc = new LatLng(34.02312140286485, -118.28766483630059);
        googleMap.addMarker(new MarkerOptions().position(jmc).title("John McKay Center"));
        LatLng ann = new LatLng(34.020821731157426, -118.28709493391072);
        googleMap.addMarker(new MarkerOptions().position(ann).title("Wallis Annenberg Hall"));
        LatLng pks = new LatLng(34.018818984872325, -118.29094257950142);
        googleMap.addMarker(new MarkerOptions().position(pks).title("Parkside Apartments"));
        LatLng phe = new LatLng(34.019156078095335, -118.28885934798686);
        googleMap.addMarker(new MarkerOptions().position(phe).title("Powell Hall"));
        LatLng rth = new LatLng(34.020176235914825, -118.28991601586922);
        googleMap.addMarker(new MarkerOptions().position(rth).title("Ronald Tutor Hall"));
        LatLng fertit = new LatLng(34.01881439884232, -118.28240853143427);
        googleMap.addMarker(new MarkerOptions().position(fertit).title("Fertitta Hall"));
        LatLng leventhal = new LatLng(34.019151529654565, -118.28556969127716);
        googleMap.addMarker(new MarkerOptions().position(leventhal).title("Leventhal School of Accounting"));
        LatLng zhs = new LatLng(34.0192540898282, -118.28634846853177);
        googleMap.addMarker(new MarkerOptions().position(zhs).title("Zumberge Hall of Science"));
        LatLng stu = new LatLng(34.020250184652944, -118.28565178083494);
        googleMap.addMarker(new MarkerOptions().position(stu).title("Student Union"));
        LatLng adm = new LatLng(34.020947159208745, -118.2855621558506);
        googleMap.addMarker(new MarkerOptions().position(adm).title("Bovard Administration Building"));
    }


    public void createNewContactDialog(){
            dialogBuilder = new AlertDialog.Builder(this);
            final View popup = getLayoutInflater().inflate(R.layout.activity_popup, null);
            btnChekIn = popup.findViewById(R.id.checkIn);
            btnViewRisk = popup.findViewById(R.id.viewRisk);
            btnViewStats = popup.findViewById(R.id.viewStats);
            back = popup.findViewById(R.id.back);
            // show the popup window
            dialogBuilder.setView(popup);
            dialog = dialogBuilder.create();
            dialog.show();
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
    }
    private void createRiskPopup() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View popup = getLayoutInflater().inflate(R.layout.view_risk_factor, null);
        back = popup.findViewById(R.id.back);
        riskDone = popup.findViewById(R.id.doneFeature);
        // show the popup window
        dialogBuilder.setView(popup);
        dialog = dialogBuilder.create();
        dialog.show();
        riskDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }

}
