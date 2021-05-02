package com.cupidofficial.listeners.GUIListeners;

import static com.cupidofficial.util.util.color;

import java.util.List;

import com.cupidofficial.CupidSkyblock;
import com.cupidofficial.components.Experience;
import com.cupidofficial.components.ProfileStorageManager;
import com.cupidofficial.components.Stats;
import com.cupidofficial.configs.GuiConfig;
import com.cupidofficial.gui.ProfileGui;
import com.cupidofficial.managers.ProfileExperienceManager;
import com.cupidofficial.managers.ProfileManager;

import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.clip.placeholderapi.PlaceholderAPI;

public class ProfileGUIListener implements Listener {
	
	private CupidSkyblock cupidSkyblock;
	private GuiConfig guiConfig;
	private FileConfiguration config;
	
	private ProfileManager profileManager;
	private ProfileExperienceManager profileExperienceManager;
	private ProfileStorageManager profileStorageManager;

	public ProfileGUIListener(CupidSkyblock cupidSkyblock) {
		this.cupidSkyblock = cupidSkyblock;
		this.guiConfig = cupidSkyblock.getGuiConfig();
		this.config = guiConfig.getConfig();
		this.profileManager = cupidSkyblock.getProfileManager();
		this.profileExperienceManager = cupidSkyblock.getProfileExperienceManager();
		this.profileStorageManager = cupidSkyblock.getProfileStorageManager();
	}
	
	@EventHandler
	public void onProfileGUIClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		
		if (!event.getView().getTitle().equalsIgnoreCase(color(config.getString(ProfileGui.PROFILEGUI + ".Display.name")))) {
			return;
		}
		
		if (event.getClickedInventory() == null) return;
		
		event.setCancelled(true);
		if (!event.getClickedInventory().equals(inv)) {
			return;
		}
		
		Player player = (Player) event.getWhoClicked();
		ItemStack clickItem = event.getCurrentItem();
		int slot = event.getSlot();
		ClickType click = event.getClick();
		if (click != ClickType.LEFT && click != ClickType.RIGHT) {
			return;
		}
		
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		Experience experience = profileExperienceManager.getPlayerProfileExperience(player.getUniqueId()).getExperience();
		
		int points = stats.getPoints(),
				vitality = stats.getVitality(),
				agility = stats.getAgility(),
				intelligence = stats.getIntelligence(),
				luck = stats.getLuck(),
				dexterity = stats.getDexterity();
		
		switch (slot) {
			case 1:
				//vit slot
				if (vitality == 0 && click == ClickType.RIGHT || 
					vitality == this.cupidSkyblock.getConfig().getInt("maximum-of-stats") && click == ClickType.LEFT ) {
					return;
				}
				if (click == ClickType.LEFT) {
					if (points == 0) {
						return;
					} else {
						stats.setPoints(points - 1);
						stats.setVitality(vitality + 1);
					}
				} else {
					stats.setPoints(points + 1);
					stats.setVitality(vitality - 1);
				}
				player.updateInventory();
				break;
			case 10:
				//agi slot
				if (agility == 0 && click == ClickType.RIGHT || 
					agility == this.cupidSkyblock.getConfig().getInt("maximum-of-stats") && click == ClickType.LEFT ) {
					return;
				}
				if (click == ClickType.LEFT) {
					if (points == 0) {
						return;
					} else {
						stats.setPoints(points - 1);
						stats.setAgility(agility + 1);
					}
				} else {
					stats.setPoints(points + 1);
					stats.setAgility(agility - 1);
				}
				player.updateInventory();
				break;
			case 19:
				
				//intelligence slot
				if (intelligence == 0 && click == ClickType.RIGHT || 
					intelligence == this.cupidSkyblock.getConfig().getInt("maximum-of-stats") && click == ClickType.LEFT ) {
					return;
				}
				if (click == ClickType.LEFT) {
					if (points == 0) {
						return;
					} else {
						stats.setPoints(points - 1);
						stats.setIntelligence(intelligence + 1);
					}
				} else {
					stats.setPoints(points + 1);
					stats.setIntelligence(intelligence - 1);
				}
				player.updateInventory();
				break;
			case 28:
				
				//luck slot
				if (luck == 0 && click == ClickType.RIGHT || 
					luck == this.cupidSkyblock.getConfig().getInt("maximum-of-stats") && click == ClickType.LEFT ) {
					return;
				}
				if (click == ClickType.LEFT) {
					if (points == 0) {
						return;
					} else {
						stats.setPoints(points - 1);
						stats.setLuck(luck + 1);
					}
				} else {
					stats.setPoints(points + 1);
					stats.setLuck(luck - 1);
				}
				player.updateInventory();
				break;
			case 37:
				
				//Dex slot
				if (dexterity == 0 && click == ClickType.RIGHT || 
					dexterity == this.cupidSkyblock.getConfig().getInt("maximum-of-stats") && click == ClickType.LEFT ) {
					return;
				}
				if (click == ClickType.LEFT) {
					if (points == 0) {
						return;
					} else {
						stats.setPoints(points - 1);
						stats.setDexterity(dexterity + 1);
					}
				} else {
					stats.setPoints(points + 1);
					stats.setDexterity(dexterity - 1);
				}
				player.updateInventory();
				break;
			case 49:
				player.closeInventory();
				break;
			case 52:
				player.openWorkbench(null, true);
				break;
			case 53:
				player.openInventory(player.getEnderChest());
				break;
			case 7:
				player.openInventory(profileStorageManager.getProfileStorage(player.getUniqueId()).getStorage().getInventoryA());
				break;
			case 16:
				player.openInventory(profileStorageManager.getProfileStorage(player.getUniqueId()).getStorage().getInventoryB());
				break;
			case 25:
				player.openInventory(profileStorageManager.getProfileStorage(player.getUniqueId()).getStorage().getInventoryC());
				break;
			case 8:
				player.openInventory(profileStorageManager.getProfileStorage(player.getUniqueId()).getStorage().getInventoryD());
				break;
			case 17:
				player.openInventory(profileStorageManager.getProfileStorage(player.getUniqueId()).getStorage().getInventoryE());
				break;
			case 26:
				player.openInventory(profileStorageManager.getProfileStorage(player.getUniqueId()).getStorage().getInventoryF());
				break;
			default:
				break;
		}
		
