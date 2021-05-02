package com.cupidofficial.configs;

import java.io.File;
import java.util.UUID;

import com.cupidofficial.CupidSkyblock;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import static com.cupidofficial.util.util.*;

public class StorageConfig {
    
    static File configFile;
    static FileConfiguration config;
    static File folder = CupidSkyblock.plugin().getDataFolder();
    static File dataFolder = new File(folder, "storage" + File.separatorChar);

    public static void createFile(UUID uuid) {
        if (!dataFolder.exists()) dataFolder.mkdirs();
        configFile = new File(dataFolder, uuid.toString() + ".yml");
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (Exception exception) {
                log("ERROR: Could not create file: " + configFile.getName());
                exception.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public static File getFolder() {
        return folder;
    }

    public static void load(UUID uuid) {
        configFile = new File(dataFolder, uuid.toString() + ".yml");
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public static FileConfiguration getConfig() {
        return config;
    }

    public static FileConfiguration getConfigFile(File file) {
        return YamlConfiguration.loadConfiguration(file);
    }

    public static void save() {
        try {
            config.save(configFile);
        } catch (Exception exception) {
            log("ERROR: Could not save file: " + configFile.getName());
            exception.printStackTrace();
        }
    }

    public static void save(File sFile, FileConfiguration cFile) {
        try {
            cFile.save(sFile);
        } catch (Exception exception) {
            log("ERROR: Could not save file:" + configFile.getName());
            exception.printStackTrace();
        }
    }
    
}
