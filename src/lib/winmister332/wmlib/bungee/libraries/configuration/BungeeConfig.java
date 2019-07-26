package lib.winmister332.wmlib.bungee.libraries.configuration;

import lib.winmister332.wmlib.bungee.main.plugin.BungeePlugin;
import lib.winmister332.wmlib.universal.libraries.logger.LogStatus;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class BungeeConfig
{
    private File configFile = null;
    private Configuration config = null;

    public BungeeConfig(String resource) throws IOException
    {
        this(resource, false);
    }

    public BungeeConfig(String resource, boolean replace) throws IOException
    {
        loadResource(resource, replace);
    }

    public BungeeConfig(File configFilePath) throws IOException
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
        config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);
    }

    public BungeeConfig(BungeePlugin plugin, String fileName) throws IOException
    {
        this(new File(plugin.getDataFolder(), fileName));
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


    public Configuration getConfig() { return config; }

    public BungeePlugin getPlugin() { return BungeePlugin.INSTANCE; }

    public void reload() throws IOException
    {
        config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);
    }

    public void save() throws IOException
    {
        ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, configFile);
    }
}
