package com.cupidofficial.listeners.experienceListeners.experiences;

import static com.cupidofficial.util.util.color;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import com.cupidofficial.CupidSkyblock;
import com.cupidofficial.util.PacketUtils;

public class WoodCuttingListener {
	
	private CupidSkyblock cupidSkyblock;
	
	public WoodCuttingListener(CupidSkyblock cupidSkyblock) {
		this.cupidSkyblock = cupidSkyblock;
	}
	
	public void logBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		Block block = event.getBlock();
		
		ItemStack inHand = player.getInventory().getItemInMainHand();
		
		if (inHand.getType().name().endsWith("_AXE")) {
			if (block.getType().name().endsWith("_LOG") && !cupidSkyblock.PlacedBlock.isBlockPlaced(block)) {
				event.setDropItems(false);
				block.getDrops().forEach(drop -> {
					player.getInventory().addItem(drop);
				});
				Location locBlock = block.getLocation();
				locBlock.add(0.5, 0.5, 0.5);
				block.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, locBlock, 25, .5, .5, .5, 0);
				player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
				
				cupidSkyblock.apiExperiences.addWoodCutting(player, cupidSkyblock.getConfig().getDouble("WoodCutting.use-tools.earn"));
				PacketUtils.sendActionBar(player, color(cupidSkyblock.getConfig().getString("earn-woodcutting-message").replace("%earn_level%", String.valueOf(cupidSkyblock.getConfig().getDouble("WoodCutting.use-tools.earn")))));
			}
		} else {
			if (block.getType().name().endsWith("_LOG") && !cupidSkyblock.PlacedBlock.isBlockPlaced(block)) {
				event.setDropItems(false);
				block.getDrops().forEach(drop -> {
					player.getInventory().addItem(drop);
				});
				Location locBlock = block.getLocation();
				locBlock.add(0.5, 0.5, 0.5);
				block.getWorld().spawnParticle(Particle.FLAME, locBlock, 15, .5, .5, .5, 0);
				player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
				
				cupidSkyblock.apiExperiences.addWoodCutting(player, cupidSkyblock.getConfig().getDouble("WoodCutting.non-tools.earn"));
				PacketUtils.sendActionBar(player, color(cupidSkyblock.getConfig().getString("earn-woodcutting-message").replace("%earn_level%", String.valueOf(cupidSkyblock.getConfig().getDouble("WoodCutting.non-tools.earn")))));
			}
		}
	}
}