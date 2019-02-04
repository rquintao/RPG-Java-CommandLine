package com.throwner.engine.character;

public enum CharacterType {
	DWARF("dwarf"), 
	ROGUE("elf"), 
	PALADIN("paladin");
	
	private String desc;
	
	CharacterType(String desc){
		this.desc = desc;
	}
	
	 @Override
	  public String toString() {
	    return desc;
	  }
}
