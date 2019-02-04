package com.throwner.utils.output;

import java.io.PrintStream;

import com.throwner.engine.world.World;

public class WorldPrinter {
	
	private final PrintStream out;
	 
	 public WorldPrinter (PrintStream out){
		 this.out = out;
	 }

	public void printWorld(World worldMap) {
		
		int height = worldMap.getHeight();
		int width = worldMap.getWidth();
		
		out.println("Current Throwner Map");
		
		for (int i = 0; i<height; i++){
			String toPrint= " ";
			for (int j = 0; j<width; j++){
				if (j == height - 1){
					toPrint = toPrint + worldMap.getTile(i, j).getSpriteValue() + " ";
				} else {
					toPrint = toPrint + worldMap.getTile(i, j).getSpriteValue() + " ";
				}
			}
			out.println(toPrint);
		}
		
	}
	
}
