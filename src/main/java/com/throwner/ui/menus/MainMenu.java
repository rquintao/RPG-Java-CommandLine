package com.throwner.ui.menus;

import com.throwner.ui.items.MainMenuTexts;

public class MainMenu extends GenericMenu<Object> {
	
	public void showMainMenu(){
		MainMenuTexts[] values = MainMenuTexts.values();
		printAllOptions(convertToArrayList(values));
	}
}
