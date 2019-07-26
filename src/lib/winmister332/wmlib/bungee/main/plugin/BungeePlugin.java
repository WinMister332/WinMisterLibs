package lib.winmister332.wmlib.bungee.main.plugin;

import lib.winmister332.wmlib.bungee.libraries.commands.Command;
import lib.winmister332.wmlib.bungee.libraries.commands.CommandInvoker;
import lib.winmister332.wmlib.bungee.libraries.configuration.BungeeConfig;
import lib.winmister332.wmlib.bungee.libraries.events.EventHandler;
import lib.winmister332.wmlib.universal.libraries.logger.LogStatus;
import lib.winmister332.wmlib.universal.libraries.logger.Logger;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

public abstract class BungeePlugin extends Plugin implements IBungeePlugin
{
    private Logger logger = null;
    public static BungeePlugin INSTANCE = null;
    private String logPath = null;
    private BungeeConfig config = null;
    private CommandInvoker invoker = null;

    public BungeePlugin()
    {
        this(true);
    }

    public BungeePlugin(boolean useDefaultLogFilePath)
    {
        INSTANCE=this;
        if (useDefaultLogFilePath)
            logPath = getDataFolder() + "\\Logs";
        invoker = new CommandInvoker();

    }

    public void registerCommand(Command command)
    {
        getInvoker().addCommand(command);
    }

    public void registerCommands(Command[] commands) { getInvoker().addCommands(commands); }

    public void unregisterCommand(Command command) { getInvoker().removeCommand(command); }

    public void unregisterCommands(Command[] commands) { getInvoker().removeCommands(commands); }

    @Override
    public void onLoad()
    {
        if (logger == null && !(logPath == null || logPath.isEmpty()))
            logger = new Logger(this, getDebugState(), logPath);
        else
            logger = new Logger((BungeePlugin)this, (boolean) getDebugState());

        try
        {
            if (config == null)
                config = new BungeeConfig(this, "config.yml");
            getProxy().getPluginManager().registerListener(this, EventHandler.INSTANCE);
            getProxy().getPluginManager().registerCommand(this, getRootCommand());
        }
        catch (Exception ex)
        {
            getPluginLogger().log(LogStatus.ERROR, "Unknown Error: \n" + ex.toString());
        }
    }

    @Override
    public void onEnable()
    {

    }

    @Override
    public void onDisable()
    {

    }

    @Override
    public Logger getPluginLogger()
    {
        return logger;
    }

    @Override
    public void setPluginLogger(Logger logger)
    {
        this.logger = logger;
    }

    @Override
    public boolean getDebugState()
    {
        return logger.isDebug();
    }

    @Override
    public void setDebug(boolean debug)
    {
        logger.setDebug(debug);
    }

    @Override
    public BungeeConfig getBungeeConfig()
    {
        return config;
    }

    @Override
    public Configuration getConfig()
    {
        return getBungeeConfig().getConfig();
    }

    @Override
    public void saveConfig()
    {
        try
        {
            getBungeeConfig().save();
        } catch (Exception ex)
        {
            getPluginLogger().log(LogStatus.ERROR, "Could not save config file... \n" + ex.toString());
        }
    }

    @Override
    public void reloadConfig()
    {
        try
        {
            getBungeeConfig().reload();
        } catch (Exception ex)
        {
            getPluginLogger().log(LogStatus.ERROR, "Could not save config file... \n" + ex.toString());
        }
    }

    public CommandInvoker getInvoker() { return invoker; }

    public RootCommand getRootCommand() { return new RootCommand(); }

    public final class RootCommand extends net.md_5.bungee.api.plugin.Command
    {
        public RootCommand()
        {
            super(getDescription().getName());
        }

        @Override
        public void execute(CommandSender commandSender, String[] strings)
        {
            String s = "";
            for (String sx : strings)
            {
                if (s.isEmpty())
                    s = sx;
                else
                    s = s + " " + sx;
            }
            if (strings.length <= 0 && strings != null)
            {
                getInvoker().invoke(s, commandSender);
            }
        }
    }
}
