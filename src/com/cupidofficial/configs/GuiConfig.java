package com.cupidofficial.configs;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.cupidofficial.CupidSkyblock;

public class GuiConfig {
	
	private CupidSkyblock cupidSkyblock;
	private String fileName;
	private FileConfiguration config = null;
	private File file = null;
	
	public GuiConfig(CupidSkyblock cupidSkyblock, String fileName) {
		this.cupidSkyblock = cupidSkyblock;
		this.fileName = fileName;
	}
	
	public void reloadConfig() {
		if (file == null) {
			file = new File(cupidSkyblock.getDataFolder(), fileName);
		}
		
		config = YamlConfiguration.loadConfiguration(file);
		InputStreamReader defConfigReader = new InputStreamReader(cupidSkyblock.getResource(fileName));
		
		if (defConfigReader != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigReader);
			config.setDefaults(defConfig);
		}
	}
	
	public FileConfiguration getConfig() {
		if (config == null) {
			reloadConfig();
		}
		return config;
	}
	
	public void saveConfig() {
		if (config == null || file == null) {
			return;
		}
		try {
			getConfig().save(file);
		} catch (IOException exception) {
			cupidSkyblock.getLogger().log(Level.SEVERE, "Could not save config to " + file, exception);
		}
	}
	
	public void saveDefaultConfig() {
		if (file == null) {
			file = new File(cupidSkyblock.getDataFolder(), fileName);
		}
		if (!file.exists()) {
			cupidSkyblock.saveResource(fileName, false);
		}
	}

	
			
//			config.set(ProfileGui.PROFILEGUI + ".InformationItem.name", "&bInformation");
//			config.set(ProfileGui.PROFILEGUI + ".InformationItem.lore", "");
//			
//			config.set(ProfileGui.PROFILEGUI + ".StatsPointsItem.name", "&eStats Points");
//			config.set(ProfileGui.PROFILEGUI + ".StatsPointsItem.lore", "");
//			
//			config.set(ProfileGui.PROFILEGUI + ".ExperiencesItem.name", "&eExperiences");
//			config.set(ProfileGui.PROFILEGUI + ".ExperiencesItem.lore", "");
//			
//			config.set(ProfileGui.PROFILEGUI + ".ExitItem.name", "&cExit");
//			config.set(ProfileGui.PROFILEGUI + ".ExitItem.lore", "");
//			
//			config.set(ProfileGui.PROFILEGUI + ".VitalityItem.name", "&aVitality");
//			config.set(ProfileGui.PROFILEGUI + ".VitalityItem.lore", "");
//			
//			config.set(ProfileGui.PROFILEGUI + ".AgilityItem.name", "&aAgility");
//			config.set(ProfileGui.PROFILEGUI + ".AgilityItem.lore", "");
//			
//			config.set(ProfileGui.PROFILEGUI + ".IntelligenceItem.name", "&aIntelligence");
//			config.set(ProfileGui.PROFILEGUI + ".IntelligenceItem.lore", "");
//			
//			config.set(ProfileGui.PROFILEGUI + ".LuckItem.name", "&aLuck");
//			config.set(ProfileGui.PROFILEGUI + ".LuckItem.lore", "");
//			
//			config.set(ProfileGui.PROFILEGUI + ".DexterityItem.name", "&aDexterity");
//			config.set(ProfileGui.PROFILEGUI + ".DexterityItem.lore", "");
//			
//			config.set(ProfileGui.PROFILEGUI + ".CraftingTableItem.name", "&dCrafting Table");
//			config.set(ProfileGui.PROFILEGUI + ".CraftingTableItem.lore", "");
//			
//			config.set(ProfileGui.PROFILEGUI + ".AnvilItem.name", "&dAnvil");
//			config.set(ProfileGui.PROFILEGUI + ".AnvilItem.lore", "");
//			
//			config.set(ProfileGui.PROFILEGUI + ".EnderChestItem.name", "&dEnder Chest");
//			config.set(ProfileGui.PROFILEGUI + ".EnderChestItem.lore", "");
//			
//			config.set(ProfileGui.PROFILEGUI + ".StorageItem.1.name", "&aStorage 1");
//			config.set(ProfileGui.PROFILEGUI + ".StorageItem.1.lore", "");
//			
//			config.set(ProfileGui.PROFILEGUI + ".StorageItem.2.name", "&aStorage 2");
//			config.set(ProfileGui.PROFILEGUI + ".StorageItem.2.lore", "");
//			
//			config.set(ProfileGui.PROFILEGUI + ".StorageItem.3.name", "&aStorage 3");
//			config.set(ProfileGui.PROFILEGUI + ".StorageItem.3.lore", "");
//			
//			config.set(ProfileGui.PROFILEGUI + ".StorageItem.4.name", "&aStorage 4");
//			config.set(ProfileGui.PROFILEGUI + ".StorageItem.4.lore", "");
//			
//			config.set(ProfileGui.PROFILEGUI + ".StorageItem.5.name", "&aStorage 5");
//			config.set(ProfileGui.PROFILEGUI + ".StorageItem.5.lore", "");
//			
//			config.set(ProfileGui.PROFILEGUI + ".StorageItem.6.name", "&aStorage 6");
//			config.set(ProfileGui.PROFILEGUI + ".StorageItem.6.lore", "");
//			
//			config.set(ProfileGui.PROFILEGUI + ".NoneItem.name", "&r");
//			config.set(ProfileGui.PROFILEGUI + ".NoneItem.lore", "");

}
