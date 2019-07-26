package lib.winmister332.wmlib.spigot.libraries.commands.commands;

import lib.winmister332.wmlib.spigot.main.plugin.SpigotPlugin;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class CommandInvoker
{
    private List<Command> commands = null;

    public CommandInvoker()
    {
        commands = new ArrayList<>();

    }

    public List<Command> getCommands()
    {
        return Collections.unmodifiableList(commands);
    }

    public void addCommand(Command command)
    {
        //add then register.
        commands.add(command);
    }

    public void addCommands(Command[] commands)
    {
        for (Command command : commands)
            addCommand(command);
    }

    public void removeCommand(Command command)
    {
        commands.remove(command);
    }

    public void removeCommands(Command[] commands)
    {
        for (Command command : commands)
            removeCommand(command);
    }

    public Command getCommandByName(String name)
    {
        for (Command command : getCommands())
            if (command.getCommandName().equalsIgnoreCase(name))
                return command;
            return null;
    }

    public Command getCommandByAlias(String alias)
    {
        for (Command command : getCommands())
            for (String aliasx : command.getCommandAliases())
                if (aliasx.equalsIgnoreCase(alias))
                    return command;
                return null;
    }

    public Command getCommandByNameOrAlias(String nameOrAlias)
    {
        Command cname = getCommandByName(nameOrAlias);
        Command calias = getCommandByName(nameOrAlias);
        if (cname != null && calias == null)
            return cname;
        else if (cname == null && calias != null)
            return calias;
        else if (cname != null && calias != null)
            return cname;
        else
            return null;
    }

    public Command getCommandByUUID(UUID uuid)
    {
        for (Command command : getCommands())
            if (command.getCommandUUID() == uuid)
                return command;
            return null;
    }

    public Command getCommandByUUID(String uuid)
    {
        return getCommandByUUID(UUID.fromString(uuid));
    }

    public Command getCommand(String value)
    {
        Command cnx = getCommandByNameOrAlias(value);
        Command cid = getCommandByUUID(value);
        if (cnx != null && cid == null)
            return cnx;
        else if (cnx == null && cid != null)
            return cid;
        else if (cnx != null && cid != null)
            return cid;
        else
            return null;
    }

    public void invoke(String rawInput, CommandSender sender)
    {
        //Verify input.
        if (rawInput == null || rawInput.isEmpty()) return;
        //Split the raw input by a space (whitespace).
        String[] rawData = rawInput.split(" ");
        //Get the first value in the array.
        String name = rawData[0]; //This is the "command".
        //Before getting the command itself, create an instance of the "CommandArgs" class.
        CommandArguments args = new CommandArguments(rawData);
        //Get the command.
        Command c = getCommand(name); //Get by name, alias, or UUID.
        //Verify command.
        if (c == null)
            sender.sendMessage(Messages.unknownCommand);
        else
        {
            if ((c.getRequiredSender() == RequiredSender.PLAYER_ONLY || c.getRequiredSender() == RequiredSender.EITHER) && sender instanceof Player)
            {
                Player player = (Player)sender;
                if (player.hasPermission(c.getCommandPermission()))
                {
                    try
                    {
                        c.onCommandInvoke(this, args, player);
                        if (c.throwSyntax) //Simple, throw the syntax.
                        {
                            String s = Messages.incorrectSyntax.replaceAll("%command%", name);
                            s = s.replaceAll("%command_syntax%", c.getCommandSyntax());
                            player.sendMessage(s);
                        }
                    }
                    catch (Exception ex)
                    {
                        String s = Messages.unknownError.replaceAll("%error%", ex.getMessage());
                        player.sendMessage(s + " " + Messages.seeConsole);
                        SpigotPlugin.INSTANCE.getServer().getConsoleSender().sendMessage(s + "\n" + ex.toString());
                    }
                }
                else
                    player.sendMessage(Messages.noPermissionMessage);
            }
            else if ((c.getRequiredSender() == RequiredSender.CONSOLE_ONLY || c.getRequiredSender() == RequiredSender.EITHER) && !(sender instanceof Player))
            {
                try
                {
                    c.onCommandInvoke(this, args, sender);
                    if (c.throwSyntax) //Simple, throw the syntax.
                    {
                        String s = Messages.incorrectSyntax.replaceAll("%command%", name);
                        s = s.replaceAll("%command_syntax%", c.getCommandSyntax());
                        sender.sendMessage(s);
                    }
                }
                catch (Exception ex)
                {
                    String s = Messages.unknownError.replaceAll("%error%", ex.getMessage());
                    sender.sendMessage(s + " " + Messages.seeConsole);
                    SpigotPlugin.INSTANCE.getServer().getConsoleSender().sendMessage(s + "\n" + ex.toString());
                }
            }
            else
            {
                if (c.getRequiredSender() == RequiredSender.CONSOLE_ONLY && sender instanceof Player)
                    sender.sendMessage(Messages.incorrectSenderPlayer);
                else
                    sender.sendMessage(Messages.incorrectSenderConsole);
            }
        }
    }
}
