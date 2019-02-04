package com.throwner.ui.items;

public enum CharactersTexts {
	PALADIN("     Paladin has 5 Strenght, 4 Health and 3 Agility.", 5, 4, 3),
	DWARF("     Dwarf has 6 Strenght, 5 Health and 1 Agility.", 6, 5, 1),
	ROGUE("     Rogue has 3 Strenght, 3 Health and 6 Agility", 3, 3, 6);
	
	private final String desc;
	private final int strenght;
	private final int health;
	private final int agility;
	
	CharactersTexts(String desc, int strenght,  int health,  int agility){
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

	public int getAgility() {
		return agility;
	}

	public int getHealth() {
		return health;
	}
    
    
}
