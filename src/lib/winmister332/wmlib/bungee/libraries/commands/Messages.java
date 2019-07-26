package lib.winmister332.wmlib.bungee.libraries.commands;

import net.md_5.bungee.api.ChatColor;

public final class Messages
{

    public static String noPermissionMessage = ChatColor.translateAlternateColorCodes('&', "&c&lYou don't have permission to use that command.");
    public static String incorrectSenderPlayer = ChatColor.translateAlternateColorCodes('&', "&c&lThat command may only be executed by the console.");
    public static String incorrectSenderConsole = ChatColor.translateAlternateColorCodes('&', "&c&lThat command may only be executed in-game by a player.");
    public static String incorrectSyntax = ChatColor.translateAlternateColorCodes('&', "&c&lThat command is incorrect.\n&b&l/%command% %command_syntax%");
    public static String unknownCommand = ChatColor.translateAlternateColorCodes('&', "&rUnknown command. Type /help for help.");
    public static String unknownError = ChatColor.translateAlternateColorCodes('&', "&4&lAn unknown error has occurred: \"%error%\".");
    public static String seeConsole = ChatColor.translateAlternateColorCodes('&', "&4&l(See Console For Details!)");

}
