package lib.winmister332.wmlib.spigot.libraries.configuration;

import lib.winmister332.wmlib.spigot.main.plugin.SpigotPlugin;
import lib.winmister332.wmlib.universal.libraries.logger.LogStatus;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class SpigotConfig
{
    private File configFile = null;
    private FileConfiguration config = null;

    public SpigotConfig(String resource)
    {
        this(resource, false);
    }

    public SpigotConfig(String resource, boolean replace)
    {
        loadResource(resource, replace);
    }

    public SpigotConfig(File configFilePath, String header) throws IOException
    {
        if (!configFilePath.getParentFile().exists())
        {
            configFilePath.getParentFile().mkdirs();
            if (!configFilePath.exists())
                configFilePath.createNewFile();
        }
        else
        {
            if (!configFilePath.exists())
                configFilePath.createNewFile();
        }

        configFile = configFilePath;
        config = YamlConfiguration.loadConfiguration(configFile);

        if (!(header == null && header.isEmpty()))
        {
            config.options().header(header);
            config.options().copyHeader();
        }
    }

    public SpigotConfig(SpigotPlugin plugin, String fileName) throws IOException
    {
        this(plugin, fileName, null);
    }

    public SpigotConfig(SpigotPlugin plugin, String fileName, String header) throws IOException
    {
        this(new File(plugin.getDataFolder(), fileName), header);
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

        File outputFile = new File(getPlugin().getDataFolder(), resource);
        int lastIndex = resource.lastIndexOf('/');
        File outputDir = new File(getPlugin().getDataFolder(), resource.substring(0, lastIndex >= 0 ? lastIndex : 0));
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
            getPlugin().getPluginLogger().log(LogStatus.ERROR, "Could not load configuration resource!\n" + ex.toString());
            return;
        }
    }

    private InputStream getResource(String fileName)
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
            getPlugin().getPluginLogger().log(LogStatus.ERROR, "Could not load configuration resource!\n" + ex.toString());
            return null;
        }
    }

    public ClassLoader getClassLoader() { return getPlugin().getClass().getClassLoader(); }

    public FileConfiguration getConfig() { return config; }

    public SpigotPlugin getPlugin() { return SpigotPlugin.INSTANCE; }

    public void reload()
    {
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public void save() throws IOException
    {
            config.save(configFile);
    }
}
