package com.cupidofficial.discord;

import javax.security.auth.login.LoginException;

import com.cupidofficial.CupidSkyblock;
import com.cupidofficial.discord.discordCommands.DiscordCommandManager;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class DiscordSetup {
	
	private CupidSkyblock cupidSkyblock;
	
	public DiscordSetup(CupidSkyblock cupidSkyblock) {
		this.cupidSkyblock = cupidSkyblock;
		
		setup();
	}
	
	public void setup() {
		try {
			JDA jda = new JDABuilder(AccountType.BOT).setToken(cupidSkyblock.getConfig().getString("bot-token")).build();
		
			jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
			jda.getPresence().setActivity(Activity.playing("MC-CUPID.COM"));
			
			jda.addEventListener(new DiscordCommandManager(cupidSkyblock));
			
		} catch (LoginException exception) {
			exception.printStackTrace();
		}
	}
	
}
