package com.company.Location;

import com.company.Location.Location;

public class Room extends Location {
    public Room(String name, String description, String shortDescription) {
        super(name, description, shortDescription);
        setLocationPathConnector("door");
    }

//    public Room(String name, String description, String shortDescription, LastLocation lastLocation, Location location) {
//        super(name, description, lastLocation, location);
//        setLocationPathConnector("door");
//        setShortDescription(shortDescription);
//    }

}
