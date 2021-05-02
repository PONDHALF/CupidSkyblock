package com.cupidofficial.gui;

import static com.cupidofficial.util.util.color;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.cupidofficial.CupidSkyblock;
import com.cupidofficial.components.Experience;
import com.cupidofficial.components.Stats;
import com.cupidofficial.configs.GuiConfig;
import com.cupidofficial.managers.ProfileExperienceManager;
import com.cupidofficial.managers.ProfileManager;

import me.clip.placeholderapi.PlaceholderAPI;

public class ProfileGui {

	public static final String PROFILEGUI = "ProfileGui";

	private CupidSkyblock cupidSkyblock;
	private GuiConfig guiConfig;
	private FileConfiguration config;

	private ProfileExperienceManager profileExperienceManager;
	private ProfileManager profileManager;

	private ItemStack statsPointsItem;
	private ItemStack informationItem;
	private ItemStack experiencesItem;
	private ItemStack exitItem;
	private ItemStack vitalityItem;
	private ItemStack agilityItem;
	private ItemStack intelligenceItem;
	private ItemStack luckItem;
	private ItemStack dexterityItem;
	private ItemStack craftingTableItem;
	private ItemStack enderChestItem;

	private ItemStack StorageItem_1;
	private ItemStack StorageItem_2;
	private ItemStack StorageItem_3;
	private ItemStack StorageItem_4;
	private ItemStack StorageItem_5;
	private ItemStack StorageItem_6;

	private ItemStack NoneItem;

