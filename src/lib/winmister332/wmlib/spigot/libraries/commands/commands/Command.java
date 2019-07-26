package lib.winmister332.wmlib.spigot.libraries.commands.commands;

import org.bukkit.command.CommandSender;

import java.util.UUID;

public abstract class Command
{
    private UUID commandUUID;

    public abstract String getCommandName();
    public abstract String getCommandDescription();
    public abstract String getCommandSyntax();
    public abstract String getCommandPermission();
    public abstract String[] getCommandAliases();
    public abstract RequiredSender getRequiredSender();
    public abstract void onCommandInvoke(CommandInvoker invoker, CommandArguments args, CommandSender sender);

    public Command()
    {
        commandUUID = UUID.randomUUID();
    }

    public UUID getCommandUUID() { return commandUUID; }
    public boolean throwSyntax=false;
}
