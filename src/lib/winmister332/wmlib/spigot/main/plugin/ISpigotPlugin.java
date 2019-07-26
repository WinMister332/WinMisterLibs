package lib.winmister332.wmlib.spigot.main.plugin;

import lib.winmister332.wmlib.universal.libraries.logger.Logger;

public interface ISpigotPlugin
{
    Logger getPluginLogger();
    void setPluginLogger(Logger logger);

    boolean getDebugState();
    void setDebug(boolean debug);
}
