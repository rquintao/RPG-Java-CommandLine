package com.throwner.engine.core.fight;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.throwner.engine.character.CharacterStatus;
import com.throwner.engine.character.MonsterCharacter;
import com.throwner.engine.character.playerfactory.PlayerCharacter;
import com.throwner.engine.core.Game;
import com.throwner.engine.world.Tile;
import com.throwner.exceptions.InputNotInOptionsException;
import com.throwner.framework.ContextsMap;
import com.throwner.ui.core.UIManager;
import com.throwner.ui.items.FightMenuTexts;
import com.throwner.ui.items.FightStatus;
import com.throwner.utils.input.InputUtils;

public class FightManager {
	
	private static final Logger LOG = LogManager.getLogger(InputUtils.class);
	private UIManager uiManager = ContextsMap.getBean(UIManager.class);
	private Random RANDOM  = ContextsMap.getBean(Random.class);
	private final int noPlayerAttack = -100;
	
	public FightStatus startFight(MonsterCharacter monster, PlayerCharacter player){
		
		CharacterStatus monsterStatus = monster.getStatus();
		CharacterStatus playerStatus = player.getStatus();
		FightStatus status = null;
		
		while(monsterStatus!=CharacterStatus.DEATH && playerStatus!=CharacterStatus.DEATH){
		
		try {
			uiManager.showFightStatus(monster, player);
			
			FightMenuTexts choice = uiManager.showFightMenu();
		
		    status = takeAction(choice,monster, player);
			
			if(status.equals(FightStatus.RAN_AWAY)) return FightStatus.RAN_AWAY;
		
		} catch (InputNotInOptionsException e) {
			LOG.error("Threw a Exception in FightManager::startFight, full stack trace follows:", e);
			//RESUME
		}
		
		monsterStatus = monster.getStatus();
		playerStatus = player.getStatus();
		
		}
		
		
		return status;
	}
	
	private FightStatus takeAction(FightMenuTexts choice, MonsterCharacter monster, PlayerCharacter player) throws InputNotInOptionsException {

		int playerFirst = agilityValidation(player, monster);
		
		switch(choice){
		case FIGHT:
				//New fight
				return processAttack(player, monster, playerFirst);
		case BLOCK:
				//block
				return processBlock(player, monster, playerFirst);
		case RUN://RUN FOREST
				if(runValidation(monster, player)){
					return FightStatus.RAN_AWAY;
				}else {
					//FIGHT CLUB ONCE AGAIN;
					return processAttack(player, monster, this.noPlayerAttack);
				}
		}
		return FightStatus.ON_GOING;
		
	}
	
	private FightStatus processBlock(PlayerCharacter player, MonsterCharacter monster, int playerFirst) {
		
		int mAttack = RANDOM.nextInt((monster.getCharStats().getStrenght() - 1) + 1) + 1;     
		int pHealth = player.getCharStats().getHealth();
		int pBlock = RANDOM.nextInt((monster.getCharStats().getStrenght() - 1) + 1) + 1;
		
		uiManager.showMessage("The monster is attacking you with " + mAttack + " points of damage.");
		
		if(playerFirst >=0 ){		
			uiManager.showMessage("You are blocking " + pBlock + " points of damage.");
			mAttack = Math.max(0, mAttack - pBlock);
		} ;
	
		uiManager.showMessage("You are left with " + Math.max(0, pHealth - mAttack) + " points of health.");
		player.getCharStats().setHealth(Math.max(0, pHealth - mAttack));
		
		if(isPlayerAlive(player).equals(FightStatus.PLAYER_DEAD)) return FightStatus.PLAYER_DEAD;
		return FightStatus.ON_GOING;	
		
	}

