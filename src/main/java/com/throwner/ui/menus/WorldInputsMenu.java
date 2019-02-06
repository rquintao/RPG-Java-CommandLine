package com.throwner.ui.menus;

import com.throwner.exceptions.InputGenericException;
import com.throwner.exceptions.InputNotInOptionsException;
import com.throwner.ui.items.WorldInputsTexts;

public class WorldInputsMenu extends GenericMenu<Object> {
	
	public WorldInputsTexts showWorldInputsMenu() throws InputNotInOptionsException{
	
		WorldInputsTexts[] values = WorldInputsTexts.values();
		
		showMessage("What action do you want to take?");
		printAllOptions(convertToArrayList(values));
		
		try {
			char choice = getCharResponseFromInput(WorldInputsTexts.values());
			
			if(choice == WorldInputsTexts.UP.toString().charAt(0)){
				return WorldInputsTexts.UP;
			} else if(choice == WorldInputsTexts.DOWN.toString().charAt(0)){
				return WorldInputsTexts.DOWN;
			} else if(choice == WorldInputsTexts.LEFT.toString().charAt(0)){
				return WorldInputsTexts.LEFT;
			}else if(choice == WorldInputsTexts.RIGHT.toString().charAt(0)){
				return WorldInputsTexts.RIGHT;
			}else if(choice == WorldInputsTexts.OPTIONS.toString().charAt(0)){
					return WorldInputsTexts.OPTIONS;				
			}else if(choice == WorldInputsTexts.FIGHT.toString().charAt(0)){
				return WorldInputsTexts.FIGHT;				
			}else if(choice == WorldInputsTexts.RUN.toString().charAt(0)){
				return WorldInputsTexts.RUN;				
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
