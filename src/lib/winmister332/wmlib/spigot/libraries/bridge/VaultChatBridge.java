package lib.winmister332.wmlib.spigot.libraries.bridge;

import org.bukkit.World;

public class VaultChatBridge
{
    private static VaultBridge vault = VaultBridge.INSTANCE;
    public static VaultChatBridge INSTANCE = new VaultChatBridge(VaultBridge.INSTANCE);

    public VaultChatBridge(VaultBridge bridge)
    {
        vault = bridge;
    }

    public boolean getGroupInfoAsBoolean(String world, String group, String node, boolean defaultValue)
    {
        return vault.getChat().getGroupInfoBoolean(world, group, node, defaultValue);
    }

    public boolean getGroupInfoAsBoolean(World world, String group, String node, boolean defaultValue)
    {
        return vault.getChat().getGroupInfoBoolean(world, group, node, defaultValue);
    }

    public double getGroupInfoAsDouble(String world, String group, String node, double defaultValue)
    {
        return vault.getChat().getGroupInfoDouble(world, group, node, defaultValue);
    }

    public double getGroupInfoAsDouble(World world, String group, String node, double defaultValue)
    {
        return vault.getChat().getGroupInfoDouble(world, group, node, defaultValue);
    }

    public int getGroupInfoAsInt()
    {
        return 0;
    }
}
