package com.cupidofficial.managers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.cupidofficial.CupidSkyblock;
import com.cupidofficial.components.Profile;
import com.cupidofficial.components.Stats;
import com.cupidofficial.configs.ProfileConfig;

public class ProfileManager {
	
	private CupidSkyblock cupidSkyblock;
	private Map<UUID, Profile> profiles = new HashMap<>();
	
	private ProfileConfig profileConfig;
	private FileConfiguration config;
	
	public ProfileManager(CupidSkyblock cupidSkyblock) {
		this.cupidSkyblock = cupidSkyblock;
		profileConfig = cupidSkyblock.getProfileConfig();
		config = profileConfig.getConfig();
	}
	
	public void loadProfilesFromConfig() {
		for (String id : config.getConfigurationSection("").getKeys(false)) {
			UUID uuid = UUID.fromString(id);
			int points = config.getInt(id + ".stats.points");
			int vitality = config.getInt(id + ".stats.vitality");
			int agility = config.getInt(id + ".stats.agility");
			int intelligence = config.getInt(id + ".stats.intelligence");
			int dexterity = config.getInt(id + ".stats.dexterity");
			int luck = config.getInt(id + ".stats.luck");
			Stats stats = new Stats(points, vitality, agility, intelligence, dexterity, luck);
			Profile profile = new Profile(stats);
			profiles.put(uuid, profile);
		}
	}
	
	public void saveProfilesToConfig() {
		for (UUID uuid : profiles.keySet()) {
			String id = uuid.toString();
			Profile profile = profiles.get(uuid);
			Stats stats = profile.getStats();
			config.set(id + ".stats.points", stats.getPoints());
			config.set(id + ".stats.vitality", stats.getVitality());
			config.set(id + ".stats.agility", stats.getAgility());
			config.set(id + ".stats.intelligence", stats.getIntelligence());
			config.set(id + ".stats.dexterity", stats.getDexterity());
			config.set(id + ".stats.luck", stats.getLuck());
		}
	}
	
	public Profile createNewProfile(Player player) {
		Stats stats = new Stats(10,0,0,0,0,0);
		Profile profile = new Profile(stats);
		profiles.put(player.getUniqueId(), profile);
		return profile;
	}
	
	public Profile getPlayerProfile(UUID uuid) {
		return profiles.get(uuid);
	}
	
}
