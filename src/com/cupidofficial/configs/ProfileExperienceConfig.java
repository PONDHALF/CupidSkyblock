package com.cupidofficial.configs;

import static com.cupidofficial.util.util.warn;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.cupidofficial.CupidSkyblock;

public class ProfileExperienceConfig {
	
	private CupidSkyblock cupidSkyblock;
	private File file;
	private String fileName;
	private FileConfiguration config = new YamlConfiguration();
	
	public ProfileExperienceConfig(CupidSkyblock cupidSkyblock, String fileName) {
		this.cupidSkyblock = cupidSkyblock;
		this.fileName = fileName;
		file = new File(cupidSkyblock.getDataFolder(),fileName);
	}
	
	public void loadProfileConfig() {
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			cupidSkyblock.saveResource(fileName, false);
		}
		try {
			config.load(file);
		} catch (IOException | InvalidConfigurationException e) {
			warn("Error while loading profile config!");
			e.printStackTrace();
		}
	}
	
	public void saveProfileConfig() {
		try {
			config.save(file);
		} catch (IOException e) {
			warn("Error while saving profile config!");
			e.printStackTrace();
		}
	}

	public FileConfiguration getConfig() {
		return config;
	}	
	
}
