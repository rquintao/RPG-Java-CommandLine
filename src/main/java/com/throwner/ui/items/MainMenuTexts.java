package com.throwner.ui.items;

public enum MainMenuTexts {
	START("1 - Start a new game"),
	LOAD("2 - Load the saved game"),
	ABOUT("3 - About the creator"),
	EXIT("4 - Quit");
	
	private final String desc;
	
    MainMenuTexts(String desc){
		this.desc = desc;
	}

    @Override
    public String toString() {
          return desc;
    }

}
