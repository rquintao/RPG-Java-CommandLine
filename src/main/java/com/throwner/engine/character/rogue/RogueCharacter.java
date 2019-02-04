package com.throwner.engine.character.rogue;

import com.throwner.engine.character.CharacterStats;
import com.throwner.engine.character.CharacterType;
import com.throwner.engine.character.Charater;

public class RogueCharacter extends Charater{
	
	private CharacterType character;
	
	public RogueCharacter(CharacterType character){
		super(CharacterType.ROGUE);
		
		this.character = character;
		
		CharacterStats charStats = new CharacterStats();
		
		charStats.setAgility(CharacterType.ROGUE.getAgility());
		charStats.setHealth(CharacterType.ROGUE.getHealth());
		charStats.setStrenght(CharacterType.ROGUE.getStrenght());
		
		super.setCharStats(charStats);
		
	}

	public CharacterType getCharacterType() {
		return this.character;
	}

}
