package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;

public class Main {
    private static Collection<Location> locations = null;
    private static String playerName = null;

    private static Location activeLocation = null;

    public static void main(String[] args) throws  Exception{
        locations = World.initRooms();

        startMessage();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            playerName = reader.readLine();
            printConstantMessage(Constants.HELLO_MSG, playerName);

            activeLocation =  locations.stream().findFirst().get();
            activeLocation.announce();

            while(true){
                System.out.print(Constants.PRE_INPUT_TEXT);
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
            Location tempLocation = navigateRoom(input);

            if(tempLocation !=null){
                System.out.println(); // new line to easier distinguish each input
                activeLocation = tempLocation;
                activeLocation.announce();
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

    private static Location navigateRoom(String movement){
        Location tempLocation = null;
        if(Constants.CMD_NAV_EAST.equals(movement)){
            tempLocation = activeLocation.goEast();
        }
        else if(Constants.CMD_NAV_WEST.equals(movement)){
            tempLocation = activeLocation.goWest();
        }
        else if(Constants.CMD_NAV_NORTH.equals(movement)){
            tempLocation = activeLocation.goNorth();
        }
        else if(Constants.CMD_NAV_SOUTH.equals(movement)){
            tempLocation = activeLocation.goSouth();
        }
        else{
            System.out.println(String.format(Constants.CMD_NAV_UNKNOWN, movement));
        }
        return tempLocation;
    }


    private static void printHelp() {
        System.out.println(Constants.HELP_NAV);
        System.out.println(Constants.HELP_QUIT);
    }

}
