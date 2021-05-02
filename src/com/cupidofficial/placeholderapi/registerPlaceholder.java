package com.cupidofficial.placeholderapi;

import org.bukkit.entity.Player;

import com.cupidofficial.CupidSkyblock;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class registerPlaceholder extends PlaceholderExpansion{
	
	private CupidSkyblock cupidSkyblock;
	
	public static final String Identifier = "cupidskyblock"; 
	
	public registerPlaceholder(CupidSkyblock cupidSkyblock) {
		this.cupidSkyblock = cupidSkyblock;
	}
	
    @Override
    public boolean persist(){
        return true;
    }
	
    @Override
    public boolean canRegister(){
        return true;
    }
	
	@Override
	public String getAuthor() {
		return cupidSkyblock.getDescription().getAuthors().toString();
	}

	@Override
	public String getIdentifier() {
		return this.Identifier;
	}

	@Override
	public String getVersion() {
		return cupidSkyblock.getDescription().getVersion();
	}
	
	@Override
	public String onPlaceholderRequest(Player player, String identifier) {
		if (player == null) {return "";}
		
		if (identifier.equals("stats_points")) {
			return cupidSkyblock.apiStats.getPoints(player);
		}
		
		if (identifier.equals("stats_vitality")) {
			return cupidSkyblock.apiStats.getVitality(player);
		}
		
		if (identifier.equals("stats_agility")) {
			return cupidSkyblock.apiStats.getAgility(player);
		}
		
		if (identifier.equals("stats_intelligence")) {
			return cupidSkyblock.apiStats.getIntelligence(player);
		}
		
		if (identifier.equals("stats_luck")) {
			return cupidSkyblock.apiStats.getLuck(player);
		}
		
		if (identifier.equals("stats_dexterity")) {
			return cupidSkyblock.apiStats.getDexterity(player);
		}
		
		// Experiences 
		
		if (identifier.equals("experience_woodcutting")) {
			return cupidSkyblock.apiExperiences.getWoodCutting(player);
		}
		
		if (identifier.equals("experience_miner")) {
			return cupidSkyblock.apiExperiences.getMiner(player);		
		}
		
		if (identifier.equals("experience_farmer")) {
			return cupidSkyblock.apiExperiences.getFarmer(player);	
		}
		
		return null;
		
	}

}
