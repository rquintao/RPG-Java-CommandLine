package com.throwner.ui.items;

public enum CharactersTexts {
	PALADIN("     1 - Paladin has 5 Strenght, 4 Health and 3 Agility."),
	DWARF("     2 - Dwarf has 6 Strenght, 5 Health and 1 Agility."),
	ROGUE("     3 - Rogue has 3 Strenght, 3 Health and 6 Agility");
	
	private final String desc;
	
	
	CharactersTexts(String desc){
		this.desc = desc;
	}

    @Override
    public String toString() {
          return desc;
    }

    
}
