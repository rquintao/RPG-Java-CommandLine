package com.throwner.ui.menus;

import com.throwner.engine.core.GameEngine;
import com.throwner.engine.core.ThrownerLauncher;
import com.throwner.ui.items.MainMenuTexts;

public class MainMenu extends GenericMenu<Object> {
	
	public void showMainMenu(){
		MainMenuTexts[] values = MainMenuTexts.values();
		
		showMessage("//////////////////////////////////////////////////////// \r/////////===============THROWNER===============///////// \r////////////////////////////////////////////////////////");
		
		printAllOptions(convertToArrayList(values));
		
		try {
			String choice = getResponseFromInput(MainMenuTexts.values());
			 
			if(choice.equals(MainMenuTexts.START.toString())){
				showMessage("Starting a new Game");
				GameEngine.startNewGame();
			} else if(choice.equals(MainMenuTexts.LOAD.toString())){
				showMessage("Loading previous game");
				GameEngine.loadPreviousGame();
			} else if(choice.equals(MainMenuTexts.ABOUT.toString())){
				showMessage("Made by Rafael Quintão");
			} else if(choice.equals(MainMenuTexts.EXIT.toString())){
				showMessage("Shutting engines down. See ya!");
				ThrownerLauncher.shutdown();
			}
			 
			 
		} catch (Exception e) {
			// RESUME
			showMessage("Please provide a valid input!");
			showMainMenu();
			//LOG
		}	
		
	}
	

}
