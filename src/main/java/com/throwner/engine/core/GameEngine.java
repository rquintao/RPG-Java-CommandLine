package com.throwner.engine.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.throwner.engine.character.CharacterFactory;
import com.throwner.engine.character.CharacterType;
import com.throwner.engine.character.Charater;
import com.throwner.engine.character.MonsterCharacter;
import com.throwner.engine.character.monsterfactory.MonsterFactory;
import com.throwner.engine.character.playerfactory.PlayerCharacter;
import com.throwner.engine.character.playerfactory.PlayerFactory;
import com.throwner.engine.world.Tile;
import com.throwner.engine.world.World;
import com.throwner.framework.ContextsMap;
import com.throwner.ui.core.UIManager;
import com.throwner.ui.items.CharactersTexts;
import com.throwner.utils.input.InputUtils;
import com.throwner.utils.output.OutputUtils;

public class GameEngine {
	
	private UIManager uiManager = ContextsMap.getBean(UIManager.class);
	private PlayerCharacter player;
	private World world;
	private List<MonsterCharacter> monsters;
	private CharacterFactory charFactory;
	private Random RANDOM = ContextsMap.getBean(Random.class);
	private OutputUtils sw = ContextsMap.getBean(OutputUtils.class);
	private InputUtils in = ContextsMap.getBean(InputUtils.class);
	
	//MAKE THIS EDITABLE WITH DIFICULTY MAYBE?
	private double monsterOcurrence = 0.15;

	public static void startNewGame() {
		GameEngine gameEngine = new GameEngine();
		gameEngine.newGame();
	};
	
	public static void loadPreviousGame() {
		GameEngine gameEngine = new GameEngine();
		gameEngine.loadGame();
	}
	
	public void newGame(){
		//choose class OK
		//choose name OK
		//choose skill points NOK
		//create caracter OK
		 this.setPlayer((PlayerCharacter) newCharacter());
		
		//create world OK
		this.setWorld(newWorld(20, 20));

		//choose place for caracter in world OK
		choosePlacePlayerInWorld();
		
		//place monsters in world
		//create monsters
		this.setMonsters(newMonsters());		
		
		//uiManager.printWorld(this.world);
		
		//create Game class
		Game game = new Game(player, world, monsters);
		
		saveGame(game);
		runGame(game);
		
	}
	
	

	public void runGame(Game game){
		//RUN THE GAME
	}
	
	public void loadGame(){
		Game game = in.loadState();
		runGame(game);
	}
	
	public void saveGame(Game game){
		sw.saveState(game);
	}
	
	private List<MonsterCharacter> newMonsters() {
		List<MonsterCharacter> arr = new ArrayList<MonsterCharacter>();
		charFactory = new MonsterFactory();
		
		int numberOfMonsters = (int)(world.getTiles().size() * monsterOcurrence);
		int sizeOfEnum = CharacterType.values().length;
		
		
		for(int i=0; i<numberOfMonsters; i++){
			CharacterType monsterPicked;
			do{
				monsterPicked = CharacterType.values()[RANDOM.nextInt(sizeOfEnum-1)];
			} while(!monsterPicked.toString().equals("monster"));
			
			MonsterCharacter newMonster = (MonsterCharacter) charFactory.createCharacter(CharacterType.MONSTER_1);
			arr.add(newMonster);
		}
		
		//place them in world
		int[][] posArray = new int[this.world.getHeight()][this.world.getWidth()];
		Arrays.fill(posArray[0], 0);  //WORKS!?
		
		//block player position who is already defined
		posArray[this.player.getCharXpos()][this.player.getCharYpos()] = 1;
		
		for(MonsterCharacter monster: arr){
			int xPos = 0;
			int yPos = 0;
			
			do{
				xPos = RANDOM.nextInt(world.getHeight()-1);
				yPos = RANDOM.nextInt(world.getWidth()-1);
			}
			while(posArray[xPos][yPos]!=0);
			
			monster.setCharXpos(xPos);
			monster.setCharYpos(yPos);
			
			world.getTile(xPos, yPos).setMonster(monster);
			world.getTile(xPos, yPos).updateTile();
			posArray[xPos][yPos] = 1;
			
		}
		
		return arr;
	}
	
	private Charater newCharacter(){
		
		Charater player = null;
		CharactersTexts choice  = uiManager.showCharacterSelectionMenu();
		
		switch(choice){
		case PALADIN:
			charFactory = new PlayerFactory();
		    player = (Charater) charFactory.createCharacter(CharacterType.PALADIN);
			break;
		case DWARF:
			charFactory = new PlayerFactory();
		    player = (Charater) charFactory.createCharacter(CharacterType.DWARF);
			break;
		case ROGUE:
			charFactory = new PlayerFactory();
		    player = (Charater) charFactory.createCharacter(CharacterType.ROGUE);
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
		player.setCharXpos(RANDOM.nextInt(world.getHeight()-1));
		player.setCharYpos(RANDOM.nextInt(world.getWidth()-1));
		
		Tile playerTile = world.getTile(player.getCharXpos(), player.getCharYpos());
		playerTile.setPlayer(player);
		playerTile.updateTile();
		
	}

	public Charater getPlayer() {
		return player;
	}

	public void setPlayer(PlayerCharacter player) {
		this.player = player;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public List<MonsterCharacter> getMonsters() {
		return monsters;
	}

	public void setMonsters(List<MonsterCharacter> monsters) {
		this.monsters = monsters;
	}


	
}
