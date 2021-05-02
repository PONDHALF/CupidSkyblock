package com.cupidofficial.discord.discordCommands;

import java.util.ArrayList;

import com.cupidofficial.CupidSkyblock;
import com.cupidofficial.discord.ObjectDiscordCommands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DiscordCommandManager extends ListenerAdapter{
	
	private CupidSkyblock cupidSkyblock;
	
	private ArrayList<ObjectDiscordCommands> objectDiscordCommands = new ArrayList<>();
	
	public DiscordCommandManager(CupidSkyblock cupidSkyblock) {
		this.cupidSkyblock = cupidSkyblock;
		
		objectDiscordCommands.add(new DiscordGetInfoPlayer(cupidSkyblock));
	}
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String args[] = event.getMessage().getContentRaw().split(" ");
		
		for (int i = 0; i < objectDiscordCommands.size(); i++) {
			if (args[0].equalsIgnoreCase(objectDiscordCommands.get(i).getName())) {
				
				objectDiscordCommands.get(i).execute(event, args);
				
			}
		}
	}
	
}
