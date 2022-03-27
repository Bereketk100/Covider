package com.example.map;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Map;

public class USCMap {
    private ArrayList<Building> uscBuildings;

    public void setUscBuildings() {
        uscBuildings.add(new Building(1,"Leavey Library", 34.0217, -118.2828));
        uscBuildings.add(new Building(1,"Center of International and Public Affairs", 34.0213, -118.2840));
        uscBuildings.add(new Building(1,"Doheny Memorial Library", 34.0202, -118.2837));
        uscBuildings.add(new Building(1,"USC Physical Education Building", 34.0213, -118.2863));
        uscBuildings.add(new Building(1,"USC bookstore", 34.0206, -118.2865));
        uscBuildings.add(new Building(1,"Mark Taper Hall of Humanities", 34.0235, -118.2852));
        uscBuildings.add(new Building(1,"Kaprielian Hall", 34.0224, -118.2910));
        uscBuildings.add(new Building(1,"Grace Ford Salvatori Hall", 34.0224, -118.2910));
        uscBuildings.add(new Building(1,"Joint Educational Project (JEP) House", 34.0229, -118.2840));
        uscBuildings.add(new Building(1,"Seeley G. Mudd Building", 34.0212, -118.2891));
        uscBuildings.add(new Building(1,"Salvatori Computer Science Center", 34.0195, -118.2891));
        uscBuildings.add(new Building(1,"Lyon Center", 34.024273982347424, -118.28844182109525));
        uscBuildings.add(new Building(1,"Uytengsu Aquatics Center", 34.02398408084013, -118.28842171842793));
        uscBuildings.add(new Building(1,"John McKay Center", 34.02312140286485, -118.28766483630059));
        uscBuildings.add(new Building(1,"Wallis Annenberg Hall", 34.020821731157426, -118.28709493391072));
        uscBuildings.add(new Building(1,"Parkside Apartments", 34.018818984872325, -118.29094257950142));
        uscBuildings.add(new Building(1,"Powell Hall", 34.019156078095335, -118.28885934798686));
        uscBuildings.add(new Building(1,"Ronald Tutor Hall", 34.020176235914825, -118.28991601586922));
        uscBuildings.add(new Building(1,"Fertitta Hall", 34.01881439884232, -118.28240853143427));
        uscBuildings.add(new Building(1,"Leventhal School of Accounting", 34.019151529654565, -118.28556969127716));
        uscBuildings.add(new Building(1,"Zumberge Hall of Science", 34.0217, -118.2828));
        uscBuildings.add(new Building(1,"Student Union", 34.020250184652944, -118.28565178083494));
        uscBuildings.add(new Building(1,"Bovard Administration Building", 34.020947159208745, -118.2855621558506));

    }


    public ArrayList<Building> getUscBuildings() {
        return uscBuildings;
    }

}
