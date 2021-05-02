package com.cupidofficial.components;

public class Experience {
	
	private double woodcutting;
	private double miner;
	private double farmer;
	
	public Experience(double woodcutting, double miner, double farmer) {
		super();
		this.woodcutting = woodcutting;
		this.miner = miner;
		this.farmer = farmer;
	}


	public double getWoodcutting() {
		return woodcutting;
	}


	public void setWoodcutting(double woodcutting) {
		this.woodcutting = woodcutting;
	}


	public double getMiner() {
		return miner;
	}


	public void setMiner(double miner) {
		this.miner = miner;
	}


	public double getFarmer() {
		return farmer;
	}


	public void setFarmer(double farmer) {
		this.farmer = farmer;
	}
	
	
	
}