		ItemStack pointsItem = inv.getItem(22),
				vitalityItem = inv.getItem(1),
				agilityItem = inv.getItem(10),
				intelligenceItem = inv.getItem(19),
				luckItem = inv.getItem(28),
				dexterityItem = inv.getItem(37),
				informationItem = inv.getItem(4),
				experienceItem = inv.getItem(31);
		
		List<String> informationItemLores = config.getStringList(ProfileGui.PROFILEGUI + ".Information.lore");
		List<String> statsPointsLores = config.getStringList(ProfileGui.PROFILEGUI + ".StatsPointsItem.lore");
		List<String> experienceLores = config.getStringList(ProfileGui.PROFILEGUI + ".ExperiencesItem.lore");
		List<String> vitalityItemLores = config.getStringList(ProfileGui.PROFILEGUI + ".VitalityItem.lore");
		List<String> agilityItemLores = config.getStringList(ProfileGui.PROFILEGUI + ".AgilityItem.lore");
		List<String> intelligenceItemLores = config.getStringList(ProfileGui.PROFILEGUI + ".IntelligenceItem.lore");
		List<String> luckItemLores = config.getStringList(ProfileGui.PROFILEGUI + ".LuckItem.lore");
		List<String> dexterityItemLores = config.getStringList(ProfileGui.PROFILEGUI + ".DexterityItem.lore");

		for (int i = 0; i < statsPointsLores.size(); i++) {
			String lines = statsPointsLores.get(i);
			statsPointsLores.set(i, color(PlaceholderAPI.setPlaceholders(player, lines)));
		}
		
		for (int i = 0; i < experienceLores.size(); i++) {
			String lines = experienceLores.get(i);
			experienceLores.set(i, color(PlaceholderAPI.setPlaceholders(player, lines)));
		}
		
		for (int i = 0; i < vitalityItemLores.size(); i++) {
			String lines = vitalityItemLores.get(i);
			vitalityItemLores.set(i, color(PlaceholderAPI.setPlaceholders(player, lines)));
		}
		
		for (int i = 0; i < agilityItemLores.size(); i++) {
			String lines = agilityItemLores.get(i);
			agilityItemLores.set(i, color(PlaceholderAPI.setPlaceholders(player, lines)));
		}
		
		for (int i = 0; i < intelligenceItemLores.size(); i++) {
			String lines = intelligenceItemLores.get(i);
			intelligenceItemLores.set(i, color(PlaceholderAPI.setPlaceholders(player, lines)));
		}
		
		for (int i = 0; i < luckItemLores.size(); i++) {
			String lines = luckItemLores.get(i);
			luckItemLores.set(i, color(PlaceholderAPI.setPlaceholders(player, lines)));
		}
		
		for (int i = 0; i < dexterityItemLores.size(); i++) {
			String lines = dexterityItemLores.get(i);
			dexterityItemLores.set(i, color(PlaceholderAPI.setPlaceholders(player, lines)));
		}
		
		
		inv.setItem(4, editItem(informationItem.clone(), 1, informationItemLores));
		
		inv.setItem(22, editItem(pointsItem.clone(), 1, statsPointsLores));
		
		inv.setItem(31, editItem(experienceItem.clone(), 1, experienceLores));
		
		inv.setItem(1, editItem(vitalityItem.clone(), stats.getVitality(), vitalityItemLores));
		
		inv.setItem(10, editItem(agilityItem.clone(), stats.getAgility(), agilityItemLores));
		
		inv.setItem(19, editItem(intelligenceItem.clone(), stats.getIntelligence(),intelligenceItemLores));
		
		inv.setItem(28, editItem(luckItem.clone(), stats.getLuck(), luckItemLores));
		
		inv.setItem(37, editItem(dexterityItem.clone(), stats.getDexterity(), dexterityItemLores));
		
		player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(1D + stats.getLuck()); 
		player.setWalkSpeed((float) (0.2 + ((stats.getAgility() / 10) * 0.2)));
	}
	
	public ItemStack editItem(ItemStack item, int amount, List<String> lore) {
		if (amount == 0) {
			amount = 1;
		}
		item.setAmount(amount);
		ItemMeta itemMeta  = item.getItemMeta();
		itemMeta.setLore(lore);
		item.setItemMeta(itemMeta);
		return item;
	}
	
}
