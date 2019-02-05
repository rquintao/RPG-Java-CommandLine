package com.throwner.ui.menus;

import com.throwner.engine.core.GameEngine;
import com.throwner.engine.core.ThrownerLauncher;
import com.throwner.exceptions.InputGenericException;
import com.throwner.ui.items.MainMenuTexts;

public class MainMenu extends GenericMenu<Object> {
	
	public void showMainMenu(){
		MainMenuTexts[] values = MainMenuTexts.values();
		printAllOptions(convertToArrayList(values));
		
		try {
			String choice = getResponseFromInput(MainMenuTexts.values());
			 
			if(choice.equals(MainMenuTexts.START.toString())){
				GameEngine.startNewGame();
				showMessage("Starting a new Game");
			} else if(choice.equals(MainMenuTexts.LOAD.toString())){
				GameEngine.loadPreviousGame();
				showMessage("Loading previous game");
			} else if(choice.equals(MainMenuTexts.ABOUT.toString())){
				showMessage("Made by Rafael Quintão");
			} else if(choice.equals(MainMenuTexts.EXIT.toString())){
				showMessage("Shutting engines down. See ya!");
				ThrownerLauncher.shutdown();
			}
			 
			 
		} catch (InputGenericException e) {
			e.printStackTrace();
		}
		
		
		
	}
	

}
