package com.throwner.framework;

import java.util.HashMap;
import java.util.Map;

import com.throwner.engine.core.ThrownerLauncher;
import com.throwner.engine.menu.MenuManager;
import com.throwner.ui.core.UIManager;

public class ContextsMap {
	/*USED TO CREATE BEANS TO NEVER HAVE TO INSTANTIATE CLASSES*/
	
	@SuppressWarnings("rawtypes")
	private static final Map<Class, Object> context = new HashMap<Class, Object>();
	
	public ContextsMap(){
	    loadCore();
	    loadUI(); 
	}
	
	private void loadCore(){
		ThrownerLauncher thrownerLauncher = new ThrownerLauncher();
		context.put(ThrownerLauncher.class, thrownerLauncher);
	};
	
	private void loadUI(){
		UIManager uiManager = new UIManager();
		MenuManager menuManager = new MenuManager();
		
		context.put(UIManager.class, uiManager);
		context.put(MenuManager.class, menuManager);
		
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz){
		T bean = null;
		
		try{
			bean = (T) context.get(clazz);
		}
		catch(Exception e){
			e=null;
		}
		
		if (bean == null){
			
		}
		
		return bean;
		
	}
}
