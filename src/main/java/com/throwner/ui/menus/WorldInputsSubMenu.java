package com.throwner.ui.menus;

import com.throwner.exceptions.InputGenericException;
import com.throwner.exceptions.InputNotInOptionsException;
import com.throwner.ui.items.WorldInputsSubTexts;

public class WorldInputsSubMenu extends GenericMenu<Object> {
	
	public WorldInputsSubTexts showWorldInputsSubMenu() throws InputNotInOptionsException{
		
		WorldInputsSubTexts[] values = WorldInputsSubTexts.values();
		
		showMessage("What action do you want to take?");
		printAllOptions(convertToArrayList(values));
		
		try {
			char choice = getCharResponseFromInput(WorldInputsSubTexts.values());
			
			if(choice == WorldInputsSubTexts.SAVE.toString().charAt(0)){
				return WorldInputsSubTexts.SAVE;
			} else if(choice == WorldInputsSubTexts.QUIT.toString().charAt(0)){
				return WorldInputsSubTexts.QUIT;
			} else if(choice == WorldInputsSubTexts.BACK.toString().charAt(0)){
				return WorldInputsSubTexts.BACK;
			}
		} catch (InputGenericException e) {
			e.printStackTrace();
		} catch (InputNotInOptionsException e) {
			showMessage("Please provide a valid input!");
			throw new InputNotInOptionsException(null);
		}
		return null;
	}
}
