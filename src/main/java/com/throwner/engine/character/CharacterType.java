package com.throwner.engine.character;

public enum CharacterType {
	DWARF("dwarf", 6, 5, 1 ), 
	ROGUE("rogue", 3, 3, 6), 
	PALADIN("paladin", 5, 4, 3),
	MONSTER_1("monster", 2, 2, 2),
	MONSTER_2("monster", 2, 7, 2),
	MONSTER_3("monster", 6, 10, 6);
	
	private final int strenght;
	private final int health;
	private final int agility;
	
	private String desc;
	
	CharacterType(String desc, int strenght,  int health,  int agility){
		this.desc = desc;
		this.strenght = strenght;
		this.health = health;
		this.agility = agility;
	}
	
	 @Override
	  public String toString() {
	    return desc;
	  }

	public int getStrenght() {
		return strenght;
	}

	public int getHealth() {
		return health;
	}

	public int getAgility() {
		return agility;
	}
}
