package com.cupidofficial.api;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.cupidofficial.CupidSkyblock;
import com.cupidofficial.components.Stats;
import com.cupidofficial.managers.ProfileManager;

public class ApiStats {
	
	private CupidSkyblock cupidSkyblock;
	
	private ProfileManager profileManager;
	
	public ApiStats(CupidSkyblock cupidSkyblock) {
		this.cupidSkyblock = cupidSkyblock;
		this.profileManager = cupidSkyblock.getProfileManager();
	}
	
	public String getPoints(Player player) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		return String.valueOf(stats.getPoints());
	}
	
	public String getVitality(Player player) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		return String.valueOf(stats.getVitality());
	}
	
	public String getAgility(Player player) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		return String.valueOf(stats.getAgility());
	}
	
	public String getIntelligence(Player player) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		return String.valueOf(stats.getIntelligence());
	}
	
	public String getLuck(Player player) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		return String.valueOf(stats.getLuck());
	}
	
	public String getDexterity(Player player) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		return String.valueOf(stats.getDexterity());
	}

	public String getPoints(OfflinePlayer player) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		return String.valueOf(stats.getPoints());
	}
	
	public String getVitality(OfflinePlayer player) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		return String.valueOf(stats.getVitality());
	}
	
	public String getAgility(OfflinePlayer player) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		return String.valueOf(stats.getAgility());
	}
	
	public String getIntelligence(OfflinePlayer player) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		return String.valueOf(stats.getIntelligence());
	}
	
	public String getLuck(OfflinePlayer player) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		return String.valueOf(stats.getLuck());
	}
	
	public String getDexterity(OfflinePlayer player) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		return String.valueOf(stats.getDexterity());
	}
	
	public void setPoints(Player player, int amount) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		stats.setPoints(amount);
	}
	
	public void setVitality(Player player, int amount) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		stats.setVitality(amount);
	}
	
	public void setAgility(Player player, int amount) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		stats.setAgility(amount);
	}
	
	public void setIntelligence(Player player, int amount) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		stats.setIntelligence(amount);
	}
	
	public void setLuck(Player player, int amount) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		stats.setLuck(amount);
	}
	
	public void setDexterity(Player player, int amount) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		stats.setDexterity(amount);
	}
	
	public void addPoints(Player player, int amount) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		stats.setPoints(amount + stats.getPoints());
	}
	
	public void addVitality(Player player, int amount) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		stats.setVitality(amount + stats.getVitality());
	}
	
	public void addAgility(Player player, int amount) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		stats.setAgility(amount + stats.getAgility());
	}
	
	public void addIntelligence(Player player, int amount) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		stats.setIntelligence(amount + stats.getIntelligence());
	}
	
	public void addLuck(Player player, int amount) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		stats.setLuck(amount + stats.getLuck());
	}
	
	public void addDexterity(Player player, int amount) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		
		stats.setDexterity(amount + stats.getDexterity());
	}
	
}
