package com.company;

public class Constants {
    public static final String CMD_NAV_UNKNOWN = "'%s' is an invalid navigation.";
    public static final String ROOM_SPLASH_MESSAGE = "You have entered '%s'";
    public static final String PRE_INPUT_TEXT = "What do you want to do? ";

    public static final String NORTH = "north";
    public static final String SOUTH = "south";
    public static final String EAST = "east";
    public static final String WEST = "west";

    public static final String CMD_NAV_BASE = "go ";
    public static final String CMD_NAV_NORTH = CMD_NAV_BASE + NORTH;
    public static final String CMD_NAV_SOUTH =CMD_NAV_BASE + SOUTH;
    public static final String CMD_NAV_EAST =CMD_NAV_BASE + EAST;
    public static final  String CMD_NAV_WEST = CMD_NAV_BASE +WEST;

    public static final String CMD_HELP = "help";
    public static final String CMD_QUIT = "quit";

    public static final String HELP_NAV = "You can move around by typing \"go north/south/west/east\".";
    public static final String HELP_QUIT = "You can quit playing by typing " + CMD_QUIT;

    public static final String HELLO_MSG = "Hello %s, welcome to this magical world of wonder! "+HELP_NAV+" You may need to learn more commands as you play the game! (Hint: there is a command \""+CMD_HELP+"\").";
    public static final  String ROOM_DESCRIPTION_NOT_FOUND = "The light has gone out and you can't see anything, you should go back the way you came";
    public static final  String ROOM_SHORT_DESCRIPTION_NOT_FOUND = "You have already been here.";

    public static final String LOCATION_CONNECTED_LOCATIONS = "There is a %s leading %s";



}
