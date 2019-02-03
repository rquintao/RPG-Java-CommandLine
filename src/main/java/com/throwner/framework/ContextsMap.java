package com.throwner.framework;

import java.util.HashMap;
import java.util.Map;

import com.throwner.engine.core.ThrownerLauncher;
import com.throwner.ui.core.UIManager;
import com.throwner.ui.menus.AllMenus;
import com.throwner.ui.menus.GenericMenu;
import com.throwner.ui.menus.MainMenu;
import com.throwner.utils.output.StringWriter;

public class ContextsMap {
	/*USED TO CREATE BEANS TO NEVER HAVE TO INSTANTIATE CLASSES*/
	
	@SuppressWarnings("rawtypes")
	private static final Map<Class, Object> context = new HashMap<Class, Object>();
	
	static{
		loadUtils();
		loadCore(); 
		loadUI();
	}
	
	private ContextsMap(){
	}
	
	private static void loadUtils(){
		StringWriter stringWriter = new StringWriter();
		context.put(StringWriter.class, stringWriter);
	}
	
	private static void loadCore(){
		ThrownerLauncher thrownerLauncher = new ThrownerLauncher();
		context.put(ThrownerLauncher.class, thrownerLauncher);
	};
	
	private static void loadUI(){
		GenericMenu<Object> menuManager = new GenericMenu<Object>();
		context.put(GenericMenu.class, menuManager);
		
		MainMenu mainMenu = new MainMenu();
		context.put(MainMenu.class, mainMenu);
		
		AllMenus allMenus = new AllMenus();
		context.put(AllMenus.class, allMenus);
		
		UIManager uiManager = new UIManager();
		context.put(UIManager.class, uiManager);
	
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
