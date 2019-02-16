package com.company;

public class OutdoorArea extends Location{
    public OutdoorArea(String name, String description, String shortDescription) {
        super(name, description, shortDescription);
        setLocationPathConnector("road");
    }

    public OutdoorArea(String name, String description, LastLocation lastLocation, Location location) {
        super(name, description, lastLocation, location);
        setLocationPathConnector("road");
    }
}
