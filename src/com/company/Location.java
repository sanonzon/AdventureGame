package com.company;

import com.company.Interfaces.INavigation;

import java.util.ArrayList;
import java.util.Collection;



public  abstract class Location implements INavigation {
        public enum LastLocation{
        WEST, EAST, NORTH, SOUTH;
    }

    private Location(){}
    public Location(String name){
        this.name = name;
    }

    public Location(String name, String description, String shortDescription){
        this.name = name;
        this.description = description;
        this.shortDescription = shortDescription;
    }

    // Set location for opposite location, so you can navigate back.
    public Location(String name, String description, LastLocation lastLocation, Location location){
        this.name = name;
        this.description = description;
        switch (lastLocation){
            case EAST:
                setWestLocation(location);
                break;
            case WEST:
                setEastLocation(location);
                break;
            case NORTH:
                setSouthLocation(location);
                break;
            case SOUTH:
                setNorthLocation(location);
                break;
        }
    }

    private String name = null;
    private String description = null;
    private String shortDescription = null;
    private String locationPathConnector = null;
    private boolean firstVisit = true;

    private Location westLocation = null;
    private Location southLocation = null;
    private Location northLocation = null;
    private Location eastLocation = null;
    private Collection<Location> connectedLocations = null;

    @Override
    public Location goNorth() {
        if(validateNavigation(northLocation)){
            return northLocation;
        }
        return null;
    }

    @Override
    public Location goEast() {
        if(validateNavigation(eastLocation)){
            return eastLocation;
        }
        return null;
    }

    @Override
    public Location goSouth() {
        if(validateNavigation(southLocation)){
            return southLocation;
        }
        return null;
    }

    @Override
    public Location goWest() {
        if(validateNavigation(westLocation)){
            return westLocation;
        }
        return null;
    }

    public boolean validateNavigation(Location location) {
        if(location == null){
            System.out.println("You cannot go that way, there is nothing there.");
            return false;
        }
        return true;
    }

//    public void triggerRoom(Location room){
//        System.out.println(String.format(ROOM_SPLASH_MESSAGE, room.getName()));
//    }

    private String getName() {
        return name;
    }

    public void setNorthLocation(Location location){
        northLocation = location;
    }
    public void setSouthLocation(Location location){ southLocation = location;}
    public void setWestLocation(Location location){
        westLocation = location;
    }
    public void setEastLocation(Location location){
        eastLocation = location;
    }

    // "Greetings text" for the room
    public void announce() {
        if(firstVisit){
            System.out.println(description != null ? description : Constants.ROOM_DESCRIPTION_NOT_FOUND);
        }else {
            System.out.println(shortDescription != null ? shortDescription : Constants.ROOM_SHORT_DESCRIPTION_NOT_FOUND);
        }
        printConnectedPaths();
        firstVisit = false;
    }

    // No idea what to use this for yet.... but requirements said an array of connected locations
    private void initConnectedLocations(){
        connectedLocations = new ArrayList<>();
        if (westLocation != null){
            connectedLocations.add(westLocation);
        }
        if (eastLocation != null){
            connectedLocations.add(eastLocation);
        }
        if (northLocation != null){
            connectedLocations.add(northLocation);
        }
        if (southLocation != null){
            connectedLocations.add(southLocation);
        }
    }

    protected void setLocationPathConnector(String type){
        this.locationPathConnector = type;
    }

    protected String getLocationPathConnector(){
        return locationPathConnector;
    }

    // Print available paths
    protected void printConnectedPaths(){
        if(westLocation != null) {
            System.out.println(String.format(Constants.LOCATION_CONNECTED_LOCATIONS, getLocationPathConnector(), Constants.WEST));
        }
        if(eastLocation != null) {
            System.out.println(String.format(Constants.LOCATION_CONNECTED_LOCATIONS, getLocationPathConnector(), Constants.EAST));
        }
        if(northLocation != null) {
            System.out.println(String.format(Constants.LOCATION_CONNECTED_LOCATIONS, getLocationPathConnector(), Constants.NORTH));
        }
        if(southLocation != null) {
            System.out.println(String.format(Constants.LOCATION_CONNECTED_LOCATIONS, getLocationPathConnector(), Constants.SOUTH));
        }
    }
}
