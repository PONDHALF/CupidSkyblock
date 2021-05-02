package com.cupidofficial.listeners.experienceListeners.experiences;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import com.cupidofficial.CupidSkyblock;
import com.cupidofficial.components.Stats;
import com.cupidofficial.listeners.experienceListeners.BlockMetaData;
import com.cupidofficial.managers.ProfileManager;
import com.cupidofficial.util.PacketUtils;

import static com.cupidofficial.util.util.*;

public class MinerListener {
	
	private CupidSkyblock cupidSkyblock;
	private ProfileManager profileManager;
	
	public MinerListener(CupidSkyblock cupidSkyblock) {
		this.cupidSkyblock = cupidSkyblock;
		this.profileManager = cupidSkyblock.getProfileManager();
	}
	
	public void minerEvent(BlockBreakEvent event) {
		Block block = event.getBlock();
		Player player = event.getPlayer();
		
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		ItemStack inHand = player.getInventory().getItemInMainHand();
		
		if (inHand.getType().name().endsWith("_PICKAXE")) {
			if (!cupidSkyblock.PlacedBlock.isBlockPlaced(block)) {
				event.setCancelled(true);
				switch (block.getType()) {
				
					case DIAMOND_ORE:
						afterBreakEvent(player, block, Color.AQUA, block.getLocation());
						cupidSkyblock.apiExperiences.addMiner(player, cupidSkyblock.getConfig().getDouble("Miner.DIAMOND_ORE.earn"));
						PacketUtils.sendActionBar(player, color(cupidSkyblock.getConfig().getString("earn-miner-message").replace("%earn_level%", String.valueOf(cupidSkyblock.getConfig().getDouble("Miner.DIAMOND_ORE.earn") * (2 + ((stats.getDexterity() / 10) * 2))))));
						break;
					
					case EMERALD_ORE:
						afterBreakEvent(player, block, Color.GREEN, block.getLocation());
						cupidSkyblock.apiExperiences.addMiner(player, cupidSkyblock.getConfig().getDouble("Miner.EMERALD_ORE.earn"));
						PacketUtils.sendActionBar(player, color(cupidSkyblock.getConfig().getString("earn-miner-message").replace("%earn_level%", String.valueOf(cupidSkyblock.getConfig().getDouble("Miner.EMERALD_ORE.earn") * (2 + ((stats.getDexterity() / 10) * 2))))));
						break;

					case COAL_ORE:
						afterBreakEvent(player, block, Color.BLACK, block.getLocation());
						cupidSkyblock.apiExperiences.addMiner(player, cupidSkyblock.getConfig().getDouble("Miner.COAL_ORE.earn"));
						PacketUtils.sendActionBar(player, color(cupidSkyblock.getConfig().getString("earn-miner-message").replace("%earn_level%", String.valueOf(cupidSkyblock.getConfig().getDouble("Miner.COAL_ORE.earn") * (2 + ((stats.getDexterity() / 10) * 2))))));
						break;
						
					case IRON_ORE:
						afterBreakEvent(player, block, Color.WHITE, block.getLocation());
						cupidSkyblock.apiExperiences.addMiner(player, cupidSkyblock.getConfig().getDouble("Miner.IRON_ORE.earn"));
						PacketUtils.sendActionBar(player, color(cupidSkyblock.getConfig().getString("earn-miner-message").replace("%earn_level%", String.valueOf(cupidSkyblock.getConfig().getDouble("Miner.IRON_ORE.earn") * (2 + ((stats.getDexterity() / 10) * 2))))));
						break;
						
					case LAPIS_ORE:
						afterBreakEvent(player, block, Color.BLUE, block.getLocation());
						cupidSkyblock.apiExperiences.addMiner(player, cupidSkyblock.getConfig().getDouble("Miner.LAPIS_ORE.earn"));
						PacketUtils.sendActionBar(player, color(cupidSkyblock.getConfig().getString("earn-miner-message").replace("%earn_level%", String.valueOf(cupidSkyblock.getConfig().getDouble("Miner.LAPIS_ORE.earn") * (2 + ((stats.getDexterity() / 10) * 2))))));
						break;
						
					case GOLD_ORE:
						afterBreakEvent(player, block, Color.YELLOW, block.getLocation());
						cupidSkyblock.apiExperiences.addMiner(player, cupidSkyblock.getConfig().getDouble("Miner.GOLD_ORE.earn"));
						PacketUtils.sendActionBar(player, color(cupidSkyblock.getConfig().getString("earn-miner-message").replace("%earn_level%", String.valueOf(cupidSkyblock.getConfig().getDouble("Miner.GOLD_ORE.earn") * (2 + ((stats.getDexterity() / 10) * 2))))));
						break;

					case REDSTONE_ORE:
						afterBreakEvent(player, block, Color.RED, block.getLocation());
						cupidSkyblock.apiExperiences.addMiner(player, cupidSkyblock.getConfig().getDouble("Miner.REDSTONE_ORE.earn"));
						PacketUtils.sendActionBar(player, color(cupidSkyblock.getConfig().getString("earn-miner-message").replace("%earn_level%", String.valueOf(cupidSkyblock.getConfig().getDouble("Miner.REDSTONE_ORE.earn") * (2 + ((stats.getDexterity() / 10) * 2))))));
						break;
						
					case NETHER_QUARTZ_ORE:
						afterBreakEvent(player, block, Color.RED, block.getLocation());
						cupidSkyblock.apiExperiences.addMiner(player, cupidSkyblock.getConfig().getDouble("Miner.NETHER_QUARTZ_ORE.earn"));
						PacketUtils.sendActionBar(player, color(cupidSkyblock.getConfig().getString("earn-miner-message").replace("%earn_level%", String.valueOf(cupidSkyblock.getConfig().getDouble("Miner.NETHER_QUARTZ_ORE.earn") * (2 + ((stats.getDexterity() / 10) * 2))))));
						break;
						
					case STONE:
						afterBreakEvent(player, block, Color.GRAY, block.getLocation());
						break;
					
					case LIGHT_GRAY_TERRACOTTA:
						break;
						
					default:
						break;
				}
			}
		} else {
			if (cupidSkyblock.PlacedBlock.isBlockPlaced(block)) {
				event.setCancelled(false);
			} else {
				event.setCancelled(true);
				
				PacketUtils.sendActionBar(player, color(cupidSkyblock.getConfig().getString("pickaxe-require-message")));
			}
		}
	}
	
	private void afterBreakEvent(Player player, Block block, Color color, Location location) {
		
		ItemStack inHand = player.getInventory().getItemInMainHand();
		
		block.getDrops(inHand).forEach(drop -> {
			player.getInventory().addItem(drop);
		});
		
		BlockMetaData blockMetaData = new BlockMetaData(location.getWorld(), location.getX(), location.getY(), location.getZ(), block.getType());
		cupidSkyblock.blockMetaData.put(blockMetaData, System.currentTimeMillis());
		block.setType(Material.LIGHT_GRAY_TERRACOTTA);
		
		Particle.DustOptions dustOptions = new Particle.DustOptions(color, 1);
		location.add(0.5, 0.5, 0.5);
		location.getWorld().spawnParticle(Particle.REDSTONE, location, 100, .5, .5, .5, 0, dustOptions);
		
	}
}
