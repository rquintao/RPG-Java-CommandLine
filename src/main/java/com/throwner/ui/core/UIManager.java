package com.throwner.ui.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.throwner.engine.character.MonsterCharacter;
import com.throwner.engine.character.playerfactory.PlayerCharacter;
import com.throwner.engine.world.World;
import com.throwner.exceptions.InputNotInOptionsException;
import com.throwner.framework.ContextsMap;
import com.throwner.ui.items.CharactersTexts;
import com.throwner.ui.items.FightMenuTexts;
import com.throwner.ui.items.WorldInputsSubTexts;
import com.throwner.ui.items.WorldInputsTexts;
import com.throwner.ui.menus.AllMenus;
import com.throwner.utils.output.WorldPrinter;

public class UIManager {
	AllMenus allMenus = null;
	WorldPrinter worldPrinter = null;
	private static final Logger LOG = LogManager.getLogger(UIManager.class);
	
	public UIManager(){
		allMenus = ContextsMap.getBean(AllMenus.class);
		worldPrinter = ContextsMap.getBean(WorldPrinter.class);
	}
	
	public void showMainMenu(){
		LOG.debug("Getting main menu and showing it..");
		allMenus.getMainMenu().showMainMenu();
	}
	
	public CharactersTexts showCharacterSelectionMenu(){
		return allMenus.getCharacterSelectionMenu().showCharacterSeletionMenu();
	}
	
	public String showNameSelectionMenu(){
		return allMenus.getCharacterSelectionMenu().showInputNameQuery();
	}
	
	public void printWorld(World worldMap){
		worldPrinter.printWorld(worldMap);
	}

	public WorldInputsTexts showWorldInputs() throws InputNotInOptionsException {
		return allMenus.getWorldInputsMenu().showWorldInputsMenu();
		
	}
	
	public WorldInputsSubTexts showWorldSubInputs() throws InputNotInOptionsException {
		return allMenus.getWorldInputsSubMenu().showWorldInputsSubMenu();
		
	}
	
	public void showMessage(String msg){
		allMenus.getGenericMenu().showMessage(msg);
	}

	public FightMenuTexts showFightMenu() throws InputNotInOptionsException {
		return allMenus.getFightMenu().showFightMenu();
	}

	public void showFightStatus(MonsterCharacter monster, PlayerCharacter player) {
		worldPrinter.printFight(monster, player);
		
	}

	

	
}
