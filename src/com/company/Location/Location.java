package com.company.Location;

import com.company.Constants;
import com.company.Item.BaseItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


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

//    // Set location for opposite location, so you can navigate back.
//    public Location(String name, String description, LastLocation lastLocation, Location location){
//        this.name = name;
//        this.description = description;
//        switch (lastLocation){
//            case EAST:
//                setWestLocation(location);
//                break;
//            case WEST:
//                setEastLocation(location);
//                break;
//            case NORTH:
//                setSouthLocation(location);
//                break;
//            case SOUTH:
//                setNorthLocation(location);
//                break;
//        }
//    }

    private String name = null;
    private String description = null;
    private String shortDescription = null;
    private String locationPathConnector = null;
    private boolean firstVisit = true;

//    private Location westLocation = null;
//    private Location southLocation = null;
//    private Location northLocation = null;
//    private Location eastLocation = null;
//    private Collection<Location> connectedLocations = null;
private Map<String, Location> connectedLocations = new HashMap<>();

    private Collection<BaseItem> items = new ArrayList<>();


    @Override
    public Location goNorth() {
        Location loc = getConnectedLocations().get(Constants.NORTH);
        if(validateNavigation(loc)){
            return loc;
        }
        return null;
    }

    @Override
    public Location goEast() {
        Location loc = getConnectedLocations().get(Constants.EAST);
        if(validateNavigation(loc)){
            return loc;
        }
        return null;
    }

    @Override
    public Location goSouth() {
        Location loc = getConnectedLocations().get(Constants.SOUTH);
        if(validateNavigation(loc)){
            return loc;
        }
        return null;
    }

    @Override
    public Location goWest() {
        Location loc = getConnectedLocations().get(Constants.WEST);
        if(validateNavigation(loc)){
            return loc;
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

    private String getName() {
        return name;
    }


    // "Greetings text" for the room
    public void announce() {
        System.out.println();
        if(firstVisit){
            System.out.println(description != null && !description.isEmpty() ? description : Constants.ROOM_DESCRIPTION_NOT_FOUND);
        }else {
            System.out.println(shortDescription != null && !shortDescription.isEmpty()? shortDescription : Constants.ROOM_SHORT_DESCRIPTION_NOT_FOUND);
        }
        printAvailableItems();
        printConnectedPaths();
        firstVisit = false;
    }

    public Map<String, Location> getConnectedLocations(){
        return connectedLocations;
    }

    protected void setLocationPathConnector(String type){
        this.locationPathConnector = type;
    }

    protected String getLocationPathConnector(){
        return locationPathConnector;
    }

    // Print available paths
    protected void printConnectedPaths(){
        if(getConnectedLocations().get(Constants.WEST) != null) {
            System.out.println(String.format(Constants.LOCATION_CONNECTED_LOCATIONS, getLocationPathConnector(), Constants.WEST));
        }
        if(getConnectedLocations().get(Constants.EAST) != null) {
            System.out.println(String.format(Constants.LOCATION_CONNECTED_LOCATIONS, getLocationPathConnector(), Constants.EAST));
        }
        if(getConnectedLocations().get(Constants.NORTH) != null) {
            System.out.println(String.format(Constants.LOCATION_CONNECTED_LOCATIONS, getLocationPathConnector(), Constants.NORTH));
        }
        if(getConnectedLocations().get(Constants.SOUTH) != null) {
            System.out.println(String.format(Constants.LOCATION_CONNECTED_LOCATIONS, getLocationPathConnector(), Constants.SOUTH));
        }
    }

    protected void setShortDescription(String shortDescription){
        this.shortDescription = shortDescription;
    }

    protected void addItem(BaseItem item){
        items.add(item);
    }

    private void printAvailableItems() {
        if(!items.isEmpty()){
            boolean moreThanOneItem = items.size()>1;
            System.out.println(String.format(Constants.PRINT_AVAILABLE_ITEMS,
                    moreThanOneItem ? Constants.ITEM_SOME : Constants.ITEM_ONE,
                    Constants.LOCATION_GROUND_ROOM.equals(locationPathConnector) ? Constants.LOCATION_GROUND_ROOM : Constants.LOCATION_GROUND_WORLD));

            String itemString = null;
            if(moreThanOneItem){
                itemString = "Items: ";
                boolean firstItem = true;
                for(BaseItem item : items){
                    if(!firstItem){
                        itemString += Constants.ITEM_PRINT_SEPARATOR;
                    }itemString += item.getName();
                }
            }else{
                itemString = "Item: " + items.stream().findFirst().get().getName();
            }
            System.out.println(itemString);
        }
    }

    public Collection<BaseItem> getItems(){
        return items;
    }

    // Connect two locations
    public void setNorthLocation(Location location){
        getConnectedLocations().put(Constants.NORTH, location);
        location.getConnectedLocations().put(Constants.SOUTH, this);
    }

    // Connect two locations
    public void setEastLocation(Location location){
        getConnectedLocations().put(Constants.EAST, location);
        location.getConnectedLocations().put(Constants.WEST, this);
    }

    // Connect two locations
    public void setSouthLocation(Location location){
        getConnectedLocations().put(Constants.SOUTH, location);
        location.getConnectedLocations().put(Constants.NORTH, this);
    }

    // Connect two locations
    public void setWestLocation(Location location){
        getConnectedLocations().put(Constants.WEST, location);
        location.getConnectedLocations().put(Constants.EAST, this);
    }

}
