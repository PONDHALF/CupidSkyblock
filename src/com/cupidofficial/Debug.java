package com.cupidofficial;

import java.io.File;

public class Debug {
	
	public static String ID = "DEBUG::CASE\n";
	
	public static void main(String[] args) { 
		System.out.println(ID);

		File file = new File("D:" + File.separatorChar + "mccupid" + File.separatorChar + "plugins" + File.separatorChar + "CupidSkyblock" + File.separatorChar + "storage");
		File[] files = file.listFiles();

		for (File list : files) {
			if (list.isFile()) {
				System.out.println(list.getName());
			}
		}

		System.out.println("\nEnd");
	}
	
}
