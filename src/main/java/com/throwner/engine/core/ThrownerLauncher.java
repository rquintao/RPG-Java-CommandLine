package com.throwner.engine.core;

import com.throwner.framework.ContextsMap;
import com.throwner.ui.core.UIManager;

public class ThrownerLauncher {
	
	private ThrownerLauncher tl = ContextsMap.getBean(ThrownerLauncher.class);
	
	private static UIManager uiManager = ContextsMap.getBean(UIManager.class);
	
	public static void startGame(){
		uiManager.showMainMenu();
	}
}
