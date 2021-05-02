package com.cupidofficial.commands;

import org.bukkit.command.CommandSender;

public abstract class ObjectCommands {
	
	public abstract String getName();
	
	public abstract String getSyntax();
	
	public abstract String getDescription();
	
	public abstract void execute(CommandSender sender, String[] args);
	
}
