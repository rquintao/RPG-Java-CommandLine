package com.throwner.ui.core;

import com.throwner.framework.ContextsMap;
import com.throwner.ui.menus.AllMenus;

public class UIManager {
	AllMenus allMenus = null;
	
	public UIManager(){
		allMenus = ContextsMap.getBean(AllMenus.class);
	}
	
	public void showMainMenu(){
		allMenus.getMainMenu().showMainMenu();
	}

	

	
}