	public ProfileGui(CupidSkyblock cupidSkyblock) {
		this.cupidSkyblock = cupidSkyblock;
		this.profileExperienceManager = cupidSkyblock.getProfileExperienceManager();
		this.profileManager = cupidSkyblock.getProfileManager();
		guiConfig = cupidSkyblock.getGuiConfig();
		this.config = guiConfig.getConfig();

		informationItem = new ItemStack(Material.PLAYER_HEAD, 1);
		ItemMeta infItemMeta = informationItem.getItemMeta();
		infItemMeta.setDisplayName(color(config.getString(PROFILEGUI + ".InformationItem.name")));
		infItemMeta.setLore(Arrays.asList(""));
		informationItem.setItemMeta(infItemMeta);

		statsPointsItem = new ItemStack(Material.SNOWBALL, 1);
		ItemMeta statsPointsItemMeta = statsPointsItem.getItemMeta();
		statsPointsItemMeta.setDisplayName(color(config.getString(PROFILEGUI + ".StatsPointsItem.name")));
		statsPointsItemMeta.setLore(Arrays.asList(""));
		statsPointsItem.setItemMeta(statsPointsItemMeta);

		experiencesItem = new ItemStack(Material.BREWING_STAND, 1);
		ItemMeta exItemMeta = experiencesItem.getItemMeta();
		exItemMeta.setDisplayName(color(config.getString(PROFILEGUI + ".ExperiencesItem.name")));
		exItemMeta.setLore(Arrays.asList(""));
		experiencesItem.setItemMeta(exItemMeta);

		exitItem = new ItemStack(Material.BARRIER, 1);
		ItemMeta exitItemMeta = exitItem.getItemMeta();
		exitItemMeta.setDisplayName(color(config.getString(PROFILEGUI + ".ExitItem.name")));
		exitItemMeta.setLore(Arrays.asList(""));
		exitItem.setItemMeta(exitItemMeta);

		vitalityItem = new ItemStack(Material.GOLDEN_APPLE, 1);
		ItemMeta vitalityItemMeta = vitalityItem.getItemMeta();
		vitalityItemMeta.setDisplayName(color(config.getString(PROFILEGUI + ".VitalityItem.name")));
		vitalityItemMeta.setLore(Arrays.asList(""));
		vitalityItem.setItemMeta(vitalityItemMeta);

		agilityItem = new ItemStack(Material.FEATHER, 1);
		ItemMeta agilityItemMeta = agilityItem.getItemMeta();
		agilityItemMeta.setDisplayName(color(config.getString(PROFILEGUI + ".AgilityItem.name")));
		agilityItemMeta.setLore(Arrays.asList(""));
		agilityItem.setItemMeta(agilityItemMeta);

		intelligenceItem = new ItemStack(Material.POTION, 1);
		ItemMeta inItemMeta = intelligenceItem.getItemMeta();
		inItemMeta.setDisplayName(color(config.getString(PROFILEGUI + ".IntelligenceItem.name")));
		inItemMeta.setLore(Arrays.asList(""));
		intelligenceItem.setItemMeta(inItemMeta);

		luckItem = new ItemStack(Material.GOLD_INGOT, 1);
		ItemMeta luckItemMeta = luckItem.getItemMeta();
		luckItemMeta.setDisplayName(color(config.getString(PROFILEGUI + ".LuckItem.name")));
		luckItemMeta.setLore(Arrays.asList(""));
		luckItem.setItemMeta(luckItemMeta);

		dexterityItem = new ItemStack(Material.BOOK, 1);
		ItemMeta dexterityItemMeta = dexterityItem.getItemMeta();
		dexterityItemMeta.setDisplayName(color(config.getString(PROFILEGUI + ".DexterityItem.name")));
		dexterityItemMeta.setLore(Arrays.asList(""));
		dexterityItem.setItemMeta(dexterityItemMeta);

		craftingTableItem = new ItemStack(Material.CRAFTING_TABLE, 1);
		ItemMeta craftingTableItemMeta = craftingTableItem.getItemMeta();
		craftingTableItemMeta.setDisplayName(color(config.getString(PROFILEGUI + ".CraftingTableItem.name")));
		craftingTableItemMeta.setLore(Arrays.asList(""));
		craftingTableItem.setItemMeta(craftingTableItemMeta);

		enderChestItem = new ItemStack(Material.ENDER_CHEST, 1);
		ItemMeta enderChestItemMeta = enderChestItem.getItemMeta();
		enderChestItemMeta.setDisplayName(color(config.getString(PROFILEGUI + ".EnderChestItem.name")));
		enderChestItemMeta.setLore(Arrays.asList(""));
		enderChestItem.setItemMeta(enderChestItemMeta);

		StorageItem_1 = new ItemStack(Material.CHEST, 1);
		ItemMeta storageItem_1ItemMeta = StorageItem_1.getItemMeta();
		storageItem_1ItemMeta.setDisplayName(color(config.getString(PROFILEGUI + ".StorageItem.1.name")));
		storageItem_1ItemMeta.setLore(Arrays.asList(""));
		StorageItem_1.setItemMeta(storageItem_1ItemMeta);

		StorageItem_2 = new ItemStack(Material.CHEST, 1);
		ItemMeta storageItem_2ItemMeta = StorageItem_2.getItemMeta();
		storageItem_2ItemMeta.setDisplayName(color(config.getString(PROFILEGUI + ".StorageItem.2.name")));
		storageItem_2ItemMeta.setLore(Arrays.asList(""));
		StorageItem_2.setItemMeta(storageItem_2ItemMeta);

		StorageItem_3 = new ItemStack(Material.CHEST, 1);
		ItemMeta storageItem_3ItemMeta = StorageItem_3.getItemMeta();
		storageItem_3ItemMeta.setDisplayName(color(config.getString(PROFILEGUI + ".StorageItem.3.name")));
		storageItem_3ItemMeta.setLore(Arrays.asList(""));
		StorageItem_3.setItemMeta(storageItem_3ItemMeta);

		StorageItem_4 = new ItemStack(Material.CHEST, 1);
		ItemMeta storageItem_4ItemMeta = StorageItem_4.getItemMeta();
		storageItem_4ItemMeta.setDisplayName(color(config.getString(PROFILEGUI + ".StorageItem.4.name")));
		storageItem_4ItemMeta.setLore(Arrays.asList(""));
		StorageItem_4.setItemMeta(storageItem_4ItemMeta);

		StorageItem_5 = new ItemStack(Material.CHEST, 1);
		ItemMeta storageItem_5ItemMeta = StorageItem_5.getItemMeta();
		storageItem_5ItemMeta.setDisplayName(color(config.getString(PROFILEGUI + ".StorageItem.5.name")));
		storageItem_5ItemMeta.setLore(Arrays.asList(""));
		StorageItem_5.setItemMeta(storageItem_5ItemMeta);

		StorageItem_6 = new ItemStack(Material.CHEST, 1);
		ItemMeta storageItem_6ItemMeta = StorageItem_6.getItemMeta();
		storageItem_6ItemMeta.setDisplayName(color(config.getString(PROFILEGUI + ".StorageItem.6.name")));
		storageItem_6ItemMeta.setLore(Arrays.asList(""));
		StorageItem_6.setItemMeta(storageItem_6ItemMeta);

		NoneItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
		ItemMeta noneItemMeta = NoneItem.getItemMeta();
		noneItemMeta.setDisplayName(color(config.getString(PROFILEGUI + ".NoneItem.name")));
		noneItemMeta.setLore(Arrays.asList(""));
		NoneItem.setItemMeta(noneItemMeta);
	}

//	public void formatAndReplaceList(List<String> list, Player player) {
//		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
//		Experience experience = profileExperienceManager.getPlayerProfileExperience(player.getUniqueId()).getExperience();
//		
//		  for (int i = 0; i < list.size(); i++) {
//		    String line = list.get(i);
//		    list.set(i, color(line
//					.replace("%player_stats_points%", String.valueOf(stats.getPoints()))
//					.replace("%player_stats_vitality%", String.valueOf(stats.getVitality())
//					.replace("%player_stats_agility%", String.valueOf(stats.getAgility())
//					.replace("%player_stats_intelligence%", String.valueOf(stats.getIntelligence())
//					.replace("%player_stats_luck%", String.valueOf(stats.getLuck())
//					.replace("%player_stats_dexterity%", String.valueOf(stats.getDexterity())
//					.replace("%player_experience_woodcutting%", String.valueOf(experience.getWoodcutting())
//					.replace("%player_experience_miner%", String.valueOf(experience.getMiner())
//					.replace("%player_experience_farmer%", String.valueOf(experience.getFarmer())))))))))));
//		  }
//		}

