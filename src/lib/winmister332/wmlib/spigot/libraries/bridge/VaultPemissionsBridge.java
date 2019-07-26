package lib.winmister332.wmlib.spigot.libraries.bridge;

import lib.winmister332.wmlib.utils.GlobalUtils;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VaultPemissionsBridge
{
    private static VaultBridge vault = VaultBridge.INSTANCE;
    public static VaultPemissionsBridge INSTANCE = new VaultPemissionsBridge(VaultBridge.INSTANCE);

    public VaultPemissionsBridge(VaultBridge bridge)
    {
        vault = bridge;
    }

    public List<String> getGroups()
    {
        return Collections.unmodifiableList(GlobalUtils.toList(vault.getPerm().getGroups()));
    }

    public List<String> getPlayerGroups(Player player)
    {
        return Collections.unmodifiableList(GlobalUtils.toList(vault.getPerm().getPlayerGroups(player)));
    }

    public List<String> getPlayerGroups(String world, OfflinePlayer player)
    {
        return Collections.unmodifiableList(GlobalUtils.toList(vault.getPerm().getPlayerGroups(world, player)));
    }

    public String getPrimaryGroup(Player player)
    {
        return vault.getPerm().getPrimaryGroup(player);
    }

    public String getPrimaryGroup(String world, OfflinePlayer player)
    {
        return vault.getPerm().getPrimaryGroup(world, player);
    }

    public boolean addPermissionToGroup(World world, String group, String permission)
    {
        return vault.getPerm().groupAdd(world, group, permission);
    }

    public boolean addPermissionToGroup(String world, String group, String permission)
    {
        return vault.getPerm().groupAdd(world, group, permission);
    }

    public boolean groupHasPermission(String world, String group, String permission)
    {
        return vault.getPerm().groupHas(world, group, permission);
    }

    public boolean groupHasPermission(World world, String group, String permission)
    {
        return vault.getPerm().groupHas(world, group, permission);
    }

    public boolean removePermissionFromGroup(String world, String group, String permission)
    {
        return vault.getPerm().groupRemove(world, group, permission);
    }

    public boolean removePermissionFromGroup(World world, String group, String permission)
    {
        return vault.getPerm().groupRemove(world, group, permission);
    }

    public boolean senderHasPermission(CommandSender sender, String permission)
    {
        if (sender instanceof Player)
            return playerHasPermission((Player)sender, permission);
        else
            return vault.getPerm().has(sender, permission);
    }

    public boolean senderPlayerHasPermission(Player player, String permission)
    {
        return vault.getPerm().has(player, permission);
    }

    public boolean supportsGroups() { return vault.getPerm().hasGroupSupport(); }

    public boolean isEnabled() { return (vault.vaultEnabled() && vault.getPerm().isEnabled()); }

    public boolean addPermissionToPlayer(Player player, String permission)
    {
        return vault.getPerm().playerAdd(player, permission);
    }

    public boolean addPermissionToPlayer(String world, OfflinePlayer player, String permission)
    {
        return vault.getPerm().playerAdd(world, player, permission);
    }

    public boolean addPlayerToGroup(Player player, String group)
    {
        return vault.getPerm().playerAddGroup(player, group);
    }

    public boolean addPlayerToGroup(String world, OfflinePlayer player, String group)
    {
        return vault.getPerm().playerAddGroup(world, player, group);
    }

    public boolean addTransientPermissionToPlayer(OfflinePlayer player, String permission)
    {
        return vault.getPerm().playerAddTransient(player, permission);
    }

    public boolean addTransientPermissionToPlayer(Player player, String permission)
    {
        return vault.getPerm().playerAddTransient(player, permission);
    }

    public boolean addTransientPermissionToPlayer(String world, Player player, String permission)
    {
        return vault.getPerm().playerAddTransient(world, player, permission);
    }

    public boolean addTransientPermissionToPlayer(String world, OfflinePlayer player, String permission)
    {
        return vault.getPerm().playerAddTransient(world, player, permission);
    }

    public boolean playerHasPermission(Player player, String permission)
    {
        return vault.getPerm().playerHas(player, permission);
    }

    public boolean playerHasPermission(String world, OfflinePlayer player, String permission)
    {
        return vault.getPerm().playerHas(world, player, permission);
    }

    public boolean playerIsInGroup(Player player, String group)
    {
        return vault.getPerm().playerInGroup(player, group);
    }

    public boolean playerIsInGroup(String world, OfflinePlayer player, String group)
    {
        return vault.getPerm().playerInGroup(world, player, group);
    }

    public boolean removePermissionFromPlayer(Player player, String permission)
    {
        return vault.getPerm().playerRemove(player, permission);
    }

    public boolean removePermissionFromPlayer(String world, OfflinePlayer player, String permission)
    {
        return vault.getPerm().playerRemove(world, player, permission);
    }

    public boolean removePlayerFromGroup(Player player, String permission)
    {
        return vault.getPerm().playerRemoveGroup(player, permission);
    }

    public boolean removePlayerFromGroup(String world, OfflinePlayer player, String permission)
    {
        return vault.getPerm().playerRemoveGroup(world, player, permission);
    }

    public boolean removeTransientPermissionFromPlayer(Player player, String permission)
    {
        return vault.getPerm().playerRemoveTransient(player, permission);
    }

    public boolean removeTransientPermissionFromPlayer(String world, OfflinePlayer player, String permission)
    {
        return vault.getPerm().playerRemoveTransient(world, player, permission);
    }

    public boolean removeTransientPermissionFromPlayer(String world, Player player, String permission)
    {
        return vault.getPerm().playerRemoveTransient(world, player, permission);
    }

    public boolean removeTransientPermissionFromPlayer(OfflinePlayer player, String permission)
    {
        return vault.getPerm().playerRemoveTransient(player, permission);
    }
}
