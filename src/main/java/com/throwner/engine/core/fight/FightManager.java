package com.throwner.engine.core.fight;

import java.util.Random;

import com.throwner.engine.character.CharacterStatus;
import com.throwner.engine.character.MonsterCharacter;
import com.throwner.engine.character.playerfactory.PlayerCharacter;
import com.throwner.exceptions.InputNotInOptionsException;
import com.throwner.framework.ContextsMap;
import com.throwner.ui.core.UIManager;
import com.throwner.ui.items.FightMenuTexts;

public class FightManager {
	
	private UIManager uiManager = ContextsMap.getBean(UIManager.class);
	private Random RANDOM  = ContextsMap.getBean(Random.class);
	
	public void startFight(MonsterCharacter monster, PlayerCharacter player){
		
		CharacterStatus monsterStatus = monster.getStatus();
		CharacterStatus playerStatus = player.getStatus();
		
		while(monsterStatus!=CharacterStatus.DEATH || playerStatus!=CharacterStatus.DEATH){
		
		try {
			FightMenuTexts choice = uiManager.showFightMenu();
		
		
		
		
		
		} catch (InputNotInOptionsException e) {
			//RESUME
		}
		
		monsterStatus = monster.getStatus();
		playerStatus = player.getStatus();
		}
	}
	
	private boolean runValidation(MonsterCharacter monster, PlayerCharacter player){
		
		int pAgility = player.getCharStats().getAgility();
		int mAgility = monster.getCharStats().getAgility();
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
}
