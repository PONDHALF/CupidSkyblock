package com.cupidofficial.components;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;
import java.util.List;

import com.cupidofficial.CupidSkyblock;
import com.cupidofficial.configs.StorageConfig;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import static com.cupidofficial.util.util.*;

public class ProfileStorageManager {
    
    private CupidSkyblock cupidskyblock;

    public static String TITLE = color("&o's Storage");

    public static HashMap<UUID, ProfileStorage> profiles = new HashMap<>();

    public ProfileStorageManager(CupidSkyblock cupidskyblock) {
        this.cupidskyblock = cupidskyblock;
    }

    public void loadStorageFromConfig() {
        File folder = new File(cupidskyblock.getDataFolder(), "storage" + File.separatorChar);
        File[] files = folder.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    File file = new File(folder, files[i].getName());
                    FileConfiguration config = StorageConfig.getConfigFile(file);
                    String uuidFile = files[i].getName().replace(".yml", "");

                    ItemStack[] aContents = ((List<ItemStack>) config.get(uuidFile + ".Type.1.Contents")).toArray(new ItemStack[0]);
                    ItemStack[] bContents = ((List<ItemStack>) config.get(uuidFile + ".Type.2.Contents")).toArray(new ItemStack[0]);
                    ItemStack[] cContents = ((List<ItemStack>) config.get(uuidFile + ".Type.3.Contents")).toArray(new ItemStack[0]);
                    ItemStack[] dContents = ((List<ItemStack>) config.get(uuidFile + ".Type.4.Contents")).toArray(new ItemStack[0]);
                    ItemStack[] eContents = ((List<ItemStack>) config.get(uuidFile + ".Type.5.Contents")).toArray(new ItemStack[0]);
                    ItemStack[] fContents = ((List<ItemStack>) config.get(uuidFile + ".Type.6.Contents")).toArray(new ItemStack[0]);
                    
                    String ownerName = config.getString(uuidFile + ".Owner");
                    int aSlots = config.getInt(uuidFile + ".Type.1.Size");
                    int bSlots = config.getInt(uuidFile + ".Type.2.Size");
                    int cSlots = config.getInt(uuidFile + ".Type.3.Size");
                    int dSlots = config.getInt(uuidFile + ".Type.4.Size");
                    int eSlots = config.getInt(uuidFile + ".Type.5.Size");
                    int fSlots = config.getInt(uuidFile + ".Type.6.Size");

                    Inventory aInv = Bukkit.createInventory((InventoryHolder) null, aSlots, ownerName + TITLE);
                    aInv.setContents(aContents);
                    
                    Inventory bInv = Bukkit.createInventory((InventoryHolder) null, bSlots, ownerName + TITLE);
                    bInv.setContents(bContents);
                    
                    Inventory cInv = Bukkit.createInventory((InventoryHolder) null, cSlots, ownerName + TITLE);
                    cInv.setContents(cContents);
                    
                    Inventory dInv = Bukkit.createInventory((InventoryHolder) null, dSlots, ownerName + TITLE);
                    dInv.setContents(dContents);
                    
                    Inventory eInv = Bukkit.createInventory((InventoryHolder) null, eSlots, ownerName + TITLE);
                    eInv.setContents(eContents);
                    
                    Inventory fInv = Bukkit.createInventory((InventoryHolder) null, fSlots, ownerName + TITLE);
                    fInv.setContents(fContents);

                    Storage storage = new Storage(aInv, bInv, cInv, dInv, eInv, fInv, ownerName);
                    ProfileStorage profile = new ProfileStorage(storage);
                    profiles.put(UUID.fromString(files[i].getName().replace(".yml", "")), profile);


                    log("LOG: Loading profiles: " + files[i].getName());

                }
            }
        }
    }

    public void saveStorageToConfig() {
        for (UUID uuid : profiles.keySet()) {
            ProfileStorage profile = profiles.get(uuid);
            Storage storage = profile.getStorage();
            File file = new File(cupidskyblock.getDataFolder(), "storage" + File.separatorChar + uuid.toString() + ".yml"); 
            FileConfiguration config = StorageConfig.getConfigFile(file);
            config.set(uuid.toString() + ".Owner", storage.getOwnerName());

            config.set(uuid.toString() + ".Type.1.Size", storage.getInventoryA().getSize());
            config.set(uuid.toString() + ".Type.2.Size", storage.getInventoryB().getSize());
            config.set(uuid.toString() + ".Type.3.Size", storage.getInventoryC().getSize());
            config.set(uuid.toString() + ".Type.4.Size", storage.getInventoryD().getSize());
            config.set(uuid.toString() + ".Type.5.Size", storage.getInventoryE().getSize());
            config.set(uuid.toString() + ".Type.6.Size", storage.getInventoryF().getSize());

            config.set(uuid.toString() + ".Type.1.Contents", storage.getInventoryA().getContents());
            config.set(uuid.toString() + ".Type.2.Contents", storage.getInventoryB().getContents());
            config.set(uuid.toString() + ".Type.3.Contents", storage.getInventoryC().getContents());
            config.set(uuid.toString() + ".Type.4.Contents", storage.getInventoryD().getContents());
            config.set(uuid.toString() + ".Type.5.Contents", storage.getInventoryE().getContents());
            config.set(uuid.toString() + ".Type.6.Contents", storage.getInventoryF().getContents());

            StorageConfig.save(file, config); 

        }
    }

    public ProfileStorage createProfileStorage(Player player) {
        Storage storage = new Storage(createInventory(player, 27), createInventory(player, 27), createInventory(player, 27),
        createInventory(player, 54), createInventory(player, 54), createInventory(player, 54), player.getName());

        ProfileStorage profile = new ProfileStorage(storage);
        profiles.put(player.getUniqueId(), profile);
        
        return profile;
    }

    public Inventory createInventory(Player player, int slots) {
        Inventory inv = Bukkit.createInventory((InventoryHolder) null, slots, player.getName() + TITLE);
        return inv;
    }

    public ProfileStorage getProfileStorage(UUID uuid) {
        return profiles.get(uuid);
    }

}
