package com.cupidofficial.commands;

import static com.cupidofficial.util.util.color;
import static com.cupidofficial.util.util.warn;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.cupidofficial.CupidSkyblock;

public class adminProfileCommand implements CommandExecutor {

	private CupidSkyblock cupidSkyblock;
	private ArrayList<ObjectCommands> objectCommands = new ArrayList<ObjectCommands>();
	
	public static final String ADMINPROFILE = "adminprofile";
	
	public adminProfileCommand(CupidSkyblock cupidSkyblock) {
		this.cupidSkyblock = cupidSkyblock;
		
		cupidSkyblock.getCommand(this.ADMINPROFILE).setExecutor(this::onCommand);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,
			String[] args) {
		
		if (!(sender instanceof Player)) {
			warn("[ERROR] This feature isn't allowed for console!");
			return true;
		}
		
		FileConfiguration config = cupidSkyblock.getConfig();
		
		Player player = (Player) sender;
		
		if (player.hasPermission("cupidskyblock.admin.command.adminprofile")) {
			
			if (args.length == 0) {
				
				player.sendMessage(color("&f( &cADMIN-PROFILE &f)"));
				
				for (int i = 0; i < objectCommands.size(); i++) {
					player.sendMessage(color(objectCommands.get(i).getSyntax()));
				}
				
				player.sendMessage(color("&f( &cADMIN-PROFILE &f)"));
				
				return true;
				
			} else if (args.length == 1) {
				
				for (int i = 0; i < objectCommands.size(); i++) {
					
					if (args[1].equalsIgnoreCase(objectCommands.get(i).getName())) {
						objectCommands.get(i).execute(sender, args);
					}
					return true;
				}
				
			}
			
		} else { player.sendMessage(color(cupidSkyblock.getConfig().getString("no-permission-message"))); }
		
		return true;
	
	}

}
