package com.throwner.ui.items;

public enum FightMenuTexts {
	FIGHT("A - Attack the monster"),
	BLOCK("B - Block monster's attack"),
	RUN("R - Try to run");
	
	private final String desc;
	
	FightMenuTexts(String desc){
		this.desc = desc;
	}

    @Override
    public String toString() {
          return desc;
    }
}
