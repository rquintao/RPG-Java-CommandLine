package com.throwner.engine.core;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.throwner.engine.character.CharacterFactory;
import com.throwner.engine.character.CharacterStatus;
import com.throwner.engine.character.CharacterType;
import com.throwner.engine.character.Charater;
import com.throwner.engine.character.MonsterCharacter;
import com.throwner.engine.character.monsterfactory.MonsterFactory;
import com.throwner.engine.character.playerfactory.PlayerCharacter;
import com.throwner.engine.character.playerfactory.PlayerFactory;
import com.throwner.engine.core.fight.FightManager;
import com.throwner.engine.world.Tile;
import com.throwner.engine.world.World;
import com.throwner.exceptions.InputNotInOptionsException;
import com.throwner.framework.ContextsMap;
import com.throwner.ui.core.UIManager;
import com.throwner.ui.items.CharactersTexts;
import com.throwner.ui.items.FightStatus;
import com.throwner.ui.items.WorldInputsSubTexts;
import com.throwner.ui.items.WorldInputsTexts;
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
	private FightManager fightManager = ContextsMap.getBean(FightManager.class);
	private static final Logger LOG = LogManager.getLogger(GameEngine.class);
	
	//MAKE THIS EDITABLE WITH DIFICULTY MAYBE?
	private double monsterOcurrence = 0.15;
	private boolean victory = false;
	private boolean defeat = false;

	public static void startNewGame() {
		LOG.traceEntry();
		GameEngine gameEngine = new GameEngine();
		gameEngine.newGame();
		LOG.traceExit();
	};
	
	public static void loadPreviousGame() throws FileNotFoundException {
		LOG.traceEntry();
		GameEngine gameEngine = new GameEngine();
		gameEngine.loadGame();
		LOG.traceExit();
	}
	
	public void newGame(){
		LOG.traceEntry();
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
		
		//create Game class
		Game game = new Game(player, world, monsters);

		runGame(game);
		LOG.traceExit();
	}
	
	public void loadGame() throws FileNotFoundException{
		LOG.traceEntry();
		Game game = in.loadState();
		
		if(game == null) throw new FileNotFoundException();
		
		runGame(game);
		LOG.traceExit();
	}
	
	public void saveGame(Game game){
		sw.saveState(game);
	}
	
	private List<MonsterCharacter> newMonsters() {
		LOG.traceEntry();
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
		LOG.traceExit();
		return arr;
	}
	
	private Charater newCharacter(){
		LOG.traceEntry();
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
		LOG.traceExit();
		return player;
	}
	
	private World newWorld(int width, int height){
		LOG.traceEntry();
		World world = new World(width, height);
		LOG.traceExit();
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
	
	

	public void runGame(Game game){
		
		
		while(!victory && !defeat){
			//PRINT WORLD
			uiManager.printWorld(game.getWorld());
			//WAIT FOR USER INPUT
			WorldInputsTexts choice;
			try {
				choice = uiManager.showWorldInputs();

			//TAKE ACTION
				//FIGHT?
				//DEFEAT?
			takeAction(choice, game);
			
			//UPDATE WORLD	//VICTORY
			if(!updateWorld(game)) this.victory=true;
			
			} catch (Exception e) {
				//resume;
			}
			
		}
		
		if(defeat){
			uiManager.showMessage("You are weak young blood.. You should rest before trying again!");
			ThrownerLauncher.shutdown();
		}
		
		if(victory){
			uiManager.showMessage("You are the almighty king of the wastelands!! Enjoy your last days alone in this world!");
			ThrownerLauncher.shutdown();
		}
		
		
	}

	private boolean updateWorld(Game game) {
		boolean areThereMonstersAlive = false;
		
		//UPDATE Tiles
		List<Tile> tiles = game.getWorld().getTiles();
		
		for(Tile t: tiles){
			MonsterCharacter monster = t.getMonster();
			
			if(monster != null && t.getMonster().getStatus().equals(CharacterStatus.ALIVE)) areThereMonstersAlive=true;
			
			t.updateTile();
		}
		return areThereMonstersAlive;
	}

	private void takeAction(WorldInputsTexts choice, Game game) throws InputNotInOptionsException {
		FightStatus status = null;

		switch(choice){
		case UP: playerMove(-1, 0, game, 'W');
				break;
		case DOWN: playerMove(1, 0, game, 'W');
				break;	
		case LEFT: playerMove(0, -1, game, 'W');
				break;
		case RIGHT: playerMove(0, 1, game,'W');
				break;
		case OPTIONS: 
				WorldInputsSubTexts subChoice = uiManager.showWorldSubInputs();
				switch(subChoice){
				case SAVE: saveGame(game);
						   uiManager.showMessage("Saved game!");
					break;
				case QUIT: 	uiManager.showMessage("Shutting engines down. See ya!");
							ThrownerLauncher.shutdown();
					break;
				case BACK: break;
				}
				break;
		case FIGHT://New fight
					if(fightValidation(game)){
						//FIGHTCLUB
						PlayerCharacter fightplayer = game.getPlayer();
						MonsterCharacter fightmonster = game.getWorld().getTile(game.getPlayer().getCharXpos(), game.getPlayer().getCharYpos()).getMonster();
						status = fightManager.startFight(fightmonster, fightplayer);
						
						if(status!= null && status.equals(FightStatus.PLAYER_DEAD)) this.defeat = true;
						if(status!= null && status.equals(FightStatus.RAN_AWAY)) 
								playerMove(RANDOM.nextInt(3)-1, RANDOM.nextInt(3)-1, game, 'R');
						
					}
			break;
		case RUN:
				if(runValidation(game)){
					playerMove(RANDOM.nextInt(3)-1, RANDOM.nextInt(3)-1, game, 'R');
					break;
				}else {//FIGHT CLUB ONCE AGAIN;
					PlayerCharacter fightplayer = game.getPlayer();
					MonsterCharacter fightmonster = game.getWorld().getTile(game.getPlayer().getCharXpos(), game.getPlayer().getCharYpos()).getMonster();
					status = fightManager.startFight(fightmonster, fightplayer);
					
					if(status.equals(FightStatus.PLAYER_DEAD)) this.defeat = true;
				};
				break;
		}
		
	}



	private void playerMove(int i, int j, Game game, char flgMovementType) {
		PlayerCharacter gamePlayer = game.getPlayer();
		int xPos = gamePlayer.getCharXpos();
		int yPos = gamePlayer.getCharYpos();
		
		//check if is a valid move
		if(xPos + i < 0 || yPos + j < 0 || xPos+i > game.getWorld().getHeight() || yPos+j > game.getWorld().getWidth()){
			uiManager.showMessage("You can't go out of this world smart ass!");
			return;
		}
		
		MonsterCharacter monster = game.getWorld().getTile(xPos, yPos).getMonster();
		
		if(monster!=null && monster.getStatus().equals(CharacterStatus.ALIVE) && flgMovementType != 'R'){
			uiManager.showMessage("You can't just walk past a monster.. Either try to run or fight!");	
			return;
		}
		
		//set tile with player to null
		game.getWorld().getTile(xPos, yPos).setPlayer(null);
		
		gamePlayer.setCharXpos(xPos+i);
		gamePlayer.setCharYpos(yPos+j);
		
		game.getWorld().getTile(xPos+i, yPos+j).setPlayer(gamePlayer);
	}
	
	private boolean runValidation(Game game){
		PlayerCharacter player = game.getPlayer();
		Tile tileWithPlayer = game.getWorld().getTile(player.getCharXpos(), player.getCharYpos());
		
		if(tileWithPlayer.getMonster()==null){
			uiManager.showMessage("Can't run from your own shadow");
			return false;
		}
		
		int pAgility = player.getCharStats().getAgility();
		int mAgility = tileWithPlayer.getMonster().getCharStats().getAgility();
		int min = -10;
		int max = 10;
		
		
		int aDiference = pAgility - mAgility;
		
		int randomNumber = RANDOM.nextInt(max + 1 + aDiference - min) + min;
		
		if (randomNumber>=0){
			uiManager.showMessage("You escaped without a bruise!");
			return true;
		}
		uiManager.showMessage("The monster runs way faster than you! You'll have to fight");
		return false;
	}
	
	private boolean fightValidation(Game game) {
		PlayerCharacter player = game.getPlayer();
		Tile tileWithPlayer = game.getWorld().getTile(player.getCharXpos(), player.getCharYpos());
		
		//If there is a monster and it is alive
		if(tileWithPlayer.getMonster()!=null && tileWithPlayer.getMonster().getStatus().equals(CharacterStatus.ALIVE)){
			uiManager.showMessage("Starting fight club");
			return true;
		}
		if(tileWithPlayer.getMonster()!=null && tileWithPlayer.getMonster().getStatus().equals(CharacterStatus.DEATH)){
			uiManager.showMessage("You already killed this one. No point in beating it up even more.");
			return true;
		}
		uiManager.showMessage("Can't fight with your own problems");
		return false;
	}


	
}
