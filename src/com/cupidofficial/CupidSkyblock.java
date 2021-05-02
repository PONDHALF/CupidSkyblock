package com.cupidofficial;

import static com.cupidofficial.util.util.log;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import com.cupidofficial.api.ApiExperiences;
import com.cupidofficial.api.ApiStats;
import com.cupidofficial.commands.adminProfileCommand;
import com.cupidofficial.commands.profileCommand;
import com.cupidofficial.components.ProfileStorageManager;
import com.cupidofficial.configs.GuiConfig;
import com.cupidofficial.configs.ProfileConfig;
import com.cupidofficial.configs.ProfileExperienceConfig;
import com.cupidofficial.discord.DiscordSetup;
import com.cupidofficial.gui.ProfileGui;
import com.cupidofficial.listeners.DamageIndicatorListener;
import com.cupidofficial.listeners.placedBlock;
import com.cupidofficial.listeners.profileJoinListener;
import com.cupidofficial.listeners.GUIListeners.ProfileGUIListener;
import com.cupidofficial.listeners.experienceListeners.BlockMetaData;
import com.cupidofficial.listeners.experienceListeners.ExperienceListener;
import com.cupidofficial.listeners.experienceListeners.experiences.FarmingListener;
import com.cupidofficial.listeners.experienceListeners.experiences.MinerListener;
import com.cupidofficial.listeners.experienceListeners.experiences.WoodCuttingListener;
import com.cupidofficial.managers.ProfileExperienceManager;
import com.cupidofficial.managers.ProfileManager;
import com.cupidofficial.placeholderapi.registerPlaceholder;
import com.cupidofficial.util.CompatUtil;
import com.cupidofficial.util.storage.SimpleStorageProvider;
import com.cupidofficial.util.storage.StorageProvider;

