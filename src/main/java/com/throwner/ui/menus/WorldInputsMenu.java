package com.throwner.ui.menus;

import com.throwner.exceptions.InputGenericException;
import com.throwner.ui.items.CharactersTexts;

public class WorldInputsMenu extends GenericMenu<Object> {
	
	public CharactersTexts showWorldInputsMenu(){
	
		CharactersTexts[] values = CharactersTexts.values();
		
		sw.write("Choose your character's class:");
		printAllOptions(convertToArrayList(values));
		
		try {
			String choice = getResponseFromInput(CharactersTexts.values());
			 
			if(choice.equals(CharactersTexts.PALADIN.toString())){
				showMessage("Starting a new Game with paladin.");
				return CharactersTexts.PALADIN;
			} else if(choice.equals(CharactersTexts.DWARF.toString())){
				showMessage("Starting a new Game with dwarf.");
				return CharactersTexts.DWARF;
			} else if(choice.equals(CharactersTexts.ROGUE.toString())){
				showMessage("Starting a new Game with rogue.");
				return CharactersTexts.ROGUE;
			}
			 
		} catch (InputGenericException e) {
			e.printStackTrace();
		}
		return null;
	}

}
