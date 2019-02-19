package com.company.Location;

import com.company.Item.Weapon;
import com.company.Location.Location;
import com.company.Location.OutdoorArea;
import com.company.Location.Room;

import java.util.ArrayList;
import java.util.Collection;

public class World {
    private static Collection<Location> locations = null;

    private static void generateRooms(){
        Location startLocation = new OutdoorArea("Field of oats", "You are standing in the middle of a plain. It seems to go on for miles " +
                "and miles. You cannot remember how you got here and you have nothing "+
                "but the clothes on you and your trustworthy backpack with an infinite storage space. Way out in the distance to the north you see "+
                "some mountains. Over to the east you see some trees. The sun is pale "+
                "and a cool breeze caresses your skin.", "The field with oats.");

        startLocation.addItem(new Weapon("Short stick","Fragile short stick which could break any time",0));

        // Connected areas to start
        Location startWest = new OutdoorArea("Field of logs","You see a pile of logs nicely stacked on top of each other. There is a house to the north",
                "The area with a lot of logs");
        Location startNorth = new OutdoorArea("Field of logs","", "");
        Location startEast = new OutdoorArea("Field of logs","", "");
        Location startSouth = new OutdoorArea("Field of logs","", "");

        // Set connected areas to the starting area
        startLocation.setWestLocation(startWest);
        startLocation.setEastLocation(startEast);
        startLocation.setNorthLocation(startNorth);
        startLocation.setSouthLocation(startSouth);

        Location aHouse = new Room("Farmer house, entrance hall", "Large room of coat hangers",
                "The house");
        startWest.setNorthLocation(aHouse);

        locations = new ArrayList<>();
        locations.add(startLocation);
    }

    public static Collection<Location> getInstance(){
        if(locations == null){
            generateRooms();
        }
        return locations;
    }


}
