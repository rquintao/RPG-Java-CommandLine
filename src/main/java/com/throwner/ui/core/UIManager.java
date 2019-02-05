package com.throwner.ui.core;

import com.throwner.engine.world.World;
import com.throwner.framework.ContextsMap;
import com.throwner.ui.items.CharactersTexts;
import com.throwner.ui.menus.AllMenus;
import com.throwner.ui.menus.WorldInputsMenu;
import com.throwner.utils.output.WorldPrinter;

public class UIManager {
	AllMenus allMenus = null;
	WorldPrinter worldPrinter = null;
	
	public UIManager(){
		allMenus = ContextsMap.getBean(AllMenus.class);
		worldPrinter = ContextsMap.getBean(WorldPrinter.class);
	}
	
	public void showMainMenu(){
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

	public WorldInputsMenu showWorldInputs() {
		return allMenus.getWorldInputsMenu();
		
	}

	

	
}
