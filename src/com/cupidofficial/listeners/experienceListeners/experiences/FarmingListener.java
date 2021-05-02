package com.cupidofficial.listeners.experienceListeners.experiences;

import static com.cupidofficial.util.util.color;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import com.cupidofficial.CupidSkyblock;
import com.cupidofficial.util.PacketUtils;

public class FarmingListener {
	
	private CupidSkyblock cupidSkyblock;
	
	public FarmingListener(CupidSkyblock cupidSkyblock) {
		this.cupidSkyblock = cupidSkyblock;
	}
	
	public void farmingBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		Block block = event.getBlock();
		
		ItemStack inHand = player.getInventory().getItemInMainHand();
		
		if (block.getType() != Material.PUMPKIN_STEM && block.getType() != Material.MELON_STEM) { 
			event.setCancelled(true);
			PacketUtils.sendActionBar(player, color(this.cupidSkyblock.getConfig().getString("not-ready-earn-message")));
		}
		
			if (block.getType() != Material.PUMPKIN && block.getType() != Material.MELON) {
				Ageable ageable = (Ageable) block.getState().getBlockData();
				if (inHand.getType().name().endsWith("_HOE")) {
					if (ageable.getAge() == ageable.getMaximumAge()) {
						block.getDrops().forEach(drop -> {
							player.getInventory().addItem(drop);
						});
						Location loc = block.getLocation();
						loc.add(0.5, 0.5, 0.5);
						block.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, loc, 40, .5, .5, .5, 0);
						player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
						
						cupidSkyblock.apiExperiences.addFarmer(player, cupidSkyblock.getConfig().getDouble("Farming.use-tools.earn"));
						PacketUtils.sendActionBar(player, color(this.cupidSkyblock.getConfig().getString("earn-farm-message").replace("%earn_level%", String.valueOf(cupidSkyblock.getConfig().getDouble("Farming.use-tools.earn")))));
						ageable.setAge(0);
						block.setBlockData(ageable);
						
					} else {
						event.setCancelled(true);
						PacketUtils.sendActionBar(player, color(this.cupidSkyblock.getConfig().getString("not-ready-earn-message")));
					}
				} else {
					if (ageable.getAge() == ageable.getMaximumAge()) {
						block.getDrops().forEach(drop -> {
							player.getInventory().addItem(drop);
						});
						Location loc = block.getLocation();
						loc.add(0.5, 0.5, 0.5);
						block.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, loc, 40, .5, .5, .5, 0);
						player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
						
						cupidSkyblock.apiExperiences.addFarmer(player, cupidSkyblock.getConfig().getDouble("Farming.non-tools.earn"));
						PacketUtils.sendActionBar(player, color(this.cupidSkyblock.getConfig().getString("earn-farm-message").replace("%earn_level%", String.valueOf(cupidSkyblock.getConfig().getDouble("Farming.non-tools.earn")))));
						ageable.setAge(0);
						block.setBlockData(ageable);
						
					} else {
						event.setCancelled(true);
						PacketUtils.sendActionBar(player, color(this.cupidSkyblock.getConfig().getString("not-ready-earn-message")));
					}
				} 
			} else {
				event.setDropItems(false);
				Location loc = block.getLocation();
				loc.add(0.5, 0.5, 0.5);
				block.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, loc, 40, .5, .5, .5, 0);
				player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
				block.getDrops().forEach(drop -> {
					player.getInventory().addItem(drop);
				});
				block.setType(Material.AIR);
				cupidSkyblock.apiExperiences.addFarmer(player, cupidSkyblock.getConfig().getDouble("Farming.use-tools.earn"));
				PacketUtils.sendActionBar(player, color(this.cupidSkyblock.getConfig().getString("earn-farm-message").replace("%earn_level%", String.valueOf(cupidSkyblock.getConfig().getDouble("Farming.use-tools.earn")))));
		}
	}
}


