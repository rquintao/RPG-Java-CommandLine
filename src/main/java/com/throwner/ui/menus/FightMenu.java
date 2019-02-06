package com.throwner.ui.menus;

import com.throwner.exceptions.InputGenericException;
import com.throwner.exceptions.InputNotInOptionsException;
import com.throwner.ui.items.FightMenuTexts;

public class FightMenu extends GenericMenu<Object> {
	
	public FightMenuTexts showFightMenu() throws InputNotInOptionsException{
		
		FightMenuTexts[] values = FightMenuTexts.values();
		
		showMessage("What action do you want to take?");
		printAllOptions(convertToArrayList(values));
		
		try {
			char choice = getCharResponseFromInput(FightMenuTexts.values());
			
			if(choice == FightMenuTexts.FIGHT.toString().charAt(0)){
				return FightMenuTexts.FIGHT;
			} else if(choice == FightMenuTexts.BLOCK.toString().charAt(0)){
				return FightMenuTexts.BLOCK;
			} else if(choice == FightMenuTexts.RUN.toString().charAt(0)){
				return FightMenuTexts.RUN;
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
