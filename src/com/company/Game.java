package com.company;

import com.company.Item.BaseItem;
import com.company.Location.Location;
import com.company.Location.World;
import com.company.Player.Player;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;

public class Game {
    private static Collection<Location> locations = null;
    private static String playerName = null;
    private static Player player = null;

    private static Location activeLocation = null;

    public static void main(String[] args) throws  Exception{
        locations = World.getInstance();
        player = Player.getInstance();

        startMessage();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            playerName = reader.readLine();
            printConstantMessage(Constants.HELLO_MSG, playerName);
            System.out.println();

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
        if(input.startsWith(Constants.CMD_BASE_NAV)) {
            Location tempLocation = navigateRoom(trimCommand(input, Constants.CMD_BASE_NAV));

            if(tempLocation !=null){
                System.out.println(); // new line to easier distinguish each input
                activeLocation = tempLocation;
                activeLocation.announce();
            }
        }
        // Handle items
        else if(input.startsWith(Constants.CMD_BASE_PICKUP_ITEM)){
            pickupItem(trimCommand(input, Constants.CMD_BASE_PICKUP_ITEM));
        }else if(input.startsWith(Constants.CMD_BASE_LOOK_AT)){
            describeItem(trimCommand(input, Constants.CMD_BASE_LOOK_AT));
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
        if(Constants.EAST.equals(movement)){
            tempLocation = activeLocation.goEast();
        }
        else if(Constants.WEST.equals(movement)){
            tempLocation = activeLocation.goWest();
        }
        else if(Constants.NORTH.equals(movement)){
            tempLocation = activeLocation.goNorth();
        }
        else if(Constants.SOUTH.equals(movement)){
            tempLocation = activeLocation.goSouth();
        }
        else{
            System.out.println(String.format(Constants.CMD_NAV_UNKNOWN, movement));
        }
        return tempLocation;
    }


    private static void printHelp() {
        System.out.println(Constants.HELP_NAV);
        System.out.println(Constants.HELP_ITEM);
        System.out.println(Constants.HELP_QUIT);
    }

    private static String trimCommand(String input, String removeString){
        return input.substring(removeString.length()).trim();
    }

    private static void pickupItem(String thing) {
        BaseItem item = activeLocation.getItems().stream().filter(p -> p.getName().equalsIgnoreCase(thing)).findFirst().orElse(null);
        if(item==null){
            System.out.println(String.format(Constants.ITEM_NOT_FOUND_PICKUP, thing ));
            return;
        }else{
            System.out.println(String.format(Constants.ITEM_FOUND_PICKUP, thing ));
            player.getInventory().add(item);
            activeLocation.getItems().removeIf(p -> p.getName().equalsIgnoreCase(thing));
        }
    }

    private static void describeItem(String item) {
        BaseItem inventoryItem = player.getInventory().stream().filter(i -> i.getName().equalsIgnoreCase(item)).findFirst().orElse(null);
        if(inventoryItem ==null){
            System.out.println(String.format(Constants.ITEM_MISSING_INVENTORY, item));
            return;
        }else{
            System.out.println(inventoryItem.getDescription());
        }
    }

}
