package com.throwner.engine.character;

import com.throwner.engine.character.stats.CharacterStats;

public abstract class Charater extends GenericCharacter {
	
	private CharacterStats charStats;

	public abstract CharacterType getCharacterType();
	
	public Charater(CharacterType characterType){
		super(characterType);
		this.charStats = new CharacterStats(characterType.getStrenght(), characterType.getHealth(), characterType.getAgility());
	}

	public CharacterStats getCharStats() {
		return charStats;
	}

	public void setCharStats(CharacterStats charStats) {
		this.charStats = charStats;
	}

}