package com.cupidofficial.util;

import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.ChatColor;

import com.cupidofficial.CupidSkyblock;

public class util {
	
	private static Logger logger = CupidSkyblock.getPluginLogger();
	
	public static String color(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
	
	public static String decolor(String message) {
		return ChatColor.stripColor(message);
	}
	
	public static void log(String...message) {
		for (String messages : message) {
			logger.info(messages);
		}
	}
	
	public static void warn(String...message) {
		for (String messages : message) {
			logger.warning(messages);
		}
	}
	
	public static ChatColor getRainbowColor() {
		  ChatColor[] colors = ChatColor.values();
		  int randomColor = new Random().nextInt(colors.length);
		  return colors[randomColor];
	}
}
