package com.throwner.engine.core;

import java.util.Random;

import com.throwner.engine.character.CharacterFactory;
import com.throwner.engine.character.CharacterType;
import com.throwner.engine.character.Charater;
import com.throwner.engine.character.dwarf.DwarfFactory;
import com.throwner.engine.character.paladin.PaladinFactory;
import com.throwner.engine.character.rogue.RogueFactory;
import com.throwner.engine.world.Tile;
import com.throwner.engine.world.World;
import com.throwner.framework.ContextsMap;
import com.throwner.ui.core.UIManager;
import com.throwner.ui.items.CharactersTexts;
import com.throwner.ui.menus.AllMenus;

public class GameEngine {
	
	private UIManager uiManager = ContextsMap.getBean(UIManager.class);
	private Charater player;
	private World world;

	public static void startNewGame() {
		GameEngine gameEngine = new GameEngine();
		gameEngine.newGame();
	};
	
	public void newGame(){
		//choose class OK
		//choose name OK
		//choose skill points NOK
		//create caracter OK
		 this.setPlayer(newCharacter());
		
		//create world
		this.setWorld(newWorld(20, 20));

		//choose place for caracter in world
		choosePlacePlayerInWorld();
		
		uiManager.printWorld(this.world);
		
		//updateworld
		updateWorld(world);
		
		//place monsters in world
		
		//create Game class
	}
	
	public void runGame(/*Game class*/){
		//RUN THE GAME
	}
	
	public void loadGame(/*Game class*/){
		
	}
	
	private Charater newCharacter(){
		
		Charater player = null;
		CharacterFactory factory;
		CharactersTexts choice  = uiManager.showCharacterSelectionMenu();
		
		switch(choice){
		case PALADIN:
			factory = new PaladinFactory();
		    player = factory.createCharacter(CharacterType.PALADIN);
			break;
		case DWARF:
			factory = new DwarfFactory();
		    player = factory.createCharacter(CharacterType.DWARF);
			break;
		case ROGUE:
			factory = new RogueFactory();
		    player = factory.createCharacter(CharacterType.ROGUE);
			break;
		}
		
		//ADD POINTS TO PLAYER TO CUSTOMIZE THE CLASS (3 MAX AT START)
		
		player.setName(uiManager.showNameSelectionMenu());
		
		return player;
	}
	
	private World newWorld(int width, int height){
		World world = new World(width, height);
		return world;	
	}
	
	private void choosePlacePlayerInWorld(){
		player.setPlayerXpos(new Random().nextInt(world.getHeight()-1));
		player.setPlayerYpos(new Random().nextInt(world.getWidth()-1));
		
		Tile playerTile = world.getTile(player.getPlayerXpos(), player.getPlayerYpos());
		
		playerTile.setDiscovered(true);
		playerTile.setOccupiedbyPlayer(true);
		playerTile.updateTile();
		
	}

	private void updateWorld(World world) {
		
		
	}

	public Charater getPlayer() {
		return player;
	}

	public void setPlayer(Charater player) {
		this.player = player;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
}
