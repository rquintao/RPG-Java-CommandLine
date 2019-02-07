package com.throwner.ui.menus;

import com.throwner.exceptions.InputGenericException;
import com.throwner.exceptions.InputNotInOptionsException;
import com.throwner.ui.items.CharactersTexts;

public class CharacterSelectionMenu extends GenericMenu<Object> {
	
	public CharactersTexts showCharacterSeletionMenu(){
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
			 
		} catch (InputNotInOptionsException e) {
			e.printStackTrace();
		} catch (InputGenericException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String showInputNameQuery(){
		
		sw.write("What is the name of your caracter?");
		
		try {
			String choice = getStringResponseFromInput();
			return choice;
		} catch (InputGenericException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
