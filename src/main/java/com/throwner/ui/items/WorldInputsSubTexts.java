package com.throwner.ui.items;

public enum WorldInputsSubTexts {
	BACK("B - Resume Game"),
	SAVE("S - Save game"),
	QUIT("Q - Quit Throwner");
	
	private final String desc;
	
	
	WorldInputsSubTexts(String desc){
		this.desc = desc;
	}

    @Override
    public String toString() {
          return desc;
    }
}
