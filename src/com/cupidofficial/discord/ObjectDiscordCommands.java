package com.cupidofficial.discord;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public abstract class ObjectDiscordCommands {
	
	public abstract String getName();
	
	public abstract String getSyntax();
	
	public abstract String getDescription();
	
	public abstract void execute(GuildMessageReceivedEvent event, String[] args);
	
}
