package com.throwner.engine.character.stats;

import java.io.Serializable;

public class CharacterStats extends GenericStats implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7746966686167988100L;

	public CharacterStats(int health, int strength, int agility) {
		super(health, strength, agility);
	}
	
	private int xp = 0;
	private int level = 1;
	
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
}
