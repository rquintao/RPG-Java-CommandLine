package com.throwner.ui.items;

public enum WorldInputsTexts {
	UP("W - Move up"),
	DOWN("S - Move down"),
	LEFT("A - Move left");
	
	private final String desc;
	
	
	WorldInputsTexts(String desc){
		this.desc = desc;
	}

    @Override
    public String toString() {
          return desc;
    }

}
