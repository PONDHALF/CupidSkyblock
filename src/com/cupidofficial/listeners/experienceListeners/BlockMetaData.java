package com.cupidofficial.listeners.experienceListeners;

import org.bukkit.Material;
import org.bukkit.World;

public class BlockMetaData {
	
	World world;
	
	int x;
	int y;
	int z;
	Material material;
	
	public BlockMetaData(World world, double x, double y, double z, Material material) {
		this.world = world;
		this.x = (int) x;
		this.y = (int) y;
		this.z = (int) z;
		this.material = material;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	
	
}
