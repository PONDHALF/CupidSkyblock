package com.cupidofficial.listeners;

import com.cupidofficial.CupidSkyblock;
import com.cupidofficial.components.Profile;
import com.cupidofficial.components.ProfileExperience;
import com.cupidofficial.components.ProfileStorage;
import com.cupidofficial.components.ProfileStorageManager;
import com.cupidofficial.configs.StorageConfig;
import com.cupidofficial.managers.ProfileExperienceManager;
import com.cupidofficial.managers.ProfileManager;
import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumskyblock.User;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static com.cupidofficial.util.util.*;

public class profileJoinListener implements Listener{

	private CupidSkyblock cupidSkyblock;
	private ProfileManager profileManager;
	private ProfileExperienceManager profileExperienceManager;
	private ProfileStorageManager profileStorageManager;

	public profileJoinListener(CupidSkyblock cupidSkyblock) {
		this.cupidSkyblock = cupidSkyblock;
		this.profileManager = cupidSkyblock.getProfileManager();
		this.profileExperienceManager = cupidSkyblock.getProfileExperienceManager();
		this.profileStorageManager = cupidSkyblock.getProfileStorageManager();
	}
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		User user = User.getUser((OfflinePlayer)player); 
		Profile profile = profileManager.getPlayerProfile(player.getUniqueId());
		ProfileExperience profileExperience = profileExperienceManager.getPlayerProfileExperience(player.getUniqueId());
		ProfileStorage profileStorage = profileStorageManager.getProfileStorage(player.getUniqueId());

		if (profileStorage == null) {
			profileStorageManager.createProfileStorage(player);
			StorageConfig.createFile(player.getUniqueId());
			log("Create new Profile!: " + player.getName());
		}

		if (user.getIsland() == null) {
			IridiumSkyblock.getIslandManager().createIsland(player);
		}
		
		if (profile == null) {
			profile = profileManager.createNewProfile(player);
		}
		
		if (profileExperience == null) {
			profileExperience = profileExperienceManager.createNewProfileExperience(player);
		}
		
	}
}
