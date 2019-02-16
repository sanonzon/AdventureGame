package com.company;

import java.util.ArrayList;
import java.util.Collection;

public class Rooms {
    private static Collection<Room> rooms = null;

    private static void generateRooms(){
        Room startRoom = new Room("Marketplace", "You are in a tiny market.");
        startRoom.setEastRoom(new Room("Dead end",null, Room.LastLocation.EAST, startRoom));

        rooms = new ArrayList<>();
        rooms.add(startRoom);
    }

    public static Collection<Room> initRooms(){
        if(rooms == null){
            generateRooms();
        }
        return rooms;
    }


}
