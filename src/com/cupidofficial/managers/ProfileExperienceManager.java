package com.cupidofficial.managers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.cupidofficial.CupidSkyblock;
import com.cupidofficial.components.Experience;
import com.cupidofficial.components.ProfileExperience;
import com.cupidofficial.configs.ProfileExperienceConfig;

public class ProfileExperienceManager {
	
	private CupidSkyblock cupidSkyblock;
	private Map<UUID, ProfileExperience> profilesExperience = new HashMap<>();
	
	private ProfileExperienceConfig profileExperienceConfig;
	private FileConfiguration config;
	
	public ProfileExperienceManager(CupidSkyblock cupidSkyblock) {
		this.cupidSkyblock = cupidSkyblock;
		profileExperienceConfig = cupidSkyblock.getProfileExperienceConfig();
		config = profileExperienceConfig.getConfig();
	}
	
	public void loadProfileFromConfig() {
		for (String id : config.getConfigurationSection("").getKeys(false)) {
			UUID uuid = UUID.fromString(id);
			double woodcutting = config.getDouble(id + ".experience.woodcutting");
			double miner = config.getDouble(id + ".experience.miner");
			double farmer = config.getDouble(id + ".experience.farmer");
			Experience experience = new Experience(woodcutting, miner, farmer);
			ProfileExperience profileExperience = new ProfileExperience(experience);
			profilesExperience.put(uuid, profileExperience);
		}
	}
	
	public void saveProfileToConfig() {
		for (UUID uuid : profilesExperience.keySet()) {
			String id = uuid.toString();
			ProfileExperience profileExperience = profilesExperience.get(uuid);
			Experience experience = profileExperience.getExperience();
			config.set(id + ".experience.woodcutting", experience.getWoodcutting());
			config.set(id + ".experience.miner", experience.getMiner());
			config.set(id + ".experience.farmer", experience.getFarmer());
		}
	}
	
	public ProfileExperience createNewProfileExperience(Player player) {
		Experience experience = new Experience(0.0, 0.0, 0.0);
		ProfileExperience profileExperience = new ProfileExperience(experience);
		profilesExperience.put(player.getUniqueId(), profileExperience);
		return profileExperience;
	}

	public ProfileExperience getPlayerProfileExperience(UUID uuid) {
		return profilesExperience.get(uuid);
	}
	
	
}
