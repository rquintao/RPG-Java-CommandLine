package com.throwner.ui.items;

public enum MainMenuTexts {
	START("Start a new game"),
	LOAD("Load the saved game"),
	ABOUT("About the creator"),
	EXIT("Quit");
	
	private final String desc;
	
    MainMenuTexts(String desc){
		this.desc = desc;
	}

    @Override
    public String toString() {
          return desc;
    }

}
