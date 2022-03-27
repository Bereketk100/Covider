package com.example.firebaselogin.classes;

 class Building {
     private String name;
     private double latitude;
     private double longitude;
     private int id;
     private int riskFactor = 0;

     public Building(int id, String name, double latitude, double longitude){
         this.id = id;
         this.name = name;
         this.latitude = latitude;
         this.longitude = longitude;

     }

     public double getLongitude() {
         return longitude;
     }

     public void setLongitude(int longitude) {
         this.longitude = longitude;
     }

     public double getLatitude() {
         return latitude;
     }

     public void setLatitude(int latitude) {
         this.latitude = latitude;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public int getRiskFactor() {
         return riskFactor;
     }

     public void setRiskFactor(int riskFactor) {
         this.riskFactor = riskFactor;
     }
     // TO IMPLEMENT
     public void checkIn(){}
     public void displayBuilding(){}


}
