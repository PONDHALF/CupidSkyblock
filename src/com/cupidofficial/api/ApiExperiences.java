package com.cupidofficial.api;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.cupidofficial.CupidSkyblock;
import com.cupidofficial.components.Experience;
import com.cupidofficial.managers.ProfileExperienceManager;

public class ApiExperiences {
	
	private CupidSkyblock cupidSkyblock;
	
	private ProfileExperienceManager profileExperienceManager;
	
	public ApiExperiences(CupidSkyblock cupidSkyblock) {
		this.cupidSkyblock = cupidSkyblock;
		this.profileExperienceManager = cupidSkyblock.getProfileExperienceManager();
	}
	
	public String getWoodCutting(Player player) {
		Experience experience = profileExperienceManager.getPlayerProfileExperience(player.getUniqueId()).getExperience();
		
		return String.valueOf(experience.getWoodcutting());
	}
	
	public String getMiner(Player player) {
		Experience experience = profileExperienceManager.getPlayerProfileExperience(player.getUniqueId()).getExperience();
		
		return String.valueOf(experience.getMiner());
	}
	
	public String getFarmer(Player player) {
		Experience experience = profileExperienceManager.getPlayerProfileExperience(player.getUniqueId()).getExperience();
		
		return String.valueOf(experience.getFarmer());
	}

	public String getWoodCutting(OfflinePlayer player) {
		Experience experience = profileExperienceManager.getPlayerProfileExperience(player.getUniqueId()).getExperience();
		
		return String.valueOf(experience.getWoodcutting());
	}
	
	public String getMiner(OfflinePlayer player) {
		Experience experience = profileExperienceManager.getPlayerProfileExperience(player.getUniqueId()).getExperience();
		
		return String.valueOf(experience.getMiner());
	}
	
	public String getFarmer(OfflinePlayer player) {
		Experience experience = profileExperienceManager.getPlayerProfileExperience(player.getUniqueId()).getExperience();
		
		return String.valueOf(experience.getFarmer());
	}
	
	public void setWoodCutting(Player player, double amount) {
		Experience experience = profileExperienceManager.getPlayerProfileExperience(player.getUniqueId()).getExperience();
		
		experience.setWoodcutting(amount);
	}
	
	public void setMiner(Player player, double amount) {
		Experience experience = profileExperienceManager.getPlayerProfileExperience(player.getUniqueId()).getExperience();
		
		experience.setMiner(amount);
	}
	
	public void setFarmer(Player player, double amount) {
		Experience experience = profileExperienceManager.getPlayerProfileExperience(player.getUniqueId()).getExperience();
		
		experience.setFarmer(amount);
	}
	
	public void addWoodCutting(Player player, double amount) {
		Experience experience = profileExperienceManager.getPlayerProfileExperience(player.getUniqueId()).getExperience();
		
		experience.setWoodcutting(amount + experience.getWoodcutting());
	}
	
	public void addMiner(Player player, double amount) {
		Experience experience = profileExperienceManager.getPlayerProfileExperience(player.getUniqueId()).getExperience();
		
		experience.setMiner(amount + experience.getMiner());
	}
	
	public void addFarmer(Player player, double amount) {
		Experience experience = profileExperienceManager.getPlayerProfileExperience(player.getUniqueId()).getExperience();
		
		experience.setFarmer(amount + experience.getFarmer());
	}
	
}