	private FightStatus processAttack(PlayerCharacter player,MonsterCharacter monster, int playerFirst) {
										//((max - min) + 1) + min
		int mAttack = RANDOM.nextInt((monster.getCharStats().getStrenght() - 1) + 1) + 1;     
		int pAttack = RANDOM.nextInt((player.getCharStats().getStrenght() - 1) + 1) + 1; 
		int mHealth = monster.getCharStats().getHealth();
		int pHealth = player.getCharStats().getHealth();
		
		if(playerFirst==this.noPlayerAttack){
			uiManager.showMessage("The monster is attacking you with " + mAttack + " points of damage.");
			uiManager.showMessage("You are left with " + Math.max(0, pHealth - mAttack) + " points of health.");
			player.getCharStats().setHealth(Math.max(0, pHealth - mAttack));
			return isPlayerAlive(player);
		}	
		
		if(playerFirst >=0 ){
			uiManager.showMessage("You are attacking the monster with " + pAttack + " points of damage.");
			uiManager.showMessage("The monster is left with " + Math.max(0, mHealth - pAttack) + " points of health.");
			monster.getCharStats().setHealth(Math.max(0, mHealth - pAttack));
			if(isMonsterAlive(monster).equals(FightStatus.MONSTER_DEAD)) return FightStatus.MONSTER_DEAD;
			
			
			uiManager.showMessage("The monster is attacking you with " + mAttack + " points of damage.");
			uiManager.showMessage("You are left with " + Math.max(0, pHealth - mAttack) + " points of health.");
			player.getCharStats().setHealth(Math.max(0, pHealth - mAttack));
			
			if(isPlayerAlive(player).equals(FightStatus.PLAYER_DEAD)) return FightStatus.PLAYER_DEAD;
			return FightStatus.ON_GOING;
		}	
		
		if(playerFirst < 0 ){
			uiManager.showMessage("The monster is attacking you with " + mAttack + " points of damage.");
			uiManager.showMessage("You are left with " + Math.max(0, pHealth - mAttack) + " points of health.");
			player.getCharStats().setHealth(Math.max(0, pHealth - mAttack));
			if(isPlayerAlive(player).equals(FightStatus.PLAYER_DEAD)) return FightStatus.PLAYER_DEAD;
			
			uiManager.showMessage("You are attacking the monster with " + pAttack + " points of damage.");
			uiManager.showMessage("The monster is left with " + Math.max(0, mHealth - pAttack) + " points of health.");
			monster.getCharStats().setHealth(Math.max(0, mHealth - pAttack));
			if(isMonsterAlive(monster).equals(FightStatus.MONSTER_DEAD)) return FightStatus.MONSTER_DEAD;
			return FightStatus.ON_GOING;
		}	
		
		return FightStatus.ON_GOING;
		
	}
	
	private FightStatus isPlayerAlive(PlayerCharacter player){
		if(player.getCharStats().getHealth()==0) {
			player.setStatus(CharacterStatus.DEATH);
			return FightStatus.PLAYER_DEAD; 
		}	
		return FightStatus.ON_GOING;
	}
	
	private FightStatus isMonsterAlive(MonsterCharacter monster){
		if(monster.getCharStats().getHealth()==0) {
			monster.setStatus(CharacterStatus.DEATH);
			return FightStatus.MONSTER_DEAD; 
		}	
		return FightStatus.ON_GOING;
	}

	private int agilityValidation(PlayerCharacter player, MonsterCharacter monster){
		
		int pAgility = player.getCharStats().getAgility();
		int mAgility = monster.getCharStats().getAgility();
		int min = -10;
		int max = 10;
		
		
		int aDiference = pAgility - mAgility;
		
		int randomNumber = RANDOM.nextInt(max + 1 + aDiference - min) + min;
		
	return randomNumber;
	}
	
	public boolean runValidation(MonsterCharacter monster, PlayerCharacter player){
		
		int randomNumber = agilityValidation(player, monster);
		
		if (randomNumber>=0){
			uiManager.showMessage("You chickened out and ran from the fight!");
			return true;
		}
		uiManager.showMessage("The monster grabbed you and didn't let you run!");
		return false;
	}
	
	public boolean fightValidation(Game game) {
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
