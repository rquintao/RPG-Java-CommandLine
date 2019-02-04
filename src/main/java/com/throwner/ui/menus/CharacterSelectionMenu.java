package com.throwner.ui.menus;

import com.throwner.exceptions.InputGenericException;
import com.throwner.ui.items.CharactersTexts;

public class CharacterSelectionMenu extends GenericMenu<Object> {
	
	public CharactersTexts showCharacterSeletionMenu(){
		CharactersTexts[] values = CharactersTexts.values();
		
		printAllOptions(convertToArrayList(values));
		
		try {
			String choice = getResponseFromInput(CharactersTexts.values());
			 
			if(choice.equals(CharactersTexts.PALADIN.toString())){
				showMessage("Starting a new Game with paladin");
				return CharactersTexts.PALADIN;
			} else if(choice.equals(CharactersTexts.DWARF.toString())){
				showMessage("Starting a new Game with dwarf");
				return CharactersTexts.DWARF;
			} else if(choice.equals(CharactersTexts.ROGUE.toString())){
				showMessage("Starting a new Game with rogue");
				return CharactersTexts.ROGUE;
			}
			 
		} catch (InputGenericException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
