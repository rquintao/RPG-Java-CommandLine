package com.throwner.engine.core.fight;

import java.util.Random;

import com.throwner.engine.character.CharacterStatus;
import com.throwner.engine.character.MonsterCharacter;
import com.throwner.engine.character.playerfactory.PlayerCharacter;
import com.throwner.exceptions.InputNotInOptionsException;
import com.throwner.framework.ContextsMap;
import com.throwner.ui.core.UIManager;
import com.throwner.ui.items.FightMenuTexts;
import com.throwner.ui.items.FightStatus;

public class FightManager {
	
	private UIManager uiManager = ContextsMap.getBean(UIManager.class);
	private Random RANDOM  = ContextsMap.getBean(Random.class);
	
	public FightStatus startFight(MonsterCharacter monster, PlayerCharacter player){
		
		CharacterStatus monsterStatus = monster.getStatus();
		CharacterStatus playerStatus = player.getStatus();
		
		while(monsterStatus!=CharacterStatus.DEATH || playerStatus!=CharacterStatus.DEATH){
		
		try {
			uiManager.showFightStatus(monster, player);
			
			FightMenuTexts choice = uiManager.showFightMenu();
		
			FightStatus status = takeAction(choice,monster, player);
			
			if(status.equals(FightStatus.RAN_AWAY)) return FightStatus.RAN_AWAY;
		
		
		} catch (InputNotInOptionsException e) {
			//RESUME
		}
		
		monsterStatus = monster.getStatus();
		playerStatus = player.getStatus();
		}
		
		
		return null;
	}
	
	private FightStatus takeAction(FightMenuTexts choice, MonsterCharacter monster, PlayerCharacter player) throws InputNotInOptionsException {

		switch(choice){
		case FIGHT://New fight
			processAttack(monster, player);
			break;
		case BLOCK://block
			break;
		case RUN:
				if(runValidation(monster, player)){
					return FightStatus.RAN_AWAY;
				}else {//FIGHT CLUB ONCE AGAIN;
					//FIGHT
				};
				break;
		}
		return null;
		
	}
	
	private FightStatus processAttack(MonsterCharacter monster, PlayerCharacter player) {
		return null;
		// TODO Auto-generated method stub
		
	}

	private boolean runValidation(MonsterCharacter monster, PlayerCharacter player){
		
		int pAgility = player.getCharStats().getAgility();
		int mAgility = monster.getCharStats().getAgility();
		int min = -10;
		int max = 10;
		
		
		int aDiference = pAgility - mAgility;
		
		int randomNumber = RANDOM.nextInt(max + 1 + aDiference - min) + min;
		
		if (randomNumber>=0){
			uiManager.showMessage("You chickened out and ran from the fight!");
			return true;
		}
		uiManager.showMessage("The monster grabbed you and didn't let you run!");
		return false;
	}
}
