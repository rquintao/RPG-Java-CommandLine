package com.throwner.framework;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import com.throwner.engine.core.ThrownerLauncher;
import com.throwner.ui.core.UIManager;
import com.throwner.ui.menus.AllMenus;
import com.throwner.ui.menus.CharacterSelectionMenu;
import com.throwner.ui.menus.GenericMenu;
import com.throwner.ui.menus.MainMenu;
import com.throwner.ui.menus.WorldInputsMenu;
import com.throwner.ui.menus.WorldInputsSubMenu;
import com.throwner.utils.input.InputUtils;
import com.throwner.utils.output.OutputUtils;
import com.throwner.utils.output.WorldPrinter;

public class ContextsMap {
	/*USED TO CREATE BEANS TO NEVER HAVE TO INSTANTIATE CLASSES*/
	
	@SuppressWarnings("rawtypes")
	private static final Map<Class, Object> context = new HashMap<Class, Object>();
	
	static{
		loadUtils(); 
		loadUI();
		loadCore();
	}
	
	private ContextsMap(){
	}
	
	private static void loadUtils(){
		OutputUtils stringWriter = new OutputUtils(System.out);
		context.put(OutputUtils.class, stringWriter);
		
		WorldPrinter worldPrinter = new WorldPrinter(System.out);
		context.put(WorldPrinter.class, worldPrinter);
		
		InputUtils inputReader = new InputUtils(new Scanner(System.in));
		context.put(InputUtils.class, inputReader);
		
		Random RANDOM = new Random();
		context.put(Random.class, RANDOM);
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
		
		CharacterSelectionMenu characterSelectionMenu = new CharacterSelectionMenu();
		context.put(CharacterSelectionMenu.class, characterSelectionMenu);
		
		WorldInputsMenu worldInputsMenu = new WorldInputsMenu();
		context.put(WorldInputsMenu.class, worldInputsMenu);
		
		WorldInputsSubMenu worldInputsSubMenu = new WorldInputsSubMenu();
		context.put(WorldInputsSubMenu.class, worldInputsSubMenu);
		
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
