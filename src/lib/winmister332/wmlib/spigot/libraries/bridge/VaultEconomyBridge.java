package lib.winmister332.wmlib.spigot.libraries.bridge;

import lib.winmister332.wmlib.spigot.main.plugin.SpigotPlugin;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.OfflinePlayer;

public final class VaultEconomyBridge
{
    private static VaultBridge vault = VaultBridge.INSTANCE;
    public static VaultEconomyBridge INSTANCE = new VaultEconomyBridge(VaultBridge.INSTANCE);

    public VaultEconomyBridge(VaultBridge bridge)
    {
        vault = bridge;
    }

    public void addMoney(OfflinePlayer player, double amount)
    {
        vault.getEco().depositPlayer(player, amount);
    }

    public void subtractMoney(OfflinePlayer player, double amount)
    {
        vault.getEco().withdrawPlayer(player, amount);
    }

    public void setBalance(OfflinePlayer player, double amount)
    {
        double balance = getBalance(player);
        subtractMoney(player, balance);
        addMoney(player, amount);
    }

    public double getBalance(OfflinePlayer player)
    {
        return vault.getEco().getBalance(player);
    }

    public boolean isMember(OfflinePlayer player, String accountName)
    {
        EconomyResponse resp = vault.getEco().isBankMember(accountName, player);
        return (resp.transactionSuccess());
    }

    public boolean isOwner(OfflinePlayer player, String accountName)
    {
        EconomyResponse resp = vault.getEco().isBankOwner(accountName, player);
        return (resp.transactionSuccess());
    }

    public void createBank(String accountName, OfflinePlayer owner)
    {
        vault.getEco().createBank(accountName, owner);
    }

    public void deleteBank(String accountName)
    {
        vault.getEco().deleteBank(accountName);
    }

    public double getBankBalance(String accountName)
    {
        return vault.getEco().bankBalance(accountName).balance;
    }

    public void addMoney(String accountName, double amount)
    {
        vault.getEco().bankDeposit(accountName, amount);
    }

    public void subtractMoney(String accountName, double amount)
    {
        vault.getEco().bankWithdraw(accountName, amount);
    }

    public void setBalance(String accountName, double amount)
    {
        double balance = getBalance(accountName);
        subtractMoney(accountName, balance);
        addMoney(accountName, amount);
    }

    public double getBalance(String accountName)
    {
        return vault.getEco().bankBalance(accountName).balance;
    }

    public boolean hasBalance(OfflinePlayer player)
    {
        return getBalance(player) > 0;
    }

    public boolean hasBalance(String accountName)
    {
        return getBalance(accountName) > 0;
    }
}
