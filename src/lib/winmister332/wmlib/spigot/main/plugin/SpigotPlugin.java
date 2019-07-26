package lib.winmister332.wmlib.spigot.main.plugin;

import lib.winmister332.wmlib.spigot.libraries.commands.commands.Command;
import lib.winmister332.wmlib.spigot.libraries.commands.commands.CommandInvoker;
import lib.winmister332.wmlib.spigot.libraries.configuration.SpigotConfig;
import lib.winmister332.wmlib.spigot.libraries.events.EventHandler;
import lib.winmister332.wmlib.universal.libraries.logger.LogStatus;
import lib.winmister332.wmlib.universal.libraries.logger.Logger;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;

public abstract class SpigotPlugin extends JavaPlugin implements ISpigotPlugin
{
    public static SpigotPlugin INSTANCE = null;
    private Logger logger = null;
    private String logPath = "";
    private SpigotConfig config = null;
    private CommandInvoker invoker = null;

    public SpigotPlugin()
    {
        this(true);
    }

    public SpigotPlugin(boolean useDefaultLogFilePath)
    {
        INSTANCE = this;
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
            logger = new Logger(this, false, logPath);
        else
            logger = new Logger(this, false);

        try
        {
            if (config == null)
                config = new SpigotConfig(this, "config.yml");
            getServer().getPluginManager().registerEvents(EventHandler.INSTANCE, this);
            final Field bukkitCommandMap = getServer().getClass().getDeclaredField("commandMap");

            bukkitCommandMap.setAccessible(true);
            CommandMap commandMap = (CommandMap) bukkitCommandMap.get(getServer());

            commandMap.register(getCName(), getRootCommand());
        }
        catch (Exception ex)
        {
            getPluginLogger().log(LogStatus.ERROR, "Unknown Error: \n" + ex.toString());
        }
    }

    @Override
    public Logger getPluginLogger()
    {
        return logger;
    }

    @Override
    public void setPluginLogger(Logger logger) { this.logger = logger; }

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
    public FileConfiguration getConfig() {
        return config.getConfig();
    }

    @Override
    public void reloadConfig() {
        config.reload();
    }

    @Override
    public void saveConfig()
    {
        try
        {
            config.save();
        }
        catch (Exception ex)
        {
            getPluginLogger().log(LogStatus.ERROR, "Could not save config file... \n" + ex.toString());
        }
    }

    public CommandInvoker getInvoker() { return invoker; }

    public RootCommand getRootCommand() { return new RootCommand(); }

    String getCName() { return getName().toLowerCase().replaceAll(" ", ""); }

    public final class RootCommand extends org.bukkit.command.Command
    {
        protected RootCommand() {
            super(getCName());
        }

        @Override
        public boolean execute(CommandSender commandSender, String s, String[] strings)
        {
            String sx = "";
            for (String _sx : strings)
            {
                if (sx.isEmpty())
                    sx = _sx;
                else
                    sx = sx + " " + _sx;
            }

            getInvoker().invoke(sx, commandSender);
            return true;
        }
    }

    private void loadResource(String resource, boolean replaceExisting)
    {
        if (resource == null || resource.equals(""))
        {
            throw new IllegalArgumentException("\"resource\", cannot be null or empty");
        }

        resource = resource.replace('\\', '/');
        InputStream str = getResource(resource);
        if (str == null)
            throw new IllegalArgumentException("The embedded resource \"" + resource + "\", cannot be found.");

        File outputFile = new File(getDataFolder(), resource);
        int lastIndex = resource.lastIndexOf('/');
        File outputDir = new File(getDataFolder(), resource.substring(0, lastIndex >= 0 ? lastIndex : 0));
        if (!(outputDir.exists()))
            outputDir.mkdirs();

        try
        {
            if (!outputFile.exists() || replaceExisting)
            {
                OutputStream output = new FileOutputStream(outputFile);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = str.read(buffer)) > 0)
                {
                    output.write(buffer, 0, length);
                }
                output.close();
                str.close();
            }
        }
        catch (Exception ex)
        {
            getPluginLogger().log(LogStatus.ERROR, "Could not load resource!\n" + ex.toString());
            return;
        }
    }

    private void loadResource(File file, boolean replaceExisting)
    {
        if (file == null)
        {
            throw new IllegalArgumentException("\"resource\", cannot be null or empty");
        }

        InputStream str = getResource(file.getName());
        if (str == null)
            throw new IllegalArgumentException("The embedded resource \"" + file.getName() + "\", cannot be found.");

        try
        {
            if (!file.exists() || replaceExisting)
            {
                OutputStream output = new FileOutputStream(file);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = str.read(buffer)) > 0)
                {
                    output.write(buffer, 0, length);
                }
                output.close();
                str.close();
            }
        }
        catch (Exception ex)
        {
            getPluginLogger().log(LogStatus.ERROR, "Could not load resource!\n" + ex.toString());
            return;
        }
    }

    public InputStream getResource(String fileName)
    {
        if (fileName == null)
            throw new IllegalArgumentException("\"fileName\", cannot be null.");

        try
        {
            URL url = getClassLoader().getResource(fileName);

            if (url == null)
                return null;

            URLConnection connection = url.openConnection();
            connection.setUseCaches(false);
            return connection.getInputStream();
        }
        catch (Exception ex)
        {
            getPluginLogger().log(LogStatus.ERROR, "Could not load resource!\n" + ex.toString());
            return null;
        }
    }
}