import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CupidSkyblock extends JavaPlugin {
	
	public static final String prefix = "CUPID";
	
	private static CupidSkyblock plugin;

	public HashMap<BlockMetaData, Long> blockMetaData = new HashMap<>();
	
	private static Logger logger;
	
	private ProfileManager profileManager;
	private ProfileExperienceManager profileExperienceManager;
	
	private ProfileConfig profileConfig;
	private ProfileExperienceConfig profileExperienceConfig;
	
	private ProfileStorageManager profileStorageManager;

	private ExperienceListener experienceListener;
	
	// == API ==
	
	public ApiExperiences apiExperiences;
	public ApiStats apiStats;
	
	// =========
	
	public GuiConfig guiConfig;
	public ProfileGui profileGui;
	
	public placedBlock PlacedBlock;
	
	public WoodCuttingListener woodCuttingListener;
	public FarmingListener farmingListener;
	public MinerListener minerListener;
	
	// ========
	
	private DamageIndicatorListener damageIndicatorListener;
	private StorageProvider storageProvider = null;
	
	// ========
	
	private DiscordSetup discordSetup;
	
	@Override
	public void onEnable() {
		logger = getLogger();
		plugin = this;
		PluginManager pluginManager = this.getServer().getPluginManager();

		profileConfig = new ProfileConfig(this, "statsDatabase.yml");
		profileConfig.loadProfileExperienceConfig();
		
		profileManager = new ProfileManager(this);
		profileManager.loadProfilesFromConfig();
		
		profileExperienceConfig = new ProfileExperienceConfig(this, "experienceDatabase.yml");
		profileExperienceConfig.loadProfileConfig();
		
		profileExperienceManager = new ProfileExperienceManager(this);
		profileExperienceManager.loadProfileFromConfig();
		
		guiConfig = new GuiConfig(this, "guiconfig.yml");
		guiConfig.saveDefaultConfig();
		guiConfig.saveConfig();
		
		profileGui = new ProfileGui(this);
		
		profileStorageManager = new ProfileStorageManager(this);
		profileStorageManager.loadStorageFromConfig();

		CommandsRegistry();
		
		ListenersRegistry();

		// ======
		
		if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
			
			new registerPlaceholder(this).register();
			
			log("PlaceholderAPI hooked.!");
			
		} else { log("NOT found PlaceholderAPI plugin.!"); }
		// ======
		
		discordSetup = new DiscordSetup(this);
		
		// ======
		
		// API
		
		apiExperiences = new ApiExperiences(this);
		apiStats = new ApiStats(this);
		

		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		
		if (storageProvider == null) {
			storageProvider = new SimpleStorageProvider();
		}
		
		if (this.getConfig().getBoolean("DamageIndicator.Enabled")) {
			pluginManager.registerEvents(damageIndicatorListener = new DamageIndicatorListener(this), this);
		}
		startTasks();
		CompatUtil.onEnable();
		
		log("Enabled");
	}

	void CommandsRegistry() {
		new profileCommand(this);
		new adminProfileCommand(this);
	}

	void ListenersRegistry() {
		PluginManager pluginManager = this.getServer().getPluginManager();
		experienceListener = new ExperienceListener(this);
		
		PlacedBlock = new placedBlock(this);
		
		pluginManager.registerEvents(new profileJoinListener(this), this);
		pluginManager.registerEvents(experienceListener, this);
		pluginManager.registerEvents(new ProfileGUIListener(this), this);
		woodCuttingListener = new WoodCuttingListener(this);
		farmingListener = new FarmingListener(this);
		minerListener = new MinerListener(this);
		
		experienceListener.runBlockChanger();
	}

	@Override
	public void onDisable() {
        if (damageIndicatorListener != null) {
            damageIndicatorListener.getArmorStands().forEach((armor, time) -> armor.remove());
        }
		experienceListener.restoreBlocks();
		blockMetaData.clear();
		
		profileStorageManager.saveStorageToConfig();

		profileManager.saveProfilesToConfig();
		profileConfig.saveProfileExperienceConfig();
		
		profileExperienceManager.saveProfileToConfig();
		profileExperienceConfig.saveProfileConfig();
	}
	
	private void startTasks() {
        Bukkit.getScheduler().runTaskTimer(this, () -> {
            if (damageIndicatorListener != null) {
                Iterator<Map.Entry<ArmorStand, Long>> asit = damageIndicatorListener.getArmorStands().entrySet().iterator();
                while (asit.hasNext()) {
                    Map.Entry<ArmorStand, Long> ent = asit.next();
                    if (ent.getValue() + 1500 <= System.currentTimeMillis()) {
                        ent.getKey().remove();
                        asit.remove();
                    } else {
                        ent.getKey().teleport(ent.getKey().getLocation().clone().add(0.0, 0.07, 0.0));
                    }
                }
            }
        }, 0, 1);
	}

	public static CupidSkyblock plugin() {
		return plugin;
	}

	public static Logger getPluginLogger() {
		return logger;
	}
	
	public ProfileManager getProfileManager() {
		return profileManager;
	}
	
	public ProfileConfig getProfileConfig() {
		return profileConfig;
	}
	
	public ProfileExperienceManager getProfileExperienceManager() {
		return profileExperienceManager;
	}
	
	public ProfileExperienceConfig getProfileExperienceConfig() {
		return profileExperienceConfig;
	}

	public ProfileStorageManager getProfileStorageManager() {
		return profileStorageManager;
	}

	public GuiConfig getGuiConfig() {
		return guiConfig;
	}
	
	public boolean isDamageIndicator(Entity entity) {
		return isDamageIndicator(entity, true);
	}
	
    public boolean isDamageIndicator(Entity entity, boolean strict) {
        if (!(entity instanceof ArmorStand)) {
            return false;
        }
        ArmorStand as = (ArmorStand) entity;
        return as.hasMetadata("Mastercode-DamageIndicator") || !strict && (as.isMarker() && !as.isVisible() && as.isCustomNameVisible() && !as.hasGravity());
    }
    
    public StorageProvider getStorageProvider() {
        return storageProvider;
    }

    public void setStorageProvider(StorageProvider storageProvider) {
        this.storageProvider = storageProvider;
    }

}
