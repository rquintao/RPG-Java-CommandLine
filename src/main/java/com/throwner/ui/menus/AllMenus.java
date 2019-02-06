package com.throwner.ui.menus;

import com.throwner.framework.ContextsMap;

public class AllMenus {
	private MainMenu mainMenu = ContextsMap.getBean(MainMenu.class);
	private CharacterSelectionMenu characterSelectionMenu = ContextsMap.getBean(CharacterSelectionMenu.class);
	private WorldInputsMenu worldInputsMenu = ContextsMap.getBean(WorldInputsMenu.class); 
	private WorldInputsSubMenu worldInputsSubMenu = ContextsMap.getBean(WorldInputsSubMenu.class); 
	@SuppressWarnings("unchecked")
	private GenericMenu<Object> genericMenu = ContextsMap.getBean(GenericMenu.class); 
	
	public MainMenu getMainMenu() {
		return mainMenu;
	}

	public CharacterSelectionMenu getCharacterSelectionMenu() {
		return characterSelectionMenu;
	}

	public WorldInputsMenu getWorldInputsMenu() {
		return worldInputsMenu;
	}

	public GenericMenu<Object> getGenericMenu() {
		return genericMenu;
	}

	public WorldInputsSubMenu getWorldInputsSubMenu() {
		return worldInputsSubMenu;
	}
	
}