	public void profileGui(Player player) {
		Stats stats = profileManager.getPlayerProfile(player.getUniqueId()).getStats();
		Experience experience = profileExperienceManager.getPlayerProfileExperience(player.getUniqueId()).getExperience();

		String guiDisplayName = color(config.getString(PROFILEGUI + ".Display.name"));

		Inventory profileGuiInv = Bukkit.createInventory(null, 54, guiDisplayName);

		List<String> informationItemLores = config.getStringList(PROFILEGUI + ".Information.lore");
		List<String> statsPointsLores = config.getStringList(PROFILEGUI + ".StatsPointsItem.lore");
		List<String> experienceLores = config.getStringList(PROFILEGUI + ".ExperiencesItem.lore");
		List<String> exitItemLores = config.getStringList(PROFILEGUI + ".ExitItem.lore");
		List<String> vitalityItemLores = config.getStringList(PROFILEGUI + ".VitalityItem.lore");
		List<String> agilityItemLores = config.getStringList(PROFILEGUI + ".AgilityItem.lore");
		List<String> intelligenceItemLores = config.getStringList(PROFILEGUI + ".IntelligenceItem.lore");
		List<String> luckItemLores = config.getStringList(PROFILEGUI + ".LuckItem.lore");
		List<String> dexterityItemLores = config.getStringList(PROFILEGUI + ".DexterityItem.lore");
		List<String> craftingTableItemLores = config.getStringList(PROFILEGUI + ".CraftingTableItem.lore");
		List<String> enderChestItemLores = config.getStringList(PROFILEGUI + ".EnderChestItem.lore");
		List<String> StorageItem_1Lores = config.getStringList(PROFILEGUI + ".StorageItem.1.lore");
		List<String> StorageItem_2Lores = config.getStringList(PROFILEGUI + ".StorageItem.2.lore");
		List<String> StorageItem_3Lores = config.getStringList(PROFILEGUI + ".StorageItem.3.lore");
		List<String> StorageItem_4Lores = config.getStringList(PROFILEGUI + ".StorageItem.4.lore");
		List<String> StorageItem_5Lores = config.getStringList(PROFILEGUI + ".StorageItem.5.lore");
		List<String> StorageItem_6Lores = config.getStringList(PROFILEGUI + ".StorageItem.6.lore");
		List<String> noneItemLores = config.getStringList(PROFILEGUI + ".NoneItem.lore");

		for (int i = 0; i < statsPointsLores.size(); i++) {
			String lines = statsPointsLores.get(i);
			statsPointsLores.set(i, color(PlaceholderAPI.setPlaceholders(player, lines)));
		}

		for (int i = 0; i < experienceLores.size(); i++) {
			String lines = experienceLores.get(i);
			experienceLores.set(i, color(PlaceholderAPI.setPlaceholders(player, lines)));
		}

		for (int i = 0; i < exitItemLores.size(); i++) {
			String lines = exitItemLores.get(i);
			exitItemLores.set(i, color(PlaceholderAPI.setPlaceholders(player, lines)));
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

		for (int i = 0; i < craftingTableItemLores.size(); i++) {
			String lines = craftingTableItemLores.get(i);
			craftingTableItemLores.set(i, color(PlaceholderAPI.setPlaceholders(player, lines)));
		}

		for (int i = 0; i < enderChestItemLores.size(); i++) {
			String lines = enderChestItemLores.get(i);
			enderChestItemLores.set(i, color(PlaceholderAPI.setPlaceholders(player, lines)));
		}

		for (int i = 0; i < StorageItem_1Lores.size(); i++) {
			String lines = StorageItem_1Lores.get(i);
			StorageItem_1Lores.set(i, color(PlaceholderAPI.setPlaceholders(player, lines)));
		}

		for (int i = 0; i < StorageItem_2Lores.size(); i++) {
			String lines = StorageItem_2Lores.get(i);
			StorageItem_2Lores.set(i, color(PlaceholderAPI.setPlaceholders(player, lines)));
		}

		for (int i = 0; i < StorageItem_3Lores.size(); i++) {
			String lines = StorageItem_3Lores.get(i);
			StorageItem_3Lores.set(i, color(PlaceholderAPI.setPlaceholders(player, lines)));
		}

		for (int i = 0; i < StorageItem_4Lores.size(); i++) {
			String lines = StorageItem_4Lores.get(i);
			StorageItem_4Lores.set(i, color(PlaceholderAPI.setPlaceholders(player, lines)));
		}

		for (int i = 0; i < StorageItem_5Lores.size(); i++) {
			String lines = StorageItem_5Lores.get(i);
			StorageItem_5Lores.set(i, color(PlaceholderAPI.setPlaceholders(player, lines)));
		}

		for (int i = 0; i < StorageItem_6Lores.size(); i++) {
			String lines = StorageItem_6Lores.get(i);
			StorageItem_6Lores.set(i, color(PlaceholderAPI.setPlaceholders(player, lines)));
		}

		profileGuiInv.setItem(4, editItem(informationItem.clone(), 1, informationItemLores));

		profileGuiInv.setItem(22, editItem(statsPointsItem.clone(), 1, statsPointsLores));

		profileGuiInv.setItem(31, editItem(experiencesItem.clone(), 1, experienceLores));

		profileGuiInv.setItem(49, editItem(exitItem.clone(), 1, exitItemLores));

		profileGuiInv.setItem(1, editItem(vitalityItem.clone(), stats.getVitality(), vitalityItemLores));

		profileGuiInv.setItem(10, editItem(agilityItem.clone(), stats.getAgility(), agilityItemLores));

		profileGuiInv.setItem(19, editItem(intelligenceItem.clone(), stats.getIntelligence(), intelligenceItemLores));

		profileGuiInv.setItem(28, editItem(luckItem.clone(), stats.getLuck(), luckItemLores));

		profileGuiInv.setItem(37, editItem(dexterityItem.clone(), stats.getDexterity(), dexterityItemLores));

		profileGuiInv.setItem(52, editItem(craftingTableItem.clone(), 1, craftingTableItemLores));

		profileGuiInv.setItem(53, editItem(enderChestItem.clone(), 1, enderChestItemLores));

		profileGuiInv.setItem(7, editItem(StorageItem_1.clone(), 1, StorageItem_1Lores));

		profileGuiInv.setItem(16, editItem(StorageItem_2.clone(), 1, StorageItem_2Lores));

		profileGuiInv.setItem(25, editItem(StorageItem_3.clone(), 1, StorageItem_3Lores));

		profileGuiInv.setItem(8, editItem(StorageItem_4.clone(), 1, StorageItem_4Lores));

		profileGuiInv.setItem(17, editItem(StorageItem_5.clone(), 1, StorageItem_5Lores));

		profileGuiInv.setItem(26, editItem(StorageItem_6.clone(), 1, StorageItem_6Lores));

		profileGuiInv.setItem(0, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(9, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(18, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(27, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(36, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(45, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(46, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(47, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(48, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(39, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(30, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(21, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(12, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(3, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(13, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(14, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(5, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(23, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(32, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(41, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(40, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(50, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(42, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(43, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(44, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(45, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(35, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(34, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(33, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(24, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(15, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(6, editItem(NoneItem.clone(), 1, noneItemLores));
		profileGuiInv.setItem(51, editItem(NoneItem.clone(), 1, noneItemLores));

		player.openInventory(profileGuiInv);
	}

	public ItemStack editItem(ItemStack item, int amount, List<String> lore) {
		if (amount == 0) {
			amount = 1;
		}
		item.setAmount(amount);
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setLore(lore);
		item.setItemMeta(itemMeta);
		return item;
	}

}