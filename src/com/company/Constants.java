package com.company;

public class Constants {
    public static String ROOM_SPLASH_MESSAGE = "You have entered '%s'";

    public static String CMD_NAV_BASE = "go ";
    public static String CMD_NAV_NORTH = CMD_NAV_BASE + "north";
    public static String CMD_NAV_SOUTH =CMD_NAV_BASE + "south";
    public static String CMD_NAV_EAST =CMD_NAV_BASE + "east";
    public static String CMD_NAV_WEST = CMD_NAV_BASE +"west";

    public static String CMD_HELP = "help";
    public static String CMD_QUIT = "quit";

    public static String HELP_NAV = "You can move around by typing \"go north/south/west/east\".";
    public static String HELP_QUIT = "You can quit playing by typing " + CMD_QUIT;

    public static String HELLO_MSG = "Hello %s, welcome to this magical world of wonder! "+HELP_NAV+" You may need to learn more commands as you play the game! (Hint: there is a command \""+CMD_HELP+"\").";
    public static String ROOM_DESCRIPTION_NOT_FOUND = "The light has gone out and you can't see anything, you should go back the way you came";

}
