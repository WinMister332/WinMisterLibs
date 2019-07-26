package lib.winmister332.wmlib.bungee.libraries.events;

import net.md_5.bungee.api.event.PlayerHandshakeEvent;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.event.ProxyReloadEvent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.api.event.SettingsChangedEvent;
import net.md_5.bungee.api.event.PermissionCheckEvent;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;

public abstract class EventHandler implements Listener
{
    public static EventHandler INSTANCE = null;

    public EventHandler()
    {
        INSTANCE = this;
    }

    @net.md_5.bungee.event.EventHandler
    public void onServerConnectedEvent(ServerConnectedEvent event) {}

    @net.md_5.bungee.event.EventHandler
    public void onServerConnectEvent(ServerConnectEvent event) {}

    @net.md_5.bungee.event.EventHandler
    public void onServerDisconnectEvent(ServerDisconnectEvent event){}

    @net.md_5.bungee.event.EventHandler
    public void onPlayerConnectEvent(PlayerHandshakeEvent event){}

    @net.md_5.bungee.event.EventHandler
    public void onPlayerDisconnectEvent(PlayerDisconnectEvent event){}

    @net.md_5.bungee.event.EventHandler
    public void onChatEvent(ChatEvent event){}

    @net.md_5.bungee.event.EventHandler
    public void onProxyPingEvent(ProxyPingEvent event){}

    @net.md_5.bungee.event.EventHandler
    public void onProxyReloadEvent(ProxyReloadEvent event){}

    @net.md_5.bungee.event.EventHandler
    public void onServerKickEvent(ServerKickEvent event){}

    @net.md_5.bungee.event.EventHandler
    public void onServerSwitchEvent(ServerSwitchEvent event){}

    @net.md_5.bungee.event.EventHandler
    public void onSettingsChangedEvent(SettingsChangedEvent event){}

    @net.md_5.bungee.event.EventHandler
    public void onPermissionCheckEvent(PermissionCheckEvent event){}

    @net.md_5.bungee.event.EventHandler
    public void onPluginMessageEvent(PluginMessageEvent event){}
}
