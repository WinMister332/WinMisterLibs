package lib.winmister332.wmlib.spigot.libraries.events;

import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerChangedMainHandEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerItemMendEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerPickupArrowEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.event.player.PlayerUnleashEntityEvent;
import org.bukkit.event.player.PlayerVelocityEvent;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.block.SignChangeEvent;

import org.bukkit.event.enchantment.EnchantItemEvent;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;

import org.bukkit.event.server.BroadcastMessageEvent;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.event.server.TabCompleteEvent;
import org.bukkit.event.server.ServerListPingEvent;

import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.event.world.SpawnChangeEvent;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.event.world.WorldUnloadEvent;

import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityCreatePortalEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.EntityPortalEnterEvent;
import org.bukkit.event.entity.EntityPortalExitEvent;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.entity.EntityUnleashEvent;
import org.bukkit.event.entity.PlayerLeashEntityEvent;

public abstract class EventHandler implements Listener
{
    public static EventHandler INSTANCE = null;

    public EventHandler()
    {
        INSTANCE = this;
    }

    @org.bukkit.event.EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerAdvancementEvent(PlayerAdvancementDoneEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerAnimationEvent(PlayerAnimationEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerArmorStandManipulateEvent(PlayerArmorStandManipulateEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerBedEnterEvent(PlayerBedEnterEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerBedLeaveEvent(PlayerBedLeaveEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerBucketEmptyEvent(PlayerBucketEmptyEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerBucketEvent(PlayerBucketEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerBucketFillEvent(PlayerBucketFillEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerChangedMainHandEvent(PlayerChangedMainHandEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerChangedWorldEvent(PlayerChangedWorldEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerCommandSendEvent(PlayerCommandSendEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerDropItemEvent(PlayerDropItemEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerEditBookEvent(PlayerEditBookEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerGameModeChangeEvent(PlayerGameModeChangeEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerExpChangeEvent(PlayerExpChangeEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerInteractAtEntityEvent(PlayerInteractAtEntityEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerItemBreakEvent(PlayerItemBreakEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerItemConsumeEvent(PlayerItemConsumeEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerItemDamageEvent(PlayerItemDamageEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerItemHeldEvent(PlayerItemHeldEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerItemMendEvent(PlayerItemMendEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerLevelChangeEvent(PlayerLevelChangeEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerKickEvent(PlayerKickEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerPortalEvent(PlayerPortalEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerPickupArrowEvent(PlayerPickupArrowEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerRespawnEvent(PlayerRespawnEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerTeleportEvent(PlayerTeleportEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerToggleFlightEvent(PlayerToggleFlightEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerToggleSprintEvent(PlayerToggleSprintEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerUnleashEntityEvent(PlayerUnleashEntityEvent event){}

    @org.bukkit.event.EventHandler
    public void onPlayerVelocityEvent(PlayerVelocityEvent event){}

    @org.bukkit.event.EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {}

    @org.bukkit.event.EventHandler
    public void onBlockBurnEvent(BlockBurnEvent event) {}

    @org.bukkit.event.EventHandler
    public void onBlockCanBuildEvent(BlockCanBuildEvent event) {}

    @org.bukkit.event.EventHandler
    public void onBlockDamageEvent(BlockDamageEvent event) {}

    @org.bukkit.event.EventHandler
    public void onBlockExplodeEvent(BlockExplodeEvent event) {}

    @org.bukkit.event.EventHandler
    public void onBlockFormEvent(BlockFormEvent event) {}

    @org.bukkit.event.EventHandler
    public void onBlockIgniteEvent(BlockIgniteEvent event) {}

    @org.bukkit.event.EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {}

    @org.bukkit.event.EventHandler
    public void onBlockRedstoneEvent(BlockRedstoneEvent event) {}

    @org.bukkit.event.EventHandler
    public void onBlockSignChangeEvent(SignChangeEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEnchantItemEvent(EnchantItemEvent event) {}

    @org.bukkit.event.EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {}

    @org.bukkit.event.EventHandler
    public void onInventoryCloseEvent(InventoryCloseEvent event) {}

    @org.bukkit.event.EventHandler
    public void onInventoryCreativeEvent(InventoryCreativeEvent event) {}

    @org.bukkit.event.EventHandler
    public void onInventoryInteractEvent(InventoryInteractEvent event) {}

    @org.bukkit.event.EventHandler
    public void onInventoryMoveItemEvent(InventoryMoveItemEvent event) {}

    @org.bukkit.event.EventHandler
    public void onInventoryOpenEvent(InventoryOpenEvent event) {}

    @org.bukkit.event.EventHandler
    public void onInventoryPickupItemEvent(InventoryPickupItemEvent event) {}

    @org.bukkit.event.EventHandler
    public void onInventoryDragEvent(InventoryDragEvent event) {}

    @org.bukkit.event.EventHandler
    public void onBroadcastMessageEvent(BroadcastMessageEvent event) {}

    @org.bukkit.event.EventHandler
    public void onMapInitializeEvent(MapInitializeEvent event) {}
    
    @org.bukkit.event.EventHandler
    public void onPluginDisableEvent(PluginDisableEvent event) {}
    
    @org.bukkit.event.EventHandler
    public void onPluginEnableEvent(PluginEnableEvent event) {}

    @org.bukkit.event.EventHandler
    public void onServerCommandEvent(ServerCommandEvent event) {}

    @org.bukkit.event.EventHandler
    public void onServerLoadEvent(ServerLoadEvent event) {}

    @org.bukkit.event.EventHandler
    public void onTabCompleteEvent(TabCompleteEvent event) {}

    @org.bukkit.event.EventHandler
    public void onServerListPingEvent(ServerListPingEvent event) {}

    @org.bukkit.event.EventHandler
    public void onChunkLoadEvent(ChunkLoadEvent event) {}

    @org.bukkit.event.EventHandler
    public void onChunkPopulate(ChunkPopulateEvent event) {}

    @org.bukkit.event.EventHandler
    public void onChunkUnloadEvent(ChunkUnloadEvent event) {}

    @org.bukkit.event.EventHandler
    public void onPortalCreateEvent(PortalCreateEvent event) {}

    @org.bukkit.event.EventHandler
    public void onSpawnChangeEvent(SpawnChangeEvent event) {}

    @org.bukkit.event.EventHandler
    public void onWorldInitEvent(WorldInitEvent event) {}

    @org.bukkit.event.EventHandler
    public void onWorldLoadEvent(WorldLoadEvent event) {}

    @org.bukkit.event.EventHandler
    public void onWorldSaveEvent(WorldSaveEvent event) {}

    @org.bukkit.event.EventHandler
    public void onWorldUnloadEvent(WorldUnloadEvent event) {}

    @org.bukkit.event.EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent event) {}

    @org.bukkit.event.EventHandler
    public void onCreatureSpawnEvent(CreatureSpawnEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEntityChangeBlockEvent(EntityChangeBlockEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEntityCreatePortalEvent(EntityCreatePortalEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEntityDamageByBlockEvent(EntityDamageByBlockEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEntityDeathEvent(EntityDeathEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEntityDropItemEvent(EntityDropItemEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEntityInteractEvent(EntityInteractEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEntityPickupEvent(EntityPickupItemEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEntityPortalEnterEvent(EntityPortalEnterEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEntityPortalExitEvent(EntityPortalExitEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEntityPortalEvent(EntityPortalEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEntityPotionEffectEvent(EntityPotionEffectEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEntityRegainHealthEvent(EntityRegainHealthEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEntityResurrectEvent(EntityResurrectEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEntitySpawnEvent(EntitySpawnEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEntityTargetLivingEntityEvent(EntityTargetLivingEntityEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEntityTeleportEvent(EntityTeleportEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEntityUnleashEvent(EntityUnleashEvent event) {}

    @org.bukkit.event.EventHandler
    public void onEntityLeashEntityEvent(PlayerLeashEntityEvent event) {}
    
    
    
    
    
    
}
