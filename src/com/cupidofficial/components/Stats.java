package com.cupidofficial.components;

public class Stats {
	
	private int points;
	private int vitality;
	private int agility;
	private int intelligence;
	private int luck;
	private int dexterity;
	
	
	public Stats(int points, int vitality, int agility, int intelligence, int dexterity, int luck) {
		this.points = points;
		this.vitality = vitality;
		this.agility = agility;
		this.intelligence = intelligence;
		this.luck = luck;
		this.dexterity = dexterity;
	}
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getVitality() {
		return vitality;
	}
	public void setVitality(int vitality) {
		this.vitality = vitality;
	}
	public int getAgility() {
		return agility;
	}
	public void setAgility(int agility) {
		this.agility = agility;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getLuck() {
		return luck;
	}
	public void setLuck(int luck) {
		this.luck = luck;
	}	
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	
}
