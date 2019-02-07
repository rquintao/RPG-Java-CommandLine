package com.throwner.utils.output;

import java.io.PrintStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.throwner.engine.character.MonsterCharacter;
import com.throwner.engine.character.playerfactory.PlayerCharacter;
import com.throwner.engine.world.World;

public class WorldPrinter {
	
	private final PrintStream out;
	private static final Logger LOG = LogManager.getLogger(WorldPrinter.class);
	 
	 public WorldPrinter (PrintStream out){
		 this.out = out;
	 }

	public void printWorld(World worldMap) {
		LOG.traceEntry();
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

	public void printFight(MonsterCharacter monster, PlayerCharacter player) {
		out.println("LVL:		Monster:-  |  " + player.getName() + ": " + player.getCharStats().getLevel());
		out.println("XP:		Monster:-  |  " + player.getName() + ": " + player.getCharStats().getXp());
		out.println("Strength:	Monster:"+monster.getCharStats().getStrenght()+"  |  " + player.getName() + ": " + player.getCharStats().getStrenght());
		out.println("Agility:	Monster:"+monster.getCharStats().getAgility()+"  |  " + player.getName() + ": " + player.getCharStats().getAgility());
		out.println("Health:		Monster:"+monster.getCharStats().getHealth()+"  |  " + player.getName() + ": " + player.getCharStats().getHealth());
	}
	
}
