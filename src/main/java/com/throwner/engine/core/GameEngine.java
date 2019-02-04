package com.throwner.engine.core;

import com.throwner.engine.character.CharacterFactory;
import com.throwner.framework.ContextsMap;
import com.throwner.ui.items.CharactersTexts;
import com.throwner.ui.menus.AllMenus;
import com.throwner.utils.output.StringWriter;

public class GameEngine {
	
	private AllMenus allMenus = ContextsMap.getBean(AllMenus.class);
	private StringWriter sw = ContextsMap.getBean(StringWriter.class);

	public static void startNewGame() {
		GameEngine gameEngine = new GameEngine();
		gameEngine.newGame();
	};
	
	public void newGame(){
		//choose class
		sw.write("Choose your character's class:");
		CharactersTexts choice  = allMenus.getCharacterSelectionMenu().showCharacterSeletionMenu();
		
		CharacterFactory factory;
		
		//choose name
		//choose skill points
		
		//create caracter
		
		//create world
		
		//place caracter in world position
		
		//create Game class
	}
	
	public void runGame(/*Game class*/){
		//RUN THE GAME
	}
	
	public void loadGame(/*Game class*/){
		
	}
}
