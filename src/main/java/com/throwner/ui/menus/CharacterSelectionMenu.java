package com.throwner.ui.menus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.throwner.exceptions.InputGenericException;
import com.throwner.exceptions.InputNotInOptionsException;
import com.throwner.ui.items.CharactersTexts;
import com.throwner.utils.input.InputUtils;

public class CharacterSelectionMenu extends GenericMenu<Object> {
	private static final Logger LOG = LogManager.getLogger(InputUtils.class);
	
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
			LOG.error("Threw a Exception in CharacterSelectionMenu::showCharacterSeletionMenu, full stack trace follows:", e);
		} catch (InputGenericException e) {
			LOG.error("Threw a Exception in CharacterSelectionMenu::showCharacterSeletionMenu, full stack trace follows:", e);
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
