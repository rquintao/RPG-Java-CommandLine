package com.throwner.ui.core;

import com.throwner.engine.menu.MenuManager;
import com.throwner.framework.ContextsMap;

public class UIManager {
	
	private MenuManager menuManager = ContextsMap.getBean(MenuManager.class);

	public void showMainMenu(){
		menuManager.showMainMenu();
	}

	

	
}
