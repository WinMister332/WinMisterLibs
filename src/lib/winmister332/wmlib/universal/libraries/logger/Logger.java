package lib.winmister332.wmlib.universal.libraries.logger;

import lib.winmister332.wmlib.bungee.main.plugin.BungeePlugin;
import lib.winmister332.wmlib.spigot.main.plugin.SpigotPlugin;

import java.io.IOException;
import java.util.List;

public class Logger {
    private boolean debug = false;
    private String sender = "";
    private String logFilePath = "";

    @Deprecated
    public Logger(String name, boolean debug) {
        sender = name;
        this.debug = debug;
    }

    public Logger(Object sender, boolean debug, String logFilePatb) {
        this.sender = sender.getClass().getSimpleName();
        this.debug = debug;
    }

    public Logger(SpigotPlugin plugin) {
        this(plugin, false);
    }

    public Logger(SpigotPlugin plugin, String logFilePath) {
        this(plugin, false, logFilePath);
    }

    public Logger(SpigotPlugin plugin, boolean debug) {
        this(plugin, debug, null);
    }

    public Logger(SpigotPlugin plugin, boolean debug, String logFilePath) {
        this.sender = plugin.getName();
        this.debug = debug;
    }

    public Logger(BungeePlugin plugin) {
        this(plugin, false);
    }

    public Logger(BungeePlugin plugin, String logFilePath) {
        this(plugin, false, logFilePath);
    }

    public Logger(BungeePlugin plugin, boolean debug) {
        this(plugin, debug, null);
    }

    public Logger(BungeePlugin plugin, boolean debug, String logFilePath) {
        this.sender = plugin.getDescription().getName();
        this.debug = debug;
    }

    public void log() {
        log(" ");
    }

    public void log(String message) {
        LoggerCore.log(message);
    }

    public void log(LogStatus status, String text) {
        try {
            LoggerCore.log(sender, debug, status.getStatusID(), text, logFilePath);
        } catch (IOException ex) {
            LoggerCore.getInstance().logError("Could not write to log file!", ex);
        } catch (Exception ex) {
            LoggerCore.getInstance().logError("Could not log to console!", ex);
        }
    }

    public void log(LogStatus status, String text, List<String> output)
    {
        try {
            LoggerCore.log(sender, debug, status.getStatusID(), text,logFilePath, output);
        } catch (IOException ex) {
            LoggerCore.getInstance().logError("Could not write to log file!", ex);
        } catch (Exception ex) {
            LoggerCore.getInstance().logError("Could not log to console!", ex);
        }
    }

    public void setDebug(boolean debug)
    {
        this.debug = debug;
    }

    public boolean isDebug() { return debug; }
}
