package com.throwner.engine.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.throwner.framework.ContextsMap;
import com.throwner.ui.core.UIManager;

public class ThrownerLauncher {
	
	private static final Logger LOG = LogManager.getLogger(ThrownerLauncher.class);
	private static UIManager uiManager = ContextsMap.getBean(UIManager.class);
	
	public static void startGame(){
		uiManager.showMainMenu();
	}
	
	public static void shutdown(){
		LOG.traceExit();
		System.exit(0);
	}
}
