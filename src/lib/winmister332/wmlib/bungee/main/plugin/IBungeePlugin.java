package lib.winmister332.wmlib.bungee.main.plugin;

import lib.winmister332.wmlib.bungee.libraries.configuration.BungeeConfig;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

public interface IBungeePlugin
{
    lib.winmister332.wmlib.universal.libraries.logger.Logger getPluginLogger();
    void setPluginLogger(lib.winmister332.wmlib.universal.libraries.logger.Logger logger);

    boolean getDebugState();
    void setDebug(boolean debug);

    BungeeConfig getBungeeConfig();
    Configuration getConfig();
    void saveConfig();
    void reloadConfig();
}
