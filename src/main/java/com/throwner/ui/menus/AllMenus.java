package com.throwner.ui.menus;

import com.throwner.framework.ContextsMap;

public class AllMenus {
	private MainMenu mainMenu = ContextsMap.getBean(MainMenu.class);

	public MainMenu getMainMenu() {
		return mainMenu;
	}

	
}
