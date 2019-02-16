package com.company;

import com.company.Interfaces.INavigation;

import static com.company.Constants.ROOM_SPLASH_MESSAGE;

public class Room implements INavigation {
       public enum LastLocation{
        WEST, EAST, NORTH, SOUTH;
    }
    public Room(String name){
        this.name = name;
    }
    public Room(String name, String description){
        this.name = name;
        this.description = description;
    }

    // Set room for opposite location, so you can navigate back.
    public Room(String name, String description, LastLocation lastLocation, Room room){
        this.name = name;
        this.description = description;
        switch (lastLocation){
            case EAST:
                setWestRoom(room);
                break;
            case WEST:
                setEastRoom(room);
                break;
            case NORTH:
                setSouthRoom(room);
                break;
            case SOUTH:
                setNorthRoom(room);
                break;
        }
    }

    private String name = null;
    private String description = null;

    private Room westRoom= null;
    private Room southRoom= null;
    private Room northRoom= null;
    private Room eastRoom= null;


    @Override
    public Room goNorth() {
        if(validateNavigation(northRoom)){
//            triggerRoom(northRoom);
            return northRoom;
        }
        return null;
    }

    @Override
    public Room goEast() {
        if(validateNavigation(eastRoom)){
//            triggerRoom(eastRoom);
            return eastRoom;
        }
        return null;
    }

    @Override
    public Room goSouth() {
        if(validateNavigation(southRoom)){
//            triggerRoom(southRoom);
            return southRoom;
        }
        return null;
    }

    @Override
    public Room goWest() {
        if(validateNavigation(westRoom)){
//            triggerRoom(westRoom);
            return westRoom;
        }
        return null;
    }

    public boolean validateNavigation(Room room) {
        if(room == null){
            System.out.println("You cannot go that way, there is nothing there.");
            return false;
        }
        return true;
    }

//    public void triggerRoom(Room room){
//        System.out.println(String.format(ROOM_SPLASH_MESSAGE, room.getName()));
//    }

    private String getName() {
        return name;
    }

    public void setNorthRoom(Room room){
        northRoom = room;
    }
    public void setSouthRoom(Room room){ southRoom = room;}
    public void setWestRoom(Room room){
        westRoom = room;
    }
    public void setEastRoom(Room room){
        eastRoom = room;
    }

    // "Greetings text" for the room
    public void announce() {
//        if(name == null || name.isEmpty()){
//            if(description == null || description.isEmpty()){
//                System.out.println("This location is unknown.");
//            }else{
//                System.out.println("Description of location: " + description);
//            }
//        }
//        else if(description == null || description.isEmpty()) {
//            System.out.println("There is no description for this room yet");
//        }else{
//            System.out.println("This is the '" + name + "' location, with description: " + description);
//        }
        System.out.println(description != null ? description : Constants.ROOM_DESCRIPTION_NOT_FOUND);
    }

}
