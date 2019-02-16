package com.company;

import java.util.ArrayList;
import java.util.Collection;

public class World {
    private static Collection<Location> locations = null;

    private static void generateRooms(){
        Location startLocation = new OutdoorArea("Field of oats", "You are standing in the middle of a plain. It seems to go on for miles" +System.lineSeparator()+
                "and miles. You cannot remember how you got here and you have nothing"+System.lineSeparator()+
                "but the clothes on you. Way out in the distance to the north you see"+System.lineSeparator()+
                "some mountains. Over to the east you see some trees. The sun is pale"+System.lineSeparator()+
                "and a cool breeze caresses your skin.", "The field with oats.");

        startLocation.setEastLocation(new Room("Dead end",null, Location.LastLocation.EAST, startLocation));

        locations = new ArrayList<>();
        locations.add(startLocation);
    }

    public static Collection<Location> initRooms(){
        if(locations == null){
            generateRooms();
        }
        return locations;
    }


}
