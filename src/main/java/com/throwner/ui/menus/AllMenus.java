package com.throwner.ui.menus;

import com.throwner.framework.ContextsMap;

public class AllMenus {
	private MainMenu mainMenu = ContextsMap.getBean(MainMenu.class);
	private CharacterSelectionMenu characterSelectionMenu = ContextsMap.getBean(CharacterSelectionMenu.class);
	private WorldInputsMenu worldInputsMenu  = ContextsMap.getBean(WorldInputsMenu.class); 
	
	public MainMenu getMainMenu() {
		return mainMenu;
	}

	public CharacterSelectionMenu getCharacterSelectionMenu() {
		return characterSelectionMenu;
	}

	public WorldInputsMenu getWorldInputsMenu() {
		return worldInputsMenu;
	}
	
}
