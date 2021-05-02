package com.cupidofficial.listeners.experienceListeners;

import static com.cupidofficial.util.util.color;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.cupidofficial.CupidSkyblock;
import com.cupidofficial.util.PacketUtils;
import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumskyblock.Island;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ExperienceListener implements Listener {
	
	private CupidSkyblock cupidSkyblock;
		
	public ExperienceListener(CupidSkyblock cupidSkyblock) {
		this.cupidSkyblock = cupidSkyblock;
	}
	
	@EventHandler
	public void experienceListener(BlockBreakEvent event) {
		Block block = event.getBlock();
		Player player = event.getPlayer();
		Location locPlayer = player.getLocation();
		Island island = IridiumSkyblock.getIslandManager().getIslandViaLocation(locPlayer);
		
		if (island != null) {
			String uuidString = player.getUniqueId().toString();
			if (!(player.hasPermission("cupidskyblock.bypass.break"))) {
				if (!island.getOwner().equals(uuidString) && !island.getMembers().contains(uuidString)) {
					
					PacketUtils.sendActionBar(player, color(cupidSkyblock.getConfig().getString("message-break-in-island")));
				
				} 
			} 
		if (!player.isSneaking()) {
			switch (block.getType()) {
				case WHEAT:
				case BEETROOTS:
				case CARROTS:
				case PUMPKIN:
				case MELON:
				case NETHER_WART:
				case POTATOES:
				case ATTACHED_MELON_STEM:
				case ATTACHED_PUMPKIN_STEM:
					event.setCancelled(true);
					this.cupidSkyblock.farmingListener.farmingBreak(event);
					break;
				default:
					break;
				}
			}

		} else {
			switch (block.getType()) {
				case WHEAT:
				case BEETROOTS:
				case CARROTS:
				case PUMPKIN:
				case MELON:
				case NETHER_WART:
				case POTATOES:
				case ATTACHED_MELON_STEM:
				case ATTACHED_PUMPKIN_STEM:
					event.setCancelled(true);
					this.cupidSkyblock.farmingListener.farmingBreak(event);
					break;
				case DIAMOND_ORE:
				case EMERALD_ORE:
				case COAL_ORE:
				case IRON_ORE:
				case LAPIS_ORE:
				case GOLD_ORE:
				case REDSTONE_ORE:
				case NETHER_QUARTZ_ORE:
				case STONE:
				case LIGHT_GRAY_TERRACOTTA:
					this.cupidSkyblock.minerListener.minerEvent(event);
					break;
				case OAK_LOG:
				case SPRUCE_LOG:
				case BIRCH_LOG:
				case JUNGLE_LOG:
				case ACACIA_LOG:
				case DARK_OAK_LOG:
					this.cupidSkyblock.woodCuttingListener.logBreak(event);
					break;	
				default:
					break;
			}
		}
	}
	
	@EventHandler
	public void cropTrample(PlayerInteractEvent event) {
		Player player = event.getPlayer();
        if(event.getAction() != Action.PHYSICAL) { return; }
        if(!event.hasBlock()) {return;}

        final Block farmland = event.getClickedBlock();
        if(farmland == null) return;
        final Block crop = farmland.getRelative(BlockFace.UP);
        if(isNotCrop(crop)) { return; }
        
        PacketUtils.sendActionBar(player, color(cupidSkyblock.getConfig().getString("error-message")));
        event.setCancelled(true);
	}
	
    private boolean isNotCrop(Block block) {
        switch (block.getType()) {
            case WHEAT:
            case CARROTS:
            case POTATOES:
            case BEETROOTS:
            case MELON_STEM:
            case PUMPKIN_STEM:
            case NETHER_WART:
                return false;
        }
        return true;
    }
    
    public void runBlockChanger() {
    	Bukkit.getScheduler().runTaskTimer(cupidSkyblock, this::restoreBlocks, 0, 20);
    }
    // null exception // Line: 133 // Fixed!
    public void restoreBlocks() {
		ArrayList<BlockMetaData> tempMeta = new ArrayList<>();
		cupidSkyblock.blockMetaData.keySet().forEach(blockMetaData -> {
			long old = cupidSkyblock.blockMetaData.get(blockMetaData);
			long current = System.currentTimeMillis();
			long seconds = TimeUnit.MILLISECONDS.toSeconds(current - old);
			if (seconds >= 2) {
				Location blockLoc = new Location(blockMetaData.getWorld(), blockMetaData.getX(), blockMetaData.getY(), blockMetaData.getZ());
				blockMetaData.getWorld().getBlockAt(blockLoc).setType(blockMetaData.getMaterial());
				blockMetaData.getWorld().playEffect(blockLoc, Effect.EXTINGUISH, 3, 10);
				tempMeta.add(blockMetaData);
			}
		});
	
		tempMeta.forEach(data -> {
			cupidSkyblock.blockMetaData.remove(data);
		});
	}
	
}
