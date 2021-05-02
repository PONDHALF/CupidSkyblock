package com.cupidofficial.commands;

import static com.cupidofficial.util.util.warn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cupidofficial.CupidSkyblock;

public class profileCommand implements CommandExecutor {

	private CupidSkyblock cupidSkyblock;
	
// private ArrayList<ObjectCommands> objectCommands = new ArrayList<>();
		
	public profileCommand(CupidSkyblock cupidSkyblock) {
		this.cupidSkyblock = cupidSkyblock;
		
		cupidSkyblock.getCommand("profile").setExecutor(this::onCommand);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,
			String[] args) {
		
		if (!(sender instanceof Player)) { 
			warn("[ERROR] This feature isn't allowed for console!");
		} 
		
		Player player = (Player) sender;
		
		cupidSkyblock.profileGui.profileGui(player);
		
		return true;
	}

}
