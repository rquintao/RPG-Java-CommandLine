package com.throwner.engine.character.paladin;

import com.throwner.engine.character.CharacterStats;
import com.throwner.engine.character.CharacterType;
import com.throwner.engine.character.Charater;

public class PaladinCharacter extends Charater{
	
	private CharacterType character;
	
	public PaladinCharacter(CharacterType character){
		
		super(CharacterType.PALADIN);
		
		this.character = character;
		
		CharacterStats charStats = new CharacterStats();
		
		charStats.setAgility(CharacterType.PALADIN.getAgility());
		charStats.setHealth(CharacterType.PALADIN.getHealth());
		charStats.setStrenght(CharacterType.PALADIN.getStrenght());
		
		super.setCharStats(charStats);
		
	}

	public CharacterType getCharacterType() {
		return this.character;
	}

}
