package com.throwner.engine.core;

import com.throwner.framework.ContextsMap;
import com.throwner.ui.core.UIManager;

public class ThrownerLauncher {
	
	private static UIManager uiManager = ContextsMap.getBean(UIManager.class);
	public static boolean shutdown = false;
	
	public static void startGame(){
		while(!shutdown){
			uiManager.showMainMenu();
		}
	}
}
