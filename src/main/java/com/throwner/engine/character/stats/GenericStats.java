package com.throwner.engine.character.stats;

public class GenericStats {
	private int health;
	private int strenght;
	private int agility;
	
	public GenericStats(int health, int strength, int agility){
		setHealth(health);
		setStrenght(strength);
		setAgility(agility);
	}
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getStrenght() {
		return strenght;
	}
	public void setStrenght(int strenght) {
		this.strenght = strenght;
	}
	public int getAgility() {
		return agility;
	}
	public void setAgility(int agility) {
		this.agility = agility;
	}
}
