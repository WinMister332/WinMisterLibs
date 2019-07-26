package lib.winmister332.wmlib.spigot.main;

import lib.winmister332.wmlib.spigot.libraries.events.EventHandler;
import lib.winmister332.wmlib.spigot.main.plugin.SpigotPlugin;
import lib.winmister332.wmlib.universal.libraries.logger.LogStatus;
import lib.winmister332.wmlib.universal.libraries.logger.Logger;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class WMCore extends JavaPlugin
{
    public static WMCore CORE_INSTANCE = null;
    private static Logger logger = null;

    public WMCore()
    {
        CORE_INSTANCE = this;
        logger = new Logger("WMLibs", false, null);
    }

    @Override
    public void onLoad()
    {
        File pluginFolder = new File(getDataFolder().getParentFile().getAbsolutePath());
        File mySQLSource = new File(pluginFolder, "MySQL.jar");

        try
        {
            //Load dependency to plugin folder.
            if (!mySQLSource.exists())
            {
                loadResource(mySQLSource, false);
                getServer().getPluginManager().loadPlugin(mySQLSource);
                getServer().reload();
            }
        }
        catch (Exception ex)
        {
            getCoreLogger().log(LogStatus.ERROR, "Unknon error: \"" + ex.getMessage() + "\"\n" + ex.toString());
        }
    }

    public Logger getCoreLogger() { return logger; }

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
            getCoreLogger().log(LogStatus.ERROR, "Could not load resource!\n" + ex.toString());
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
            getCoreLogger().log(LogStatus.ERROR, "Could not load resource!\n" + ex.toString());
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
            getCoreLogger().log(LogStatus.ERROR, "Could not load resource!\n" + ex.toString());
            return null;
        }
    }
}
