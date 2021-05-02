package com.cupidofficial.util;

import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_15_R1.ChatMessageType;
import net.minecraft.server.v1_15_R1.IChatBaseComponent;
import net.minecraft.server.v1_15_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_15_R1.PacketPlayOutChat;

public class PacketUtils {
	
	public static void sendActionBar(Player player, String message) {
		IChatBaseComponent baseComponent = ChatSerializer.a("{\"text\": \"" + message + "\"}");
		PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(baseComponent, ChatMessageType.GAME_INFO);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packetPlayOutChat);
	}
	
}
