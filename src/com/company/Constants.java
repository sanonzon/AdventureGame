package com.company;

public class Constants {
    // Base commands
    public static final String CMD_BASE_NAV = "go ";
    public static final String CMD_BASE_PICKUP_ITEM = "pick up ";
    public static final String CMD_BASE_USE_ITEM = "use ";
    public static final String CMD_BASE_LOOK_AT = "look at ";

    public static final String CMD_NAV_UNKNOWN = "There is nothing in the direction '%s'.";
    public static final String ROOM_SPLASH_MESSAGE = "You have entered '%s'";
    public static final String PRE_INPUT_TEXT = "What do you want to do? ";

    public static final String NORTH = "north";
    public static final String SOUTH = "south";
    public static final String EAST = "east";
    public static final String WEST = "west";


//    public static final String CMD_NAV_NORTH = CMD_BASE_NAV + NORTH;
//    public static final String CMD_NAV_SOUTH = CMD_BASE_NAV + SOUTH;
//    public static final String CMD_NAV_EAST = CMD_BASE_NAV + EAST;
//    public static final  String CMD_NAV_WEST = CMD_BASE_NAV +WEST;

    public static final String CMD_HELP = "help";
    public static final String CMD_QUIT = "quit";

    public static final String HELP_NAV = "You can move around by typing \"go north/south/west/east\".";
    public static final String HELP_ITEM = "You can pickup an item by typing \"pickup axe/bottle/something\"";
    public static final String HELP_QUIT = "You can quit playing by typing " + CMD_QUIT;

    public static final String HELLO_MSG = "Hello %s, welcome to this magical world of wonder! "+HELP_NAV+" You may need to learn more commands as you play the game! (Hint: there is a command \""+CMD_HELP+"\").";
    public static final  String ROOM_DESCRIPTION_NOT_FOUND = "There's nothing special about this location.";
    public static final  String ROOM_SHORT_DESCRIPTION_NOT_FOUND = "You have already been here.";

    public static final String LOCATION_CONNECTED_LOCATIONS = "There is a %s leading %s";

    public static final String ITEM_SOME = "some items";
    public static final String ITEM_ONE = "an item";
    public static final String LOCATION_GROUND_ROOM = "floor";
    public static final String LOCATION_GROUND_WORLD = "ground";
    public static final String PRINT_AVAILABLE_ITEMS = "You notice %s on the %s.";
    public static final String ITEM_NOT_FOUND_PICKUP = "%s is not available for pickup.";
    public static final String ITEM_FOUND_PICKUP = "You put %s into your backpack.";
    public static final String ITEM_MISSING_INVENTORY = "You do not have \"%s\" in your inventory.";
    public static final String ITEM_PRINT_SEPARATOR = ", ";



}
