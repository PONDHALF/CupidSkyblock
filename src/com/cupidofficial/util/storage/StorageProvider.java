package com.cupidofficial.util.storage;

import org.bukkit.entity.Player;

public interface StorageProvider {
    /**
     * Check if a player should see a armor stand or not.
     *
     * @param player player to check.
     * @return true if the player can see the armor stand, false otherwhise.
     */
    boolean showArmorStand(Player player);

    /**
     * Set the armorstand show status for a player.
     *
     * @param player player to set the status.
     * @param status new status.
     */
    void setShowArmorStand(Player player, boolean status);
}
