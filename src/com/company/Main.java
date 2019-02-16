package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;

public class Main {
    private static Collection<Room> rooms = null;
    private static String playerName = null;

    private static Room activeRoom = null;

    public static void main(String[] args) throws  Exception{
        rooms = Rooms.initRooms();

        startMessage();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            playerName = reader.readLine();
            printConstantMessage(Constants.HELLO_MSG, playerName);

            activeRoom =  rooms.stream().findFirst().get();
            activeRoom.announce();

            while(true){
                parseInput(reader.readLine());
            }
        }
    }


    private static void parseInput(String input){
        if(input==null){
            System.out.println("Invalid movement, try again.");
            return;
        }

        // Handle movement
        if(input.startsWith(Constants.CMD_NAV_BASE)) {
            Room tempRoom = navigateRoom(input);

            if(tempRoom!=null){
                activeRoom=tempRoom;
                activeRoom.announce();
            }
        }

        // Help and quit
        else if(Constants.CMD_HELP.equals(input)){
            printHelp();
        }
        else if(Constants.CMD_QUIT.equals(input)){
            System.out.println("GGWP, BYE");
            System.exit(-1);
        }
        else{
            System.out.println("Invalid navigation command...");
            return;
        }
    }

    private static void startMessage(){
        System.out.println("Welcome to the adventure game!");
        System.out.print("What is your name? ");
    }

    private static void printConstantMessage(String msg, String... things){
        System.out.println(String.format(msg, things));
    }

    private static Room navigateRoom(String movement){
        Room tempRoom = null;
        if(Constants.CMD_NAV_EAST.equals(movement)){
            tempRoom = activeRoom.goEast();
        }
        else if(Constants.CMD_NAV_WEST.equals(movement)){
            tempRoom = activeRoom.goWest();
        }
        else if(Constants.CMD_NAV_NORTH.equals(movement)){
            tempRoom = activeRoom.goNorth();
        }
        else if(Constants.CMD_NAV_SOUTH.equals(movement)){
            tempRoom = activeRoom.goSouth();
        }
        return tempRoom;
    }


    private static void printHelp() {
        System.out.println(Constants.HELP_NAV);
        System.out.println(Constants.HELP_QUIT);
    }

}
