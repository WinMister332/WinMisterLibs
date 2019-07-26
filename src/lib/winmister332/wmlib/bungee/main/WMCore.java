package lib.winmister332.wmlib.bungee.main;

import lib.winmister332.wmlib.bungee.libraries.events.EventHandler;
import lib.winmister332.wmlib.bungee.main.plugin.BungeePlugin;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Plugin;

public class WMCore extends Plugin
{
    public static WMCore CORE_INSTANCE = null;

    public WMCore()
    {
        CORE_INSTANCE = this;

    }
}
