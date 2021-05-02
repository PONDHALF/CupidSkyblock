package com.cupidofficial.listeners;

import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import com.cupidofficial.CupidSkyblock;

public class placedBlock implements Listener{
	private CupidSkyblock cupidSkyblock;
	
	public placedBlock(CupidSkyblock cupidSkyblock) {
		this.cupidSkyblock = cupidSkyblock;
		
		cupidSkyblock.getServer().getPluginManager().registerEvents(this, cupidSkyblock);
	}
	
	@EventHandler
	public void placeBlock(BlockPlaceEvent event) {
		Block block = event.getBlock();
		Player player = event.getPlayer();
		
		block.setMetadata(block.getType().toString() + "_PlacedBlock", new FixedMetadataValue(cupidSkyblock, Boolean.valueOf(true)));
	}
	
	public boolean isBlockPlaced(Block block) {
		List<MetadataValue> valueMeta = block.getMetadata(block.getType().toString() + "_PlacedBlock");
		
		for (MetadataValue metadataValue : valueMeta) {
			return metadataValue.asBoolean();
		}
		return false;
	}
	
}
