package com.throwner.ui.menus;

import com.throwner.ui.items.MainMenuTexts;

public class MainMenu extends GenericMenu<Object> {
	
	public void showMainMenu(){
		MainMenuTexts[] values = MainMenuTexts.values();
		printAllOptions(convertToArrayList(values));
		
		try {
			 getResponseFromInput(MainMenuTexts.values());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
