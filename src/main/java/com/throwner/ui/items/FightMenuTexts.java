package com.throwner.ui.items;

public enum FightMenuTexts {
	FIGHT("Attack the monster"),
	BLOCK("Block monster's attack"),
	RUN("Try to run");
	
	private final String desc;
	
	FightMenuTexts(String desc){
		this.desc = desc;
	}

    @Override
    public String toString() {
          return desc;
    }
}
