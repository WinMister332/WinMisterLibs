package lib.winmister332.wmlib.spigot.libraries.bridge;

import lib.winmister332.wmlib.spigot.main.plugin.SpigotPlugin;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;

public class VaultBridge
{
    public static VaultBridge INSTANCE = null;
    private boolean usingVault = false;
    private Economy eco = null;
    private Chat chat = null;
    private Permission perm = null;

    public VaultBridge()
    {
        INSTANCE = this;

    }

    public boolean setupEconomy()
    {
        if (SpigotPlugin.INSTANCE.getServer().getPluginManager().getPlugin("Vault") == null) return false;
        RegisteredServiceProvider<Economy> ecoProvider = SpigotPlugin.INSTANCE.getServer().getServicesManager().getRegistration(Economy.class);
        if (ecoProvider == null) return false;
        eco = ecoProvider.getProvider();
        return eco != null;
    }

    public boolean setupChat()
    {
        RegisteredServiceProvider<Chat> chatProvider = SpigotPlugin.INSTANCE.getServer().getServicesManager().getRegistration(Chat.class);
        chat = chatProvider.getProvider();
        return chat != null;
    }

    public boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> permProvider = SpigotPlugin.INSTANCE.getServer().getServicesManager().getRegistration(Permission.class);
        perm = permProvider.getProvider();
        return perm != null;
    }

    public Economy getEco() { return eco; }
    public Chat getChat() { return chat; }
    public Permission getPerm() { return perm; }

    public boolean vaultEnabled()
    {
        if (usingVault && SpigotPlugin.INSTANCE.getServer().getPluginManager().isPluginEnabled("Vault")) return true;
        return false;
    }
}
