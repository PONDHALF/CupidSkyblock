package com.cupidofficial.discord.discordCommands;

import java.awt.Color;

import com.cupidofficial.CupidSkyblock;
import com.cupidofficial.discord.ObjectDiscordCommands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class DiscordGetInfoPlayer extends ObjectDiscordCommands{
	
	private CupidSkyblock cupidSkyblock;
	
	public DiscordGetInfoPlayer(CupidSkyblock cupidSkyblock) {
		this.cupidSkyblock = cupidSkyblock;
	}
	
	@Override
	public String getName() {
		return "skyblock!/info";
	}

	@Override
	public String getSyntax() {
		return "";
	}

	@Override
	public String getDescription() {
		return "";
	}

	@Override
	public void execute(GuildMessageReceivedEvent event, String[] args) {
		TextChannel channel = event.getChannel();
		if (args.length == 2) {
			Player selector = Bukkit.getPlayer(args[1]);
			
			if (selector != null) {
				EmbedBuilder eb = new EmbedBuilder();
				eb.setThumbnail("https://visage.surgeplay.com/face/" + selector.getUniqueId());
				eb.setTitle(selector.getName() + "'s Information");
				eb.addField("Stats Points", String.valueOf(cupidSkyblock.apiStats.getPoints(selector)), true);
				eb.addField("Vitality", String.valueOf(cupidSkyblock.apiStats.getVitality(selector)), true);
				eb.addField("Agility", String.valueOf(cupidSkyblock.apiStats.getAgility(selector)), true);
				eb.addField("Intelligence", String.valueOf(cupidSkyblock.apiStats.getIntelligence(selector)), true);
				eb.addField("Luck", String.valueOf(cupidSkyblock.apiStats.getLuck(selector)), true);
				eb.addField("Dexterity", String.valueOf(cupidSkyblock.apiStats.getDexterity(selector)), true);
				eb.addField("Experiences:", "", true);
				eb.addField("WoodCutting", String.valueOf(cupidSkyblock.apiExperiences.getWoodCutting(selector)), true);
				eb.addField("Miner", String.valueOf(cupidSkyblock.apiExperiences.getMiner(selector)), true);
				eb.addField("Farmer", String.valueOf(cupidSkyblock.apiExperiences.getFarmer(selector)), true);
				eb.setAuthor("BOT MADE BY @PONDHALF");
				eb.setColor(new Color(50, 97, 168));
				
				channel.sendTyping().queue();
				channel.sendMessage(eb.build()).queue();
			} else {
				channel.sendTyping().queue();
				channel.sendMessage(":x: ไม่พบผู้เล่นดังกล่าว").queue();
			}
		} else {
			channel.sendTyping().queue();
			channel.sendMessage(":x: cupid!/info <ชื่อผู้เล่น>").queue();
		}
		
	}

}
